package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@EnableAutoConfiguration
@EnableZuulProxy // Act as reverse proxy, forwarding requests to other services based on routes.
@SpringBootApplication
public class GatewayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class);
    }
}



@Configuration
class KeepAwakeCommandRunner implements CommandLineRunner {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${extra.keep-awake}")
    private boolean isKeepAwake;

    @Value("${extra.keep-awake-interval-seconds}")
    private int keepAwakeIntervalSeconds;

    @Value("${extra.domain-name}")
    private String domainName = "http://localhost:8080";

    @Override
    public void run(String... strings) throws Exception {
        while(isKeepAwake) {
            restTemplate.execute(
                    domainName + "/info",
                    HttpMethod.GET,
                    request -> {},
                     response ->response.getStatusText(),
                    new HashMap<>()
                    );
            TimeUnit.SECONDS.sleep(keepAwakeIntervalSeconds);
        }
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

