import java.util.*;
public class _1110 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String in = sc.next();
		String newSt=in;
		int count=0;
		while(true) {
			if(newSt.length()==1) {				//입력 숫자가 한자리수
				newSt="0".concat(in);

			}
			int a = newSt.charAt(0)-'0',b = newSt.charAt(1)-'0';
			if(a+b>=10) {
				String tmp = String.valueOf(a+b).substring(1, 2);
				newSt=String.valueOf(b).concat(tmp);
			}
			else {
				String tmp = String.valueOf(a+b).substring(0, 1);
				newSt=String.valueOf(b).concat(tmp);

			}
			count++;
			if(newSt.startsWith("0")&&in.length()==1) {
				if(newSt.charAt(1)==in.charAt(0)) {
					System.out.println(count);
					return;
				}
			}
			if(newSt.equals(in)) {
				System.out.println(count);
				return;
			
			}
		}
	}
}