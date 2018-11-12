#include <stdio.h>
 
int main(int argc, const char * argv[]) {
    int dumpCount;
    int result;
    int max, min;
    int temp;
    int c;
    int height[101];
     
    for(int testCase=1;testCase<=10;testCase++){
        max = -1;
        min = 101;
        result = 0;
        scanf("%d", &dumpCount);
        for(int i=0;i<101;i++){
            height[i] = 0;
        }
        for (int i=0; i<100; i++) {
            scanf("%d", &temp);
            height[temp]++;
            if(max<temp) max = temp;
            if(min>temp) min = temp;
        }
         
        while(dumpCount>0){
            if(max==min){
                result = 0;
                break;
            }
            else if(max-min==1){
                result = 1;
                break;
            }
             
            dumpCount--;
            height[max]--;
            height[min]--;
            height[max-1]++;
            height[min+1]++;
             
            if(height[max]<=0){
                c = max;
                while (true) {
                    c--;
                    if(height[c]!=0){
                        max = c;
                        break;
                    }
                }
            }
             
            if(height[min]<=0){
                c = min;
                while (true) {
                    c++;
                    if(height[c]!=0){
                        min = c;
                        break;
                    }
                }
            }
        }
        result = max - min;
        printf("#%d %d\n", testCase, result);
    }
    return 0;
}