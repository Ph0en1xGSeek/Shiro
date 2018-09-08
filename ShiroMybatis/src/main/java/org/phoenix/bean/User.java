package org.phoenix.bean;

public class User {
    private Integer id;
    private String name;

    //不返回password
//    @JsonIgnore
    private String password;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUsername(){
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", username=" + name +
                ", password=" + password +
                "}";
    }
}
