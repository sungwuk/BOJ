import java.util.*;
public class _5214 {
	static class Station{
		int n, dep;
		
		Station(int n, int dep){
			this.n=n;this.dep=dep;
		}
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
			int n,k,m;
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();k=sc.nextInt();m=sc.nextInt();
//			boolean[][] map = new boolean[n+3][n+3];
			LinkedList<Integer>[] maps = new LinkedList[n+1];
			LinkedList<Integer> arr = new LinkedList();
			for(int i=0;i<=n;i++) {
				maps[i]= new LinkedList<>();
			}
			for(int i=0;i<m;i++) {
				for(int j=0;j<k;j++) {
					int e=sc.nextInt();
					arr.add(new Integer(e));
				}
				for(int y=0;y<k;y++) {
						int a = arr.remove(0);
						int t=arr.remove(0);
						maps[a].add(t);
						maps[t].add(a);
						arr.add(new Integer(a));
						arr.add(new Integer(t));
				}
				arr.clear();
			}
			LinkedList<Station> list = new LinkedList<>();
			list.add(new Station(1,1));
			boolean[][] check = new boolean[n+1][n+1];
			while(!list.isEmpty()) {
				Station tmp = list.removeFirst();
				int a=tmp.n;
				int dep = tmp.dep;
				if(tmp.n==n) {
					System.out.println(dep);
					return;
				}
				for(int i=1;i<=n;i++) {
					if(maps[a].contains(i)&&!check[a][i]) {
						check[a][i]=true;
						list.add(new Station(i,dep+1));
					}
				}
			}
			System.out.println(-1);
	}

}
