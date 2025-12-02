package collections.world_control_collections.dto.web;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CollectionWebDto implements Serializable {
	@Serial
	private static final long serialVersionUID = -7957839091986419810L;

	private String name;
	private String type;
	private String editorial;
	private String origin;
	private String status;
	private Integer priority;
	private String destiny;
	private String form;
	private String binder;
}
