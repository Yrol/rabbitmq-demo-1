package blog.yrol.rabbitmq.demo.app.publisher;

import blog.yrol.rabbitmq.demo.app.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json_binding.key}")
    private String json_binding_key;

    /**
     * Using the RabbitMQ template auto-configured by Spring Boot
     * */
    private RabbitTemplate rabbitTemplate;

    /**
     * Injecting the RabbitMQ template auto-configured by Spring Boot via constructor
     * **/
    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user) {
        LOGGER.info(String.format("JSON message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange, json_binding_key, user);
    }
}
