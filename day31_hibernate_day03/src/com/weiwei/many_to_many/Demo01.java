package com.weiwei.many_to_many;

import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Course;
import com.weiwei.domain.Student;
import com.weiwei.utils.HebernateUtils;

public class Demo01 {
	//保存学生 =》通过学生保存课程，由学生维护外键
	//Student 
	//inverse = false
	//cascade = 
	//Course
	//inverse = true
	//记过输出5条添加到实体中，6条添加到对应表中
	@Test
	public void fun1(){
		//3 获得session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Student stu1 = new Student();
		stu1.setName("tom");
		
		Student stu2 = new Student();
		stu2.setName("jerry");
		
		Course c1 = new Course();
		c1.setName("数学");
		
		Course c2 = new Course();
		c2.setName("语文");
		
		Course c3 = new Course();
		c3.setName("英语");
		
		stu1.getCourse().add(c1);
		stu1.getCourse().add(c2);
		stu1.getCourse().add(c3);
		
		stu2.getCourse().add(c1);
		stu2.getCourse().add(c2);
		stu2.getCourse().add(c3);
		
		session.save(stu1);
		session.save(stu2);
		
		//------------------
		session.getTransaction().commit();
		session.close();
		
//		Hibernate: 
//		    insert 
//		    into
//		        t_student
//		        (name) 
//		    values
//		        (?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_course
//		        (name) 
//		    values
//		        (?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_course
//		        (name) 
//		    values
//		        (?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_course
//		        (name) 
//		    values
//		        (?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_student
//		        (name) 
//		    values
//		        (?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_student_course
//		        (sid, cid) 
//		    values
//		        (?, ?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_student_course
//		        (sid, cid) 
//		    values
//		        (?, ?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_student_course
//		        (sid, cid) 
//		    values
//		        (?, ?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_student_course
//		        (sid, cid) 
//		    values
//		        (?, ?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_student_course
//		        (sid, cid) 
//		    values
//		        (?, ?)
//		Hibernate: 
//		    insert 
//		    into
//		        t_student_course
//		        (sid, cid) 
//		    values
//		        (?, ?)
	}
}
