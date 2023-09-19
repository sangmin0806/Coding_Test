import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Birthday {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Member> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            Member member = new Member(name,day,month,year);
            list.add(member);
        }
        Member maxage = new Member("k",32,13,2011);
        Member minage = new Member("a",0,0,1989);

        for (int i = 0; i < N; i++) {
            Member mem = list.get(i);
            if(mem.year<maxage.year){
                maxage = mem;
            }
            else if(mem.year==maxage.year){
                if(mem.month<maxage.month){
                    maxage = mem;
                }
                else if(mem.month==maxage.month){
                    if(mem.day<maxage.day){
                        maxage = mem;
                    }
                }
            }
            if(mem.year>minage.year){
                minage = mem;
            }
            else if(mem.year==minage.year){
                if(mem.month>minage.month){
                    minage = mem;
                }
                else if(mem.month==minage.month){
                    if(mem.day>minage.day){
                        minage = mem;
                    }
                }
            }
        }
        System.out.println(minage.name);
        System.out.println(maxage.name);


    }
}
class Member {
    String name;
    int day,month,year;
    public Member(String name,int day, int month, int year){
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
