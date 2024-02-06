import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,R;
    static int[][] map;
    static int[] operation;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        operation = new int[R];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < R; i++) {
            operate(operation[i]);
        }
        for (int j = 0; j < N; j++) {
            for (int K = 0; K < M; K++) {
                sb.append(map[j][K]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static void operate(int operNum) {
        int temp = 0;
        if(operNum==1) {
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < M; j++) {
                    temp = map[N-i-1][j];
                    map[N-i-1][j] = map[i][j];
                    map[i][j] = temp;
                }
            }
        }
        else if(operNum==2) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M/2; j++) {
                    temp = map[i][M-j-1];
                    map[i][M-j-1] = map[i][j];
                    map[i][j] = temp;
                }
            }
        }
        else if(operNum==3) {
            int[][] arr = new int[N][M];
            for (int i = 0; i  <N; i ++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = map[i][j];
                }
            }
            map = new int[M][N];
            for (int i = 0; i <N; i++) {
                for (int j = 0; j < M; j++) {
                    map[j][N-i-1] = arr[i][j];
                }
            }
            temp = N;
            N = M;
            M = temp;
        }
        else if(operNum==4) {
            int[][] arr = new int[N][M];
            for (int i = 0; i  <N; i ++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = map[i][j];
                }
            }
            map = new int[M][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[M-j-1][i] = arr[i][j];
                }
            }
            temp = N;
            N = M;
            M = temp;
        }
        else if(operNum==5) {
            int[][] arr= new int[N][M];
            for (int i = 0; i <N ; i ++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < N/2; i++) {
                for (int j = M/2; j < M; j++) {
                    map[i][j] = arr[i][j-M/2];
                }
            }
            for (int i = N/2; i < N; i++) {
                for (int j = M/2; j < M; j++) {
                    map[i][j] = arr[i-N/2][j];
                }
            }
            for (int i = N/2; i < N; i++) {
                for (int j = 0; j < M/2; j++) {
                    map[i][j] = arr[i][M/2+j];
                }
            }
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < M/2; j++) {
                    map[i][j] = arr[N/2+i][j];
                }
            }
        }
        else if(operNum==6) {
            int[][] arr= new int[N][M];
            for (int i = 0; i <N ; i ++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < N/2; i++) {
                for (int j = M/2; j < M; j++) {
                    map[i][j] = arr[N/2+i][j];
                }
            }
            for (int i = N/2; i < N; i++) {
                for (int j = M/2; j < M; j++) {
                    map[i][j] = arr[i][j-M/2];
                }
            }
            for (int i = N/2; i < N; i++) {
                for (int j = 0; j < M/2; j++) {
                    map[i][j] = arr[i-N/2][j];
                }
            }
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < M/2; j++) {
                    map[i][j] = arr[i][j+M/2];
                }
            }
        }
    }
}
