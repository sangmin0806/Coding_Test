import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num; i++) {
            int a = sc.nextInt();
            max = Math.max(a,max);
            min = Math.min(a,min);
        }


//        for (int i = 0; i < num; i++) {
//            int a = sc.nextInt();
//            if(max<a) max = a;
//            if(min>a) min = a;
//        }



//        int[] list = new int[num];
//        for (int i = 0; i < num; i++) {
//            list[i] = sc.nextInt();
//        }
//        for (int i = 0; i < num; i++) {
//            if(max<list[i]) max = list[i];
//            if(min>list[i]) min = list[i];
//        }
        System.out.println(min+" "+max);
    }
}
