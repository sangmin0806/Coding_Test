import java.util.*;
public class Phone_Book {
        public boolean solution(String[] phoneBook) {
            // 1. HashMap을 선언한다.
            Map<String, Integer> map = new HashMap<>();

            // 2. 모든 전화번호를 HashMap에 넣는다.
            for (int i = 0; i < phoneBook.length; i++)
                map.put(phoneBook[i], i);

            // 3. 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다.
            for (int i = 0; i < phoneBook.length; i++)
                for (int j = 0; j < phoneBook[i].length(); j++) {

                    if (map.containsKey(phoneBook[i].substring(0, j)))
                        return false;
                }
            return true;
        }
    public static void main(String[] args) {
        Phone_Book solutionInstance = new Phone_Book();

        String[] phone_book = {"119", "97674223", "1195524421"};


        boolean result = solutionInstance.solution(phone_book);
        System.out.println("Is an arbitrary number not a prefix of another number?: " + result);
    }
}
