package ink.boyuan.activemqdemo.controller;

import ink.boyuan.activemqdemo.api.SendAmqInterface;
import ink.boyuan.activemqdemo.common.RetResponse;
import ink.boyuan.activemqdemo.common.RetResult;
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
@RequestMapping(value = "/product")
public class DemoController implements SendAmqInterface {

    @Autowired
    private ProductService productService;

    @Override
    @RequestMapping(path = "/sendQue")
    public RetResult<Object> sendMsg(@RequestParam String msg,String name){
        Queue queue = new ActiveMQQueue();
        Destination destination = ((ActiveMQQueue) queue).createDestination(name);
        productService.sendMessage(destination,msg);
        return RetResponse.makeOKRsp(name);
    }

    @Override
    @RequestMapping(value = "/sendTopic")
    public RetResult sendTopic(@RequestBody String topic,String name){
        Topic mqTopic = new ActiveMQTopic(name);
        productService.sendTopic(mqTopic,topic);
        return RetResponse.makeOKRsp(name);
    }


}
