package com.zxh.ssh;

import com.zxh.ssh.dao.UserDao;
import com.zxh.ssh.entity.User;
import com.zxh.ssh.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test1 {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, 1);
        System.out.println(user);
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<User> list = userService.getList("123");
        System.out.println(list);
    }
}
