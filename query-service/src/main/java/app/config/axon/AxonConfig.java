package app.config.axon;

import com.rabbitmq.client.Channel;
import org.axonframework.amqp.eventhandling.AMQPMessageConverter;
import org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter;
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.axonframework.serialization.Serializer;
import org.springframework.context.annotation.Scope;

@Configuration
public class AxonConfig {
    @Bean
    SpringAMQPMessageSource springAMQPMessageSource(AMQPMessageConverter amqpMessageConverter) {
        return new SpringAMQPMessageSource(amqpMessageConverter) {
            final Logger logger = LoggerFactory.getLogger(getClass());
            @Override
            @RabbitListener(queues = "${external.amqp.queue}")
            public void onMessage(Message message, Channel channel) throws Exception {
                logger.info("Received message: {}", message);
                logger.info("Channel {}", channel);
                super.onMessage(message, channel);
            }
        };
    }

    @Bean
    @Scope(value = "prototype")
    public AMQPMessageConverter amqpMessageConverter(Serializer serializer) {
        return new DefaultAMQPMessageConverter(serializer);
    }


}
