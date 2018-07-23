import java.util.*;
public class _7562 {
   static boolean[][] map,check;
   static    int size,x,y,dest_x,dest_y;
   static Scanner sc = new Scanner(System.in);
   static LinkedList<Point> list;
   static int[] dx= {1,1,2,2,-1,-1,-2,-2};
   static int[] dy= {-2,2,-1,1,-2,2,-1,1};
   static class Point{
      int x,y,d;
      Point(int x, int y,int d){
         this.x=x;this.y=y;this.d=d;
      }
   }
   static void solve(int dest_x,int dest_y) {
      while(!list.isEmpty()) {
         Point tmp = list.poll();
         int cx=tmp.x;
         int cy=tmp.y;
         int cd=tmp.d;
         if(cx==dest_x&&cy==dest_y) {
        	 System.out.println(cd);
        	 return;
         }
         check[cx][cy]=true;
            for(int i=0;i<8;i++) {
               int a = cx+dx[i];
               int b = cy+dy[i];
               if(a<0||b<0||a>=size||b>=size) continue;
               if(!check[a][b]) {
            	   check[a][b]=true;
            	   list.add(new Point(a,b,cd+1));
               }
            }
      }
   }
   static void init() {
      map= new boolean[size][size];
      check= new boolean[size][size];
      list = new LinkedList<>();
   }
   public static void main(String[] args) {
      int t=sc.nextInt();
      for(int i=0;i<t;i++) {
         size = sc.nextInt();
         x = sc.nextInt(); y=sc.nextInt();
         init();
         list.add(new Point(x,y,0));
         dest_x=sc.nextInt(); dest_y=sc.nextInt();
         solve(dest_x,dest_y);
      }
   }
}