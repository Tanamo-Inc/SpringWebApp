package com.tanamoinc.springwebapp.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @author Tanamo
 *
 *
 * DAO stands for Data Access Object.
 *
 *
 * DAOs provide some specific data operations without exposing details of the
 * database
 *
 *
 * DAO is a design pattern, which consist on creating for each table on your
 * database a class,it provides a technique for separating object persistence
 * and data access logic
 *
 */
abstract public class BaseDAO extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void setDataSource3(DataSource ds) {
        super.setDataSource(ds);
    }

}
