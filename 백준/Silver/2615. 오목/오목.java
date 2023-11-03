import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if(map[j][i]!=0){
                    int num = map[j][i];
                    boolean flag = false;
                    for (int k = 0; k < 6; k++) {
                        if(j-k<0||i+k>=19){
                            if(k==5){
                                break;
                            }
                            flag = true;
                            break;
                        }
                        if(k==5){
                            if(map[j-k][i+k]==num){
                                flag = true;
                            }
                            break;
                        }
                        if(map[j-k][i+k]!=num){
                            flag = true;
                            break;
                        }

                    }
                    if(!flag&&j+1<19&&i-1>=0&&map[j+1][i-1]==num){
                        flag =true;
                    }
                    if(!flag){
                        System.out.println(num);
                        System.out.println(j+1+" "+(i+1));
                        return;
                    }
                    flag = false;
                    for (int k = 0; k < 6; k++) {
                        if(i+k>=19){
                            if(k==5){
                                break;
                            }
                            flag = true;
                            break;
                        }
                        if(k==5){
                            if(map[j][i+k]==num){
                                flag = true;

                            }
                            break;
                        }
                        if(map[j][i+k]!=num){
                            flag = true;
                            break;
                        }

                    }
                    if(!flag&&i-1>=0&&map[j][i-1]==num){
                        flag =true;
                    }
                    if(!flag){
                        System.out.println(num);
                        System.out.println(j+1+" "+(i+1));
                        return;
                    }
                    flag = false;
                    for (int k = 0; k < 6; k++) {
                        if(j+k>=19||i+k>=19){
                            if(k==5){
                                break;
                            }
                            flag = true;
                            break;
                        }
                        if(k==5){
                            if(map[j+k][i+k]==num){
                                flag = true;
                            }
                            break;
                        }
                        if(map[j+k][i+k]!=num){
                            flag = true;
                            break;
                        }

                    }
                    if(!flag&&j-1>=0&&i-1>=0&&map[j-1][i-1]==num){
                        flag =true;
                    }
                    if(!flag){
                        System.out.println(num);
                        System.out.println(j+1+" "+(i+1));
                        return;
                    }
                    flag = false;
                    for (int k = 0; k < 6; k++) {
                        if(j+k>=19){
                            if(k==5){
                                break;
                            }
                            flag = true;
                            break;
                        }
                        if(k==5){
                            if(map[j+k][i]==num){
                                flag = true;
                            }
                            break;
                        }
                        if(map[j+k][i]!=num){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag&&j-1>=0&&map[j-1][i]==num){
                        flag =true;
                    }
                    if(!flag){
                        System.out.println(num);
                        System.out.println(j+1+" "+(i+1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
