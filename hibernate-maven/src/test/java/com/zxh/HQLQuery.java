package com.zxh;

import com.zxh.entity.User;
import com.zxh.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class HQLQuery {

    @Test
    public void test1(){
        Session session = HibernateUtils.getSession();
        String sql ="from User t where t.name='lisi'";
        Query query = session.createQuery(sql);
        List<User> list = query.list();
        System.out.println(list);
        session.close();
    }

    @Test
    public void test2(){
        Session session = HibernateUtils.getSession();
        String sql ="select t.id,t.name from User t";
        Query query = session.createQuery(sql);
        List<Object[]> list = query.list();
        Iterator<Object[]> iter = list.iterator();
        while (iter.hasNext()) {
            Object[] objs = iter.next();
            System.out.println(objs[0] + " \t" + objs[1]);
        }
        session.close();
    }

    @Test
    public void test3(){
        Session session = HibernateUtils.getSession();
        String sql ="select new User (t.id,t.name) from User t";
        Query query = session.createQuery(sql);
        List<User> list = query.list();
        System.out.println(list);
        session.close();
    }

    @Test
    public void test4(){
        Session session = HibernateUtils.getSession();
        //使用？作为占位符，后面需要指定所在的位置索引
        String sql ="from User t where t.name like ?0 and t.password like ?1";
        Query query = session.createQuery(sql);
        //根据位置设置查询条件,位置表示的是？所在的索引位置，如第一个后面是0
        query.setString(0,"%zhang%").setString(1,"%12%");
        List<User> list = query.list();
        System.out.println(list);
        session.close();
    }

    @Test
    public void test5(){
        Session session = HibernateUtils.getSession();
        //使用:命名参数
        String sql ="from User t where t.name like :name1 and t.password like :pwd";
        Query query = session.createQuery(sql);
        //根据参数名称设置参数
        query.setParameter("name1","%zhang%").setParameter("pwd","%12%");
        List<User> list = query.list();
        System.out.println(list);
        session.close();
    }

    @Test
    public void test6(){
        Session session = HibernateUtils.getSession();
        String sql ="from User";
        Query query = session.createQuery(sql);
        //设置查询的起始索引
        query.setFirstResult(2);
        //设置查询的条数
        query.setMaxResults(10);
        List<User> list = query.list();
        System.out.println(list);
        session.close();
    }



}
