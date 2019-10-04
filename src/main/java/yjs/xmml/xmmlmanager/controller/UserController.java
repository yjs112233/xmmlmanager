package yjs.xmml.xmmlmanager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yjs.xmml.xmmlmanager.pojo.User;
import yjs.xmml.xmmlmanager.service.UserService;
import yjs.xmml.xmmlmanager.tools.IsPhone;

@Controller
public class UserController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     *
     * @param phone        手机号
     * @param pass         密码
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public String doLogin(String phone,String pass){
        logger.info("【登录信息{手机号:{},密码:{}}】",phone,pass);
        if (!IsPhone.cheak(phone)){
            return "请输入正确的手机号";
        }
        if (pass.trim().isEmpty()&&pass.length()<6){
            return "账号或密码不正确";
        }
        String regex = "^[a-z0-9A-Z]+$";
        if (!pass.matches(regex)){
            return "账号或密码不正确";
        }
        logger.info("【通过验证，开始登录】");
        User user=userService.queryUserByPhone(phone);
        if (user==null){
            return "用户不存在,请勿继续操作";
        }
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(phone,pass);
        try{
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
            return "账号或密码不正确";
        }
        //存入shiro session
        Session shiroSession=SecurityUtils.getSubject().getSession();
        shiroSession.setAttribute("user",user);
        return "登录成功";
    }
}
