package com.ssafy.phone;

import java.util.List;

public class PhoneTest {
	//이 프로젝트에 mysql jar파일을 설정
	//PhoneManager를 마저 구현
	//아래 메인함수에서 적당히 동작을 테스트하시오.
	public PhoneTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!!");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Phone phone = new Phone(11, "갤럭시20", 100000);
		
		PhoneManager phoneM = new PhoneManager();
		
		phoneM.insertPhone(phone);
		 
		System.out.println(phoneM.selectOne(11));
		
		List<Phone> list = phoneM.selectAll();
		for (Phone phone1 : list) {
			System.out.println(phone1);
		}
	}
		 
}
