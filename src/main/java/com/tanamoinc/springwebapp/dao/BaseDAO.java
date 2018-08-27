package com.tanamoinc.springwebapp.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author Tanamo
 */
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void setDataSource3(DataSource ds) {
        super.setDataSource(ds);
    }

}
