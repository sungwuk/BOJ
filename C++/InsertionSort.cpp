#include <stdio.h>
#include <algorithm>


int main() {
	int arr[] = { 6,4,8,9,3,2,14,1,8 };
	int size = sizeof(arr) / sizeof(arr[0]);

	for (int i = 1; i < size; i++) {
		int tmp = arr[i];
		int j = i;
		while (j > 0 && arr[j-1] > tmp) {
			arr[j] = arr[j - 1];
			j--;
		}
		arr[j] = tmp;
	}
	for (auto a : arr)printf("%d ", a);
	system("pause");
}