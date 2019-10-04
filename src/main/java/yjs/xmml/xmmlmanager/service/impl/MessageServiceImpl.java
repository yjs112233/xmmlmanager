package yjs.xmml.xmmlmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjs.xmml.xmmlmanager.dao.MessageDao;
import yjs.xmml.xmmlmanager.pojo.Message;
import yjs.xmml.xmmlmanager.service.MessageService;
import yjs.xmml.xmmlmanager.tools.DateFormat;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    @Override
    public void sysMessage(Message message) {
        //发送者：系统
        message.setSendTime(DateFormat.parse(new Date()));
        messageDao.sysMessage(message);
    }
}
