import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static int count = 0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        width();
        length();
        System.out.println(count);
    }
    public static void width(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!flag&&map[i][j] == '-'){
                    flag = true;
                    count++;
                }
                if(map[i][j]=='|'){
                    flag = false;
                }
                if(j==M-1){
                    flag = false;
                }
            }
        }
    }
    public static void length(){
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!flag&&map[j][i] == '|'){
                    flag = true;
                    count++;
                }
                if(map[j][i]=='-'){
                    flag = false;
                }
                if(j==N-1){
                    flag = false;
                }
            }
        }
    }
}
