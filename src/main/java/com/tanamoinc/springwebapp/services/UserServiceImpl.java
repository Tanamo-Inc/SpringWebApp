package com.tanamoinc.springwebapp.services;

import com.tanamoinc.springwebapp.dao.BaseDAO;
import com.tanamoinc.springwebapp.dao.UserDAO;
import com.tanamoinc.springwebapp.domain.User;
import com.tanamoinc.springwebapp.exceptions.UserBlockedException;
import com.tanamoinc.springwebapp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanamo
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void register(User u) {
        userDAO.save(u);
    }

    @Override
    public User login(String loginName, String password) throws UserBlockedException {
        String sql = "SELECT _id, name, phone, email, address, role, loginStatus, loginName"
                + " FROM user_table WHERE loginName=:name AND password=:pass";
        Map m = new HashMap();
        m.put("name", loginName);
        m.put("pass", password);
        try {
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            if (u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
                throw new UserBlockedException("Your accout has been blocked. Contact the Sdmin.");
            } else {
                return u;
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        return userDAO.findByProperty("role", UserService.ROLE_USER);
    }

    @Override
    public void changeLoginStatus(Integer _Id, Integer loginStatus) {
        String sql = "UPDATE user_table SET loginStatus=:lst WHERE _id=:_id";
        Map m = new HashMap();
        m.put("_id", _Id);
        m.put("lst", loginStatus);
        getNamedParameterJdbcTemplate().update(sql, m);
    }

}
