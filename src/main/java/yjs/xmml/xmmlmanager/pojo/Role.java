package yjs.xmml.xmmlmanager.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Role {

    private Integer roleId;
    private String roleName;
    private String roleType;
    /**角色描述*/
    private String roleDescription;
}
