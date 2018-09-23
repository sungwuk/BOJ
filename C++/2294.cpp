#include<algorithm>
#include<stdio.h>

using namespace std;
int main() {
	int n, k; scanf_s("%d %d", &n, &k);
	int arr[101] = { 0, };
	int dp[100001];
	for (int i = 0; i <= k; i++) dp[i] = 0x3fffffff;
	for (int i = 0; i < n; i++) {
		scanf_s("%d", &arr[i]);
	}
	dp[0] = 0;
	for (int i = 0; i < n; i++) {
		for (int j = arr[i]; j <= k; j++) {
			dp[j] = min(dp[j], dp[j - arr[i]]+1);
		}
	}
	if (dp[k] == 0x3fffffff) dp[k] = -1;
	printf("%d", dp[k]);
	system("pause");

}