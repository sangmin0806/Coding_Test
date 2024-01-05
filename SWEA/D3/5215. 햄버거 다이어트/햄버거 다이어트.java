
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
     static int N;
    static int L;
    static int[][] arr;
    static int answer;


    static int max;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            L = sc.nextInt();
            answer = 0;
            max =0;
            arr = new int[N][2];

            for(int i = 0; i<N; i++){
                for(int j = 0; j<2; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            dfs(0,0);
            System.out.println("#"+ test_case+ " "+ max);
        }
    }
    public static void dfs(int index, int totalcal){

        for (int i = index; i < N; i++) {
            if(totalcal + arr[i][1]>L){
                continue;
            }
            totalcal += arr[i][1];
            answer += arr[i][0];
            max = Math.max(max,answer);
            dfs(i+1,totalcal);
            totalcal -= arr[i][1];
            answer -= arr[i][0];
        }
    }
    
}