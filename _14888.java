import java.util.*;
public class _14888 {
   static int N;
   static int[ ] number;
   static int[]op;
   static List<Integer> list;
   static void dfs(int x, int sum) {
      for(int i=0;i<4;i++) {
         if(op[i]!=0) {
            op[i]--;
            if(i==0) {
               dfs(x+1,sum+number[x]);
               op[i]++;
            }
            else if(i==1) {
               dfs(x+1,sum-number[x]);
               op[i]++;
            }
            else if(i==2) {
               dfs(x+1,sum*number[x]);
               op[i]++;
            }
            else  {
               
               dfs(x+1,sum/number[x]);
               op[i]++;
            }
         }
      }
      if(x==N) {
    	  list.add(sum);
      }
   }
   public static void main(String[] args) {
      Scanner scan =new Scanner(System.in);
      N=scan.nextInt();
      number = new int[N];
      op= new int[4];
      for(int i=0;i<N;i++) {
         number[i]=scan.nextInt();
      }
      for(int i=0;i<4;i++) {
         op[i]=scan.nextInt();
      }
      list = new LinkedList();
      dfs(1,number[0]);
      Collections.sort(list);
      System.out.println(list.get(list.size()-1));
      System.out.println(list.get(0));
   }
}