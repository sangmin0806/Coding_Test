import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Travel_Route {
    static boolean[] visited;
    static ArrayList<String> result;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        dfs(tickets,"ICN","ICN",0);
        Collections.sort(result);
        answer = result.get(0).split(" ");
        return answer;
    }
    public void dfs(String[][] tickets, String start,String route,int cnt){
        if(cnt==tickets.length){
            result.add(route);
            return;
        }
        for(int i = 0; i<tickets.length; i++){
            if(start.equals(tickets[i][0])&& !visited[i]){
                visited[i] = true;
                dfs(tickets,tickets[i][1],route+" "+tickets[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Travel_Route sol = new Travel_Route();
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] answer = sol.solution(tickets);
        System.out.println(Arrays.toString(answer));
    }
}
