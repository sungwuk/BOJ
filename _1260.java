import java.util.*;
public class _1260 {
	static boolean chk[],map[][];
	static int n,m,start;
	static void dfs(int s) {
		System.out.print(s+" ");
		chk[s]=true;
		for(int i=1;i<=n;i++) {
			if(!chk[i]&&map[s][i]) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();m=sc.nextInt();start=sc.nextInt();
		map = new boolean[n+1][n+1];
		chk = new boolean[n+1];
		for(int i=0;i<m;i++) {
			int a = sc.nextInt(),b=sc.nextInt();
			map[a][b]= true;
			map[b][a]=true;
		}
		dfs(start);
		System.out.println();
		chk = new boolean[n+1];
		LinkedList<Integer> list = new LinkedList<>();
		list.add(start);
		chk[start]=true;
		while(!list.isEmpty()) {
			int tmp= list.poll();
			System.out.print(tmp+" ");
			for(int i=1;i<=n;i++) {
				if(map[tmp][i]&&!chk[i]) {
					chk[i]=true;
					list.add(i);
				}
			}
		}
	}

}
