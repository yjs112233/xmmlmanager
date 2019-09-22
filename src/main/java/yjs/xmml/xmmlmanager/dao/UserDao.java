package yjs.xmml.xmmlmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    /**
     * 修改身份验证状态
     */
    @Update("update dm_user_login set user_is_review=1 where user_login_id=#{id}")
    Integer alterReview(Integer id);
}
