import java.util.*;
public class _2935 {

	public static void main(String[] args) {
		String A,B,op;
		Scanner scan = new Scanner(System.in);
		A = scan.next(); op = scan.next();B = scan.next();
		int count_A = A.length()-1;				//a�� b�� 0�� ����
		int count_B = B.length()-1;
		if(op.equals("+")) {
			if(count_A>count_B) {
				System.out.print(1);
				for(int i=0;i<(count_A-count_B)-1;i++) 	System.out.print(0);
				System.out.print(1);
				for(int i=0;i<count_B;i++) System.out.print(0);
			}
			else if(count_A<count_B) {	
				System.out.print(1);
				for(int i=0;i<(count_B-count_A)-1;i++) 	System.out.print(0);
				System.out.print(1);
				for(int i=0;i<count_A;i++) System.out.print(0);
			}
			else {
				System.out.print(2);
				for(int i=0;i<count_A;i++) System.out.print(0);
			}
		}
		else if(op.equals("*")){										//*����
			System.out.print(1);
			for(int i=0;i<count_A+count_B;i++) {
				System.out.print(0);
			}
		}
	}

}
