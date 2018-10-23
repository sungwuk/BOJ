import java.util.*;
public class _1181 {
	static Comparator<String> wordSort = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			if(o1.length() == o2.length()) {
				return o1.compareTo(o2);
			} else {
				return o1.length() - o2.length();
			}
		}
	};
	public static void main(String[] args)  {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String>arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String s=sc.next();
			arr.add(s);
		}
		Collections.sort(arr,wordSort);
		LinkedList<String>tmp = new LinkedList<>();
		for(String s : arr) {
			if(!tmp.contains(s)) tmp.add(s);
		}
		for(String s : tmp)System.out.println(s);
	}

	
}
