package br.com.unip.apilivrariaautomatizada.service;

import br.com.unip.apilivrariaautomatizada.config.ApplicationProperties;
import br.com.unip.apilivrariaautomatizada.model.dto.ImageDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.com.unip.apilivrariaautomatizada.model.enums.ExtensionEnum.*;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ApplicationProperties properties;

    private final String fileSeparator = System.getProperty("file.separator");


    public ImageDTO getImageById(Long id) throws IOException, SQLException {
        Map<Long, String> mapPathByImageId = getMapPathByImageId();
        String pathImage = mapPathByImageId.get(id);
        SerialBlob image = new SerialBlob(IOUtils.toByteArray(new FileInputStream(pathImage)));
        return ImageDTO.builder().id(id).imagem(image).build();
    }

    public void deleteImageById(Long id) {
        Map<Long, String> mapPathByImageId = getMapPathByImageId();
        String filePath = mapPathByImageId.get(id);

        if (Objects.nonNull(filePath)) {
            File file = new File(filePath);
            if (file.delete()) {
                System.out.println("Image " + id + " deleted!");
            } else {
                System.out.println("Image " + id + " no exist!");
            }
        }
    }

    public List<ImageDTO> getAllImages() throws IOException, SQLException {
        List<ImageDTO> allImages = new ArrayList<>();
        Map<Long, String> pathByImageId = getMapPathByImageId();

        for (Long imageId : pathByImageId.keySet()) {
            if (!StringUtils.hasLength(pathByImageId.get(imageId))) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image Not Found: " + imageId);
            }

            allImages.add(
                    ImageDTO.builder()
                            .id(imageId)
                            .imagem(new SerialBlob(IOUtils.toByteArray(new FileInputStream(pathByImageId.get(imageId)))))
                            .build()
            );
        }

        return allImages;
    }

    public void UpdateOrSaveImageFromBase64(Long id, String base64String) {
        Map<Long, String> pathByImageId = getMapPathByImageId();
        String actualPath = pathByImageId.get(id);
        String[] imageParts = base64String.split(",");
        String imageExtension = getImageExtension(imageParts[0]);

        if (Objects.nonNull(actualPath)) {
            File file = new File(actualPath);
            if (file.delete()) {
                System.out.println("Image " + id + " deleted!");
            } else {
                System.out.println("Image " + id + " no exist!");
            }
        }

        byte[] data = Base64.getDecoder().decode(imageParts[1]);
        String path = properties.getImagesPath() + fileSeparator + id + imageExtension;

        File file = new File(path);
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            outputStream.write(data);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public String getImageExtension(String extension) {
        switch (extension) {
            case "data:image/jpeg;base64":
                return IMAGE_JPG.getName();
            case "data:image/png;base64":
                return IMAGE_PNG.getName();
            default:
                return IMAGE_JPEG.getName();
        }
    }

    private Map<Long, String> getMapPathByImageId() {
        List<String> allImagesPaths;
        Map<Long, String> pathByImageId = new HashMap<>();

        try (Stream<Path> pathStream = Files.list(Paths.get(properties.getImagesPath() + fileSeparator))) {
            allImagesPaths = pathStream.filter(file -> !Files.isDirectory(file))
                    .map(Path::toAbsolutePath)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String path : allImagesPaths) {
            List<String> stringList = Arrays.stream(path.split("\\\\")).collect(Collectors.toList());
            String nameWithSufix = stringList.get(stringList.size() - 1);
            String imageName = Arrays.stream(nameWithSufix.split("\\.")).findFirst().orElse(null);

            if (Objects.nonNull(imageName)) {
                pathByImageId.putIfAbsent(Long.parseLong(imageName), path);
            }
        }

        return pathByImageId;
    }
}
