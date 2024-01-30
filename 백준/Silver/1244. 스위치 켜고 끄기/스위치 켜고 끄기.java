import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[] onOff;
    static int studentNum;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        onOff = new char[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            onOff[i] = st.nextToken().charAt(0);
        }
        st = new StringTokenizer(br.readLine());
        studentNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(sex==1) {
                Boy(num);
            }
            else {
                Girl(num,0);
            }
        }
        for (int i = 0; i < N; i++) {
            if(i!=0&&i%20==0) {
                sb.append("\n");
            }
            sb.append(onOff[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static void Boy(int num) {
        int gob = num;
        while (true) {
            if(num>N) return;
            int index = num-1;
            if(onOff[index]=='1') onOff[index]='0';
            else onOff[index] ='1';
            num+=gob;
        }
    }
    public static void Girl(int num,int index) {
        if(num-1+index>=N||num-1-index<0||onOff[num-1+index]!=onOff[num-1-index]) {
            return;
        }

        Girl(num, index+1);

        if(onOff[num-1+index]=='1') onOff[num-1+index]='0';
        else onOff[num-1+index] ='1';
        if(index==0) return;
        if(onOff[num-1-index]=='1') onOff[num-1-index]='0';
        else onOff[num-1-index] ='1';
    }
}

