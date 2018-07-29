import java.util.*;
public class _1 {

	public static void main(String[] args) {
		String input;
		//			System.out.println((char)65);
		input =new Scanner(System.in).next();
		int count=1;
		char[] tmp = input.toCharArray();
		for(int i=0;i<input.length();i++) {
			if(count%3==0) {
				int lower = input.charAt(i);
				if(lower>=97&&lower<=122) {				//¼Ò¹®ÀÚ
					int c=lower-32;
					char in = (char)c;
					System.out.print(in);
				}
				else {
					System.out.print("!");
				}
			}
			else {
				System.out.print(input.charAt(i));
			}
			count++;
		}
	}
}
