import java.util.Scanner;

public class N_and_M_One {
    static int N;
    static int M;
    static int[] arr;

    static boolean visited[];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];
        arr = new int[M];
        cal(0);
    }
    public static void cal(int num){
        if(num == M){
            for(int val: arr){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for(int i =0; i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[num] = i+1;
                cal(num+1);
                visited[i] = false;
            }
        }
    }
}
