package yjs.xmml.xmmlmanager.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Message {

    /**主键id*/
    private Integer messageId;
    /**发送者名字*/
    private String senderName;
    /**发送者id*/
    private Integer senderId;
    /**消息内容*/
    private String messageContent;
    /**接收者名字*/
    private String receiverName;
    /**接收者id*/
    private Integer receiverId;
    /**发送时间*/
    private String sendTime;
    /**接收时间*/
    private String receiveTime;
    /**状态*/
    private String status;

}
