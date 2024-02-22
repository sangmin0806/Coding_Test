import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N,start;
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer =0;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test = 1; test <= 10; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            max = start;
            list = new List[101];
            for (int i = 0; i < 101; i++) {
                list[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N/2; i++) {

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from].add(to);
            }

            visited = new boolean[101];
            bfs();
            System.out.println("#"+test+" "+max);
        }
    }
    public static void bfs() {
        Queue<int[]> que  = new ArrayDeque<>();
        int cnt = 0;
        que.add(new int[] {start,cnt});
        visited[start] = true;
        while (!que.isEmpty()) {
            max = Integer.MIN_VALUE;
            int size = que.size();
            for (int q = 0; q < size; q++) {
                int[] current = que.poll();
                int cur = current[0];
                cnt = current[1];
                max = Math.max(max, cur);
                for (int i = 0; i < list[cur].size(); i++) {
                    int next = list[cur].get(i);
                    if (visited[next]) continue;
                    visited[next] = true;
                    que.add(new int[]{next, cnt + 1});
                }
            }
        }
    }
}