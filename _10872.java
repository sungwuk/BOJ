import java.util.*;
public class _10872 {
	static int factorial(int n) {
		if(n==0) return 1;
		else {
			return factorial(n-1)*n;
		}
	}
	public static void main(String[] args) {
		int n;
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		System.out.println(factorial(n));
	}
}