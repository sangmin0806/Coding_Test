public class Change_Word {
    static boolean[] visited;
    static int answer = 0;
    static int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int have = 0;
        for(int i =0; i<words.length; i++){
            if(words[i].equals(target)){
                have++;
            }
        }
        if(have ==0)
            return answer;
        else{
            visited = new boolean[words.length];
            dfs(begin,target,words,0);
            return answer;
        }

    }
    public void dfs(String begin, String target, String[] words,int cnt){

        if(begin.equals(target)){
            min = Math.min(min,cnt);
            answer = min;
            return;
        }
        for(int i = 0; i<words.length; i++){
            int count =0;
            for(int j =0; j<begin.length(); j++){
                if(begin.charAt(j)==words[i].charAt(j)){
                    count++;
                }
            }
            if(count==begin.length()-1&& !visited[i]){
                visited[i] = true;
                dfs(words[i],target,words,cnt+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args){
        Change_Word sol = new Change_Word();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hat","hot","dat","dot","cat","dog","cot","cog"};
        int k = sol.solution(begin,target,words);
        System.out.println(k);
    }
}
