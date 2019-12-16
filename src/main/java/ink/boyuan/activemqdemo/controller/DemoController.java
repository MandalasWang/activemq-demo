package ink.boyuan.activemqdemo.controller;

import ink.boyuan.activemqdemo.service.ProductService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;

/**
 * @author wyy
 * @version 1.0
 * @date 2019/12/16 18:39
 * @description
 **/
@RestController
@RequestMapping(value = "/")
public class DemoController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "test")
    public String sendMsg(@RequestParam String msg){
        Queue queue = new ActiveMQQueue();
        Destination destination = ((ActiveMQQueue) queue).createDestination("demo.queue");
        productService.sendMessage(destination,msg);
        return "success";
    }



}
