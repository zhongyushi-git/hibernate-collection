package com.zxh;

import com.zxh.entity.User;
import com.zxh.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class QBCQuery {

    @Test
    public void test1(){
        Session session = HibernateUtils.getSession();
        Criteria criteria = session.createCriteria(User.class);
        // 设定查询条件
        LogicalExpression expression = Restrictions.or(Restrictions.like("name", "%li%"), Restrictions.eq("id", 3));
        // 添加查询条件
        criteria.add(expression);
        // 执行查询，返回查询结果
        List<User> list = criteria.list();
        System.out.println(list);
        session.close();
    }

    @Test
    public void test2(){
        Session session = HibernateUtils.getSession();
        Criteria criteria = session.createCriteria(User.class);
        // 设定分页条件
        criteria.setFirstResult(2);
        criteria.setMaxResults(10);
        // 执行查询，返回查询结果
        List<User> list = criteria.list();
        System.out.println(list);
        session.close();
    }
}
