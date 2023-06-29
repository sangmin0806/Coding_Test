
public class Fatigue {
    static boolean[] visited;
    static int count = 0;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons,k,visited,count);
        return answer;
    }
    public void dfs(int[][] dungeons, int k, boolean[] visited,int count){
        for(int i =0; i<dungeons.length;i++){
            if(!visited[i]&&k>=dungeons[i][0]){
                visited[i]=true;
                dfs(dungeons,k-dungeons[i][1],visited,count+1);
                visited[i]=false;
            }
        }
        answer = Math.max(answer,count);
    }
    public static void main(String[] args) {
        Fatigue sol = new Fatigue();
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(sol.solution(80, dungeons));
    }
}
