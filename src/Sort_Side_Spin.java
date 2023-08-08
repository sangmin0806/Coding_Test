import java.util.Arrays;

public class Sort_Side_Spin {
    static int querylen;
        public int[] solution(int rows, int columns, int[][] queries) {

            int num =1;
            int[][] map = new int[rows][columns];
            for(int i = 0; i<rows; i++){
                for(int j =0; j<columns; j++){
                    map[i][j] = num;
                    num++;
                }
            }
            querylen = queries.length;
            int[] answer = new int[querylen];
            for(int k =0; k<querylen; k++){
                int pre = map[queries[k][0]-1][queries[k][1]-1];
                int next;

                for(int j =queries[k][1]-1; j<queries[k][3]-1;j++) {
                    //오른쪽으로 갈때
                    next = map[queries[k][0] - 1][j + 1];
                    map[queries[k][0] - 1][j + 1] = pre;
                    pre = next;
                }

                for(int j = queries[k][0]-1; j<queries[k][2]-1;j++) {
                    next = map[j+1][queries[k][3]-1];
                    map[j+1][queries[k][3]-1] = pre;
                    pre = next;
                }

                for(int j = queries[k][3]-1; j>queries[k][1]-1;j--) {
                    next = map[queries[k][2] - 1][j - 1];
                    map[queries[k][2] - 1][j - 1] = pre;
                    pre = next;
                }

                for(int j = queries[k][2]-1; j>queries[k][0]-1;j--) {
                    next = map[j-1][queries[k][1] - 1];
                    map[j-1][queries[k][1] - 1] = pre;
                    pre = next;
                }
                int min = Integer.MAX_VALUE;
                for(int i = queries[k][0]-1; i<= queries[k][2]-1; i++){
                    for(int j = queries[k][1]-1; j<= queries[k][3]-1; j++){
                        if(i > queries[k][0]-1 && i<queries[k][2]-1&& j>queries[k][1]-1&& j<queries[k][3]-1)
                            continue;
                        min = Math.min(min,map[i][j]);
                    }
                }
                answer[k] = min;

            }

            return answer;
        }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        Sort_Side_Spin sol = new Sort_Side_Spin();
        int[] result =  sol.solution(rows,columns,queries);
        System.out.println(Arrays.toString(result));
    }

}
