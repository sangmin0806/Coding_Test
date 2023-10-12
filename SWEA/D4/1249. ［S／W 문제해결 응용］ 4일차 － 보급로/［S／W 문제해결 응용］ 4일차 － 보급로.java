/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int N;
    static int[][] map;
    static int[][] cost;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int min;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            min =Integer.MAX_VALUE;
            map = new int[N][N];
            cost = new int[N][N];
            for(int i  =0; i<N; i++){
                String str = sc.next();
                for(int j = 0; j<N; j++){
                    map[i][j] = str.charAt(j)-'0';
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
            cost[0][0] = 0;
            bfs(0,0);
            
            System.out.println("#"+test_case+" "+cost[N-1][N-1]);
		}
	}
    public static void bfs(int row, int col){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{row,col});
        while(!que.isEmpty()){
            int[] current = que.poll();
            int crow = current[0];
            int ccol = current[1];
            for(int i = 0; i<4; i++){
                int nrow = crow + dr[i];
                int ncol = ccol + dc[i];
                if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                    continue;
                if(cost[nrow][ncol]>cost[crow][ccol]+map[nrow][ncol]){
                    cost[nrow][ncol]=cost[crow][ccol]+map[nrow][ncol];
                    que.add(new int[]{nrow,ncol});
                }
            }
        }
    }
    
}