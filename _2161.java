import java.util.*;
public class _2161 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> tmp = new LinkedList<>();
		for(int i=1;i<=n;i++) q.add(i);
		while(q.size()!=1) {
			tmp.add(q.poll());
			q.add(q.poll());
		}
		for(int a : tmp) System.out.print(a+" ");
		System.out.println(q.poll());
	}
}