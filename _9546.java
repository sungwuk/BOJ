import java.util.*;
public class _9546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		for(int k=0;k<t;k++) {
			int n = sc.nextInt();
			int count=0;
			double dap =0;
			while(count<n) {
				dap+=0.5;
				dap*=2;
				count++;
			}
			System.out.println((int)dap);
		}

	}
}