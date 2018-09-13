#include <stdio.h>
#include <string.h>
#include <string>
#include <vector>
#include <algorithm>
#include <functional>
using namespace std;
vector<int> num, op;
int an1 = INT32_MAX;
int an2 = INT32_MIN;

void solve(int c, int nu) {
	if (c == num.size()) {
		if (nu > an2) an2 = nu;
		if (nu < an1) an1 = nu;
	}
	for (int i = 0; i < 4; i++) {
		if (op[i] != 0) {
			op[i]--;
			if (i == 0) {
				solve(c + 1, nu + num[c]);
				op[i]++;
			}
			else if (i == 1) {
				solve(c + 1, nu - num[c]);
				op[i]++;
			}
			else if (i == 2) {
				solve(c + 1, nu * num[c]);
				op[i]++;
			}
			else {
				solve(c + 1, nu / num[c]);
				op[i]++;
			}
		}
	}
}
int main() {
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int in; scanf_s("%d", &in);
		num.push_back(in);
	}
	for (int i = 0; i < 4; i++) {
		int in; scanf_s("%d", &in);
		op.push_back(in);
	}
	solve(1, num.front());
	printf("%d\n%d", an2, an1);
	return 0;
}