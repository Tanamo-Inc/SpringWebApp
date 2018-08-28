package com.tanamoinc.springwebapp.dao;

import com.tanamoinc.springwebapp.domain.Contact;
import com.tanamoinc.springwebapp.rm.ContactRowMapper;
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
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

    @Override
    public void save(Contact c) {

        String sql = "INSERT INTO contact_table(_id, name, phone, email, address, remark) VALUES(:_id, :name, :phone, :email, :address, :remark)";
        Map m = new HashMap();
        m.put("userId", c.getUserId());
        m.put("name", c.getcName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        c.setId(kh.getKey().intValue());

    }

    @Override
    public void update(Contact c) {
        String sql = "UPDATE contact_table SET name=:name, phone=:phone, email=:email, address=:address, remark=:remark WHERE _id=:_id";
        Map m = new HashMap();
        m.put("_id", c.getId());
        m.put("cName", c.getcName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        getNamedParameterJdbcTemplate().update(sql, m);

    }

    @Override
    public void delete(Contact c) {
        this.delete(c.getId());
    }

    @Override
    public void delete(Integer contactId) {
        String sql = "DELETE FROM contact_table WHERE _id=?";
        getJdbcTemplate().update(sql, contactId);
    }

    @Override
    public Contact findById(Integer contactId) {
        String sql = "SELECT _id, userId, name, phone, email, address, remark FROM contact WHERE _id=?";
        return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
    }

    @Override
    public List<Contact> findAll() {
        String sql = "SELECT _id, userId, name, phone, email, address, remark FROM contact_table";
        return getJdbcTemplate().query(sql, new ContactRowMapper());
    }

    @Override
    public List<Contact> findByProperty(String propName, Object propValue) {
        String sql = "SELECT _id, userId, name, phone, email, address, remark FROM contact_table WHERE " + propName + "=?";
        return getJdbcTemplate().query(sql, new ContactRowMapper(), propValue);
    }

}
