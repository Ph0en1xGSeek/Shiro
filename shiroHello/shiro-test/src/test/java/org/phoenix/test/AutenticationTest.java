package org.phoenix.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AutenticationTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("Ph0en1x", "1234", "admin");
    }

    @Test
    public void testAutentication(){

        // 构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Ph0en1x", "1234");
        subject.login(token);

        System.out.println("isAutenticated: " + subject.isAuthenticated());

//        subject.checkRole("admin");
        subject.checkRole("a");

        subject.logout();

        System.out.println("isAutenticated: " + subject.isAuthenticated());
    }
}
