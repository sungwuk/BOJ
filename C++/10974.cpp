#include <stdio.h>
#include <algorithm>
#include <string>
#include <string.h>
#include <vector>
using namespace std;
void solve(vector<int>v, int start, int end) {
	if (start == end) {
		for (int a : v) {
			printf("%d ", a);
		}
		printf("\n");
	}
	for (int i = start; i < end; i++) {
		swap(v[i], v[start]);
		solve(v, start+1, end);
	}
}
int main() {
	vector<int> v;
	int n; scanf_s("%d", &n);

	for (int i = 1; i <= n; i++) {
		v.push_back(i);
	}
	solve(v, 0, n);
}