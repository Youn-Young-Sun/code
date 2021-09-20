import java.util.Arrays;
import java.util.Scanner;

public class 방배정_백준13300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //학생 수
		int K = sc.nextInt(); //한방당 최대인원
						  //성별 학년
		int[][] arr = new int[2][7]; //학생 카운팅할 배열
		
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt(); //성별 여:0, 남:1
			int Y = sc.nextInt(); //학년
			
			arr[S][Y]++; //카운팅
		}
		
		//방계산
		int roomCnt = 0;
		for (int[] grade : arr) { //학년정보만
			//System.out.println(Arrays.toString(grade));
			for(int cnt : grade) {
				roomCnt += cnt / K + (cnt % K == 0 ? 0 : 1);
			}
		}
		System.out.println(roomCnt);
		

	}

}
