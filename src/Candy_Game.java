import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Candy_Game {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String[][] map = new String[N][N];
        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<N; j++){
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                for(int k = 0; k<2; k++){
                    if(k==0 && j<N-1){
                        String temp = map[i][j+1];
                        map[i][j+1] = map[i][j];
                        map[i][j] = temp;
                        Row(map);
                        Col(map);
                        map[i][j]=map[i][j+1];
                        map[i][j+1]=temp;
                    }
                    else if (k==1 && i<N-1){
                        String temp = map[i+1][j];
                        map[i+1][j] = map[i][j];
                        map[i][j] = temp;
                        Row(map);
                        Col(map);
                        map[i][j]=map[i+1][j];
                        map[i+1][j] =temp;
                    }
                }

            }
        }

        System.out.println(max);
    }
    public static void Row(String[][] map){
        for (int i = 0 ; i < N; i ++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[i][j].equals(map[i][j + 1])) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }

    }
    public static void Col(String[][] map){
        for (int i = 0 ; i < N; i ++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[j][i].equals(map[j+1][i])) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }

        }
    }
}
