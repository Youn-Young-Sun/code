package 괄호짝짓기;

import java.util.Scanner;
import java.util.Stack;

public class mateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); //개수 입력
			String str = sc.next(); //문자열 입력
			Stack<Character> stack = new Stack<Character>(); //스택 생성
			boolean isOk = true;
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i); //하나씩 자르기
				//열리는 괄호일 경우 Stack에 삽입
				//닫히는 괄호일 경우
				//	Stack이 비어있으면 꽝
				//	Stack의 맨위에 들어있던 친구가.이번에 검사하는 애와 짝꿍이어야함
				if( c == '(' || c == '[' || c == '{' || c == '<')
					stack.push(c); //스택에 넣어
				else {
					if(stack.isEmpty()) { //스택 비어있으면 
						isOk = false; //0출력
						break;
					}
					else { //스택 안비어있으면
						if( stack.peek() == '(' && c == ')' )
							stack.pop(); //TOP에 있는 모양이랑 c가 짝이면 삭제
						else if( stack.peek() == c - 2 ) //아스키코드: 짝이 2씩 차이남
							stack.pop();//짝이면 삭제
						else { //짝 없는게 있으면 0 출력
							isOk = false;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + (isOk?1:0));
		}

}
}

