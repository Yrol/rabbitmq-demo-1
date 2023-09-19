package blog.yrol.rabbitmq.demo.app.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTemplateConfig {

    /**
     * Setting up / enabling JSON in RabbitTemplate to be compatible with JSON
     * **/
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connection) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connection);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
