import java.util.*;
public class PhoneCatMon {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] nums) {
                int answer = 0;
                int length = nums.length;
                HashSet<Integer> type = new HashSet<>();
                for(int i = 0; i< length; i++){
                    type.add(nums[i]);
                }
                int count = type.size();
                if((length/2)<count)
                    answer = length/2;
                else
                    answer = count;

                return answer;
            }
        }
    }
}
