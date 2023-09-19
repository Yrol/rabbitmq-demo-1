package blog.yrol.rabbitmq.demo.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.key}")
    private String binding_key;

    /**
     * Spring bean for rabbitmq queue
     * */
    @Bean
    public Queue queue() {
        return new Queue(queue);
    }

    /**
     * Spring bean for rabbitmq exchange
     * */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    /**
     * Bind using a routing key
     * Binding an exchange to a queue using a routing key
     * */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(binding_key);
    }

    /**
     * The following infrastructure beans required by RabbitMQ will be auto-configured by Spring boot auto configure
     * ConnectionFactory
     * RabbitTemplate
     * RabbitAdmin
     * **/
}
