import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Switch_On_Off {
    static int[] swit;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt = Integer.parseInt(st.nextToken());
        swit = new int[cnt+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<cnt+1; i++){
            swit[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int humanNum = Integer.parseInt(st.nextToken());
        int sex;
        int num;
        for (int i = 0; i<humanNum; i++) {
            st = new StringTokenizer(br.readLine());
            sex = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            if(sex == 1){
                man(num);
            }
            else if(sex==2){
                woman(num);
            }
        }
        for(int i = 1; i<cnt+1; i++){
            System.out.print(swit[i] + " ");
            if(i%20==0)
                System.out.println();
        }
    }
    public static void man(int num){
        for(int i = 1; num*i<cnt+1; i++){
            if(swit[num*i]==1){
                swit[num*i]=0;
            }
            else if(swit[num*i]==0){
                swit[num*i] = 1;
            }
        }
    }
    public static void woman(int num){
        for(int i = 0; num+i<cnt+1; i++){
            if(num-i<1)
                break;
            if(swit[num+i]==swit[num-i]){
                if(swit[num+i]==1){
                    swit[num+i]=0;
                    swit[num-i]=0;
                }
                else if(swit[num+i]==0){
                    swit[num+i]=1;
                    swit[num-i]=1;
                }
            }
            else {
                break;
            }
        }
    }
}
