package br.com.unip.apilivrariaautomatizada.service;

import br.com.unip.apilivrariaautomatizada.model.dto.UserDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class TokenService {

    public UserDTO parseGoogleBearerToken(String token) {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = token.split("\\.");
        JsonObject obj = new Gson().fromJson(new String(decoder.decode(chunks[1])), JsonObject.class);
        String name = obj.get("name").getAsString();
        String password = obj.get("sub").getAsString(); // Google code
        String email = obj.get("email").getAsString();
        String picture = obj.get("picture").getAsString();
        String roles = obj.has("roles")?obj.get("roles").getAsString():null;
        String status = obj.has("status")?obj.get("status").getAsString():null;
        return new UserDTO(email, password, "", name, picture, roles, status);
    }

}
