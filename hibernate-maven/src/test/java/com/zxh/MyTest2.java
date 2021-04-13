package com.zxh;

import com.zxh.entity.Clazz;
import com.zxh.entity.Course;
import com.zxh.entity.Stud;
import com.zxh.entity.Student;
import com.zxh.util.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

public class MyTest2 {

    @Test
    public void test1() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Clazz clazz = new Clazz();
        clazz.setName("计算机1班");
        //学生属于某个班级
        Student student1 = new Student().setName("蔡敏敏").setClazz(clazz);
        Student student2 = new Student().setName("李明").setClazz(clazz);
        //班级里有多个学生
        clazz.getStudents().add(student1);
        clazz.getStudents().add(student2);
        //保存数据
        session.save(clazz);
        session.save(student1);
        session.save(student2);
        //提交事务
        session.getTransaction().commit();
        //关闭session
        session.close();
    }

    @Test
    public void test2() {
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
        session.save(course);
        session.save(course2);
        session.save(student1);
        session.save(student2);
        //提交事务
        session.getTransaction().commit();
        //关闭session
        session.close();
    }

    @Test
    public void test3() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        //学生
        Stud student1 = new Stud().setName("张三丰");
        Stud student2 = new Stud().setName("赵虎义");
        //学科
        Course course = new Course().setName("redis 基础");
        Course course2 = new Course().setName("java框架");

        //学生关联科目
        student1.getCourses().add(course);
        student1.getCourses().add(course2);

        student2.getCourses().add(course);
        student2.getCourses().add(course2);

        //科目关联学生
        course.getStudents().add(student1);
        course.getStudents().add(student2);

        course2.getStudents().add(student1);
        course2.getStudents().add(student2);

        //保存数据
        session.save(course);
        session.save(course2);
        session.save(student1);
        session.save(student2);
        //提交事务
        session.getTransaction().commit();
        //关闭session
        session.close();
    }
}
