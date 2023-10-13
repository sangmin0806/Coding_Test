import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int dumpnum = sc.nextInt();
            int[] height = new int[100];
            for(int i = 0; i<100; i++){
                height[i] = sc.nextInt();
            }

            Queue<Integer> maxque = new LinkedList<>();
            Queue<Integer> minque = new LinkedList<>();
            while(true){

                maxque.clear();
                minque.clear();
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int i = 0; i<100; i++){
                    max = Math.max(max,height[i]);
                    min = Math.min(min,height[i]);
                }
                if(dumpnum == 0||(max-min)==1){
                    int answer = max-min;
                    System.out.println("#"+test_case+" "+answer);
                    break;
                }
                for(int i = 0; i<100; i++){
                    if(max==height[i]){
                        maxque.add(i);
                    }
                    if(min == height[i]){
                        minque.add(i);
                    }
                }
                //System.out.println(maxque);
                while(true){
                    if(maxque.isEmpty() || minque.isEmpty()){
                        break;
                    }
                    if(dumpnum==0) break;
                    int maxindex = maxque.poll();
                    int minindex = minque.poll();
                    height[maxindex] -= 1;
                    height[minindex] += 1;
                    dumpnum--;
                }
            }
        }
    }
}