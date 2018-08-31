package com.tanamoinc.springwebapp.services;

import com.tanamoinc.springwebapp.domain.User;
import com.tanamoinc.springwebapp.exceptions.UserBlockedException;
import java.util.List;

/**
 *
 * @author Tanamo
 */
public interface UserService {

    public static final Integer LOGIN_STATUS_ACTIVE = 1;
    public static final Integer LOGIN_STATUS_BLOCKED = 2;

    public static final Integer ROLE_ADMIN = 1;
    public static final Integer ROLE_USER = 2;

    public void register(User u);

    /**
     * Handles login operation(authentication) using given credentials, it
     * returns User object when success and null when failed. When user account
     * is blocked an exception will be thrown by this method.
     *
     * @param loginName
     * @param password
     * @return
     */
    public User login(String loginName, String password) throws UserBlockedException;

    public List<User> getUserList();

    public void changeLoginStatus(Integer userId, Integer loginStatus);

}
