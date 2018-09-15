#include <stdio.h>
#include <functional>
#include <algorithm>
int map[20][20]; int n;
bool chk[20] = { 0 };
int result = INT32_MAX;
using namespace std;
void calc() {
	int a=0, b=0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (chk[i] && chk[j]) {
				a += map[i][j];
			}
			else if(!chk[i]&&!chk[j]){
				b += map[i][j];
			}
		}
	}
	result = __min(result, abs(a - b));
}
void solve(int ch, int dep) {
	if (n / 2 == ch) {
		calc();
	}
	else {
		for (int i = dep; i < n; i++) {
			chk[i] = true;
			solve(ch+1,i+1);
			chk[i] = false;
		}
	}
}
int main() {
	 scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf_s("%d", &map[i][j]);
		}
	}
	solve(0,0);
	printf("%d", result);
}