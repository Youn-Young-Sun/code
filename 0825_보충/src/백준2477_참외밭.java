import java.util.Scanner;

public class 백준2477_참외밭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt(); //1제곱당 참외개수
		int w = 0, h = 0; //너비랑 높이
		int[][] data = new int[6][2]; //방향, 길이

		for(int i = 0; i < 6; i++) {
			data[i][0] = sc.nextInt(); //방향
			data[i][1] = sc.nextInt(); //길이
			if(data[i][0] == 1 || data[i][0] == 2) { //너비
				w = Math.max(w, data[i][1]); //길이를 줘야하니깐
			}
			else { //높이
				h = Math.max(h, data[i][1]);
			}
		}
		//뺄 직사각형 변 구하기
		int min = 1; //뺄 직사각형을 위해
		for (int i = 0; i < 6; i++) {
			if(data[(i + 5) % 6][0] == data[(i + 1) % 6][0]) { //뺄 직사각형이면(방향 같으면)
				min *= data[i][1];
			}
		}
		
		System.out.println((w * h - min) * K);
	}

}
