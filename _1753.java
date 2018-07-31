import java.util.*;
class Point implements Comparable<Point>{
	int dest;
	int wei;
	Point(int d, int w){
		this.dest=d;this.wei=w;
	}
	@Override
	public int compareTo(Point o) {
		
		return this.wei-o.wei;
	}
}
public class _1753 {
	public static void main(String[] args) {
		int v,e,s;
		Scanner sc = new Scanner(System.in);
		v=sc.nextInt();e=sc.nextInt();
		s=sc.nextInt();
		LinkedList<Point>[] list = new LinkedList[v+1]; 
		int dist[] = new int[v+1];
		boolean check[] = new boolean[v+1];
		for(int i=1;i<=v;i++) {
			list[i]= new LinkedList<>();
		}
		for(int i=0;i<e;i++) {
			int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
			list[a].add(new Point(b,c));
		}
		for(int i=1;i<=v;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[s]=0;
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(s,0));
		while(!pq.isEmpty()) {
			Point tmp = pq.poll();
			if(check[tmp.dest]) continue;
			check[tmp.dest]=true;
			for(Point a : list[tmp.dest]) {
				if(!check[a.dest]) {
					dist[a.dest]= Math.min(dist[a.dest], dist[tmp.dest]+a.wei);
					pq.add(new Point(a.dest,dist[a.dest]));
				}
			}
		}
		for(int i=1;i<=v;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(dist[i]);
		}
	}
}