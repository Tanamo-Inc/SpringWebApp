package com.tanamoinc.springwebapp.rm;

import com.tanamoinc.springwebapp.domain.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Tanamo
 */
public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        Contact c = new Contact();
        c.setId(rs.getInt("_id"));
        c.setUserId(rs.getInt("userId"));
        c.setcName(rs.getString("cName"));
        c.setEmail(rs.getString("email"));
        c.setAddress(rs.getString("address"));
        c.setPhone(rs.getString("phone"));
        c.setRemark(rs.getString("remark"));
        return c;

    }

}
