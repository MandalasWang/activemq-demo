package ink.boyuan.activemqdemo.service.impl;

import ink.boyuan.activemqdemo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;

/**
 * @author wyy
 * @version 1.0
 * @date 2019/12/16 17:33
 * @description
 **/
@Service
public class ProductServiceImpl implements ProductService {
    /**
     * 用来发送消息的模板
     */
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void sendMessage(Destination destination, String msg) {
        jmsTemplate.convertAndSend(destination,msg);
    }

    @Override
    public void sendMessage(String msg) {
        jmsTemplate.convertAndSend(this.queue,msg);
    }
}
