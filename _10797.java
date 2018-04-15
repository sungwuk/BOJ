import java.util.*;
public class _10797 {

	public static void main(String[] args) {
		int day,input,count=0;
		Scanner scan = new Scanner(System.in);
		day=scan.nextInt();
		for(int i=0;i<5;i++) {
			input=scan.nextInt();
			if(input==day) count++;
		}
		System.out.println(count);
	}

}
