import java.util.*;
public class _2798 {
	public static void main(String[] args) {
		int n,m,sum=0;
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();m=scan.nextInt();
		int [] in = new int[n];
		for(int i=0;i<n;i++) {
			in[i]=scan.nextInt();
		}
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					int a=in[i]+in[j]+in[k];
					if(a<=m) {
						sum= (sum>a)? sum:a;
					}
				}
			}
		}
		System.out.println(sum);
	}

}
