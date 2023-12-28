import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(br.readLine());
            pq.add(card);
        }

        long answer = 0;
        for (int i = 0; i < N-1; i++) {
            int A = pq.poll();
            int B = pq.poll();
            pq.add(A+B);
            answer += A+B;

        }
        System.out.println(answer);

    }
}
