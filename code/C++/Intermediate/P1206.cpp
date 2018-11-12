#include <stdio.h>
 
int arr[1000];
 
int main(int argc, const char * argv[]) {
    int n;
    int result;
    int diff[4];
    int min = 0;
    for(int testCase=1;testCase<=10;testCase++){
        result = 0;
        scanf("%d", &n);
        for(int i=0;i<n;i++){
            scanf("%d", &arr[i]);
            if(i>=4){
                diff[0] = arr[i-2]-arr[i-4];
                diff[1] = arr[i-2]-arr[i-3];
                diff[2] = arr[i-2]-arr[i-1];
                diff[3] = arr[i-2]-arr[i];
                min = diff[0];
                for(int j=1;j<4;j++){
                    if(diff[j]<min) min = diff[j];
                }
                if(min<0){
                    min = 0;
                }
                result+=min;
            }
        }
        printf("#%d %d\n", testCase, result);
    }
    return 0;
}