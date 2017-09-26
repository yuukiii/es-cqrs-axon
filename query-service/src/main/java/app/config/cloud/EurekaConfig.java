package app.config.cloud;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"prod", "cloud"})
@Configuration
@EnableEurekaClient
public class EurekaConfig {
}
