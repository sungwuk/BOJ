import java.util.*;
public class _11650 {
	static class Point implements Comparable<Point>{
		int x,y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
		@Override
		public int compareTo(Point o) {
			if(this.x==o.x) {
				return this.y-o.y;
			}
			else {
				return this.x-o.x;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		Point arr [] = new Point[n];
		for(int i=0;i<n;i++) {
			int x= sc.nextInt(),y=sc.nextInt();
			arr[i]= new Point(x, y);
		}
		Arrays.sort(arr);
		for(Point i : arr) {
			System.out.println(i.x+" "+i.y);
		}
	}
}