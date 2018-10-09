import java.util.*;
public class _3190 {
	static int map[][],dir,n,k,count=0,time=1,cx,cy,nx,ny;
	static boolean chk[][],flag =false;
	static LinkedList<Point> bam = new LinkedList<>();
	static class Point{
		int x,y,min;
		char ord;
		Point(int x,int y){
			this.y=y;this.x=x;
		}
		Point(int a, char b){
			this.min=a;this.ord=b;
		}
	}
	static void move(LinkedList<Point> list) {
		while(true) {
			if(dir==0) {
				cx = bam.peekLast().x;
				cy = bam.peekLast().y;
				nx = cx-1;
				if(nx<1) return;
				if(chk[nx][cy]) return;
				bam.add(new Point(nx,cy));
				if(map[nx][cy]==1) {
					chk[nx][cy]=true;
					map[nx][cy]=0;
				}
				else if(map[nx][cy]==0) {
					Point tmp=bam.pollFirst();
					chk[tmp.x][tmp.y]=false;
					chk[nx][cy]=true;
				}
			}
			if(dir==1) {
				cx= bam.peekLast().x;
				cy = bam.peekLast().y;
				ny = cy+1;
				if(ny>n) return;
				if(chk[cx][ny]) return;
				bam.add(new Point(cx,ny));			//뱀의 머리를 한칸 이동
				if(map[cx][ny]!=0) {
					chk[cx][ny]=true;
					map[cx][ny]=0;
				}
				else if(map[cx][ny]==0) {
					Point tmp=bam.pollFirst();
					chk[tmp.x][tmp.y]=false;				//뱀의 꼬리를 지운다
					chk[cx][ny]=true;
				}
			}
			if(dir==2) {
				cx = bam.peekLast().x;
				cy = bam.peekLast().y;
				nx = cx+1;
				if(nx>n) return;
				if(chk[nx][cy]) return;
				bam.add(new Point(nx,cy));
				if(map[nx][cy]!=0) {				//사과가 있다면
					chk[nx][cy]=true;
					map[nx][cy]=0;
				}
				else if(map[nx][cy]==0) {
					Point tmp=bam.pollFirst();
					chk[tmp.x][tmp.y]=false;
					chk[nx][cy]=true;
				}
			}
			if(dir==3) {
				cx= bam.peekLast().x;
				cy = bam.peekLast().y;
				ny = cy-1;
				if(ny<1) return;
				if(chk[cx][ny]) return;
				bam.add(new Point(cx,ny));
				if(map[cx][ny]!=0) {
					chk[cx][ny]=true;
					map[cx][ny]=0;
				}
				else if(map[cx][ny]==0) {
					Point tmp = bam.pollFirst();
					chk[tmp.x][tmp.y]=false;				//뱀의 꼬리를 지운다
					chk[cx][ny]=true;
				}
			}
			if(!list.isEmpty()) {
				if(time==list.peek().min) {
					if(list.peekFirst().ord=='D') dir = (dir+1)%4;
					if(list.peekFirst().ord=='L') dir = (dir+3)%4;
					list.pollFirst();
				}
			}
			time++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();k=sc.nextInt();
		map = new int[n+1][n+1];
		chk = new boolean[n+1][n+1];
		for(int i=0;i<k;i++) {
			int a=sc.nextInt(),b=sc.nextInt();
			map[a][b]=1;
		}
		int l = sc.nextInt();
		bam.add(new Point(1,1));
		chk[1][1]=true;
		dir=1;
		LinkedList<Point> list = new LinkedList<>();
		for(int i=0;i<l;i++) {
			int min = sc.nextInt();
			char order = sc.next().charAt(0);
			list.add(new Point(min,order));
		}
		move(list);
		System.out.println(time);
	}
}