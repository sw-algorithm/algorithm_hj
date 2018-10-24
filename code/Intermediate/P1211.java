import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1211 {
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		int temp;
		int[] col;
		int[] ans;
		int cnt;
		StringTokenizer stringTokenizer;
		
		for(int testCase=1;testCase<=T;testCase++) {
			cnt = 0;
			col = new int[100];
			map = new int[100][100];
			temp = Integer.parseInt(bufferedReader.readLine());
			for(int i=0;i<100;i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for(int j=0;j<100;j++) {
					map[i][j]=Integer.parseInt(stringTokenizer.nextToken());
				}
			}
			int k=0;
			for(int i=0;i<100;i++) {
				if(map[0][i]==1) {
					col[k]=i;
					cnt++;
					k++;
				}
			}
			
			ans = new int[cnt];
			for(int i=0;i<cnt;i++) {
				ans[i]=0;
			}
			
			for(int i=0;i<cnt;i++) {
				int cc = i;
				for(int j=0;j<100;j++) {
					int nx1 = col[cc]+1;
					int nx2 = col[cc]-1;
					if(nx1<100&&map[j][nx1]==1) {
						ans[i]+=col[cc+1]-col[cc];
						cc = cc+1;
					}else if(nx2>=0&&map[j][nx2]==1) {
						ans[i]+=col[cc]-col[cc-1];
						cc = cc-1;
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			int index = -1;
			for(int i=0;i<cnt;i++) {
//				System.out.println(ans[i]);
				if(ans[i]<=min) {
					min = ans[i];
					index = col[i];
				}
			}
			
			System.out.println("#"+testCase+" "+index);
		}
	}
}
