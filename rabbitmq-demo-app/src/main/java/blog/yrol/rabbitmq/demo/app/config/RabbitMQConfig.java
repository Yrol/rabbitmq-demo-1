package blog.yrol.rabbitmq.demo.app.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuring RabbitMQ exchanges, queues and binding keys within Spring boot Java code
 * These configurations are disabled / commented out since they're already pre-configured in: "docker-compose/rabbitmq/definitions.json" (can be maintained in both places side by side)
 * **/

//@Configuration
//public class RabbitMQConfig {
//
//    @Value("${rabbitmq.exchange.name}")
//    private String exchange;
//
//    @Value("${rabbitmq.queue.name}")
//    private String queue;
//
//
//    @Value("${rabbitmq.binding.key}")
//    private String binding_key;
//
//
//    @Value("${rabbitmq.json_queue.name}")
//    private String json_queue;
//
//
//    @Value("${rabbitmq.json_binding.key}")
//    private String json_binding_key;
//
//    /**
//     * Spring bean for rabbitmq queue
//     * */
//    @Bean
//    public Queue queue() {
//        return new Queue(queue);
//    }
//
//    /**
//     * Queue for storing messages in JSON format
//     * **/
//    @Bean
//    public Queue jsonQueue() {
//        return new Queue(json_queue);
//    }
//
//    /**
//     * Spring bean for rabbitmq exchange
//     * */
//    @Bean
//    public TopicExchange exchange() {
//        return new TopicExchange(exchange);
//    }
//
//    /**
//     * String message queue
//     * Bind using a routing key
//     * Binding an exchange to a queue using a routing key
//     * */
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(queue()).to(exchange()).with(binding_key);
//    }
//
//    /**
//     * JSON message queue
//     * Bind using a routing key
//     * Binding an exchange to a queue using a routing key
//     * */
//    @Bean
//    public Binding jsonBinding() {
//        return BindingBuilder.bind(jsonQueue()).to(exchange()).with(json_binding_key);
//    }
//
//    /**
//     * The following infrastructure beans required by RabbitMQ will be auto-configured by Spring boot auto configure
//     * ConnectionFactory
//     * RabbitTemplate
//     * RabbitAdmin
//     * **/
//}
