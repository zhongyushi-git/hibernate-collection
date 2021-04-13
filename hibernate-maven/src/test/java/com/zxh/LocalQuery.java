package com.zxh;

import com.zxh.entity.User;
import com.zxh.util.HibernateUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class LocalQuery {

    @Test
    public void test1() {
        Session session = HibernateUtils.getSession();
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
        List<Object> queryList = sqlQuery.list();
        System.out.println(queryList);
        session.close();
    }

    @Test
    public void test2() {
        Session session = HibernateUtils.getSession();
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
        //设置封装对象
        sqlQuery.addEntity(User.class);
        List<Object> queryList = sqlQuery.list();
        System.out.println(queryList);
        session.close();
    }

    @Test
    public void test3() {
        Session session = HibernateUtils.getSession();
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_user where name=:name");
        //设置封装对象
        sqlQuery.addEntity(User.class);
        //指定参数
        sqlQuery.setString("name","zhangsan111");
        List<Object> queryList = sqlQuery.list();
        System.out.println(queryList);
        session.close();
    }


}
