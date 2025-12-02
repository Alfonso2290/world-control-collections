package collections.world_control_collections.entity.sql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "dbo", name = "Collection")
public class Collection {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
