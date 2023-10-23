import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int X = 0;
            if(st.hasMoreTokens()){
                X = Integer.parseInt(st.nextToken());
            }

            if(str.equals("push_front")&& X != 0){
                deque.addFirst(X);
            }
            else if(str.equals("push_back")&& X != 0){
                deque.addLast(X);

            }
            else if(str.equals("pop_front")){
                if(!deque.isEmpty())
                    System.out.println(deque.pollFirst());
                else
                    System.out.println(-1);
            }
            else if(str.equals("pop_back")){
                if(!deque.isEmpty())
                    System.out.println(deque.pollLast());
                else
                    System.out.println(-1);
            }
            else if(str.equals("size")){
                System.out.println(deque.size());
            }
            else if(str.equals("empty")){
                if(!deque.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(1);
            }
            else if(str.equals("front")){
                if(!deque.isEmpty())
                    System.out.println(deque.peekFirst());
                else
                    System.out.println(-1);
            }
            else if(str.equals("back")){
                if(!deque.isEmpty())
                    System.out.println(deque.peekLast());
                else
                    System.out.println(-1);
            }
        }
    }
}
