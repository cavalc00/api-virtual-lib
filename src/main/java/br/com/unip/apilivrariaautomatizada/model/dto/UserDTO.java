package br.com.unip.apilivrariaautomatizada.model.dto;

import com.google.common.base.Objects;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Getter
public class UserDTO extends User {
    private static final long serialVersionUID = 4966090351966447820L;
    private String id;
    private String name;
    private String picture;
    private String status;
    private String roles; // json object

    public UserDTO(String username, String password, String id, String name, String picture, String roles, String status) {
        super(username, password, Collections.emptyList());
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.roles = roles;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equal(getUsername(), userDTO.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), getUsername());
    }
}