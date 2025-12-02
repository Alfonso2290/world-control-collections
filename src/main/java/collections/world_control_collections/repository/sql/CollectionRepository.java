package collections.world_control_collections.repository.sql;

import collections.world_control_collections.entity.sql.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {

	List<Collection> findByNameLike(String name);

	List<Collection> findByEditorial(String editorial);

	List<Collection> findByNameLikeAndEditorial(String name, String editorial);


}
