package collections.world_control_collections.repository.sql;

import collections.world_control_collections.entity.sql.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlRepository extends JpaRepository<Control, Long> {

	@Query(value ="Select * from dbo.[Control] " +
			" where collectionId=:collectionId and numeration NOT LIKE '[A-Z]%' " +
			" order by type asc,cast(numeration as int) asc",  nativeQuery = true)
	List<Control> findControlByNumerationNumeric(@Param("collectionId") Long collectionId);

	@Query(value ="Select  * from dbo.[Control] " +
			" where collectionId=:collectionId and numeration LIKE '[A-Z]%' " +
			" order by type asc,cast(SUBSTRING(numeration, 2, LEN(numeration))as int) asc",  nativeQuery = true)
	List<Control> findControlByNumerationAlphaNumeric(@Param("collectionId") Long collectionId);
}
