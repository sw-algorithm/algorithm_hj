import java.util.Scanner;

public class P1240 {
	public static void main(String[] args) {
		int row, col;
		int result;
		int x,y;
		int stop;
		int check;
		
		
		Scanner scn = new Scanner(System.in);
		
		int T = scn.nextInt();
		
		
		for(int testCase=1;testCase<=T;testCase++) {
			result = 0;
			stop=0;
			check=0;
			row = scn.nextInt();
			col = scn.nextInt();
			
			String code = "";
			int[] code2 = new int[8];
            for (y = 0; y < row; y++) {
                String temp = scn.next();
                if (!isZeroRow(temp)) {
                    code = temp;
                }
            }
            
            for(x=code.length()-1;x>=0;x--) {
            	if(code.charAt(x)=='1') {
            		stop = x;
            		break;
            	}
            }
            
            for(x=0;x<8;x++) {
            	code2[x]=decode(code.substring(stop-55+x*7, stop-55+x*7+7));
            	if(x==0||x==2||x==4||x==6)
            		check+=code2[x]*3;
            	else
            		check+=code2[x];
            }
            
            if(check%10==0) {
            	for(x=0;x<8;x++)
            		result+=code2[x];
            }else {
            	result = 0;
            }
            
			System.out.println("#"+testCase+" "+result);
		}
	}

	private static boolean isZeroRow(String temp) {
		// TODO Auto-generated method stub
		return temp.indexOf("1") < 0;
	}
	
	public static int decode(String s){
        switch (s){
            case "0001101":
                return 0;
            case "0011001":
                return 1;
            case "0010011":
                return 2;
            case "0111101":
                return 3;
            case "0100011":
                return 4;
            case "0110001":
                return 5;
            case "0101111":
                return 6;
            case "0111011":
                return 7;
            case "0110111":
                return 8;
            case "0001011":
                return 9;
        }
        return -1;
    }
}
