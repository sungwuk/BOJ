package fg;
import java.util.*;
public class _3975 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d=sc.nextInt();
			double result_A= (double)a/b;
			double result_B =(double)c/d;
			if(result_A>result_B) System.out.println("ALICE");
			else if(result_A<result_B) System.out.println("BOB");
			else System.out.println("DRAW");
		}
	}
}
