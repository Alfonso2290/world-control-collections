package collections.world_control_collections.entity.sql;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "dbo", name = "Missing")
public class Missing {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;
	private String numeration;
	private String status;

	@JoinColumn(name = "collectionId", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Collection collection;
}
