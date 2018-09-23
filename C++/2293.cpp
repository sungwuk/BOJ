#include <algorithm>
#include <stdio.h>
#include <vector>
int main() {
	int n, k; scanf_s("%d %d", &n, &k);
	int arr[100];
	for (int i = 0; i < n; i++) {
		int a; scanf_s("%d", &a);
		arr[i] = a;
	}
	int dp[100001] = { 0, };
	dp[0] = 1;
	for (int i = 0; i < n; i++) {
		for (int j = arr[i]; j <= k; j++) {
			dp[j] += dp[j - arr[i]];
		}
	}
	printf("%d", dp[k]);
	system("pause");
}