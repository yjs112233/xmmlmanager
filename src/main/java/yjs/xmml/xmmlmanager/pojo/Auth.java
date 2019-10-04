package yjs.xmml.xmmlmanager.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Auth {

    private Integer authId;
    private Integer authUserId;
    private String authImg;
    /**创建时间*/
    private Date authCreateTime;
    /**审核时间*/
    private Date authVerifyTime;
    /**0 未审核  1待审核  9已审核*/
    private Integer authStatus;
    /**审核结果*/
    private String authResult;
    private Integer authFlag;
}
