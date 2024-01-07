import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 2;
        arr[4] = 2;
        arr[5] = 8;
        int[] input = new int[6];
        for (int i = 0; i < 6; i++) {
            input[i] = sc.nextInt();
            if(i ==5){
                System.out.print(arr[i]-input[i]);
                return;
            }
            System.out.print(arr[i]-input[i]+" ");
        }

    }
}
