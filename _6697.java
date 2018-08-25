import java.util.*;
public class _6697 {

	public static void main(String[] args) {
		for(int i=1000;i<=9999;i++) {
			int a=0,tmp=i;
			while(tmp!=0) {
				a += tmp%10;
				tmp /=10;
			}
			int b=0;
			tmp=i;
			while(tmp!=0) {
				b+=tmp%12;
				tmp/=12;
			}
			int c=0;
			tmp=i;
			while(tmp!=0) {
				c+=tmp%16;
				tmp/=16;
			}
			if(a==b&&b==c) {
				System.out.println(i);
			}
		}
	}
}