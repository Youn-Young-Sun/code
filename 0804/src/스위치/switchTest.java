package 스위치;

import java.util.Scanner;

public class switchTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int[] swi = new int[size+1]; //배열의 1번부터 사용
		for(int i=1;i<=size;i++) {
			swi[i]=sc.nextInt();
		}
		
		int student = sc.nextInt();
		
		for(int i=0;i<student;i++) {
			int gender = sc.nextInt();
			int swiNum = sc.nextInt();
		
			if(gender == 1) { //남자
				for(int j=swiNum ; j<=size ; j+=swiNum) { //자신 포함 배수인것들 0->1, 1->0
					swi[j] = (swi[j] == 0) ? 1 : 0;
				}
			}
			
			else if(gender == 2) { //여자
				int cur=1;
				swi[swiNum] = swi[swiNum] == 1 ? 0 : 1;  //자신 바꾸고
				while(true) {
					if(swiNum-cur < 1 || swiNum+cur>size || swi[swiNum-cur]!=swi[swiNum+cur]) break;
					swi[swiNum-cur] = swi[swiNum-cur] == 1 ? 0 : 1; //양 옆에 있는 애들도 바꿔
					swi[swiNum+cur] = swi[swiNum+cur] == 1 ? 0 : 1;
					cur++;
				}
			}
			
		}
		for(int i=1;i<=size;i++) {
			System.out.print(swi[i]+" ");
			if(i % 20 == 0)
				System.out.println();
		}

	}

}
