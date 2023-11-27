import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r;
    static int c;
    static int k;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[100][100];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean R = true;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int row = 3;
        int col = 3;

        List<int[]> list = new ArrayList<>();
        int count = 0;
        while (true){
            if(arr[r-1][c-1]==k){
                System.out.println(count);
                return;
            }
            if(count==100){
                System.out.println(-1);
                return;
            }
            if (R){
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < row; i++) {
                    hashMap.clear();
                    list.clear();
                    for (int j = 0; j < col; j++) {
                        if(arr[i][j]==0) continue;
                        hashMap.put(arr[i][j],hashMap.getOrDefault(arr[i][j],0)+1);
                    }
                    for(int num: hashMap.keySet()){
                        list.add(new int[]{num,hashMap.get(num)});
                    }
                    Collections.sort(list, new Comparator<int[]>() {
                        @Override
                        public int compare(int[] a, int[] b) {
                            return Integer.compare(a[0],b[0]);
                        }
                    });
                    Collections.sort(list, new Comparator<int[]>() {
                        @Override
                        public int compare(int[] a, int[] b) {
                            return Integer.compare(a[1],b[1]);
                        }
                    });

                    int index = 0;
                    for (int j = 0; j < list.size(); j++) {
                        arr[i][index] = list.get(j)[0];
                        index++;
                        arr[i][index] = list.get(j)[1];
                        index++;
                    }
                    if(index<col){
                        for (int j = index; j < col; j++) {
                            arr[i][j] = 0;
                        }
                    }
                    max = Math.max(max,index);

                }
                col = max;
            }else {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < col; i++) {
                    hashMap.clear();
                    list.clear();
                    for (int j = 0; j < row; j++) {
                        if(arr[j][i]==0) continue;
                        hashMap.put(arr[j][i],hashMap.getOrDefault(arr[j][i],0)+1);
                    }
                    for(int num: hashMap.keySet()){
                        list.add(new int[]{num,hashMap.get(num)});
                    }
                    Collections.sort(list, new Comparator<int[]>() {
                        @Override
                        public int compare(int[] a, int[] b) {
                            return Integer.compare(a[0],b[0]);
                        }
                    });
                    Collections.sort(list, new Comparator<int[]>() {
                        @Override
                        public int compare(int[] a, int[] b) {
                            return Integer.compare(a[1],b[1]);
                        }
                    });

                    int index = 0;
                    for (int j = 0; j < list.size(); j++) {
                        arr[index][i] = list.get(j)[0];
                        index++;
                        arr[index][i] = list.get(j)[1];
                        index++;
                    }
                    if(index<row){
                        for (int j = index; j < row; j++) {
                            arr[j][i] = 0;
                        }
                    }
                    max = Math.max(max,index);

                }
                row = max;

            }
            if(row>=col){
                R = true;
            }
            else {
                R = false;
            }
            count++;
        }

    }
}
