import java.util.*;
public class _11651 {
	static class Point implements Comparable<Point>{
		int x,y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
		@Override
		public int compareTo(Point o) {
			if(o.y==this.y) {
				return this.x-o.x;
			}
			return this.y-o.y;
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt();
		Point ar[]= new Point[n];
		for(int i=0;i<n;i++) {
			int x=sc.nextInt(),y=sc.nextInt();
			ar[i]=new Point(x,y);
		}
		Arrays.sort(ar);
		for(Point x: ar)System.out.println(x.x+" "+x.y);
	}
}