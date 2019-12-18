package ink.boyuan.activemqdemo.api;

import ink.boyuan.activemqdemo.common.RetResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jms.JMSException;


/**
 * @author 有缘
 * @version 1.0
 * @date 2019/12/17 10:09
 * @description
 **/
public interface SendAmqInterface {
    /**
     * 生产消息队列
     * @param msg
     * @param name
     * @return
     */
    @RequestMapping(path = "/amq/product/sendQue",method = RequestMethod.GET)
    public RetResult<Object> sendMsg(@RequestParam(value = "msg") String msg, @RequestParam(value = "name") String name);

    /**
     * 发布订阅
     * @param topic
     * @param name
     * @return
     */
    @RequestMapping(value = "/amq/product/sendTopic",method = RequestMethod.GET)
    public RetResult sendTopic(@RequestBody String topic)throws JMSException;
}
