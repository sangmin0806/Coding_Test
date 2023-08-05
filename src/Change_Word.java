public class Change_Word {
    static boolean[] visited;
    static int answer = 0;
    static int result = 0;
    static boolean first = true;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        boolean have = false;
        for(int i = 0; i<words.length; i++){
            if(words[i].equals(target)){
                have = true;
            }
        }
        if(!have)
            return result;
        dfs(begin,target,words);
        return result;

    }
    public void dfs(String begin, String target, String[] words){
        int targetcount = 0;
        for(int j = 0; j<begin.length(); j++){
            if(begin.charAt(j)==target.charAt(j)){

                targetcount++;


            }
        }
        System.out.println(begin+" "+targetcount+" "+first);
        if(targetcount == (begin.length()-1)&&first){

            answer++;
            first = false;
            result = answer;
            return;
        }

        for(int i = 0; i<words.length; i++){
            if(visited[i])
                continue;
            int count = 0;
            for(int j = 0; j<begin.length(); j++){
                if(begin.charAt(j)==words[i].charAt(j)){
                    count++;
                }
            }
            if(count == (begin.length()-1)){
                begin = words[i];
                visited[i] = true;
                answer++;

                dfs(begin,target,words);
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
