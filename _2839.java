import java.util.*;
public class _2839 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int dap = n/5;				//5에 담아보기
		n%=5;
		while(true) {
			if(n%3==0) {
				dap+=n/3;
				break;
			}
			else {
				if(dap-1<0) {
					System.out.println(-1);
					return;
				}
				dap--;
				n+=5;
			}

		}
		System.out.println(dap);
	}
}