package yjs.xmml.xmmlmanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yjs.xmml.xmmlmanager.dto.UserDTO;
import yjs.xmml.xmmlmanager.pojo.UserInfo;
import yjs.xmml.xmmlmanager.service.UserInfoService;

import java.util.*;

@Controller
@RequestMapping("userInfo")
public class UserInfoController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserInfoService userInfoService;

    /**
     * 获取用户列表
     */
    @RequestMapping("all")
    @ResponseBody
    public List<UserDTO>  getUserInfo(){
        List<UserDTO> list=userInfoService.getUserInfo();
        logger.info("【用户列表:{}】",list);
        return list;
    }

    /**
     * 获取待审核用户列表
     */
    @RequestMapping("needCheck")
    @ResponseBody
    public List<UserDTO>  getCheckUserInfo(){
        List<UserDTO> list=userInfoService.getCheckUserInfo();
        logger.info("【待审核用户列表:{}】",list);
       return list;
    }

    /**
     * 通过登录id获取用户信息
     */
    @RequestMapping("one")
    @ResponseBody
    public UserInfo getUserInfoByLoginId(Integer loginId){
        logger.info("【登录id:{}】",loginId);
        UserInfo userInfo=userInfoService.getUserInfoByLoginId(loginId);
        logger.info("【用户详情:{}】",userInfo);
        return userInfo;
    }
}
