import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //백준, #1152
      /*
       1. 영어 대소문자와 공백으로 이루어진 문자열
       2. 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 함
       3. 이 문자열의 길이는 1,000,000을 넘지 않음
       4. 단어는 공백 한 개로 구분
       5. 공백이 연속해서 나오는 경우는 없음
       6. 문자열은 공백으로 시작하거나 끝날 수 있음
      */

        Scanner sc = new Scanner(System.in);
      //1.앞뒤 공백없애기
        String val = sc.nextLine();
        int cnt = 0;


         //입력 길이값 만큼 for문 돌리기
         for(int i = 1; i < val.length(); i++) {
            //charAt - String타입으로 받은 문자열을 char타입으로 한 글자만 받는 함수
            if(val.charAt(i) == ' '&&val.charAt(i-1)!=' ') {
               cnt++;
            }

         }
        if(val.charAt(val.length()-1)!=' '){
            cnt++;
        }


      //총 공백 개수+1
      //이러면.. 앞 뒤 공백 자르고 안에 공백 개수 + 1 해서 문자 개수 추출가능할줄 앎
      //여기서 문제점은 뭐였을까?
      System.out.println(cnt);

    }

}