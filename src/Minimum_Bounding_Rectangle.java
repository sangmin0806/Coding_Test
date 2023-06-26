public class Minimum_Bounding_Rectangle {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;
        int max = 0;
        for(int i = 0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1])
                height=sizes[i][0];
            else
                height=sizes[i][1];
            for (int j = 0; j<=1; j++){
                if(sizes[i][j]>width)
                    width=sizes[i][j];
                if(height>max)
                    max = height;
            }
        }
        answer = (max*width);
        return answer;
    }
    public static void main(String[] args) {
        Minimum_Bounding_Rectangle solutionInstance = new Minimum_Bounding_Rectangle();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result = solutionInstance.solution(sizes);
        System.out.println("Minimum_Bounding_Rectangle: " + result);
    }
}
