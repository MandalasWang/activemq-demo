package ink.boyuan.activemqconsumer.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author wyy
 * @version 1.0
 * @date 2019/12/16 19:34
 * @description
 **/
@Component
public class QueueListener {

    @JmsListener(destination = "demo.queue", containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")
    public String receive(String text){
        System.out.println("QueueListener: consumer-a 收到一条信息: " + text);
        return "consumer-a received : " + text;
    }

}
