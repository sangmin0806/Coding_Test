import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Croatia_Alphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            String word="";
            if(i<str.length()-1)
                word = str.charAt(i)+""+str.charAt(i+1);
            else if(i==str.length()-1){
                answer++;
                break;
            }
            if(word.equals("c=")){
                answer++;
                i++;
            }
            else if(word.equals("c-")){
                answer++;
                i++;
            }
            else if(word.equals("dz")){
                if(i<str.length()-2&&str.charAt(i+2)=='='){
                    answer++;
                    i++;
                    i++;
                }
                else
                    answer++;
            }
            else if(word.equals("d-")){
                answer++;
                i++;
            }
            else if(word.equals("lj")){
                answer++;
                i++;
            }
            else if(word.equals("nj")){
                answer++;
                i++;
            }
            else if(word.equals("s=")){
                answer++;
                i++;
            }
            else if(word.equals("z=")){
                answer++;
                i++;
            }
            else
                answer++;
        }
        System.out.println(answer);
    }
}
