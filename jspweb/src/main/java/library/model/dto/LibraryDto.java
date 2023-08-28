package library.model.dto;

public class LibraryDto {

	private int lno;
    private String lphone;     
    private String lname;
    
    public LibraryDto() {
		// TODO Auto-generated constructor stub
	}

	public LibraryDto(int lno,  String lname , String lphone) {
		super();
		this.lno = lno;
		
		this.lname = lname;
		this.lphone = lphone;
	}
	
	public LibraryDto(int lno, String lphone) {
		super();
		this.lno = lno;
		this.lphone = lphone;
		
	}
	

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public String getLphone() {
		return lphone;
	}

	public void setLphone(String lphone) {
		this.lphone = lphone;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "LibraryDto [lno=" + lno + ", lphone=" + lphone + ", lname=" + lname + "]";
	}
    
    
    
}
