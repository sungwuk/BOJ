import java.util.*;
public class _6593 {
   static class pair{
      int x,y,d;
      pair(int x,int y, int d){
         this.x=x;this.y=y;this.d=d;
      }
   }
   public static void main(String[] args) {
      boolean[][] check;
      boolean flag=false;
      char[][] map;
      int end_x=-1,end_y=-1,L,R,C;
      int start_x=-1,start_y=-1;
      Scanner sc = new Scanner(System.in);
      int[]dy = {0,0,-1,1,0,0},dx;
      while(true) {
         L=sc.nextInt();R=sc.nextInt();C=sc.nextInt();
         if(L==0&&R==0&&C==0) break;
         dx = new int[]{1,-1,0,0,R,-R};
         map = new char[L*R][C];
         check= new boolean[L*R][C];
         LinkedList<pair> list = new LinkedList<pair>();
         for(int i=0;i<R*L;i++) {
            String input = sc.next();
            for(int j=0;j<C;j++) {
               if(input.charAt(j)==83) {      //start지점   
                  list.add(new pair(i,j,0));
               }
               else if(input.charAt(j)==69) {
                  end_x=i;end_y=j;
               }
               map[i][j]=input.charAt(j);
            }
         }
         check[list.peek().x][list.peek().y]=true;
         while(!list.isEmpty()) {
            pair first = list.remove(0);
            for(int i=0;i<6;i++) {
               int a = first.x+dx[i];
               int b = first.y+dy[i];
               if(a<0||b<0||a>=R*L||b>=C) continue;
               if(a==end_x&&b==end_y) {
                  System.out.println("Escaped in "+(first.d+1)+" minute(s).");
                  flag=true;
                  list.clear();
               }
               if((first.x)%R==0) {					//이동하게될 좌표가 인접(층간 경계)
            	   if(a==(first.x-1))
            		   continue;
               }
               if(!check[a][b]&&map[a][b]==46) {
            	  check[a][b]=true;
                  list.add(new pair(a,b,first.d+1));
               }
            }
         }
         if(!flag) {
            System.out.println("Trapped!");
         }
         flag=false;
      }
   }
}