import java.io.*;
import java.util.*;
public class _13752 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			int a = sc.nextInt();
			for(int j=0;j<a;j++) {
				System.out.print("=");
			}
			System.out.println();
		}
	}
}
