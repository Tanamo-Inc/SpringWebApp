package com.tanamoinc.springwebapp.dao;

import com.tanamoinc.springwebapp.domain.User;
import com.tanamoinc.springwebapp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tanamo
 */
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

    @Override
    public void save(User u) {
        String sql = "INSERT INTO user_table(name, phone, email, address, loginName, password, role, loginStatus)"
                + " VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("loginName", u.getLoginName());
        m.put("password", u.getPassword());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setId(userId);
    }

    @Override
    public void update(User u) {
        String sql = "UPDATE user_table SET name=:name, phone=:phone, email=:email,address=:address,role=:role,loginStatus=:loginStatus  WHERE _id=:_id";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());
        m.put("_id", u.getId());
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(User u) {
        this.delete(u.getId());
    }

    @Override
    public void delete(Integer Id) {
        String sql = "DELETE FROM user_table WHERE _id=?";
        getJdbcTemplate().update(sql, Id);
    }

    @Override
    public User findById(Integer userId) {
        String sql = "SELECT _id, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user_table WHERE _id=?";
        User u = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
        return u;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT _id, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user_table";

        List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
        return users;
    }

    @Override
    public List<User> findByProperty(String propName, Object propValue) {
        String sql = "SELECT _id, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user_table WHERE " + propName + "=?";
        return getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
    }

}
