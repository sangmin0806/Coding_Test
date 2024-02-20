import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int out = 0;
    static int[] person;
    static int score=0;
    static int max = Integer.MIN_VALUE;
    static boolean[] visited;
    static int[] hitter;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[9];
        hitter = new int[9];
        person = new int[4];
        visited[0] = true;

        permutation(0);

        System.out.println(max);
    }
    public static void permutation(int index) {
        if(index==3){
            permutation(index+1);
            return;
        }
        if(index == 9) {
            for (int i = 0; i < 4; i++) {
                person[i] = 0;
            }
            out = 0;
            score = 0;
            recur(0, 0);
            return;
        }
        for (int i = 1; i < 9; i++) {
            if(!visited[i]) {
                hitter[index] = i;
                visited[i] = true;
                permutation(index + 1);
                visited[i] = false;
            }
        }

    }
    public static void recur(int inning,int index) {

        if(index==9) index = 0;

        if(inning==N-1&&out==3) {
            max = Math.max(max,score);
            return;
        }
        else if(out==3) {
            out = 0;
            for (int i = 0; i < 4; i++) {
                person[i] = 0;
            }
            recur(inning+1, index);
            return;
        }
        int count = 0;
        if(arr[inning][hitter[index]]==1) {
            count = 1;
        }
        else if(arr[inning][hitter[index]]==2) {
            count = 2;
        }
        else if(arr[inning][hitter[index]]==3) {
            count = 3;
        }
        else if(arr[inning][hitter[index]]==4) {
            count = 4;
        }
        else {
            out++;
        }

        for (int i = 3; i >= 1; i--) {
            if(person[i-1]>0&&count!=0) {
                person[i] = person[i-1]+count;
            }

        }
        if(count!=0) person[0] = count;

        for (int i = 0; i <4 ; i++) {
            if(person[i]>=4) {
                score++;
                person[i] = 0;
            }
        }


        recur(inning,index+1);

    }
}