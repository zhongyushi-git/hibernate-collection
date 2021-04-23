package com.zxh.ssh.dao.impl;

import com.zxh.ssh.dao.UserDao;
import com.zxh.ssh.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    public void save(User user) {
        sessionFactory.openSession().save(user);
    }

    @Override
    public List<User> getList(String name) {
        String sql = "from User";
        Query query = sessionFactory.openSession().createQuery(sql);
        return query.list();
    }

    @Override
    public User login(User user) {
        String sql = "from User t where t.name = ?0 and t.password = ?1";
        Query query = sessionFactory.openSession().createQuery(sql);
        query.setParameter(0, user.getId()).setParameter(1, user.getPassword());
        List<User> list = query.list();
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}
