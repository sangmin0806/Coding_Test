import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.util.StringTokenizer;

public class Shark_School {
    static int N;
    static int[][] studentLike;
    static int[][] map;
    static int answer =0;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        studentLike = new int[N*N][5];
        map = new int[N][N];
        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            studentLike[i][0] = Integer.parseInt(st.nextToken());//학생의 번호
            studentLike[i][1] = Integer.parseInt(st.nextToken());
            studentLike[i][2] = Integer.parseInt(st.nextToken());
            studentLike[i][3] = Integer.parseInt(st.nextToken());
            studentLike[i][4] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N*N; i++) {
            List<int[]> list = new ArrayList<>();
            MapSearch(i,list);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                satisfaction(i,j);
            }
        }

        System.out.println(answer);
    }
    public static void satisfaction(int row,int col){
        int num = 0;
        for (int i = 0; i < N * N; i++) {
            if(map[row][col]==studentLike[i][0]){
                num = i;
                break;
            }
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nrow = row+dr[i];
            int ncol = col+dc[i];
            if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                continue;
            for (int k = 1; k < 5; k++) {
                if(map[nrow][ncol]==studentLike[num][k]){
                    count++;
                }

            }
        }
        if(count==1){
            answer+=1;
        }else if(count==2){
            answer+=10;
        }else if(count==3){
            answer+=100;
        }else if(count==4){
            answer+=1000;
        }
    }
    public static void MapSearch(int seq,List<int[]> list){
        int max = Integer.MIN_VALUE;
        int[][] likeCount = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]!=0)
                    continue;
                likeCount[i][j] = LikeSearch(seq,i,j);
                max = Math.max(max,likeCount[i][j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(max==likeCount[i][j]&&map[i][j]==0){
                    list.add(new int[]{i,j});
                }
            }
        }

        int len = list.size();
        max = Integer.MIN_VALUE;
        int[] emptyCount = new int[len];
        for (int i = 0; i < len; i++) {
            emptyCount[i] = emptySearch(i,list);
            max = Math.max(max,emptyCount[i]);
        }
        for (int i = 0; i < len; i++) {
            if(max==emptyCount[i]){
                int row = list.get(i)[0];
                int col = list.get(i)[1];
                map[row][col] = studentLike[seq][0];
                return;
            }
        }
    }
    public static int emptySearch(int index,List<int[]> list){
        int row = list.get(index)[0];
        int col = list.get(index)[1];
        int count=0;
        for (int i = 0; i < 4; i++) {
            int nrow = row+dr[i];
            int ncol = col+dc[i];
            if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                continue;
            if(map[nrow][ncol]==0){
                count++;
            }
        }
        return count;
    }
    public static int LikeSearch(int seq,int row, int col){

        int count=0;
        for (int i = 0; i < 4; i++) {
            int nrow = row+dr[i];
            int ncol = col+dc[i];
            if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                continue;
            for (int j = 1; j < 5; j++) {
                if(map[nrow][ncol]==studentLike[seq][j]){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
