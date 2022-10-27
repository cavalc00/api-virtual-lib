package br.com.unip.apilivrariaautomatizada.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExtensionEnum {

    IMAGE_JPEG(".jpeg"),
    IMAGE_JPG(".jpg"),
    IMAGE_PNG(".png");

    private final String name;
}
