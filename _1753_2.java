import java.util.*;
public class _1753_2 {
	static int[] dist;
	static boolean[] chk;
	static class Vertex implements Comparable<Vertex>{
		int dest,wei;
		Vertex(int d,int w){
			this.dest=d;this.wei=w;
		}
		@Override
		public int compareTo(Vertex o) {
			return this.wei-o.wei;
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int v=sc.nextInt(),e=sc.nextInt(),start=sc.nextInt();
		LinkedList<Vertex>[] list = new LinkedList[v+1];
		dist = new int[v+1];chk= new boolean[v+1];
		for(int i=1;i<=v;i++) {
			list[i]= new LinkedList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		for(int i=1;i<=e;i++) {
			int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
			list[a].add(new Vertex(b, c));
		}
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.add(new Vertex(start, 0));
		dist[start]=0;
		while(!q.isEmpty()) {
			Vertex cur = q.poll();
			if(chk[cur.dest]) continue;
			chk[cur.dest]=true;
			for(Vertex ve : list[cur.dest]) {
				if(chk[ve.dest]) continue;
					dist[ve.dest] = Math.min(dist[cur.dest]+ve.wei, dist[ve.dest]);
					q.add(new Vertex(ve.dest, dist[ve.dest]));
			}
		}
		for(int i=1;i<=v;i++) {
			if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
}