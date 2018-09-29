#include <stdio.h>
#include <vector>
#include <deque>
#include <algorithm>
#include<functional>
#include<queue>
using namespace std;
deque<int> deq;
int dap,n,m;
void solve(int a) {
	if (deq[0]== a) {
		deq.pop_front();
		dap = 0;
		return;
	}
	else {
		deque<int> v;
		v.assign(deq.begin(), deq.end());
		int count1 = 0, count2 = 0;
		while (true) {			//2번규칙만 사용한경우
			if (v[0] == a) break;
			else {
				v.push_back(v[0]);
				v.pop_front();
				count1++;
			}
		}
		v.assign(deq.begin(), deq.end());
		while (true) {			//3번 규칙만 사용한경우
			if (v[0] == a) break;
			else {
				v.push_front(v[v.size()-1]);
				v.pop_back();
				count2++;
			}
		}
		deq.assign(v.begin(),v.end());deq.pop_front();
		dap = min(count1, count2);
	}
 }
int main() {
	 scanf_s("%d %d", &n, &m);
	for (int i = 0; i < n; i++) deq.push_back(i);
	int sum = 0;
	for (int i = 0; i < m; i++) {
		int a; scanf_s("%d", &a);
		solve(a-1);
		sum += dap;
	}
	printf("%d", sum);
}