package com.tanamoinc.springwebapp.services;

import com.tanamoinc.springwebapp.dao.BaseDAO;
import com.tanamoinc.springwebapp.dao.ContactDAO;
import com.tanamoinc.springwebapp.domain.Contact;
import com.tanamoinc.springwebapp.rm.ContactRowMapper;
import com.tanamoinc.springwebapp.utils.Utils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanamo
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public void save(Contact c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contact c) {
        contactDAO.update(c);
    }

    @Override
    public void delete(Integer cotactId) {
        contactDAO.delete(cotactId);
    }

    @Override
    public void delete(Integer[] cotactIds) {
        String ids = Utils.toCommaSeparatedString(cotactIds);
        String sql = "DELETE FROM contact_table WHERE _id IN(" + ids + ")";
        getJdbcTemplate().update(sql);
    }

    @Override
    public Contact findById(Integer cotactId) {
        return contactDAO.findById(cotactId);
    }

    @Override
    public List<Contact> findUserContact(Integer userId) {
        return contactDAO.findByProperty("userId", userId);
    }
    
    @Override
    public List<Contact> findUserContact(Integer userId, String txt) {
        String sql = "SELECT _id, userId, cName, phone, email, address, remark FROM contact_table WHERE _id=? AND (name LIKE '%" + txt + "%' OR address LIKE '%" + txt + "%' OR phone LIKE '%" + txt + "%' OR email LIKE '%" + txt + "%' OR remark LIKE '%" + txt + "%')";
        return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
    }

}
