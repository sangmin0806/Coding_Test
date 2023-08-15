import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gear {
    static int[][] gear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        gear = new int[4][8];

        for(int i = 0; i<4; i++){
             String input = br.readLine();
            for (int j =0; j<8; j++){
                gear[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int [] gearnum = new int[num];
        int [] dir = new int[num];
        for(int i = 0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            gearnum[i] = Integer.parseInt(st.nextToken());
            dir[i] = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[4];
            dfs(gearnum[i],dir[i],visited);
        }
        int sum = 0;
        for(int i = 0; i<4; i++){
            if(i==0){
                sum += gear[i][0];
            }
            else if(i==1){
                sum += (2*gear[i][0]);
            }
            else if(i==2){
                sum += (4*gear[i][0]);
            }
            else if(i==3){
                sum += (8*gear[i][0]);
            }
        }
        System.out.println(sum);
    }
    public static void dfs(int gearnum, int dir, boolean[] visited){

        int ngearnum;
        visited[gearnum-1] = true;
        for(int i = 0; i<2; i++){
            if(i==0){
                ngearnum = gearnum+1;
            }
            else {
                ngearnum = gearnum-1;
            }
            if(ngearnum==0||ngearnum==5)
                continue;
            if(visited[ngearnum-1])
                continue;
            if(i==0 && gear[gearnum-1][2]!=gear[ngearnum-1][6]){
                if(dir == -1){
                    dfs(ngearnum,1,visited);
                }
                else if(dir == 1){
                    dfs(ngearnum,-1,visited);
                }
            }
            if(i==1 && gear[gearnum-1][6] != gear[ngearnum-1][2]){
                if(dir == -1){
                    dfs(ngearnum,1,visited);
                }
                else if(dir == 1){
                    dfs(ngearnum,-1,visited);
                }
            }
        }
        int pre = gear[gearnum-1][7];
        int pre2 = gear[gearnum-1][0];
        for(int i = 0; i<8; i++){
            if(dir == -1){
                int next = gear[gearnum-1][7-i];
                gear[gearnum-1][7-i] = pre2;
                pre2 = next;
            }
            else if(dir == 1){
                int next = gear[gearnum-1][i];
                gear[gearnum-1][i] = pre;
                pre = next;
            }
        }

    }

}
