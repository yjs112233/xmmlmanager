package yjs.xmml.xmmlmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import yjs.xmml.xmmlmanager.dto.UserDTO;
import yjs.xmml.xmmlmanager.pojo.UserInfo;

import java.util.*;
@Repository
@Mapper
public interface UserInfoDao {


    /**
     * 获取用户列表
     */
    @Select("select * from dm_user_info as A,dm_user_login as B where A.user_login_id=B.user_login_id ")
    List<UserDTO> getUserInfo();

    /**
     * 获取待审核用户列表
     */
    @Select("select * from dm_user_info as A,dm_user_login as B " +
            "where A.user_login_id=B.user_login_id and B.user_is_review=0 and A.user_info_registerImg is not null")
    List<UserDTO> getCheckUserInfo();

    /**
     * 通过登录id获取用户信息
     */
    @Select("select * from dm_user_info where user_login_id=#{loginId}")
    UserInfo getUserInfoByLoginId(Integer loginId);
}
