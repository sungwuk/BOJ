import java.util.*;
public class _1316 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt(),count=0;
		for(int i=0;i<n;i++) {
			String in = sc.next();
			LinkedList<Character> list = new LinkedList<>();
			boolean arr[] = new boolean[26];
			for(int j=0;j<in.length();j++) list.add(in.charAt(j));
			boolean flag =true;
			while(!list.isEmpty()) {
				char a = list.pollFirst();
				if(arr[a-97]) {
					flag=false;
					break;
				}
				if(list.isEmpty())break;
				for(;!list.isEmpty()&&a==list.peekFirst();) {
					list.pollFirst();
				}
				arr[a-97]=true;
			}
			if(flag) count++;
		}
		System.out.println(count);
	}

}
