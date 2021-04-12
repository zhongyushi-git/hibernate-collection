package com.zxh;

import com.zxh.entity.User;
import com.zxh.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest1 {
    Logger logger = LoggerFactory.getLogger(MyTest1.class);

    @Test
    public void test1() {
        //初始化注册服务对象
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()//默认加载hibernate.cfg .xmL配置文件，如果配置文件名称被修改，configure("修改的名字")
                .build();
        //从元信息获取session工厂
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        //从工厂创建session连接
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        //创建实例
        User user = new User();
        user.setName("zhangsan111");
        user.setPassword("1223111");
        session.save(user);
        //提交事务
        tx.commit();
        //关闭
        session.close();

    }

    @Test
    public void test2() {
        //初始化注册服务对象
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()//默认加载hibernate.cfg .xmL配置文件，如果配置文件名称被修改，configure("修改的名字")
                .build();
        //从元信息获取session工厂
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        //从工厂创建session连接
        Session session = sessionFactory.openSession();
        //获取事务
        Transaction tx = session.beginTransaction();
        //创建实例
        User user = new User();
        user.setId(1);
        user.setName("王海红");
        user.setPassword("9999");
        //提交事务
        session.update(user);
        tx.commit();
        //关闭session
        session.close();
    }

    @Test
    public void test3() {
        //初始化注册服务对象
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()//默认加载hibernate.cfg .xmL配置文件，如果配置文件名称被修改，configure("修改的名字")
                .build();
        //从元信息获取session工厂
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        //从工厂创建session连接
        Session session = sessionFactory.openSession();

        User user = session.get(User.class, 1);
        System.out.println(user);

        //关闭session
        session.close();
    }

    @Test
    public void test4() {
        //初始化注册服务对象
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()//默认加载hibernate.cfg .xmL配置文件，如果配置文件名称被修改，configure("修改的名字")
                .build();
        //从元信息获取session工厂
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        //从工厂创建session连接
        Session session = sessionFactory.openSession();
        //获取事务
        Transaction tx = session.beginTransaction();
        //创建实例进行查询
        User user = session.get(User.class, 1);
        //删除
        session.delete(user);
        //提交事务
        tx.commit();
        //关闭session
        session.close();
    }


    @Test
    public void test5() {
        Session session = HibernateUtils.getSession();
        User user = session.get(User.class, 2);
        System.out.println(user);
        User user2 = session.get(User.class, 2);
        System.out.println(user2);
        //关闭session
        session.close();
    }

    @Test
    public void test6() {
        Session session = HibernateUtils.getSession();
        User user = new User();
        user.setName("李焕英");
        user.setPassword("123456");
        //向一级缓存中存入session对象
        session.save(user);
        //重新设置值
        user.setPassword("000000");
        //提交事务
        session.beginTransaction().commit();
        //关闭session
        session.close();
    }

    @Test
    public void test7() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        User user = session.get(User.class, 8);
        //重新设置值
        user.setPassword("9999");
        //执行刷出操作
        session.flush();
        //提交事务
        session.getTransaction().commit();
        //关闭session
        session.close();
    }

    @Test
    public void test8() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        User user = session.get(User.class, 8);
        //重新设置值
        user.setPassword("55555");
        //清除缓存
        session.clear();
        //提交事务
        session.getTransaction().commit();
        //关闭session
        session.close();
    }

    @Test
    public void test9() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        User user = session.get(User.class, 8);
        //重新设置值
        user.setPassword("55555");
        //清除缓存
        session.refresh(user);
        //提交事务
        session.getTransaction().commit();
        //关闭session
        session.close();
    }

    @Test
    public void test10() {
        //开启第一个Session对象
        Session session1 = HibernateUtils.getSession();
        // 开启第一个事务
        Transaction tx1 = session1.beginTransaction();
        // 获取对象
        User p1 = session1.get(User.class, 8);
        User p2 = session1.get(User.class, 8);
        // 第一次比较对象是否相同
        System.out.println(p1 == p2);
        // 提交事务
        tx1.commit();
        //session1对象关闭，一级缓存被清理
        session1.close();

        // 开启第二个Session对象
        Session session2 = HibernateUtils.getSession();
        // 开启第二个事务
        Transaction tx2 = session2.beginTransaction();
        // 获取对象
        User p3 = session2.get(User.class, 8);
        // 第二次比较
        System.out.println(p1 == p3);
        User p4 = session2.get(User.class, 8);
        // 第三次比较
        System.out.println(p3 == p4);
        // 提交事务2
        tx2.commit();
        // session2关闭
        session2.close();

    }
}
