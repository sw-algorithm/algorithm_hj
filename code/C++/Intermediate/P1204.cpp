#include <stdio.h>

int main(){
	int n, a, b;
	int max=0, ans;
	int arr[101];
	scanf("%d", &n);
	for(int j=1;j<=n;j++){
        ans = 0;
        max = 0;
		scanf("%d", &b);
		for(int i=0;i<101;i++){
			arr[i]=0;
		}
		for(int i=0;i<1000;i++){
			scanf("%d", &a);
			arr[a]++;
		}
		for(int i=0;i<101;i++){
			if(max<=arr[i]){
				max = arr[i];
				ans = i;
			}
		}
		printf("#%d %d\n", b, ans);
	}
	return 0;
}

