package 설탕배달_백준;

import java.util.Scanner;

public class sugar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int cnt = 0;
		
		while(true) {
			if(N % 5 == 0) { //5로 나눠지면 
				cnt += N / 5; //cnt에 몫 더함
				break;
			}
			
			N -= 3; //5로 안나눠지면 3빼고
			cnt++; //				 cnt 1증가
			
			if(N < 0) {
				cnt = -1; break;
			}
		}
		
		System.out.println(cnt);
	}

}
//(1) 5로 나누어 떨어지면 cnt에 5를 나눈 몫을 넣는다.
//
//(2) 5로 나누어 떨어지지 않으면 N에서 3을 빼고 cnt를 1 증가시킨다.
//
//(3) N이 0보다 작을 경우 -1을 반환한다
//
//(4) 위 3 과정을 반복한다.
