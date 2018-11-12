import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int l = 0;
		String s = new String();
		StringTokenizer st = null;
		int result = 0;
		int min=0;
		int[] d = new int[4];
		int temp = 0;
		
		for(int i=0;i<10;i++) {
			result = 0;
			l = Integer.parseInt(bf.readLine());
			int[] nums = new int[l];
			s = bf.readLine();
			st = new StringTokenizer(s);
			
			//initialization
			for(int k=0;k<l;k++) {
				nums[k]=0;
			}
			
			//store value
			int j=0;
			while(st.hasMoreTokens()) {
				temp =  Integer.parseInt(st.nextToken());
				nums[j]=temp;
				j++;
//				System.out.println(temp);
			}
			
			for(int p=2;p<l-2;p++) {
				d[0]=nums[p]-nums[p-1];
				d[1]=nums[p]-nums[p-2];
				d[2]=nums[p]-nums[p+1];
				d[3]=nums[p]-nums[p+2];
				if(d[0]>0&&d[1]>0&&d[2]>0&&d[3]>0) {
					min = d[0];
					for(int q=0;q<4;q++) {
						if(d[q]<min) min=d[q];
					}
					result+=min;
//					System.out.println(result);
				}
			}
			System.out.println("#"+(i+1)+" "+result);
			
		}
		
	}
}
