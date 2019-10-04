package yjs.xmml.xmmlmanager.service;

import yjs.xmml.xmmlmanager.dto.AuthDTO;
import yjs.xmml.xmmlmanager.dto.UserDTO;
import yjs.xmml.xmmlmanager.pojo.Auth;

import java.util.List;

public interface AuthService {

    /**
     * 获取用户所有的审核记录
     */
    List<Auth> getAuthListByUid(Integer loginId);

    /**
     * 获取待审核用户列表
     */
    List<AuthDTO> getNeedAuth();

    /**
     * 处理审核结果
     */
    Integer alterReviewById(Integer id,Integer status,String result);
}
