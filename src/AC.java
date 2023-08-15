import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC {
    static StringBuilder sb;
    static Deque<Integer> x = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int k = 0; k < T; k++) {
            sb = new StringBuilder();
            String p = br.readLine();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), "[],");
            boolean error = false;
            for (int i = 0; i < n; i++) {
                x.add(Integer.parseInt(st.nextToken()));
            }

            boolean direction = true;
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    direction = !direction;
                } else {
                    if (direction) {
                        if (!x.isEmpty()) {
                            x.pollFirst();
                        } else {
                            error=true;
                            break;
                        }

                    } else {
                        if (!x.isEmpty()) {
                            x.pollLast();

                        } else {
                            error=true;
                            break;
                        }
                    }
                }
            }
            makePrint(direction,error);
        }
    }
    public static void makePrint(boolean direction,boolean error){

        if(error==true){
            System.out.println("error");
            return;
        }
        if(x.isEmpty()){
            System.out.println("[]");
            return;
        }
        sb.append("[");
        if (direction) {
            sb.append(x.pollFirst());
            while (!x.isEmpty()) {
                sb.append(",").append(x.pollFirst());
            }
        } else {
            sb.append(x.pollLast());
            while (!x.isEmpty()) {
                sb.append(",").append(x.pollLast());
            }
        }
        sb.append("]");
        System.out.println(sb);
    }


}
