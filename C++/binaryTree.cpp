//#include <stdio.h>
//#include <stdlib.h>
//#include <functional>
//#include <algorithm>
//#include <queue>
//using namespace std;
//struct tree {
//	int value;
//	struct tree* left;
//	struct tree* right;
//};
//typedef struct tree Tree;
//Tree* root;
//void InsertNode(Tree* curr,int i) {
//	if (root == NULL) {
//		root = new Tree({ 3,NULL,NULL });
//	}
//	else {
//		if (curr->value > i) {
//			if (curr->left == NULL)
//				curr->left = new Tree({ i,NULL,NULL });
//			else InsertNode(curr->left, i);
//		}
//		else {
//			if (curr->right == NULL)
//				curr->right = new Tree({i,NULL,NULL});
//			else InsertNode(curr->right, i);
//		}
//	}
//}
//int main() {
//	InsertNode(root, 3);
//	InsertNode(root, 2);
//	InsertNode(root, 4);
//	InsertNode(root, 5);
//	system("pause");
//}