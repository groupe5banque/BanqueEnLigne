package dto;

import java.util.Timer;
import java.util.TimerTask;

public class ajouterCaC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Bourse bourse = new Bourse();
 Timer minuteur = new Timer();
 TimerTask tacher = new TimerTask(){
	 @Override
		public void run() {
			// TODO Auto-generated method stub
			bourse.ActualisationBourse();
			
		}
		  
 };

minuteur.schedule(tacher, 0,60000);	
	
		
 
 
	}

}
