import java.util.*;
public class _4153 {

	public static void main(String[] args) {
		int a,b,c,max;
		Scanner scan = new Scanner(System.in);
		while(true) {
			a=scan.nextInt();max=a;
			b=scan.nextInt();if(max<b) max=b;
			c=scan.nextInt();if(max<c) max=c;
			if(a==0&&b==0&&c==0) break;
			if(max==a) {
				if(max*max==b*b+c*c) System.out.println("right");
				else System.out.println("wrong");
			}
			else if(max==b) {
				if(max*max==a*a+c*c) System.out.println("right");
				else System.out.println("wrong");
			}	
			else {
				if(max*max==b*b+a*a) System.out.println("right");
				else System.out.println("wrong");
			}
		}
	}
}


