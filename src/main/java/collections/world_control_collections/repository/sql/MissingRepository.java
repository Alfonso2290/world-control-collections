package collections.world_control_collections.repository.sql;

import collections.world_control_collections.entity.sql.Missing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissingRepository extends JpaRepository<Missing, Long> {

}
