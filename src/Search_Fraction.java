import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Search_Fraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        boolean up = true;
        int row = 1;
        int col = 1;
        for (int i = 2; i <= X; i++) {
            if(up){
                if(row==1) {

                    col++;
                    up = false;
                    continue;
                }

                row--;
                col++;
            }
            else if(!up){
                if(col==1){

                    row++;
                    up = true;
                    continue;
                }

                row++;
                col--;
            }
        }
        System.out.println(row+"/"+col);
    }
}
