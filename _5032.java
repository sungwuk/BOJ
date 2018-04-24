import java.util.*;
public class _5032 {

	public static void main(String[] args) {
		int e,f,c,count=0;
		Scanner scan = new Scanner(System.in);
		e=scan.nextInt();f=scan.nextInt();c=scan.nextInt();
		e+=f;
		while(e>=c) {
			int a = e/c;
			count+=a;
			e-=a*c;
			e+=a;
		}
		System.out.println(count);
	}
}