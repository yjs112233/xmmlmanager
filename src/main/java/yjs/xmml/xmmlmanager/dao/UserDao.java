package yjs.xmml.xmmlmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import yjs.xmml.xmmlmanager.pojo.User;

import java.util.List;

@Repository
@Mapper
public interface UserDao {

    /**
     * 通过手机号查询用户
     * @param phone
     * @return
     */
    @Select("select * from dm_user_login where user_login_phone=#{phone}")
    User getUserByPhone(String phone);
}
