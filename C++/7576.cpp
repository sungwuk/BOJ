#include <stdio.h>
#include <queue>
using namespace std;
#define	PI pair<int,int>
int map[1001][1001];
int main() {
	int m, n; scanf_s("%d %d", &m, &n);
	queue<PI> q;
	for (int i = 0; i < n; i++) 
		for (int j = 0; j < m; j++) {
			int a;
			scanf_s("%d", &a);
			map[i][j]=a;
			if (map[i][j] == 1) q.push({ i,j });
		}
	int dx[] = { 1,-1,0,0 };
	int dy[] = { 0,0,1,-1 };
	int count = -1;
	while (!q.empty()) {
		int ss = q.size();
		for (int i = 0; i < ss; i++) {
			int cx = q.front().first;
			int cy = q.front().second; q.pop();
			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k];
				int ny = cy + dy[k];
				if (nx < 0 || ny < 0 || nx >= n || ny>= m)continue;
				if (map[nx][ny] == 0) {
					map[nx][ny] = 1;
					q.push({nx,ny});
				}
			}
		}
			count++;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) count = -1;
		}
	}
	printf("%d", count);
}