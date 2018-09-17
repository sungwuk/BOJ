import java.util.*;
public class _11399 {
	static class People implements Comparable<People>{
		int num,time;
		People(int n , int t){
			this.num=n;this.time=t;
		}
		@Override
		public int compareTo(People o) {
			return this.time-o.time;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		People p[] = new People[n];
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			p[i]=new People(i,a);
		}
		int sum,total=0;
		Arrays.sort(p);
		for(int i=0;i<n;i++) {
			 sum=0;
			for(int j=0;j<=i;j++) {
			sum+=p[j].time;
			}
			total+=sum;
		}
		System.out.println(total);
	}
}