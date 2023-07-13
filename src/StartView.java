import java.util.Scanner;

class Goods{
    private static String[][] data = {
            {"A01" , "새우깡" , "2500" , "짜고맛나다."},
            {"A02" , "치토스" , "2000" , "맛나다."},
            {"A03" , "초코파이" , "3500" , "짜다."},
            {"A04" , "콘칩" , "3000" , "맛없다."},
            {"A05" , "칙촉" , "1500" , "맛있다."},
    };

    private static int index =0;
    public void setData (String[] data){
        this.data[index] = data;
        index++;
        if(index==5)
            index=0;
    }
    public void setData (int codeNum,int num,String update){
        this.data[codeNum][num] = update;
    }
    public String[][] getData(){
        return data;
    }
    public String[] getData(int index){
        return data[index];
    }

}
class GoodsService{
    Goods g = new Goods();
    EndView ev = new EndView();
    String[][]data = g.getData();   //이렇게 써도되는지..?
    public void createGoods(String[] goods){
        for(int i = 0; i<5; i++){
            if(data[i][0].equals(goods[0])){
                System.out.println("중복된 상품코드");
                return;
            }
        }
        g.setData(goods);
        ev.create();
    }
    public void getAll(){
        ev.getAll(data);
    }
    public void getPart(String code){
        String[] item = null;
        for(int i =0; i<data.length;i++){
            if(data[i][0].equals(code)){
                item = g.getData(i);
                break;
            }
        }
        ev.getPart(item);
    }
    public void updateData (String code,int num,String update){

        for(int i = 0; i<data.length;i++){
            if(data[i][0].equals(code)){
                if(num==1){
                    g.setData(i,2,update);
                    break;
                }
                else if(num==2){
                    g.setData(i,3,update);
                    break;
                }
            }
        }
        ev.getAll(data);
    }
}
class EndView{
    public void create(){
        System.out.println("등록완료");
    }
    public void getAll(String[][] data){
        for(int i = 0; i< data.length;i++){
            for(int j = 0; j<data[0].length;j++){
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void getPart(String[] data){
        for(int i = 0; i< data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

}
class MenuView{
    Scanner sc = new Scanner(System.in);
    public void inputData(){
        GoodsService gs = new GoodsService();

        System.out.println("1.상품등록  2.전체검색  3. 부분검색  4. 수정  5.삭제  6.종료");
        System.out.print("메뉴를 선택하세요: ");
        int service = sc.nextInt();
        String[] goods = new String[4];
        if(service==1){
            System.out.print("상품코드 입력: ");
            goods[0] = sc.next();
            System.out.print("상품이름 입력: ");
            goods[1] = sc.next();
            System.out.print("상품가격 입력: ");
            goods[2] = sc.next();
            System.out.print("상품설명 입력: ");
            goods[3] = sc.next();
            gs.createGoods(goods);
        }
        else if(service==2)
            gs.getAll();
        else if(service==3){
            System.out.print("검색할 상품코드: ");
            String code = sc.next();
            gs.getPart(code);
        }
        else if(service==4){
            System.out.print("수정할 상품코드: ");
            String code = sc.next();
            System.out.print("1.가격수정 2.설명수정 ");
            int num = sc.nextInt();
            System.out.print("수정: ");
            String update = sc.next();
            gs.updateData(code,num,update);
        }
        //삭제생략
        else if(service==6){
            System.exit(0);
        }

    }
}
public class StartView {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        while(true){
            menuView.inputData();
        }
    }
}
