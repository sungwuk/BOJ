import java.util.*;
public class _10707 {
	public static void main(String[] args) {
		int A,B,C,D,P,x,y;
		Scanner scan = new Scanner(System.in);
		A=scan.nextInt();B=scan.nextInt();C=scan.nextInt();
		D=scan.nextInt();P=scan.nextInt();
		x=P*A;
		if(P<=C) y=B;
		else {
			y=B;
			P-=C;
			y+=P*D;
		}
		System.out.println((x>y)? y:x);
	}
}