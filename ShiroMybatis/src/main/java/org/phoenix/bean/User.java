package org.phoenix.bean;

public class User {
    private Integer uid;
    private String username;

    //不返回password
//    @JsonIgnore
    private String password;



    public Integer getId() {
        return uid;
    }

    public void setId(Integer id){
        this.uid = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "UserDao{" +
                "id=" + uid +
                ", username=" + username +
                ", password=" + password +
                "}";
    }
}
