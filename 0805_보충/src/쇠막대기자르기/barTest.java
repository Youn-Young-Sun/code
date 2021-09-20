package 쇠막대기자르기;

import java.util.Scanner;

public class barTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{	
			int barCnt=0,pieceCnt=0;
			String str = sc.next();
			char[] ch=new char[str.length()];
			for(int i=0;i<str.length();i++) {
				ch[i] = str.charAt(i);
				if(ch[i] == '(') { 
					barCnt++; //쇠막대기로 우선 처리
				}
				else {
					if(ch[i-1] == '(') { //레이저 발사
						barCnt--;
						pieceCnt += barCnt;
					}
					else { //쇠막대기끝
						barCnt--;
						pieceCnt++;
					}
				}
			}
			System.out.println("#"+test_case+" "+pieceCnt);
			

		}

	}

}
