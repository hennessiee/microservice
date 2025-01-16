package micro.adminservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
//
//    @Bean
//    public Queue stockGroupCreatedQueue() {
//        return new Queue("stockGroupCreatedQueue", true); // Durable queue
//    }
//
//    @Bean
//    public DirectExchange exchange() {
//        return new DirectExchange("stockGroupExchange");
//    }
//
//    @Bean
//    public Binding binding(Queue stockGroupCreatedQueue, DirectExchange exchange) {
//        return BindingBuilder.bind(stockGroupCreatedQueue)
//                .to(exchange)
//                .with("stockGroupCreatedRoutingKey");
//    }


    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter jsonMessageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter); // Set Jackson converter
        return rabbitTemplate;
    }

}

