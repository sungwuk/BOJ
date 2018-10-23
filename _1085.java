import java.util.*;
public class _1085 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a= sc.nextInt(),b=sc.nextInt(),w=sc.nextInt(),h=sc.nextInt();
		int v1 = Math.abs(a-w),v2 = Math.abs(b-h),v3 = a,v4 = b;  
		LinkedList<Integer> li = new LinkedList<>();
		li.add(v1);li.add(v2);li.add(v3);li.add(v4);
		Collections.sort(li);
		System.out.println(li.get(0));
	}	
}	