package com.one.graduateDesign.student.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.one.graduateDesign.entity.Student;
import com.one.graduateDesign.student.dao.StudentDaoImpl;

@Service
@Transactional(readOnly=false)
public class StudentServiceImpl {

	@Resource
	private StudentDaoImpl studentDaoImpl;
	
	public Student studentLogin(String studentId, String passWord) {
		Student s = studentDaoImpl.judge(studentId);
		if(s.getPassword().equals(passWord)) {
			return s;
		}
		else {
			return null;
		}
	}
}