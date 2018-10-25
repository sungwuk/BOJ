import java.util.*;
public class _2965 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
		int count=0;
		while(true) {
			int p = Math.abs(a-b),q = Math.abs(b-c);
			if(p==1&&q==1) break;
			if(p>q) {
				c = b-1;
				int tmp = b;
				b=c;
				c=tmp;
			}
			else if(p<=q) {
				a=b+1;
				int tmp = b;
				b=a;
				a = tmp;
			}
			count++;
			
		}
		System.out.println(count);
	}
}
