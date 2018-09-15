#include <stdio.h>
#include <algorithm>
int main() {
	int test; scanf_s("%d", &test);
	while (test--) {
		int n, m;
		scanf_s("%d %d", &n, &m);
		for (int i = 0; i < m; i++) {
			int a, b;
			scanf_s("%d %d", &a, &b);
		}
		printf("%d\n", n - 1);
	}
}