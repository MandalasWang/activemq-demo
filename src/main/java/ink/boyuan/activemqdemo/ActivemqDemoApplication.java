package ink.boyuan.activemqdemo;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootApplication
@EnableJms
public class ActivemqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqDemoApplication.class, args);
    }

    /**
     * 生產消息队列
     * @return
     */
    @Bean
    public Queue createQueue() {
        return new ActiveMQQueue("common.queue");
    }

    @Bean  //springboot 会自动注入线程池  所以不需要手动注入
    public JmsMessagingTemplate generateJmsTemplate(ConnectionFactory connectionFactory){
        return new JmsMessagingTemplate(connectionFactory);
    }


    @Bean
    public Topic topic(){
        return new ActiveMQTopic("common.topic");
    }
}
