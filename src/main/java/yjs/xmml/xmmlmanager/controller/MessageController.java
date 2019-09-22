package yjs.xmml.xmmlmanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yjs.xmml.xmmlmanager.pojo.Message;

@Controller
@RequestMapping("message")
public class MessageController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     * 系统消息
     * @return
     */
    @RequestMapping
    @ResponseBody
    public String sysMessage(Message message){
        logger.info("【消息详情】:{}",message);
        return null;
    }
}
