import java.util.*;
public class _10886 {

	public static void main(String[] args) {
		int n,dap=0;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		for(int i=0;i<n;i++) {
			int in=sc.nextInt();
			if(in==0) dap--;
			else dap++;
		}
		System.out.println(dap>0 ? "Junhee is cute!": "Junhee is not cute!");
	}
}