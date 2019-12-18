package ink.boyuan.activemqconsumer.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * @author wyy
 * @version 1.0
 * @date 2019/12/16 19:37
 * @description
 **/
@Component
public class TopicListener {



    @JmsListener(destination = "demo.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        System.out.println("TopicListener: consumer-a 收到一条信息: " + text);
    }
    @JmsListener(destination = "demo.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive1(String text){
        System.out.println("TopicListener: consumer-a 收到一条信息: " + text);
    }

}
