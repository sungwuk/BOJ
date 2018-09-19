#include <algorithm>
#include <vector>
#include <stdio.h>
using namespace std;
int n, m, arr[8];
bool chk[8];
vector<int> v, tmp;
void solve(int k) {
	if (k == m) {
		for (int i = 0; i < m; i++) printf("%d ", arr[i]);
		printf("\n");
		return;
	}
	for (int i = 0; i < n; i++) {
		if (!chk[i]) {
			chk[i] = true;
			arr[k] = tmp[i];
			solve(k + 1);
			chk[i] = false;
		}
	}
}
int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		int a; scanf("%d", &a);
		tmp.push_back(a);
	}
	sort(tmp.begin(), tmp.end());
	solve(0);
}