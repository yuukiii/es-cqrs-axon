package app.config.axon;

import app.config.database.EventSourcingCollectionProperties;
import org.axonframework.serialization.upcasting.event.EventUpcaster;
import org.axonframework.serialization.upcasting.event.NoOpEventUpcaster;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({AxonMongoInfraStructureConfig.class, AxonHSQLInfraStructureConfig.class})

public class AxonConfig {
    @Bean
    EventUpcaster eventUpcaster() {
        return NoOpEventUpcaster.INSTANCE;
    }
}
