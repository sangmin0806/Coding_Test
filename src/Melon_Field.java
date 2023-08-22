import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Melon_Field {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int[] dir = new int[6];
        int[] len = new int[6];
        int y = 0;
        int x = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            if(dir[i]==4||dir[i]==3){
                y = Math.max(y,len[i]);
            }
            else if(dir[i]==2||dir[i]==1){
                x = Math.max(x,len[i]);
            }
        }
        int index = 0;
        int blank = 0;
        while (true) {
            if (len[index] == x) {
                if (len[(index+1)%6]==y){
                    blank= len[(index+3)%6]*len[(index+4)%6];
                    break;
                }
                else if(len[(index+5)%6]==y){
                    blank = len[(index+2)%6]*len[(index+3)%6];
                    break;
                }
            }
            index++;
        }
        int size = x*y - blank;
        System.out.println(size*k);

    }
}
