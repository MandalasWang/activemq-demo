package ink.boyuan.activemqdemo.controller;

import ink.boyuan.activemqdemo.model.MyTopic;
import ink.boyuan.activemqdemo.service.ProductService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author wyy
 * @version 1.0
 * @date 2019/12/16 18:39
 * @description
 **/
@RestController
@RequestMapping(value = "")
public class DemoController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/test")
    public String sendMsg(@RequestParam String msg){
        Queue queue = new ActiveMQQueue();
        Destination destination = ((ActiveMQQueue) queue).createDestination("demo.queue");
        productService.sendMessage(destination,msg);
        return "success";
    }

    @RequestMapping(value = "/topic")
    public String sendTopic(@RequestBody MyTopic topic){
        Topic mqTopic = new ActiveMQTopic("demo.topic");
       return productService.sendTopic(mqTopic,topic);
    }


}
