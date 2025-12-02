package collections.world_control_collections.util;

import lombok.Getter;

@Getter
public enum StatusType {
	C("Completo"),
	I("Incompleto"),
	NA("Pendiente apertura");

	public final String description;

	StatusType(String description) {
		this.description = description;
	}

}
