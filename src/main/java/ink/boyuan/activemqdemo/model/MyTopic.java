package ink.boyuan.activemqdemo.model;

import java.io.Serializable;

/**
 * @author wyy
 * @version 1.0
 * @date 2019/12/16 19:44
 * @description
 **/
public class MyTopic implements Serializable {


    private String name;

    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
