package samsung;
import java.util.*;
public class _4014 {
	static int map[][],n,x,dap=0;
	static boolean chk [][];
	static void solve2(int s) {
		int i;
		for(i=0;i<n-1;) {				//0 ~N 행 -> 가로
			int cha = map[i][s]-map[i+1][s];
			if(cha==1) {
				int idx = i+1;
				int count=0;
				while(true) {
					if(idx>=n) return;
					if(chk[idx][s])return;
					if(map[i][s]-map[idx][s]==1) {
						count++;
						chk[idx][s]=true;
					}
					if(map[i][s]-map[idx][s]!=1) break;
					if(count==x) break;				//경사로를 놓을 수 있는 경우
					idx++;
				}
				if(count==x)i=idx;
				else if(count!=x) break;
				continue;
			}
			else if(cha==-1) {
				int idx = i;
				int count=0;
				while(true) {
					if(idx<0) return;
					if(chk[idx][s])return;
					if(map[idx][s]-map[i+1][s]==-1) {
						count++;
						chk[idx][s]=true;
					}
					if(map[idx][s]-map[i+1][s]!=-1) break;
					if(count==x) break;
					idx--;
				}
				if(count==x) i++;
				else if(count!=x) break;
				continue;
			}
			else if(cha!=0) break;				//높이 차이가 1,-1,0,이 아니면 그 길은 끝
			i++;
		}
		if(i==n-1) dap++;

	}
	static void solve1(int s) {
		int i;
		for(i=0;i<n-1;) {				//0 ~N 행 -> 가로
			int cha = map[s][i]-map[s][i+1];
			if(cha==1) {
				int idx = i+1;
				int count=0;
				while(true) {
					if(idx>=n) return;
					if(chk[s][idx])return;
					if(map[s][i]-map[s][idx]==1) {
						count++;
						chk[s][idx]=true;
					}
					if(map[s][i]-map[s][idx]!=1) break;
					if(count==x) break;				//경사로를 놓을 수 있는 경우
					idx++;
				}
				if(count==x)i=idx;
				else if(count!=x) break;
				continue;
			}
			else if(cha==-1) {
				int idx = i;
				int count=0;
				while(true) {
					if(idx<0) return;
					if(chk[s][idx])return;
					if(map[s][idx]-map[s][i+1]==-1) {
						count++;
						chk[s][idx]=true;
					}
					if(map[s][idx]-map[s][i+1]!=-1) break;
					if(count==x) break;
					idx--;
				}
				if(count==x) i++;
				else if(count!=x) break;
				continue;
			}
			else if(cha!=0) break;				//높이 차이가 1,-1,0,이 아니면 그 길은 끝
			i++;
		}
		if(i==n-1) dap++;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int p=1;p<=t;p++) {
			n = sc.nextInt();x=sc.nextInt();
			map = new int[n][n];
			
			dap=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			chk= new boolean[n][n];
			for(int i=0;i<n;i++) {
				solve1(i);
			
			}
			chk= new boolean[n][n];
			for(int i=0;i<n;i++) {
				solve2(i);
			}
			System.out.println("#"+p+" "+dap);
		}
	}
}