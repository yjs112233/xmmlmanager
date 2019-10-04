package yjs.xmml.xmmlmanager.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
    @Results({
            @Result(column = "user_login_id",property = "userLoginId"),
            @Result(column = "user_login_id",property = "auth",one = @One(
                    select = "yjs.xmml.xmmlmanager.dao.AuthDao.getAuthListByUid",fetchType = FetchType.DEFAULT
            ))
    })
    List<UserDTO> getUserInfo();


    /**
     * 通过登录id获取用户信息
     */
    @Select("select * from dm_user_info where user_login_id=#{loginId}")
    UserInfo getUserInfoByLoginId(Integer loginId);
}
