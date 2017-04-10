package dto;

public class Code {
	private String codeGuichet;

	private String clefRib;
	private String pays; 
	public Code()
	{
		this.codeGuichet = null;
		this.pays = null;
		this.clefRib = null; 
		
	}
	 public Code (String pays, String codeGuichet, String clefRib)
	 {
		 this.pays=pays;
		 this.codeGuichet = codeGuichet;
		 this.clefRib = clefRib;
		 
	 }
	 
		public String getCodeGuichet() {
			return codeGuichet;
		}
		public void setCodeGuichet(String codeGuichet) {
			this.codeGuichet = codeGuichet;
		}
		public String getClefRib() {
			return clefRib;
		}
		public void setClefRib(String clefRib) {
			this.clefRib = clefRib;
		}
		public String getPays() {
			return pays;
		}
		public void setPays(String pays) {
			this.pays = pays;
		}
}
