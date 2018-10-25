import java.util.*;
public class _1074_2 {
	static int r,c,dap=0,n;
	static void solve(int x,int y,int size) {
		if(size==1) {
			System.out.println(dap);
			return;
		}
		int nx = x+size/2;
		int ny = y+size/2;
		int k = (int)(Math.pow(size,2))/4;
		if(r<nx&&c<ny) {
			solve(x,y,size/2);
		}
		else if(r<nx&&c>=ny) {
			dap+=k;
			solve(x,ny,size/2);
		}
		else if(r>=nx&&c<ny) {
			dap+=k*2;
			solve(nx,y,size/2);
		}
		else {
			dap+=k*3;
			solve(nx,ny,size/2);
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();r=sc.nextInt();c=sc.nextInt();
		solve(0,0,(int)Math.pow(2, n));
	}

}
