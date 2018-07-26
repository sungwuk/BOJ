import java.util.*;
public class _1966 {
	static int max=Integer.MIN_VALUE,count;
	static class Pair{
		int doc,pri;
		Pair(int d,int p){
			this.doc=d;this.pri=p;
		}
	}
	static void roll(LinkedList q){
		Pair tmp = (Pair)q.peek();
		if(tmp.pri==max) return;
		else {
			Pair out = (Pair)q.poll();
			q.add(out);
			roll(q);
		}
	}
	static void solve(LinkedList q,int m) {
		Pair dd = (Pair)q.get(0);
		count++;
		if(dd.doc==m&&dd.pri==max) {
			System.out.println(count);
			return;
		}
		else {
			roll(q);
			Pair d = (Pair)q.get(0);
			if(d.doc==m&&d.pri==max) {
				System.out.println(count);
				return;
			}
			q.poll();

			max = Integer.MIN_VALUE;
			for(int a =0;a<q.size();a++ ) {
				Pair b = (Pair) q.get(a);
				if(b.pri>max) max=b.pri;
			}
			solve(q,m);
		}
	}
	public static void main(String[] args) {
		int t,n,m;
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt();
		for(int k=0;k<t;k++) {
			LinkedList<Pair> q = new LinkedList<Pair>();
			n=sc.nextInt();m=sc.nextInt();
			max = Integer.MIN_VALUE;
			count=0;
			for(int i=0;i<n;i++) {
				int tmp = sc.nextInt();
				if(max<tmp) max=tmp;
				q.add(new Pair(i,tmp));
			}
			solve(q,m);
		}
	}

}
