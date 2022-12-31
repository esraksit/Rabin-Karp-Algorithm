import java.util.ArrayList;
import java.util.Scanner;

public class RabinKarp {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter text : ");
		String text=scan.next();
		System.out.println("Enter pattern : ");
		String pattern=scan.next();
		
		int textLength = text.length();
		int patternLength = pattern.length();
		int hashValue=0,textValue=0;	

		int p=patternLength;
		for(int i =0;i<patternLength;i++) {											//sýrayla tüm harflerin
			hashValue=hashValue+((int) pattern.charAt(i))*((int) Math.pow(10, p-1));// harfin ascýý code u * 10^(harfin sýrasýný belli eden konumu)
			p--;
		}	
			
		findPattern(patternLength,textLength,pattern,text,textValue,hashValue);			
		
	}
		
	public static int findPattern(int patternLength,int textLength,String pattern,String text,int textValue,int hashValue) {
		int y=textLength+1-patternLength;
		int count=0;
		
		for(int i =0;i<y;i++) {			
			textValue=0;
			int k=i;
			String controller="";
		int	p=patternLength;
		for(int j =0;j<patternLength;j++) {      //text de pattern boyutundaki yerlerin hash deðerini hesaplýyoruz ve karþýlaþtýrýyoruz.
			textValue= textValue+((int) text.charAt(k))*((int) Math.pow(10, p-1));
			char b=text.charAt(k);
			controller=controller+Character.toString(b); // daha sonra patternle kýyaslamak için string oluþturuyoruz.
			k++;
			p--;	
		}
			if(textValue==hashValue) {

				if(controller.equals(pattern)) {
					count++;
				}
				
			}
			}
		
		
		if(count==0) {
			System.out.println("not found");
		}
		else {
			System.out.println(" There are "+count+"  times ");
		}
		
		return textValue;
	}
	
}
//EVALUATION: The Rabin-Karp algorithm takes longer than the Brute Force algorithm both because it checks one by one and because it performs calculations.

