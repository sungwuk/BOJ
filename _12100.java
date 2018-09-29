import java.util.*;
public class _12100 {
	static int map[][],n,dap = Integer.MIN_VALUE;
	static int arr[]=new int[6];
	// 1 : 위로 올리기   2 : 오른쪽으로 밀기   3 : 아래로 내리기    4 : 왼쪽으로 밀기 
	static void calc(int tmp[][]) {
		int[] ttt ={4,3,2,1,2};
		for(int i=0;i<5;i++) {
			int order = arr[i];
			if(order==1) {
				for(int p=0;p<n;p++) {					//열 count
					int [] tarr= new int[n];
					int index=0;
					for(int q=0;q<n;q++) {
						if(tmp[q][p]!=0) {
							tarr[index]=tmp[q][p];
							index++;
						}
					}
					int q=0;
					for(;q<index;q++) {
						int  g=tarr[q];
						tmp[q][p]=g;
					}
					if(n-index!=0) {
						for(;q<n;q++) {
							tmp[q][p]=0;
						}
					}
					for(q=0;q<n-1;) {				//행 0~ n-1
						if(tmp[q][p]==tmp[q+1][p]&&tmp[q][p]!=0) {	//위로 이동시 같은 수인 경우.
							tmp[q][p]=tmp[q][p]*2;
							for(int a=q+1;a<n-1;a++) {
								tmp[a][p]=tmp[a+1][p];
							}
							tmp[n-1][p]=0;
							q++;
						}
						else q++;
					}
				}
			}
			else if(order==2) {			
				for(int p=0;p<n;p++) {
					int [] tarr= new int[n];
					int index=0;
					for(int q=n-1;q>=0;q--) {
						if(tmp[p][q]!=0) {
							tarr[index]=tmp[p][q];
							index++;
						}
					}
					for(int q=0;q<index;q++) {
						int  g= tarr[q];
						tmp[p][n-q-1]=g;
					}
					if(n-index!=0) {
						for(int q=index;q<n;q++) tmp[p][n-q-1]=0;
					}
					for(int q=n-1;q>0;) {				
						if(tmp[p][q]==tmp[p][q-1]&&tmp[p][q]!=0) {	
							tmp[p][q]=tmp[p][q]*2;
							for(int a=q-1;a>0;a--) {
								tmp[p][a]=tmp[p][a-1];
							}
							tmp[p][0]=0;
							q--;
						}
						else q--;
					}
				}
			}
			else if(order==3) {
				for(int p=0;p<n;p++) {		
					int [] tarr= new int[n];
					int index=0;
					for(int q=n-1;q>=0;q--) {
						if(tmp[q][p]!=0) {
							tarr[index]=tmp[q][p];
							index++;
						}
					}
					for(int q=0;q<index;q++) {
						int  g= tarr[q];
						tmp[n-q-1][p]=g;
					}
					if(n-index!=0) {
						for(int q=index;q<n;q++) tmp[n-q-1][p]=0;
					}
					for(int q=n-1;q>0;) {			
						if(tmp[q][p]==tmp[q-1][p]&&tmp[q][p]!=0) {	
							tmp[q][p]=tmp[q][p]*2;
							for(int a=q-1;a>0;a--) {
								tmp[a][p]=tmp[a-1][p];
							}
							tmp[0][p]=0;
							q--;
						}
						else q--;
					}
				}
			}
			else if(order==4) {
				for(int p=0;p<n;p++) {
					int [] tarr= new int[n];
					int index=0;
					for(int q=0;q<n;q++) {
						if(tmp[p][q]!=0) {
							tarr[index]=tmp[p][q];
							index++;
						}
					}
					for(int q=0;q<index;q++) {
						int  g=tarr[q];
						tmp[p][q]=g;
					}
					if(n-index!=0) {
						for(int q=index;q<n;q++) tmp[p][q]=0;
					}
					for(int q=0;q<n-1;) {				
						if(tmp[p][q]==tmp[p][q+1]&&tmp[p][q]!=0) {
							tmp[p][q]=tmp[p][q]*2;
							for(int a=q+1;a<n-1;a++) {
								tmp[p][a]=tmp[p][a+1];
							}
							tmp[p][n-1]=0;
							q++;
						}
						else q++;
		
					
					}
				}
			}
//					print(tmp);
		}
	}
	static void print(int a[][]) {
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void solve(int k) {
		if(k==5) {				//4개 골라짐
			int tmp[][] = new int [n][n];
			for(int i=0;i<tmp.length;i++) {
				System.arraycopy(map[i], 0, tmp[i], 0, tmp[i].length);
			}
			calc(tmp);
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dap = Math.max(tmp[i][j], dap);
				}
			}
			return;
		}
		for(int i=1;i<=4;i++) {
			arr[k]=i;
			solve(k+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		solve(0);
		System.out.println(dap);
	}
}