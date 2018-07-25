import java.util.*;
public class _1325 {
	static LinkedList<Integer> map[];
	static 	boolean[] check;
	static int[] count;
	static int n,m,dap;
	static void solve(int x) {
		check[x]=true;
		for(int a :map[x]) {
			if(!check[a]) {
				dap++;
				solve(a);
			}
		}
	}
	public static void main(String[] args) {
		LinkedList<Integer> result = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		map = new LinkedList[n+1];
	
		for(int i=1;i<=n;i++) {
			map[i]= new LinkedList<>();
		}
		for(int i=0;i<m;i++) {
			int a= sc.nextInt(),b=sc.nextInt();
			map[b].add(a);
		}
		count = new int[n+1];
		for(int i=1;i<=n;i++) {
			check = new boolean[n+1];
			dap=0;
			solve(i);
			count[i]=dap;
		}
		int max=Integer.MIN_VALUE;
		for(int k: count) {
			if(max<=k) {
				max=k;
			}
		}
		for(int k=1;k<=n;k++) {
			if(count[k]==max) {
				System.out.print(k+" ");
			}
		}
	}

}
