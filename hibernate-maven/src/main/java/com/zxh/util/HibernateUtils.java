package com.zxh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * 工具类，用来创建session
 */
public class HibernateUtils {

    public static final StandardServiceRegistry registry;
    public static final SessionFactory sessionFactory;

    static {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
