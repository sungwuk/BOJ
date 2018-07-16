import java.util.*;
public class Main {
   static class EV{
      int floor,dep;
      EV(int f, int d){
         this.floor=f;this.dep=d;
      }
   }
   public static void main(String[] args) {
      int f,s,g,u,d;
      Scanner sc =new Scanner(System.in);
      f=sc.nextInt();s=sc.nextInt();g=sc.nextInt();
      u=sc.nextInt();d=sc.nextInt();
      int[] building  = new int[1000001];
      Queue<EV> q = new LinkedList<EV>();
      q.add(new EV(s,0));
      boolean[] c = new boolean[1000001];
      if(s==g) {
         System.out.println(0);
         return;
      }
      c[s]=true;
      while(!q.isEmpty()) {
         EV tmp = q.poll();
         int cur = tmp.floor;
         int dep = tmp.dep;
         int next_up = cur+u;
         int next_down = cur-d;
         if(next_up==g||next_down==g) {
            System.out.println(dep+1);
            return;
         }
            if(next_up<=f&&!c[next_up]) {
            	c[next_up]=true;
               q.add(new EV(next_up,dep+1));
            }
            if(next_down>=1&&!c[next_down]) {
               c[next_down]=true;
               q.add(new EV(next_down,dep+1));
            }
      }
      System.out.println("use the stairs");
   }
}