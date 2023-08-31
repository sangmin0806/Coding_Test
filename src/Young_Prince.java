import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Young_Prince {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int count = 0;

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                boolean flag = false;
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if(Math.abs((x1-cx)*(x1-cx))+Math.abs((y1-cy)*(y1-cy))<r*r){
                    count++;
                    flag = true;
                }
                if(Math.abs((x2-cx)*(x2-cx))+Math.abs((y2-cy)*(y2-cy))<r*r){
                    if(flag)
                        count--;
                    else {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
