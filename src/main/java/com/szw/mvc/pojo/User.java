package com.szw.mvc.pojo;

/**
 * @Auther: szw
 * @Date: 2023/7/17 - 07 - 17 - 13:05
 * @Description: com.szw.mvc.pojo
 * @version: 1.0
 */
public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
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
    public String toString() {
        System.out.println("master");
        return null;
    }
}
