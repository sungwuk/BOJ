import java.util.*;
public class _5554 {

	public static void main(String[] args) {
		int input,minute=0,second=0,m;
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<4;i++) {
			input = scan.nextInt();
			m=input/60;
			minute+=m;
			input = input-(60*m);
			second+=input;
			if(second>=60) {
				second-=60;
				minute++;
			}
		}
		System.out.println(minute);
		System.out.println(second);
	}
}
