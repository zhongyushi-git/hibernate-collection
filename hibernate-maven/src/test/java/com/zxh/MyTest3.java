package com.zxh;

import com.zxh.entity.Clazz;
import com.zxh.entity.Course;
import com.zxh.entity.Stud;
import com.zxh.entity.Student;
import com.zxh.util.HibernateUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

public class MyTest3 {

    @Test
    public void test1() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        // 创建一个班级
        Clazz clazz = new Clazz().setName("计算机二班");
        // 创建一个学生
        Student student = new Student().setName("王五");
        clazz.getStudents().add(student);
        // 班级关联学生
        session.save(clazz);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test2() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Clazz clazz = session.get(Clazz.class, 4);
        session.delete(clazz);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test3() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Clazz clazz = session.get(Clazz.class, 6);
        Student student = session.get(Student.class, 3);
        //解除关联关系
        clazz.getStudents().remove(student);
        session.delete(clazz);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test4() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        //学生
        Stud student1 = new Stud().setName("蔡敏敏");
        Stud student2 = new Stud().setName("李明");
        //学科
        Course course = new Course().setName("java 基础");
        Course course2 = new Course().setName("NySQL 基础");

        //学生关联科目
        student1.getCourses().add(course);
        student1.getCourses().add(course2);

        student2.getCourses().add(course);
        student2.getCourses().add(course2);
        //保存数据
        session.save(student1);
        session.save(student2);

        //提交事务
        session.getTransaction().commit();
        //关闭session
        session.close();
    }

    @Test
    public void test5() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Stud stud = session.get(Stud.class, 2);
        session.delete(stud);
        session.getTransaction().commit();
        session.close();
    }


}
