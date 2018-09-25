import java.util.*;
public class _10988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in=sc.next();
			for(int i=0;i<in.length()/2;i++) {
				if(in.charAt(i)!=in.charAt(in.length()-i-1)) {
					System.out.println(0);return ;
				}
			}
			System.out.println(1);return ;
		}
}