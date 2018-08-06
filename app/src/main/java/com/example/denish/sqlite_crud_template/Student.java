package com.example.denish.sqlite_crud_template;

/**
 * Created by denish on 4/8/18.
 */
public class Student {

    private int id;
    private String name;
    private String password;
    private String userid;

    public Student() {
    }

    public Student(int id, String name, String password, String userid) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return name + " - " + userid + " - " + password;
    }

}
