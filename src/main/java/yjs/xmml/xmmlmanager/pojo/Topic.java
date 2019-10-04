package yjs.xmml.xmmlmanager.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Topic {

    private Integer topicId;
    private Integer topicBuilderId;
    private String topicTitle;
    private String topicContent;
    private String topicCreateTime;
    private String topicCanReply;
    private Integer topicClickNumber;
    private String topicFlag;
}
