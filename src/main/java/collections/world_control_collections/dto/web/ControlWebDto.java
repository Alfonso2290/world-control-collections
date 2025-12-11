package collections.world_control_collections.dto.web;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ControlWebDto implements Serializable {

	private Long id;
	private String type;
	private String numeration;
	private String status;
	private Long collectionId;
}
