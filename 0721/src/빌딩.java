import java.util.Scanner;

public class 빌딩 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            char[][] map = new char[N][N];
            //1. 2차원배열에 맵을 입력받는다.
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.next().charAt(0);
                }
            }
            int ans = 0; //최대 높이를 저장할 변수
            //2. 2차원배열을 한칸씩 검사해나간다.
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    //         해당 칸이 G인지 B인지 검사한다.
                    if( map[i][j] == 'G' ) {
                        //        G는 패스.
                        continue;
                    }
                    else if( map[i][j] == 'B') {
                        //        B는 검사시작
                        boolean isPark = false;
                        int height = 0;
                        //            8방으로 G가 있는지 검사한다. (경계범위 유의)
                        //내 위쪽에 G가 있는지 검사. 맨윗줄이 아닐때만
                        if(i - 1 >= 0 && map[i-1][j] == 'G')
                            isPark = true;
                        //내 아래쪽에 G가 있는지 검사.
                        if(i + 1 < N && map[i+1][j] == 'G')
                            isPark = true;
                        //내 왼쪽에 G가 있는지 검사.
                        if(j - 1 >= 0 && map[i][j-1] == 'G')
                            isPark = true;
                        //내 오른쪽에 G가 있는지 검사.
                        if(j + 1 < N && map[i][j+1] == 'G')
                            isPark = true;
                        //내 왼쪽위에 G가 있는지 검사.
                        if(i - 1 >= 0 && j - 1 >= 0 && map[i-1][j-1] == 'G' )
                            isPark = true;
                        //내 오른쪽위에 G가 있는지 검사.
                        if(i - 1 >= 0 && j + 1 < N && map[i-1][j+1] == 'G')
                            isPark = true;
                        //내 왼쪽아래에 G가 있는지 검사.
                        if(i + 1 < N && j - 1 >= 0 && map[i+1][j-1] == 'G')
                            isPark = true;
                        //내 오른쪽 아래에 G가 있는지 검사.
                        if(i + 1 < N && j + 1 < N && map[i+1][j+1] == 'G')
                            isPark = true;
                        //                있다면 2층으로 확정
                        if(isPark)
                            height = 2;
                        //                없다면 가로세로에 B의 갯수를 센다.
                        else {
                            for(int k = 0; k < N; k++) {
                                if( map[i][k] == 'B')
                                    height++;
                                if( map[k][j] == 'B')
                                    height++;
                            }
                            height--; // 나 자신이 두번 세어졌음.
                        }
                        //                가장 큰 층수를 기억한다.
                        if( ans < height)
                            ans = height;
                    }

                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}