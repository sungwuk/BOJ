import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
        static int n,min=Integer.MAX_VALUE;
    static boolean[] use;
    static int[][] food ;
    static void check() {
        int a=0,b=0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(use[i]&&use[j]) a+=food[i][j];
                else if(!use[i]&&!use[j])b+=food[i][j];
            }
        }
        min = Math.min(min, Math.abs(a-b));
    }
    static void solve(int c, int d) {
        if(c==n/2) check();
        else {
            for(int i=d+1;i<n;i++) {
                use[i]=true;
                solve(c+1,i);
                use[i]=false;
            }
        }
    }
    public static void main(String args[]) throws Exception
    {
     
        Scanner sc = new Scanner(System.in);
        int T,count=0;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n=sc.nextInt();
            food = new int[n+1][n+1];
             use= new boolean[n+1];
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    food[i][j]=sc.nextInt();
                }
            }
            solve(0,0);
            System.out.println("#"+test_case+" "+min);
            min=Integer.MAX_VALUE;
        }
 
    }
}