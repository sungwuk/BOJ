#include <stdio.h>
#include <algorithm>
#include <vector>
#include <cstdlib>
using namespace std;
vector<int> v;
int main() {
	int n; scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int a; scanf_s("%d", &a);
		v.push_back(a);
	}

		sort(v.begin(), v.end());

		int dap = 0;
		do {
			int sum = 0;
			for (int i = 0; i < n - 1; i++) {
				sum += abs(v[i] - v[i + 1]);
			}
			dap = (dap > sum) ? dap : sum;
		} while (next_permutation(v.begin(), v.end()));
		printf("%d", dap);
		system("pause");
}