package 암호문1;

import java.util.LinkedList;
import java.util.Scanner;

public class code1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt(); //원본 암호문의 길이

			LinkedList<Integer> list = new LinkedList<>();
			
			for(int i=0;i<N;i++) { //원본 암호문 리스트에 넣기
				list.add(sc.nextInt());
			}
			
			int c=sc.nextInt();//명령어의 개수
			
			for(int i=0;i<c;i++) {
				String s = sc.next(); //|
				int x = sc.nextInt(); //x의 위치 
				int y = sc.nextInt(); //y개 숫자 삽입
				for(int j=0;j<y;j++) {
					list.add(x, sc.nextInt()); //x 다음에 입력받은거 입력 받음
					x++; //x 하나씩 증가 -> x번째 이후로 삽입
					
				}
			}
			System.out.println("#"+test_case);
			
			int cnt=0;
			while((!list.isEmpty())) { //10개 꺼내기
				if(cnt>9) break;
				System.out.print(list.poll() + " ");
				cnt++;
			}
			System.out.println();

		}
	}

}
