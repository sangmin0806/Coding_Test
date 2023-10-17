import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            String[] temp = str[i].split("[+]");
            int tempSum = 0;
            for(String s : temp){
                tempSum += Integer.parseInt(s);
            }
            if(i == 0){
                sum += tempSum;
            }
            else {
                sum -= tempSum;
            }

        }
        System.out.println(sum);
    }
}
