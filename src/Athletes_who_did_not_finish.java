import java.util.*;
public class Athletes_who_did_not_finish {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++)
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) != 0)
                answer = key;
        }
        return answer;
    }

    public static void main(String[] args) {
        Athletes_who_did_not_finish solutionInstance = new Athletes_who_did_not_finish();

        String[] participant = {"Alice", "Bob", "Charlie"};
        String[] completion = {"Alice", "Bob"};

        String result = solutionInstance.solution(participant, completion);
        System.out.println("The athlete who did not finish: " + result);
    }
}


