package yjs.xmml.xmmlmanager.ream;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import yjs.xmml.xmmlmanager.pojo.User;
import yjs.xmml.xmmlmanager.service.UserService;

public class MyShiroReam extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String phone=(String) authenticationToken.getPrincipal();
        User user= userService.queryUserByPhone(phone);
        if (user==null){
            throw new UnknownAccountException("用户不存在");
        }
        ByteSource salt=ByteSource.Util.bytes(user.getUserLoginSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getUserLoginPass(),salt,this.getName());
        return  info;
    }


    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1713);
        super.setCredentialsMatcher(matcher);
    }
}
