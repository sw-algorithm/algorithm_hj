import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1209 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int result=0;
		String s =new String();
		StringTokenizer st = null;
		int[][] arr = new int[101][101];
		int k = 0;
		int max = 0;
		int[] temp_r = new int[4];
		int data = 0;
		
		for(int i=0; i<10; i++) {
			max = 0;
			result = 0;
			int T = Integer.parseInt(bf.readLine());
			for(int j=0;j<100;j++) {
				s = bf.readLine();
				st = new StringTokenizer(s);
				
				k=0;
				while(st.hasMoreTokens()) {
					data = Integer.parseInt(st.nextToken());
					arr[j][k] = data;
					k++;
//					System.out.println("test");
				}
			}
			
//			System.out.println("store ok");
			
			for(int l=2; l<4; l++) {
				temp_r[l]=0;
			}
			
			for(int m=0; m<100; m++) {
				
				for(int l=0; l<2; l++) {
					temp_r[l]=0;
				}
				
				for(int n=0; n<100; n++) {
					temp_r[0] += arr[m][n];
					temp_r[1] += arr[n][m];
					if (temp_r[0] >= temp_r[1] && temp_r[0] >= max) {
			            max = temp_r[0];
			        } else if (temp_r[1] >= temp_r[0] && temp_r[1] >= max) {
			            max = temp_r[1];
			        }
				}
				
				temp_r[2] += arr[m][m];
				temp_r[3] += arr[m][99-m];
			}
			
			if (temp_r[2] >= temp_r[3] && temp_r[2] >= max) {
	            max = temp_r[2];
	        } else if (temp_r[3] >= temp_r[2] && temp_r[3] >= max) {
	            max = temp_r[3];
	        } 
			
			result = max;

			System.out.println("#"+T+" "+result);
		}
		
		
	}
}
