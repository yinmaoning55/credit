package com.neuedu.credit.util.phoenix;

import com.neuedu.credit.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Created by elvin on 2018/11/8 11:16.
 * @Describe: phoenix 样类，针对不同表需要自定义实现
 */
@Component
public class PhoenixUtil {

    private static Connection con;
    private static Logger logger = LoggerFactory.getLogger(PhoenixUtil.class);
    public PhoenixUtil() { }
    public  Connection getInstance(){
        try {
            if(con == null) {
                con = DriverManager.getConnection("jdbc:phoenix:hadoop.elvin.com:2181", "hadoop", "hadoop");
            }
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(ExceptionUtil.getMessage(e));
        }
        return null;
    }


}
