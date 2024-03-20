import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {

        int len = records.length;
        car[] arr = new car[len];
        for(int i = 0; i<len; i++){
            String str = records[i];
            int hour = Integer.parseInt(str.substring(0,2));
            int minute = Integer.parseInt(str.substring(3,5));
            int num = Integer.parseInt(str.substring(6,10));
            char temp = str.charAt(11);
            boolean status = false;
            if(temp=='I'){
                status = true;
            }
            arr[i] = new car(hour,minute,num,status);
        }
        Arrays.sort(arr);
        int[] time = new int[len];
        int index = 0;
        int curnum = arr[0].num;
        int diff = 0;
        for(int i = 0; i<len; i++){
            if(curnum!=arr[i].num){
                time[index++] = diff;
                curnum=arr[i].num;
                diff = 0;
            }
            if(i==len-1) break;
            if(arr[i].status&&arr[i+1].num==curnum){
            diff -= arr[i].hour*60+arr[i].minute;
            }
            else if(!arr[i].status){
                diff += arr[i].hour*60 + arr[i].minute;
            }
            else if(arr[i].status&&arr[i+1].num!=curnum){
                diff += (23*60+59)-(arr[i].hour*60+arr[i].minute);
            }
            
        }
        if(arr[len-1].status){
            diff += (23*60+59)-(arr[len-1].hour*60+arr[len-1].minute);
        }else{
            diff += arr[len-1].hour*60 + arr[len-1].minute;
        }
        time[index] = diff;
        int[] cost = new int[index+1];
        for(int i = 0; i<index+1;i++){
            if(time[i]>fees[0]){
                cost[i] = fees[1]+((int)Math.ceil((double)(time[i]-fees[0])/(double)fees[2]))*fees[3];
            }else{
                cost[i] = fees[1];
            }
        }
        return cost;
    }
}
class car implements Comparable<car>{
    int hour;
    int minute;
    int num;
    boolean status;
    public car(int hour,int minute, int num,boolean status){
        this.hour = hour;
        this.minute = minute;
        this.num = num;
        this.status = status;
    }
    public int compareTo(car c){
        if(this.num==c.num){
            if(this.hour==c.hour){
                return Integer.compare(this.minute,c.minute);
            }
            return Integer.compare(this.hour,c.hour);
        }
        return Integer.compare(this.num,c.num);
    }
}