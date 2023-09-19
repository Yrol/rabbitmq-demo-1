package blog.yrol.rabbitmq.demo.app.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.key}")
    private String binding_key;

    /**
     * Using the RabbitMQ template auto-configured by Spring Boot
     * */
    private RabbitTemplate rabbitTemplate;

    /**
     * Injecting the RabbitMQ template auto-configured by Spring Boot via constructor
     * **/
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent -> %s", message));
        rabbitTemplate.convertAndSend(exchange, binding_key, message);
    }
}
