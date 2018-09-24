import java.util.*;
public class _14890 {
	static int N,L,count=0,map[][];
	static boolean[][] chk;
	static boolean slope(int x,int y,int cha,int next,int cur) {
		if(cha<0) {
			int start= y-L+1;
			if(start<0) {
				return false;
			}
			else {
				for(int i=start;i<=y;i++) {
					if(map[x][i]!=cur||chk[x][i]) return false;
				}
				for(int i=start;i<=y;i++) {
					if(map[x][i]==cur) chk[x][i]=true;
				}
			}
			return true;
		}
		else {
			int end = y+L;
			if(end<N) {
				for(int i=y+1;i<=end;i++) {
					if(map[x][i]!=next||chk[x][i]) return false;
				}
				for(int i=y+1;i<=end;i++) {
					if(map[x][i]==next) chk[x][i]=true;
				}
			}
			if(end>=N) return false;
			return true;
		}
	}
	static boolean slope1(int x,int y,int cha,int next,int cur) {
		if(cha<0) {
			int start= x-L+1;
			if(start<0) {
				return false;
			}
			else {
				for(int i=start;i<=x;i++) {
					if(map[i][y]!=cur||chk[i][y]) return false;
				}
				for(int i=start;i<=x;i++) {
					if(map[i][y]==cur) chk[i][y]=true;
				}
			}
			return true;
		}
		else {
			int end = x+L;
			if(end<N) {
				for(int i=x+1;i<=end;i++) {
					if(map[i][y]!=next||chk[i][y]) return false;
				}
				for(int i=x+1;i<=end;i++) {
					if(map[i][y]==next) chk[i][y]=true;
				}
			}
			if(end>=N) return false;
			return true;
		}
	}
	static void solve(int i) {
		chk= new boolean[N][N];
		boolean flag_row=true,flag_column=true;
		for(int j=0;j<N-1;) {				//한 행씩 보는부분( 가로줄)
			int ch = map[i][j];int nh = map[i][j+1];
			int cha =ch-nh;		//현재와 다음 칸의 높이차이 
			if(cha==0) j++;
			else if(cha==1||cha==-1) {
				if(cha==1) {
					if(slope(i,j,cha,nh,ch)) j+=L;		//경사로 상황보기
					else {
						flag_row = false;
						break;
					}
				}
				else if(cha==-1) {
					if(slope(i,j,cha,nh,ch)) j++;
					else { 
						flag_row=false;
						break;
					}
				}
			}
			else if(Math.abs(cha)>1) {
				flag_row=false;
				break; 
			}
		}
		if(flag_row) count++;
		chk= new boolean[N][N];
		for(int j=0;j<N-1;) {				//한 행씩 보는부분( 가로줄)
			int ch = map[j][i];int nh = map[j+1][i];
			int cha =ch-nh;		//현재와 다음 칸의 높이차이 
			if(cha==0) 	j++;
			
			else if(cha==1||cha==-1) {
				if(cha==1) {
					if(slope1(j,i,cha,nh,ch)) j+=L;		//경사로 상황보기
					else {
						flag_column = false;
						break;
					}
				}
				else if(cha==-1) {
					if(slope1(j,i,cha,nh,ch)) j++;
					else { 
						flag_column=false;
						break;
					}
				}
			}
			else if(Math.abs(cha)>1) {
				flag_column=false;
				break; 
			}
		}
		if(flag_column) count++;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();L=sc.nextInt();map= new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) solve(i);
		System.out.println(count);
	}
}