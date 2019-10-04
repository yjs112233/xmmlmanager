package yjs.xmml.xmmlmanager.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Reply {
    /**主键id*/
    private Integer replyId;
    /**话题id*/
    private Integer replyTopicId;
    /**评论者id*/
    private Integer replyUserId;
    /**评论者名字*/
    private String replyUserName;
    /**评论发表时间*/
    private Date replyCreateTime;
    /**评论内容*/
    private String replyContent;
    /**父级评论id*/
    private Integer replyParentId;
    private Integer replyFlag;


}
