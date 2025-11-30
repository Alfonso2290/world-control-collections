package collections.world_control_collections.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("collections.world_control_collections.repository.sql")
@EntityScan("collections.world_control_collections.entity.sql")
public class JpaConfiguration {
}
