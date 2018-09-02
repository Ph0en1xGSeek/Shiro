package org.phoenix.test;

import org.phoenix.shiro.realm.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class CustomRealmTest {
    @Test
    public void testAutentication(){

        CustomerRealm customerRealm = new CustomerRealm();

        // 构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customerRealm);

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        customerRealm.setCredentialsMatcher(matcher);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Ph0en1x", "1234");
        subject.login(token);

        System.out.println("isAutenticated: " + subject.isAuthenticated());

//        subject.checkRole("admin");
//        subject.checkPermission("user:delete");
        subject.logout();

        System.out.println("isAutenticated: " + subject.isAuthenticated());
    }
}
