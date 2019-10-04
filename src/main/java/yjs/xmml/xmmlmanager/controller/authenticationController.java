package yjs.xmml.xmmlmanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yjs.xmml.xmmlmanager.dto.AuthDTO;
import yjs.xmml.xmmlmanager.pojo.Auth;
import yjs.xmml.xmmlmanager.pojo.Message;
import yjs.xmml.xmmlmanager.pojo.UserInfo;
import yjs.xmml.xmmlmanager.service.AuthService;
import yjs.xmml.xmmlmanager.service.MessageService;
import yjs.xmml.xmmlmanager.service.UserInfoService;
import yjs.xmml.xmmlmanager.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("authentication")
public class authenticationController {


    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;
    @Autowired
    AuthService authService;
    /**
     * 获取待审核用户列表
     */
    @RequestMapping("needCheck")
    @ResponseBody
    public List<AuthDTO> getCheckUserInfo(){
        List<AuthDTO> list=authService.getNeedAuth();
        logger.info("【待审核用户列表:{}】",list);
        return list;
    }

    /**
     * 查看待审核用户所有历史记录详情
     */
    @RequestMapping("one")
    @ResponseBody
    public Map  getUserInfoByLoginId(Integer loginId){
        logger.info("【登录id:{}】",loginId);
        UserInfo userInfo=userInfoService.getUserInfoByLoginId(loginId);
        logger.info("【用户详情:{}】",userInfo);
        List<Auth> authList= authService.getAuthListByUid(loginId);
        logger.info("【用户审核历史记录:{}】",authList);
        Map map=new HashMap();
        map.put("info",userInfo);
        map.put("authList",authList);
        return map;
    }
    /**
     * 处理审核结果
     */
    @RequestMapping("result")
    @ResponseBody
    public String authResult(Message message,String check){
        logger.info("【消息详情:{},处理结果:{}】",message,check);
        if (check.equals("允许通过")){
            //发送短信
            //修改身份验证状态:审核成功
            authService.alterReviewById(message.getReceiverId(),9,"成功");
        }else {
            //修改身份验证状态:审核失败
            authService.alterReviewById(message.getReceiverId(),8,message.getMessageContent());
        }
            //发送系统消息
        messageService.sysMessage(message);
        return "处理成功";
    }

}
