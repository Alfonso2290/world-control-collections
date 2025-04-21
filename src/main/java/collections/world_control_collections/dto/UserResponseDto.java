package collections.world_control_collections.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class UserResponseDto implements Serializable {
    private String message;
    private String status;
}
