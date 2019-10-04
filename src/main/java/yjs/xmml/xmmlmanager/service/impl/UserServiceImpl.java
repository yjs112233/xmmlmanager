package yjs.xmml.xmmlmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjs.xmml.xmmlmanager.dao.UserDao;
import yjs.xmml.xmmlmanager.pojo.User;
import yjs.xmml.xmmlmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public User queryUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }
}
