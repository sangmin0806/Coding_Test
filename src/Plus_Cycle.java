import java.util.Scanner;

public class Plus_Cycle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int init = N;
        int a = 0;
        int b = 0;
        int count = 0;

        while(true){
            if(N<10){
                N = 10*N+N;
            }
            else{
                a = N%10;
                b = ((N/10)+(N%10))%10;
                N = 10*a+b;
            }
            count++;
            if(init==N)
                break;
        }
        System.out.println(count);
    }
}
