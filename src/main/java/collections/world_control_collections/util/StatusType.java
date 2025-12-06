package collections.world_control_collections.util;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum StatusType {
	C("Completo"),
	I("Incompleto"),
	NA("Pendiente apertura");

	public final String description;

	StatusType(String description) {
		this.description = description;
	}

	public static StatusType getValueFromDescription(String description){
		return Arrays.stream(StatusType.values())
				.filter(statusType -> statusType.getDescription().equals(description))
				.findFirst()
				.orElseThrow(RuntimeException::new);
	}
}
