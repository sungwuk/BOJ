import java.util.*;
public class _1920 {
	static int [] a1;
	static void solve(int start,int end,int a) {
		int mid = (start+end)/2;
		if(end<start) {
			System.out.println(0);
			return;
		}
		else {
			if(a1[mid]==a) {
				System.out.println(1);
				return;
			}
			else {
				if(a1[mid]>a) {
					solve(start,mid-1,a);
				}
				else if(a1[mid]<a) {
					solve(mid+1,end,a);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int n= sc.nextInt();
		a1= new int[n];
		for(int i=0;i<n;i++) {
			a1[i]=sc.nextInt();
		}
		Arrays.sort(a1);
		int in = sc.nextInt();
		for(int i=0;i<in;i++) {
			int a = sc.nextInt();
			solve(0,n-1,a);
		}
	}
}