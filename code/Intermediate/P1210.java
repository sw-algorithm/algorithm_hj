import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1210 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int result=0;
		String s =new String();
		StringTokenizer st = null;
		int[][] arr = new int[100][102];
		int k=0;
		int data = 0;
		int endPoint = 1;
//		int startNum = 0;
//		int[] startPoint = new int[100];
//		int o=0;
		
		for(int i=0; i<10; i++) {
			result = 0;
			endPoint = 1;
			int T = Integer.parseInt(bf.readLine());
			
//			//0행 
//			s = bf.readLine();
//			st = new StringTokenizer(s);
//			
//			k=0;
//			o=0;
//			
//			for(int p=0; p<100; p++) {
//				startPoint[p]=0;
//			}
//			
//			while(st.hasMoreTokens()) {
//				data = Integer.parseInt(st.nextToken());
//				arr[0][k] = data;
//				if(data==1) {
//					startNum+=1;
//					startPoint[o]=data;
//					o++;
//				}
//				k++;
//			}
			
			//initialization
			for(int r=0;r<100;r++) {
				for(int x=0;x<102;x++) {
					arr[r][x]=0;
				}
			}
//			
			for(int j=0;j<99;j++) {
				s = bf.readLine();
				st = new StringTokenizer(s);
//				
//				arr[j][0]=0;
//				arr[j][101]=0;
				
				k=1;
				while(st.hasMoreTokens()) {
					data = Integer.parseInt(st.nextToken());
					arr[j][k] = data;
					k++;
//					for(int q=0; q<startNum; q++) {
//						if(k==startPoint[q]-1 && data==1) {
//							startPoint[q]=
//						}
//					}
//					if(k==startPoint)
//					if(arr[j][startPoint-1]==1)
				}
			}
			
			//last line
			
			s = bf.readLine();
			st = new StringTokenizer(s);
//			
//			arr[99][0]=0;
//			arr[99][101]=0;
			k=1;
			while(st.hasMoreTokens()) {
				data = Integer.parseInt(st.nextToken());
				arr[99][k] = data;
				if(data==2) {
					endPoint = k;
				}
				k++;
			}
			
			///여기까지가 데이터 저장 
//			System.out.println("data store ok");
			
			for(int p=98; p>=0; p--) {
				if(arr[p][endPoint-1]==1) {
					for(int q=endPoint-2;q>=0;q--) {
						if(arr[p][q+1]==1&&arr[p][q]==0) {
							endPoint=q+1;
							break;
						}
					}
				}else if(arr[p][endPoint+1]==1) {
					for(int q=endPoint+2;q<=101;q++) {
						if(arr[p][q-1]==1&&arr[p][q]==0) {
							endPoint=q-1;
							break;
						}
					}
				}
//				else {
//					break;
//				}
			}
			result = endPoint-1;
			System.out.println("#"+T+" "+result);
		}
	}
}