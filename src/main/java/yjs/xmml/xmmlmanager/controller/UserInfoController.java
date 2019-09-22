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
}
