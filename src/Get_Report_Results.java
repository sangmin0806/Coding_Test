import java.util.*;
public class Get_Report_Results {
    public static void main(String[] args) {
        class Solution {
            public int[] solution(String[] id_list, String[] report, int k) {
                int[] answer = new int[id_list.length];
                Map<String, HashSet<String>> reporter = new HashMap<>();
                Map<String, Integer> count = new HashMap<>();

                for(int i = 0; i < id_list.length; i++){
                    String name = id_list[i];
                    reporter.put(name, new HashSet<>()); //신고 당한 사람 이름을 넣는다.
                    count.put(name,i);
                }

                for(String s : report){
                    String[] str = s.split(" ");
                    String a = str[0];
                    String b = str[1];
                    reporter.get(b).add(a); //신고 당한 사람 가져와서 신고자 이름을 넣는다.
                }

                for(int i = 0; i<id_list.length; i++){
                    HashSet<String> mail = reporter.get(id_list[i]); //신고당한 사람을 키로 신고자 값을 가져온다.
                    if(mail.size() >= k ){  //mail.size() == 신고자의 명수
                        for(String name: mail){
                            answer[count.get(name)]++;
                        }
                    }
                }
                return answer;
            }
        }
    }
}