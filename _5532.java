import java.util.*;
public class _5532 {
	public static void main(String[] args) {
		int L,A,B,C,D;
		Scanner scan = new Scanner(System.in);
		L=scan.nextInt();A=scan.nextInt();B=scan.nextInt();
		C=scan.nextInt();D=scan.nextInt();
		while(A>0||B>0) {
			A-=C;
			B-=D;
			L--;
		}
		System.out.println(L);
	}
}