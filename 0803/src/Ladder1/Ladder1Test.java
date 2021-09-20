package src.Ladder1;

public class Ladder1Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[100][100];
		int startY=0;
		int T=sc.nextInt();
		
		 for (int i = 0; i < map.length; i++) {
	            for (int j = 0; j < map.length; j++) {
	                map[i][j] = sc.nextInt();
	            }
	        }
		
        int[] arr= new int[100]; //1있는 좌표 저장하는 배열
        int cnt=0;
        for(int i=0;i<map.length;i++) {
        	if(map[99][i] != 0) { //마지막행에서 0인 열이 아니고
        		if(map[99][i] == 2) startY=cnt;  //마지막행에서 2인 열이면 시작지점 알기위해 저장
        		arr[cnt++]=i; //1있는 좌표를 배열에 하나씩 저장
        	}
        }
        

         for(int i=0;i<map.length;i++) {
            if(arr[startY] - 1 >= 0 && map[99-i][arr[startY]- 1] == 1) { //왼쪽
                startY--;

            }
            else if(arr[startY] + 1 < 100 && map[99-i][arr[startY] + 1] == 1) { //오른쪽
            	startY++;

            }
        }

		System.out.println("#"+T+" "+arr[startY]);
        }
	}
		
