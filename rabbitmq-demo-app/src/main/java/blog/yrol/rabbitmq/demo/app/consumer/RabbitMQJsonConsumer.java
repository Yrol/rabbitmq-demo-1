package blog.yrol.rabbitmq.demo.app.consumer;

import blog.yrol.rabbitmq.demo.app.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    /**
     * Consumer that subscribe to RabbitMQ queue: rabbitmq.json_queue.name -> "demo_exchange_json_queue"
     * **/
    @RabbitListener(queues = {"${rabbitmq.json_queue.name}"})
    public void consume(User user) {
        LOGGER.info(String.format("Received JSON message -> %s", user.toString()));
    }
}
