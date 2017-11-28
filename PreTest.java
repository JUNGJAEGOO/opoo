
import java.io.*;

public class PreTest {
	public static void main(String args[])  {
		
		int input = Integer.parseInt(args[0]);
		int zari = 10000;
		String result = "";
		while( zari > 0 ) {
			int casing = input/zari;
			
			if ( (casing) != 0 ) {
				switch ( casing ) {
					case 1: result+="¿œ"; break;
					case 2: result+="¿Ã"; break;
					case 3: result+="ªÔ"; break;
					case 4: result+="ªÁ"; break;
					case 5: result+="ø¿"; break;
					case 6: result+="¿∞"; break;
					case 7: result+="ƒ•"; break;
					case 8: result+="∆»"; break;
					case 9: result+="±∏"; break;
				}
				
				if ( zari != 1 && result.equals("¿œ")) {
					result="";
				}
				
				switch ( zari ) {
					case 10000:result+="∏∏"; break;
					case 1000:result+="√µ"; break;
					case 100:result+="πÈ"; break;
					case 10:result+="Ω "; break;
				}
				
					input %= zari;
			}
				
			zari /= 10;
			
			
		}
		
		System.out.print(result);
		
	}
}
