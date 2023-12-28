import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        int[] alphabet = new int[26];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                int index = str[i].charAt(j)-65;
                int num = 1;
                for (int k = 0; k < str[i].length()-j-1; k++) {
                    num *= 10;
                }
                alphabet[index] += num;
            }
        }
        Arrays.sort(alphabet);
        int answer = 0;
        int number = 9;
        for (int i = 25; i >= 0; i--) {
            int num = alphabet[i] * number;
            answer += num;
            number--;
        }
        System.out.println(answer);
    }
}
