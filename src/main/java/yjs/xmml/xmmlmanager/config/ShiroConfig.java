package yjs.xmml.xmmlmanager.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yjs.xmml.xmmlmanager.ream.MyShiroReam;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean= new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        Map map = new LinkedHashMap();
//        map.put("/visit.html","anon");
//        map.put("/fore/visit","anon");
//        map.put("/app_login.html","anon");
//        map.put("/fore/app/login","anon");
//        map.put("/pc_login.html","anon");
//        map.put("/fore/pc/login","anon");
//        map.put("/user/logout","logout");
//        map.put("/*.css","anon");
//        map.put("/*.js","anon");
//        map.put("/*.jpg","anon");
//        map.put("/*.png","anon");
        map.put("/**","anon");
        filterFactoryBean.setFilterChainDefinitionMap(map);
        return filterFactoryBean;
    }
    @Bean
    public SessionsSecurityManager securityManager(MyShiroReam realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public MyShiroReam getMyRealm(){
       MyShiroReam ream=new MyShiroReam();
       return ream;
    }

}
