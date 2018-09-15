#include <stdio.h>
#include <algorithm>
int main() {
	int a, b;
	while (scanf_s("%d %d", &a, &b) == 2) {
		printf("%d\n", a + b);
	}
}