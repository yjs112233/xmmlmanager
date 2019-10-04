package yjs.xmml.xmmlmanager.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class AuthDTO {

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
    private Integer userLoginId;    //主键
    private String userLoginPhone;  //电话
    private String userLoginPass;   //密码
    private String userLoginSalt;   //盐值
    private String userLastLogin;   //上次登录时间
    private Integer userLoginCount; //登录次数
    private String userCreateTime;  //账号创建时间
    private Integer userLoginOut;   //是否注销
    private Integer userLoginFrozen;//是否冻结
    /**主键id*/
    private Integer userInfoId;
    /**用户真实姓名*/
    private String userInfoName;
    /**用户所在学校*/
    private String userInfoSchool;
    /**学校所在省份*/
    private String userInfoSchoolProvince;
    /**学校所在城市*/
    private String userInfoSchoolCity;
    /**所学专业*/
    private String userInfoMajor;
    /**毕业时间*/
    private String userInfoGraduationDate;
    /**社区昵称*/
    private String userInfoNickName;
    /**用户性别*/
    private String userInfoSex;
    /**用户邮箱*/
    private String userInfoEmail;
    /**用户微信号*/
    private String userInfoWechat;
    /**用户余额*/
    private String userInfoBlance;
    /**用户优惠券*/
    private String userInfoCoupon;
    /**支付宝账号*/
    private String userInfoAlipayId;
    /**微信支付账号*/
    private String userInfoVxpayId;
    /**软删除*/
    private Integer userInfoFlag;


}
