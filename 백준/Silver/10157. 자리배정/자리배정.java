import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        if(K>R*C){
            System.out.println(0);
            return;
        }
        int[][] map = new int[R+1][C+1];
        int num =1;
        int row = 1;
        int col = 1;
        int y = R;
        int x = C;
        while (true){
            while (true){
                if(num==K){
                    System.out.println(col+" "+row);
                    return;
                }
                if(row==y){
                    map[row][col] = num;
                    break;
                }
                if(map[row+1][col] ==0){
                    map[row][col] = num;
                    row += 1;
                    num++;
                }
            }
            while (true){
                if(num==K){
                    System.out.println(col+" "+row);
                    return;
                }
                if(col==x){
                    map[row][col] = num;
                    break;
                }
                if(map[row][col+1] ==0){
                    map[row][col] = num;
                    col += 1;
                    num++;
                }
            }
            while (true){
                if(num==K){
                    System.out.println(col+" "+row);
                    return;
                }
                if(row==R-y+1){
                    map[row][col] = num;
                    break;
                }
                if(map[row-1][col] ==0){
                    map[row][col] = num;
                    row -= 1;
                    num++;
                }
            }
            while (true){
                if(num==K){
                    System.out.println(col+" "+row);
                    return;
                }
                if(map[row][col-1] ==0){
                    map[row][col] = num;
                    col -= 1;
                    num++;
                }
                else {
                    map[row][col] = num;
                    break;
                }
            }
            x--;
            y--;
            if(num >= K) break;
        }
        
    }
}
