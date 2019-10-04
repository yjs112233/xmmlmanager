package yjs.xmml.xmmlmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjs.xmml.xmmlmanager.dao.AuthDao;
import yjs.xmml.xmmlmanager.dto.AuthDTO;
import yjs.xmml.xmmlmanager.dto.UserDTO;
import yjs.xmml.xmmlmanager.pojo.Auth;
import yjs.xmml.xmmlmanager.service.AuthService;

import java.util.List;
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthDao authDao;

    @Override
    public List<Auth> getAuthListByUid(Integer loginId) {
        return authDao.getAuthListByUid(loginId);
    }

    @Override
    public List<AuthDTO> getNeedAuth() {
        return authDao.getNeedAuth();
    }

    @Override
    public Integer alterReviewById(Integer id, Integer status,String result) {
        return  authDao.alterReviewById(id,status,result);
    }
}
