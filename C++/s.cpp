#include <vector>
#include <algorithm>
using namespace std;
vector<int> v;
int count1 = 0;
bool chk[1000] = { 0, };
int calc() {
	int sum = 0;
	for (int i = 0; i<v.size(); i++) {
		if (chk[i]==1) {
			sum += v[i];
		}
	}
	for (int i = 0; i < v.size(); i++) {
		if (chk[i])
			printf("%d", 1);
		else printf("%d", 0);
		}
	printf("\n");
	return sum;
}
void solution(int d,int m) {
	if (d == v.size()) {
		int b = calc();
		if (b == m) {
			count1++;
			return;
		}
	}
	else{
			chk[d] = 1;
			solution (d + 1,m);
			chk[d] = 0;
			solution (d + 1, m);
		}
}
int main() {
	v.push_back(1000);
	v.push_back(500);
	solution(0,1000);
	printf("%d", count1);
	return 0;
}