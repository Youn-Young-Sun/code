package basic;

public class BASIC_RecursiveCall {

	public static void main(String[] args) {
		
		m5(0);

	}
	
	static void m1() {
		System.out.println("m1()");
		m1();
	}
	static int m2_count = 5;
	static void m2() {
		System.out.println("앞 m2() "+m2_count);
		
		//조건
		if(m2_count > 0) {
			m2_count--;
			m2();
		}
		
		System.out.println("뒤 m2() "+m2_count);
	}
	static int m2_correct_count = 5;
	static void m2_correct() {
		
		//조건
		if(m2_correct_count == 0) {
			return;
		}
		
		System.out.println("앞 m2() "+m2_correct_count);
		
		m2_correct_count--;
		m2_correct();
		m2_correct_count++;
		
		System.out.println("뒤 m2() "+m2_correct_count);
	}
	
	static void m3(int m3_count) {
		
		//조건
		if(m3_count == 0) {
			return;
		}
		
		System.out.println("앞 m3() "+m3_count);
		
//		m2_correct_count--;
//		m2_correct();
//		m2_correct_count++;
		
		m3(--m3_count);
		
		System.out.println("뒤 m3() "+m3_count);
	}
	
	//할일 => println
	static int[] m4_intArr = {1,3,5,7,9};
	static void m4(int m4_count) {
		
		//조건
		if(m4_count >= 5) {
			//방문 종료
			//complete code 여기에다가 넣기
			//계산완료
			System.out.println("결과는....!!");
			return;
		}
			
		System.out.println("앞 m4() "+m4_intArr[m4_count]); //할일

		m4(m4_count+1);
		
		//System.out.println("뒤 m4() "+m4_intArr[m4_count]); //할일
		
	}
	
	static int[] m5_intArr = {1,2,3,4,5,6,7,8,9,10};
	static int m5_even_count; //5 짝수 개수
	static int m5_even_sum; //30 짝수 합
	
	static void m5(int m5_count) {
		//기저조건 & complete code
		if(m5_count == 10) {
			System.out.println(m5_even_count); //결과
			System.out.println(m5_even_sum); //결과
			return;
		}
		
		//할일 : 배열 원소 확인 -> 2의배수인지
		if(m5_intArr[m5_count]%2==0) {
			m5_even_count++;
			m5_even_sum+=m5_intArr[m5_count];
		}
		
		//recursive call
		m5(m5_count+1);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
