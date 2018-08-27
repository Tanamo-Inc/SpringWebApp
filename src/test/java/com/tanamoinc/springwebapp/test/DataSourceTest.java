package com.tanamoinc.springwebapp.test;

import com.tanamoinc.springwebapp.config.SpringRoot;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Tanamo
 */
public class DataSourceTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRoot.class);
         DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        
          String sql="INSERT INTO user_table(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
        
        Object[] param = new Object[]{"Tanamo", "+23311360", "tanamoinc@gmail.com", "Knust", "tanamo", "123456"};
        jt.update(sql, param);
        System.out.println("------SQL executed-----");
        
        
    }

}
