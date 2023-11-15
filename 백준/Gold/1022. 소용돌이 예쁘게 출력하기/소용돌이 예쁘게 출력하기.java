import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0,-1,0,1};
    static int[] dc = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int[][] map = new int[50][5];
        int row = 10001/2;
        int col = 10001/2;
        int count = 3;
        int dir = 1;
        if(r1<=0&&r2>=0&&c1<=0&&c2>=0){
            map[row-(10001/2+r1)][col-(10001/2+c1)] = 1;
        }
        col++;
        if(r1<=0&&r2>=0&&c1<=1&&c2>=1){
            map[row-(10001/2+r1)][col-(10001/2+c1)] = 2;
        }
        int dircnt = 1;
        int cnt = 1;
        while (true){
            if(count==100020002) break;
            if(dircnt%2==0) cnt++;
            for (int i = 0; i < cnt; i++) {
                if(count==100020002) break;
                row += dr[dir%4];
                col += dc[dir%4];
                if(row>=10001/2+r1&&row<=10001/2+r2&&col>=10001/2+c1&&col<=10001/2+c2){
                    map[row-(10001/2+r1)][col-(10001/2+c1)] = count;

                }
                count++;
            }
            dir++;
            dircnt++;
        }
        int max = 0;
        for (int i = 0; i <= r2-r1; i++) {
            for (int j = 0; j <= c2-c1; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(map[i][j]);
                max = Math.max(sb.length(),max);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= r2-r1; i++) {
            for (int j = 0; j <= c2-c1; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(map[i][j]);
                for (int k = 0; k < max-sb.length(); k++) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(map[i][j]).append(" ");
            }
            if(i==r2-r1)break;
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
