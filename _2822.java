import java.util.*;
public class _2822 {
	static class Problem implements Comparable<Problem>{
		int num;
		Integer score;
		Problem(int n,int s){
			num=n;score=s;
		}
		public int getscore() {
			return this.score;
		}
		@Override
		public int compareTo(Problem o) {

			return o.score.compareTo(score);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Problem> list = new ArrayList<Problem>();
		int[] a=new int[5];
		for(int i=1;i<=8;i++) {
			int s=sc.nextInt();
			list.add(new Problem(i,s));
		}
		Collections.sort(list);
		int sum=0;
		for(int i=0;i<5;i++) {
			sum+=list.get(i).score;
			a[i]=list.get(i).num;
		}
		Arrays.sort(a);
		System.out.println(sum);
		for(int i=0;i<5;i++) {
			System.out.print(a[i]);
		}
	}
}

