import java.util.*;
public class _2440 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=n-i+1;j>0;j--) System.out.print("*");
			System.out.println();
		}
	}
}