#include <algorithm>
#include <vector>
#include <stdio.h>
using namespace std;
int n, m, arr[8];
bool chk[8];
vector<int> v;
void solve(int k) {
	if (k == m) {
		for (int i = 0; i < m - 1; i++) {
			if (arr[i] > arr[i + 1]) return;
		}
		for (int i = 0; i < m; i++) printf("%d ", arr[i]);
		printf("\n");
		return;
	}
	for (int i = 0; i < n; i++) {
		arr[k] = i + 1;
		solve(k + 1);
	}
}
int main() {
	scanf_s("%d %d", &n, &m);
	solve(0);
	system("pause");
}