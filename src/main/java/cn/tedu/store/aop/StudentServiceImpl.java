package cn.tedu.store.aop;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

	public void add() {
		System.out.println("StudentService的add方法");
	}
}
