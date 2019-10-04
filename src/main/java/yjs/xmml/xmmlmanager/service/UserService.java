package yjs.xmml.xmmlmanager.service;

import yjs.xmml.xmmlmanager.pojo.User;

public interface UserService {

    User queryUserByPhone(String phone);
}
