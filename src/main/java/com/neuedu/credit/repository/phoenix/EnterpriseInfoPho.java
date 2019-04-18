package com.neuedu.credit.repository.phoenix;

import com.neuedu.credit.pojo.TbEnterprise;
import com.neuedu.credit.util.phoenix.PhoenixUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by elvin on 2018/11/12 16:02.
 * @Describe:
 */
@Component
public class EnterpriseInfoPho {

    @Autowired
    PhoenixUtil phoenixUtil;

    public  List<TbEnterprise> query(int entid) throws SQLException, ParseException {
        ResultSet rset;
        Connection  con = phoenixUtil.getInstance();
        List<TbEnterprise> entList = new ArrayList<>();
        PreparedStatement  preparedStatement = con.prepareStatement("select * from ph_enterprise where entid = ?");
        preparedStatement.setInt(1,entid);
        rset = preparedStatement.executeQuery();
        /*
        *    每个实体需要自定义返回List，因为ResultSet结果集数据读取需要用.next
        */
        while (rset.next()) {
            int id = rset.getInt("entid"); // 获取第一个列的值 编号id
            String creditNum = rset.getString("creditnum");
            String entName = rset.getString("entname");
            String entstatus = rset.getString("entstatus");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date registertime = new Date( sdf.parse(rset.getString("registertime")).getTime());
            TbEnterprise ent=new TbEnterprise();//book对象实例化
            ent.setEntid(id);
            ent.setCreditnum(creditNum);
            ent.setEntname(entName);
            ent.setEntstatus(entstatus);
            ent.setRegistertime(registertime);
            entList.add(ent);//添加进集合
        }
        preparedStatement.close();
        return  entList;
    }

    public  List<TbEnterprise> queryList(String name) throws SQLException, ParseException {
        ResultSet rset;
        Connection  con = phoenixUtil.getInstance();
        List<TbEnterprise> entList = new ArrayList<>();
        PreparedStatement  preparedStatement = con.prepareStatement("select * from ph_enterprise where entname like ? ");
        preparedStatement.setString(1,"%"+name+"%");
        rset = preparedStatement.executeQuery();
            while (rset.next()) {
            int id = rset.getInt("entid"); // 获取第一个列的值 编号id
            String creditNum = rset.getString("creditnum");
            String entName = rset.getString("entname");
            String entstatus = rset.getString("entstatus");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date registertime = new Date( sdf.parse(rset.getString("registertime")).getTime());
            TbEnterprise ent=new TbEnterprise();//book对象实例化
            ent.setEntid(id);
            ent.setCreditnum(creditNum);
            ent.setEntname(entName);
            ent.setEntstatus(entstatus);
            ent.setRegistertime(registertime);
            entList.add(ent);//添加进集合
        }
        preparedStatement.close();
        return  entList;
    }

    /**
     * @Created elvin yuan on 17:26 2018/11/12
     * @Describe //TODO 时间最好存字符串
     * @Param
     * @return
    */
    public  void create(String sql) throws SQLException {
        Connection  con = phoenixUtil.getInstance();
        Statement stmt = con.createStatement();
        if (sql == null) {
            sql = "create table IF NOT EXISTS  ph_enterprise (entid integer not null primary key,creditnum varchar,entname varchar,entstatus varchar,registertime varchar )";
        }
        stmt.executeUpdate(sql);
        con.commit();
    }

    public  void upsert(String sql) throws SQLException, ParseException {
        Connection  con = phoenixUtil.getInstance();
        Statement stmt  = con.createStatement();
        if (sql == null) {
            sql = "upsert into ph_enterprise values (1,'910078781289676N','天津卫酒集团有限公司','开业','2012-05-31')";
        }
        stmt.executeUpdate(sql);
        con.commit();
    }

}
