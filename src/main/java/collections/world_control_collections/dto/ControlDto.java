package collections.world_control_collections.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ControlDto implements Serializable {

	private Long id;
	private String type;
	private Integer numeration;
	private String status;
}
