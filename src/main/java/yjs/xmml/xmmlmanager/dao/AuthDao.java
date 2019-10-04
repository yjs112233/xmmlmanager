package yjs.xmml.xmmlmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import yjs.xmml.xmmlmanager.dto.AuthDTO;
import yjs.xmml.xmmlmanager.dto.UserDTO;
import yjs.xmml.xmmlmanager.pojo.Auth;

import java.util.List;

@Mapper
@Repository
public interface AuthDao {

    //获取用户所有审核记录并排序
    @Select("select * from dm_auth where auth_user_id=#{loginId} order by auth_create_time desc")
    List<Auth> getAuthListByUid(Integer loginId);

    //获取待审核用户列表
    @Select("select * from dm_auth AS A,dm_user_info AS B,dm_user_login AS C " +
            "where A.auth_user_id=C.user_login_id and B.user_login_id=C.user_login_id and A.auth_status=1")
    List<AuthDTO> getNeedAuth();

    //处理审核结果
    @Update("update dm_auth set auth_status=#{status},auth_result=#{result} where auth_user_id=#{id}")
    Integer alterReviewById(Integer id,Integer status,String result);
}
