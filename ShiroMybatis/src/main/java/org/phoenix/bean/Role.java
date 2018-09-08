package org.phoenix.bean;

public class Role {
    private Integer rid;
    private String name;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Role{" +
                "id=" + rid +
                ", name+" + name +
                "}";
    }
}
