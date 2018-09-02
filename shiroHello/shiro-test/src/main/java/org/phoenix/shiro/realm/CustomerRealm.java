package org.phoenix.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.sql.*;

public class CustomerRealm extends AuthorizingRealm{

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //角色授权

        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //认证用户

        String username = (String)authenticationToken.getPrincipal();
        String password = getPasswordByUserName(username);
        if(password == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                "Ph0en1x", password, "customRealm"
        );
        // 传回的时候也要带盐
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));
        return authenticationInfo;
    }

    private String getPasswordByUserName(String username) {
        String url = "jdbc:mysql://127.0.0.1/test";
        String name = "root";
        String password = "1234";
        String result = null;
        try{
            Connection con = DriverManager.getConnection(url, name, password);
            String sql = String.format("select password from user where username = \'%s\'", username);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            rs.next();
            // md5加盐操作
            result = (new Md5Hash(rs.getString("password"), username)).toString();
            System.out.println(result);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return result;
    }
}
