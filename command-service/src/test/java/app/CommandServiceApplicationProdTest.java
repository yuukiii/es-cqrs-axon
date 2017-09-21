package app;

import app.config.axon.AMQPConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {
                CommandServiceApplication.class,
                AMQPConfig.class
        },
        properties = {
                "spring.cloud.config.enabled:false"
        }
)
@ActiveProfiles("prod")
public class CommandServiceApplicationProdTest {
    @Inject
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        assertNotNull("application context loaded", applicationContext);

        AmqpAdmin amqpAdmin = (AmqpAdmin) applicationContext.getBean("rabbitAdmin");
        assertNotNull("AmqpAdmin bean created", amqpAdmin);
    }

}
