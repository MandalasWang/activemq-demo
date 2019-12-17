package ink.boyuan.activemqdemo.service;


import ink.boyuan.activemqdemo.model.MyTopic;

import javax.jms.Destination;
import javax.jms.Topic;

/**
 * @author 有缘
 * @version 1.0
 * @date 2019/12/16 17:30
 * @description
 **/
public interface ProductService {
    /**
     * 指定消息队列
     * @param destination
     * @param msg
     */
     void sendMessage(Destination destination, final String msg);

    /**
     * 使用默认消息队列发送消息
     * @param msg
     */
     void sendMessage(String msg);

    /**
     * 发布订阅
     * @param mqTopic
     * @param topic
     * @return
     */
     void sendTopic(Topic mqTopic,String topic);
}
