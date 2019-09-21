package yjs.xmml.xmmlmanager.service;

import yjs.xmml.xmmlmanager.dto.UserDTO;
import yjs.xmml.xmmlmanager.pojo.UserInfo;

import java.util.*;
public interface UserInfoService {

    //获取用户列表
    List<UserDTO> getUserInfo();

    //获取待审核用户列表
    List<UserDTO> getCheckUserInfo();

    //通过登录id获取用户信息
    UserInfo getUserInfoByLoginId(Integer loginId);
}
