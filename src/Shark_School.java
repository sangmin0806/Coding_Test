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
            studentLike[i][1] = Integer.parseInt(st.nextToken());//좋아하는 학생의 번호
            studentLike[i][2] = Integer.parseInt(st.nextToken());
            studentLike[i][3] = Integer.parseInt(st.nextToken());
            studentLike[i][4] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N*N; i++) {
            List<int[]> list = new ArrayList<>();
            MapSearch(i,list);//자리 하나씩 탐색
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                satisfaction(i,j);//만족도 탐색
            }
        }

        System.out.println(answer);
    }
    public static void satisfaction(int row,int col){
        int num = 0;
        for (int i = 0; i < N * N; i++) {
            if(map[row][col]==studentLike[i][0]){// 해당 자리에 앉은 학생이 studentLike에 몇번째 배열 학생인지 num에 담는다.
                num = i;
                break;
            }
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {// 상하좌우 탐색
            int nrow = row+dr[i];
            int ncol = col+dc[i];
            if(nrow<0||ncol<0||nrow>=N||ncol>=N)
                continue;
            for (int k = 1; k < 5; k++) {// studentLike배열을 탐색하며 좋아하는 학생인지 탐색
                if(map[nrow][ncol]==studentLike[num][k]){
                    count++;
                }

            }
        }
        if(count==1){//만족도 환산
            answer+=1;
        }else if(count==2){
            answer+=10;
        }else if(count==3){
            answer+=100;
        }else if(count==4){
            answer+=1000;
        }
    }
    /**
     * seq: 몇번째 학생인지
     */
    public static void MapSearch(int seq,List<int[]> list){//자리 하나씩 탐색
        int max = Integer.MIN_VALUE;
        int[][] likeCount = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]!=0)// 자리에 누가 앉아있다면 해당자리는 탐색하지 않음
                    continue;
                likeCount[i][j] = LikeSearch(seq,i,j);// 현재 좌표에서, 좋아하는 학생수가 몇명 인접해있는지 탐색
                max = Math.max(max,likeCount[i][j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(max==likeCount[i][j]&&map[i][j]==0){// 인접한 좋아하는 학생수가 최대이면서, 그자리에 앉을 수 있는지
                    list.add(new int[]{i,j});
                }
            }
        }

        int len = list.size();
        max = Integer.MIN_VALUE;
        int[] emptyCount = new int[len];
        for (int i = 0; i < len; i++) {
            emptyCount[i] = emptySearch(i,list); // 1번조건 만족하는 자리중에서 인접한 빈칸 수가 몇개인지
            max = Math.max(max,emptyCount[i]);
        }
        for (int i = 0; i < len; i++) {
            if(max==emptyCount[i]){ //인접한 빈칸수가 최대인 경우 해당 자리에 학생이 앉는다.
                int row = list.get(i)[0];
                int col = list.get(i)[1];
                map[row][col] = studentLike[seq][0];
                return;
            }
        }
    }
    public static int emptySearch(int index,List<int[]> list){// 인접한 빈칸 찾는 함수
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
    public static int LikeSearch(int seq,int row, int col){ // 좋아하는 학생이 몇명 인접해있는지 찾는 함수

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
