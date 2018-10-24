import java.util.*;
public class _1977 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int m =sc.nextInt(),n=sc.nextInt();
		LinkedList<Integer> list = new  LinkedList<>();
		for(int i=1;i<n;i++) {
			if(i*i>=m&&i*i<=n) {
				list.add(i*i);
			}
		}
		if(list.size()==0) {
			System.out.println(-1);
			return;
		}
		int sum=0;
		Collections.sort(list);
		for(int i : list)sum+=i;
		System.out.println(sum);
		System.out.println(list.get(0));
	}

}
