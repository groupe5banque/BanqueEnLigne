package dto;

import java.util.Random;

public class NumeroDeCompte {
	 public NumeroDeCompte()
	    {
	    	
	    	
	    }
	 public String getNumeroDeCompte(){
		 String[] array = new String[]{"1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			Random rand = new Random();
			String NumeroCompte = null;
			 for (int i =1; i <12; i++)
			 {
				/* int a = (int)Math.floor(Math.random()*62);*/
				 
			
				if (i !=1)
				{
					NumeroCompte=NumeroCompte+array[rand.nextInt(array.length)];
				}
				else 
					NumeroCompte=array[rand.nextInt(array.length)];
				 
			 }
			 return NumeroCompte;
	 }
}
