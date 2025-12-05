package collections.world_control_collections.repository.sql;

import collections.world_control_collections.entity.sql.Collection;
import collections.world_control_collections.entity.sql.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlRepository extends JpaRepository<Control, Long> {

	List<Control> findByCollectionOrderByType(Collection collection);
}
