import java.util.Arrays;
public class Carpet {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            //yellow의 가로세로
            int x = 0;
            int y = 0;

            for(int i = 1; i<=yellow; i++){
                if(yellow%i==0){
                    int temp = yellow/i;
                    if((i>=temp)&&((i+temp+2)==(brown/2))){
                        x=i;
                        y=temp;
                    }
                }
            }
            answer[0] = x+2;
            answer[1] = y+2;
            return answer;
        }
    public static void main(String[] args) {
        Carpet sol = new Carpet();
        int[] result = sol.solution(24,24);
        System.out.println(Arrays.toString(result));
    }
}
