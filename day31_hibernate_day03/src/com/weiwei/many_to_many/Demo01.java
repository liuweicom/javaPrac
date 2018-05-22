package com.weiwei.many_to_many;

import org.hibernate.Session;
import org.junit.Test;

import com.weiwei.domain.Course;
import com.weiwei.domain.Student;
import com.weiwei.utils.HebernateUtils;

public class Demo01 {
	//����ѧ�� =��ͨ��ѧ������γ̣���ѧ��ά�����
	//Student 
	//inverse = false
	//cascade = 
	//Course
	//inverse = true
	//�ǹ����5����ӵ�ʵ���У�6����ӵ���Ӧ����
	@Test
	public void fun1(){
		//3 ���session
		Session session = HebernateUtils.openSession();	
		session.beginTransaction();
		//-------------------
		Student stu1 = new Student();
		stu1.setName("tom");
		
		Student stu2 = new Student();
		stu2.setName("jerry");
		
		Course c1 = new Course();
		c1.setName("��ѧ");
		
		Course c2 = new Course();
		c2.setName("����");
		
		Course c3 = new Course();
		c3.setName("Ӣ��");
		
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
