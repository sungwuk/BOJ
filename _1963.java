import java.util.*;
public class _1963 {
	static class prime{
		int num,dep;
		prime(int n, int d){
			this.num=n;this.dep=d;
		}
	}
	static boolean isPrime(int input) {
		for(int i=2;i<=Math.sqrt(input);i++) {
			if(input%i==0) {
				return false;
			}
		}
		return true;
	}
	static int make(int[]a) {
		int number=0;
		number+=a[0]*1000;
		number+=a[1]*100;
		number+=a[2]*10;
		number+=a[3];
		return number;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt(),dap=0;
		boolean flag= false;
		for(int k=0;k<T;k++) {
			int start = sc.nextInt(), end= sc.nextInt();
			Queue<prime> q = new LinkedList<>();
			q.add(new prime(start,0));
			int arr[]= new int[4];
			boolean[] check  = new boolean[10001];
			while(!q.isEmpty()) {
				prime tmp = q.poll();
				int tx = tmp.num;
				int td = tmp.dep;
				check[tx-1000]=true;
				if(tx==end) {
					flag=true;
					dap=td;
					break;
				}
				arr[0]=tx/1000;tx%=1000;
				arr[1]=tx/100;tx%=100;
				arr[2]=tx/10;tx%=10;
				arr[3]=tx;
				for(int j=0;j<4;j++) {
					int a = arr[j];
					for(int i=0;i<10;i++) {
						arr[j]++;
						if(j==0&&arr[j]>=10)arr[j]=1;
						if(j!=0&&arr[j]>=10)arr[j]=0;
						int nx = make(arr);						// 4자릿수 중에 하나를 바꾸고 4자리 숫자로 다시 만들기
						if(isPrime(nx)&&!check[nx-1000]) {
							check[nx-1000]=true;
							q.add(new prime(nx,td+1));
						}
					}
					arr[j]=a;
				}
			}
			if(flag)System.out.println(dap);
			else System.out.println("Impossible");
			flag=false;
		}
	}
}