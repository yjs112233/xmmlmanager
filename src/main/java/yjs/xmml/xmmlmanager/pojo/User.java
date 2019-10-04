package yjs.xmml.xmmlmanager.pojo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {
   private Integer userLoginId;    //主键
   private String userLoginPhone;  //电话
   private String userLoginPass;   //密码
   private String userLoginSalt;   //盐值
   private String userLastLogin;   //上次登录时间
   private Integer userLoginCount; //登录次数
   private String userCreateTime;  //账号创建时间
   private Integer userLoginOut;   //是否注销
   private Integer userLoginFrozen;//是否冻结

}
