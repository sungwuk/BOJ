import java.util.*;
import java.io.FileInputStream;
class Solution
{
    static int N;
    static int[] operator;
    static int[] input ;
    static List<Integer> list ;
    static void solve(int x,int total) {
        for(int i=0;i<4;i++) {
            if(operator[i]>0) {
                operator[i]--;
                if(i==0) {
                    solve(x+1,total+input[x]);
                    operator[i]++;
                }
                else if(i==1) {
                    solve(x+1,total-input[x]);
                    operator[i]++;
                }
                else if(i==2) {
                    solve(x+1,total*input[x]);
                    operator[i]++;
                }
                else {
                    solve(x+1,total/input[x]);
                    operator[i]++;
                }
            }
        }
        if(x==N) {
            list.add(total);
        }
    }
    public static void main(String args[]) throws Exception
    {
        Scanner scan = new Scanner(System.in);
         
        int T;
        T=scan.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N=scan.nextInt();
            input = new int[N+3];
            operator = new int[N+3];
            list = new LinkedList();
            for(int i=0;i<4;i++) {
                operator[i]=scan.nextInt();             //연산자 받는부분
            }
            for(int i=0;i<N;i++) {
                input[i]=scan.nextInt();                //피연산자 받는 부분
            }
            solve(1,input[0]);
            Collections.sort(list);
            System.out.println("#"+test_case+" "+Math.abs(list.get(0)-list.get(list.size()-1)));
            list = new LinkedList<Integer>();
        }
    }
}