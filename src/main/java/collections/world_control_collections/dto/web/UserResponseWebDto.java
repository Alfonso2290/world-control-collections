package collections.world_control_collections.dto.web;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UserResponseWebDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -7957839091986419810L;

    private String message;
    private String status;
}
