package yjs.xmml.xmmlmanager.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import yjs.xmml.xmmlmanager.pojo.Message;


public class MessageDaoProvider {

    public String sysMessage(Message message){
        return new SQL(){{
            INSERT_INTO("dm_message");
            if (message.getSenderId()!=null && message.getSenderId()!=0){
                VALUES("sender_id","#{senderId}");
            }
            if (message.getSenderName()!=null && message.getSenderName()!=""){
                VALUES("sender_name","#{senderName}");
            }
            if (message.getReceiverId()!=null && message.getReceiverId()!=0){
                VALUES("receiver_id","#{receiverId}");
            }
            if (message.getReceiverName()!=null && message.getReceiverName()!=""){
                VALUES("receiver_name","#{receiverName}");
            }
            VALUES("send_time","#{sendTime}");
            VALUES("message_content","#{messageContent}");

        }}.toString();
    }
}
