//Evan White
    import java.util.Scanner;
    import java.io.*;
	import java.util.ArrayList;
    public class CDTesterEW {

	public static void main(String[] args) throws IOException{
		
		Scanner input = new Scanner(new File("CDList.txt"));
		
		String title = " ";
		String artist = " ";
		double price = 0.0;
		int numTracks = 0;
		double accum = 0.0;
		
		 String line = input.nextLine();
		 line = input.nextLine();
		 
         ArrayList <CDEW> cdList = new ArrayList <CDEW> ();
         
         while(input.hasNext())
         {
        	 line = input.nextLine();
        	 
        	 String[] s = line.split(",");
        	 title = s[0];
        	 artist = s[1];
        	 price = Double.parseDouble(s[2]);
        	 numTracks = Integer.parseInt(s[3]);
        	 
        	 cdList.add(new CDEW(title, artist, price, numTracks));
         }
         
         CDEW.bubbleSort(cdList);
         
         for(int w = 0; w < cdList.size(); w++)
         {
             if(cdList.get(w).getTitle().equals("By the Way"))
             {
		     cdList.remove(w);
             }
         }
         
         for(int k = 0; k < cdList.size(); k++)
         {
        	 if((cdList.get(k)).getTitle().equals("Double Live"))
        	 {
        		 cdList.get(k).setPrice(24.99);
        	 } 
         } 
        	
         for(int t = 0; t < cdList.size(); t++)
         {	 
           System.out.println(cdList.get(t).toString());
           accum += cdList.get(t).getPrice();
         }
        	 
        System.out.println("Accumulator total: " + String.format("%.2f" , accum));	 
        System.out.println("Total Size: " + cdList.size());
	}
	
}
/*
  Come on Over    Shania Twain            14.95  16
Soundtrack      The Producers           17.95  33
Greatest Hits   Stone Temple Pilots     15.95  13
Double Live     Garth Brooks            24.99  26
Accumulator total: 73.83999999999999
Total Size: 4  
*/