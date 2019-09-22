package yjs.xmml.xmmlmanager.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjs.xmml.xmmlmanager.dao.provider.MessageDaoProvider;
import yjs.xmml.xmmlmanager.pojo.Message;

@Repository
@Mapper
public interface MessageDao {

    /**
     * 系统消息
     */
    @InsertProvider(type = MessageDaoProvider.class,method = "sysMessage")
    Integer sysMessage(Message message);
}
