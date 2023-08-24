import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Robot_On_Conveyor_Belt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int len = 2*N+1;
        int [] durable = new int[len];
        int [] robot = new int[len];
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 1; i < len; i++) {
            durable[i] = Integer.parseInt(st.nextToken());
        }

        int dangae = 1;
        int prerobot=0;
        while(true) {
            int pre = durable[len-1];
            int next;
            int nextrobot;
            for (int i = 0; i < len-1; i++) {// 로봇, 컨베이어 같이 회전
                next = durable[i+1];
                durable[i+1]= pre;
                pre = next;

                nextrobot = robot[i+1];
                robot[i+1] = prerobot;
                prerobot = nextrobot;
            }

            if(robot[N]==1){ // 로봇 내리는 위치에 있다면 내림
                robot[N]=0;
            }
            for(int i = N-1; i>=1; i--){// 로봇 이동

                if(robot[i]==1 && robot[i+1]==0 && durable[i+1]>0){
                    robot[i+1] = 1;
                    robot[i]=0;
                    durable[i+1] -= 1;
                    if(durable[i+1]==0) {
                        count++;
                    }
                }
            }
            if(robot[N]==1){// 로봇 내리는 위치에 있다면 내림
                robot[N]=0;
            }
            if(durable[1]>0){// 올리는 위치에 로봇 올림
                durable[1] -= 1;
                robot[1] = 1;
                prerobot = 0;
                if(durable[1]==0)
                    count++;

            }

            if (count >=K) {
                break;
            }
            dangae++;
        }
        System.out.println(dangae);
    }
}
