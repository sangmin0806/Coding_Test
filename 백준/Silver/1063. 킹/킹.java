import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String king;
    static String stone;
    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        king = st.nextToken();
        stone = st.nextToken();
        N = Integer.parseInt(st.nextToken());
        char kingcol = king.charAt(0);
        int kingrow = king.charAt(1)-'0';
        char stonecol = stone.charAt(0);
        int stonerow = stone.charAt(1)-'0';
        input = new String[N];
        String[] answer = new String[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = st.nextToken();
            answer = move(input[i],kingrow,kingcol,stonerow,stonecol);
            kingcol = answer[0].charAt(0);
            kingrow = answer[0].charAt(1) - '0';
            stonecol = answer[1].charAt(0);
            stonerow = answer[1].charAt(1) - '0';
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }
    public static String[] move(String str,int kingrow,char kingcol,int stonerow,char stonecol){
        String[] answer = new String[2];
        answer[0] = kingcol+String.valueOf(kingrow);
        answer[1] = stonecol+String.valueOf(stonerow);

        int[] moving = new int[2];
        moving[0] = kingrow;
        moving[1] = kingcol;
        if (str.equals("R")){
            kingcol += 1;
        }else if (str.equals("L")){
            kingcol -= 1;
        }else if (str.equals("B")){
            kingrow -=1;
        }else if (str.equals("T")){
            kingrow +=1;
        }else if (str.equals("RT")){
            kingcol+=1;
            kingrow+=1;
        }else if (str.equals("LT")){
            kingcol-=1;
            kingrow+=1;
        }else if (str.equals("RB")){
            kingcol+=1;
            kingrow-=1;
        }else if (str.equals("LB")){
            kingcol-=1;
            kingrow-=1;
        }
        moving[0] -= kingrow;
        moving[1] -= kingcol;
        moving[0] = -moving[0];
        moving[1] = -moving[1];
        if(kingrow==stonerow&&kingcol==stonecol){//돌과 같으면
            stonerow += moving[0];
            stonecol += moving[1];
        }
        if(kingcol<65||kingrow<1||kingrow>8||kingcol>72){
            return answer;
        }
        if(stonecol<65||stonerow<1||stonerow>8||stonecol>72){
            return answer;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(kingcol).append(kingrow);
        answer[0] = String.valueOf(sb);
        sb = new StringBuilder();
        sb.append(stonecol).append(stonerow);
        answer[1] = String.valueOf(sb);

        return answer;

    }
}
