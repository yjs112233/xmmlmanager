package yjs.xmml.xmmlmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjs.xmml.xmmlmanager.dao.UserInfoDao;
import yjs.xmml.xmmlmanager.dto.UserDTO;
import yjs.xmml.xmmlmanager.pojo.UserInfo;
import yjs.xmml.xmmlmanager.service.UserInfoService;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public List<UserDTO> getUserInfo() {
        return userInfoDao.getUserInfo();
    }


    @Override
    public UserInfo getUserInfoByLoginId(Integer loginId) {
        return userInfoDao.getUserInfoByLoginId(loginId);
    }
}
