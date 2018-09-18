#include <algorithm>
using namespace std;
int n, m, arr[8];
bool chk[8];
void solve(int k) {
	if (k == m) {
		for (int i = 0; i < m; i++)printf("%d ", arr[i]);
		printf("\n");
		return;
	}
	for (int i = 0; i < n; i++) {
		if (!chk[i]) {
			chk[i] = true;
			arr[k] = i+1;
			solve(k + 1);
			chk[i] = false;
		}
	}
}
int main() {
	scanf_s("%d %d", &n, &m);
	solve(0);
	system("pause");
}