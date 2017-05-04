package dto;

import org.apache.commons.validator.routines.IBANValidator;

public class TestIban {

	IBANValidator ibval = new IBANValidator();
	
	public boolean test (String iban){
		
		
		if (ibval.isValid(iban)){
		//	System.out.println("Iban valide");
			return true;
		}
		
		else
			//System.out.println("Iban invalide");
		return false;
	}
		
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String iban="FR7630003017850005002185768";
		TestIban test= new TestIban();
		
		
  if(test.test(iban)) {
	  System.out.println("Iban valide"); 
  }
  else
		System.out.println("Iban invalide");	

}*/
}