public class Target_Number {
        static int count= 0;
        public int solution(int[] numbers, int target) {
            int answer = 0;
            dfs(0,numbers,0,target);
            return count;
        }
        public void dfs(int i,int[] numbers,int sum,int target){
            if(i==numbers.length){
                if(sum==target)
                    count++;
                return;
            }
            for(int j=0; j<2; j++){
                if(j==0)
                    sum +=numbers[i];
                else{
                    sum -=(2*numbers[i]);
                }
                dfs(i+1,numbers,sum,target);
            }

        }
    public static void main(String[] args) {
        Target_Number sol = new Target_Number();
        int target = 4;
        int[] numbers = {4,1,2,1};
        int result = sol.solution(numbers,target);
        System.out.println(result);
    }
}
