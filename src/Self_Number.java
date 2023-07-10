import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Self_Number {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        int k = 0;

        for(int i = 1; i<10000; i++){
            list.add(i);
        }
        for(int i = 1; i<=10000;i++){
            if(d(i)>10000)
                continue;
            list.remove(d(i));
        }
        Collections.sort(list);
        while(k<list.size()){
            System.out.println(list.get(k));
            k++;
        }
    }
    public static Integer d(int n){
        int answer = n;
        while(true){
            if(n<10){
                answer += n;
                break;
            }
            answer += n%10;
            n = n/10;
        }
        return answer;
    }
}
