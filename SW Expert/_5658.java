package samsung;
import java.util.*;
public class _5658 {
	static LinkedList<String> list;
	static int k;
	static boolean check(String test) {
		int size = test.length()/4;
		int count=0;
		for(int i=0;i<4;i++) {					
			int index = i*size;
			String tmp = test.substring(index,index+size);
			if(list.contains(tmp)) count++;
		}
		if(count==4) return true;
		return false;
	}
	static void solve(String in,int c) {
		int size = in.length()/4;
		while(!check(in)){ 
			for(int i=0;i<4;i++) {					
				int index = i*size;
				String tmp = in.substring(index,index+size);
				if(!list.contains(tmp))list.add(tmp);
			}
			
			char[] arr = in.toCharArray();
			char tmp = arr[arr.length-1];
			System.arraycopy(arr, 0, arr, 1, arr.length-1);
			arr[0]=tmp;
			in = new String(arr);
		}
		LinkedList<Long> list1 =new LinkedList<>();
		for(String s : list) {
			list1.add(Long.parseLong(s,16));
		}
		Object[] tmp = list.toArray();
		Arrays.sort(tmp);
		System.out.println("#"+c+" "+Long.parseLong((String) tmp[list1.size()-k],16));
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int n=sc.nextInt();k=sc.nextInt();
			String input=sc.next();
			list = new LinkedList<>();
			solve(input,i+1);
		}
	}

}
