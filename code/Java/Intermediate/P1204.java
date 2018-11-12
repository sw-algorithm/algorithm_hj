import java.util.*;
 
public class P1204 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int[][] arr = new int[t][1000];
        int start = 0; 
        int end = 0;
        int testCase = 0;
        int count = 0;
        int maxTimes = 0;
        int maxValue = 0;
        
        while(count < t) {
            count = s.nextInt();
            for(int i = 0; i < 1000; i++) {
                arr[count-1][i] = s.nextInt();
            }
            Arrays.sort(arr[count -1]);
        }
        maxValue = arr[0][0];
        for(int i = 0; i < t; i++) {
            for(int j = 0; j < 999; j++) {
 
                    if(arr[i][j] == arr[i][j+1]) {
                        end += 1;
                    }
                    else {
                         
                        if(maxTimes <= end - start + 1) {
                            maxTimes = end - start + 1;
                            maxValue = arr[i][start];
                        }
                        start = j + 1;
                        end = start;
     
                    }
 
                 
            }
            System.out.println("#" + (i+1) + " " + maxValue);
            start = 0;
            end = 0;
            maxTimes = 0;
             
        }
    } 
 
}