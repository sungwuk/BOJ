package samsung;
import java.util.*;
public class  _5644{
    static boolean map[][][];
    static int t,m,a;
    static int dx[]= {1,-1,0,0};
    static int dy[]= {0,0,1,-1};
    static int eng[];
    static Point personA, personB;
    static class Point{
        int x,y,charge;
        Point(int x,int y){
            this.x=x;this.y=y;
        }
        Point(int x,int y,int charge){
            this.x=x;this.y=y;this.charge=charge;
        }
    }
    static void onebecon(Point tmp) {       //두개 중 하나만 비콘 영역에 있을떄
            int max = Integer.MIN_VALUE;
            for(int i=1;i<9;i++) {                                       //여거래가 겹친 경우는 가장 큰값
                if(map[tmp.y][tmp.x][i]) max = Math.max(max, eng[i]);
            }
            tmp.charge+=max;
    }
    static void make_map(int x,int y,int c,int num) {
        LinkedList<Point> list = new LinkedList<>();
        list.add(new Point(x,y));
        map[y][x][num]=true;
        while(!list.isEmpty()) {
            Point tmp = list.poll();
            int cx = tmp.x;
            int cy = tmp.y;
            for(int i=0;i<4;i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx<1||ny<1||nx>10||ny>10||map[ny][nx][num])continue;
                if(Math.abs(x-nx)+Math.abs(y-ny)<=c) {
                    list.add(new Point(nx,ny));
                    map[ny][nx][num]=true;
                }
            }
        }
    }
    static boolean same(LinkedList<Integer> p1,LinkedList<Integer> p2) {    //두 사람이 속한 비콘이 같은지 다른지 확인
        for(int i=0;i<p1.size();i++) {
            if(p2.contains(p1.get(i))) return true;
        }
        return false;
    }
    static void check(Point p1,Point p2) {
        LinkedList<Integer> becon1 = new LinkedList<>();
        LinkedList<Integer> becon2 = new LinkedList<>();
        for(int i=1;i<9;i++) {                   // 해당 칸에 비콘이 겹치는지, 겹치면 몇개가 겹치는지 확인
            if(map[p1.y][p1.x][i]) becon1.add(i);
            if(map[p2.y][p2.x][i]) becon2.add(i);
        }
        if(becon1.size()==0&&becon2.size()==0) return;      // 두 사람 모두 비콘 영역이 아닌경우
 
        if(becon1.size()!=0&&becon2.size()==0) { onebecon(p1);  //사람 1만 비콘에 올라가있다.
        return;
        }
        if(becon1.size()==0&&becon2.size()!=0) { onebecon(p2);  //사람 2만 비콘에 있을 때
        return;
        }
        if(!same(becon1,becon2)) {                              //두명 다 비콘위에 있지만 각각 다른 비콘에 있을 때
            onebecon(p1);
            onebecon(p2);
            return;
        }
                //비콘끼리 겹쳐있거나, 총 충전량 계산이 필요한 경우
                int result = Integer.MIN_VALUE;         //충전량의 합
                int a=0,b=0;
                for(int i=0;i<becon1.size();i++) {
                    int tmp_becon = becon1.get(i);
                    for(int j=0;j<becon2.size();j++) {
                        int be2 = becon2.get(j);
                        if(be2==tmp_becon) {            //절반씩 나눠갖기
                            if(result<eng[be2]) {
                                a= eng[be2]/2;b=eng[be2]/2;         //모든 사용자가 충전한 양이 최대일때의 각각 충전량 기록
                                result = Math.max(result, eng[be2]);
                            }
                        }
                        else {
                            if(result<eng[be2]+eng[tmp_becon]) {
                                a=eng[tmp_becon];b=eng[be2];
                                result = Math.max(eng[be2]+eng[tmp_becon], result);
                            }
                        }
                    }
                }
                p1.charge+=a;p2.charge+=b;              //두 사람의 충전량의 합이 최대인 경우에 해당하는 각각의 충전량 더해주기
    }
    static void move(Point p,int a) {
        if(a==0) return;
        if(a==1) {
            int tmp = p.y-1;
            if(tmp<1) return;
            p.y-=1;
            return;
        }
        else if(a==2) {
            int tmp = p.x+1;
            if(tmp>10) return;
            p.x+=1;
        }
        else if(a==3) {
            int tmp = p.y+1;
            if(tmp>10) return;
            p.y+=1;
        }
        else if(a==4) {
            int tmp = p.x-1;
            if(tmp<1) return;
            p.x-=1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t=sc.nextInt();
        for(int p=1;p<=t;p++) {
            m=sc.nextInt();a=sc.nextInt();
            LinkedList<Integer> orderA = new LinkedList<>();
            LinkedList<Integer> orderB = new LinkedList<>();
            map= new boolean[11][11][9];
            for(int i=0;i<m;i++) orderA.add(sc.nextInt());
            for(int i=0;i<m;i++) orderB.add(sc.nextInt());
            eng = new int[a+1];
            for(int i=0;i<a;i++) {
                int x=sc.nextInt(),y=sc.nextInt(),c=sc.nextInt(),po=sc.nextInt();
                make_map(x,y,c,i+1);
                eng[i+1]=po;                //해당 비콘의 충전량
            }
            personA = new Point(1,1,0);personB = new Point(10,10,0);
            check(personA,personB);     //0초일 때 확인.
            while(!orderA.isEmpty()) {
                int a = orderA.poll();
                int b = orderB.poll();
                move(personA,a);move(personB,b);    //움직이는 부분
                check(personA,personB);             // 사람 2명이 어느 비콘에 있는지 확인하는 부분
            }
            System.out.println("#"+p+" "+(personA.charge+personB.charge));
        }
    }
}