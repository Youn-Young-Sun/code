package 사칙연산유효성검사;

import java.util.Scanner;

public class validation {

	public static void main(String[] args) {
		//N이 짝수라면 부적격
		//N이 홀수라면 N/2까지는 모두 연산자 -> 숫자 나오면 부적격
			//연산자면 두 피연산자가 자신의 자식이 맞는지(i*2와 i*2+1)
			//N/2+1부터 끝까지는 피연산자
		Scanner sc  = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = sc.nextInt();
			int flag = 0;
			if(N % 2 == 0) { //짝수라면
				flag = 0;
			}

		    for(int i=0;i<N;i++) {
		    	int half = N/2;
		    	int node = sc.nextInt();
		    	String[] arr = sc.nextLine().split(" ");
		    		
		    	if(i<half) { //반보다 작으면
		    			
		    		if(arr[1].equals("+") || arr[1].equals("-") || arr[1].equals("*") || arr[1].equals("/")) 
		    			flag = 1;
		    		else flag =0;
	
		    	}
		    	else { //반보다 크거나 같으면
		    		if(arr[1].equals("+") || arr[1].equals("-") || arr[1].equals("*") || arr[1].equals("/")) {
		    			flag =0;
		    		}
		    	}
		    }	
			System.out.println("#"+test_case+" "+flag);
		}
			
	}
}
