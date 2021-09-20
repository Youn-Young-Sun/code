package 탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top {
    //기억이 없다는 것은.. 내 신호를 받아줄 녀석이 없다는거다. break
    //마지막 기지국이 나보다 크면 그놈이 나의 정답이다. break
    //마지막 기지국이 나보다 작으면 지워버린다.
    //왼쪽을 매번 헤매면서 보지 않기 위해서 새로운 기지국을 만날때마다 기억한다.
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); //개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        Stack<Integer> heightStack = new Stack<Integer>();
        Stack<Integer> numStack = new Stack<Integer>();
       
        StringBuilder sb = new StringBuilder();
       
        for(int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken()); //숫자들 입력

            while(true) {
                //기억이 없으면 0이 정답.
                if(heightStack.isEmpty()) { //비어있다면 
                    sb.append(0).append(" "); //0을 출력
                    break;
                }
                //나보다 큰 놈이 있으면 그놈의 번호가 정답.
                else if(heightStack.peek() >= num) { //나보다 크거나 같은 숫자라면 
                    sb.append(numStack.peek()).append(" "); //크거나 같은 숫자의 인덱스(?)번호 출력
                    break;
                }
                //나보다 작으면 갖다버려
                else { //나보다 작으면 버려
                    heightStack.pop();
                    numStack.pop();
                }
            }
            numStack.push(i); //numStack에 남아있는 인덱스(번호) 넣어
            heightStack.push(num); //heightStack에 남아있는 입력받았던 숫자들 넣어
        }
        System.out.println(numStack);
        System.out.println(heightStack);
        System.out.println(sb);
    }
}
