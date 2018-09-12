package com.tanamoinc.springwebapp.command;

/**
 *
 * @author Tanamo
 */
public class LoginCommand {

    private String loginName;
    private String password;

    //Generated Getters and Setters for both Login Name and Password for Login.
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
