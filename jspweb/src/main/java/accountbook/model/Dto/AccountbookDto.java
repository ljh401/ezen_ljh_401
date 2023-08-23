package accountbook.model.Dto;

public class AccountbookDto {

	private int ano;
	private String acontent;
	private int amoney;
	private String adate;
	
	public AccountbookDto() {
		// TODO Auto-generated constructor stub
	}


	public AccountbookDto(int ano, String acontent, int amoney, String adate) {
		super();
		this.ano = ano;
		this.acontent = acontent;
		this.amoney = amoney;
		this.adate = adate;
	}

	public AccountbookDto(String acontent, int amoney, String adate) {
		super();
		
		this.acontent = acontent;
		this.amoney = amoney;
		this.adate = adate;
	}


	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public int getAmoney() {
		return amoney;
	}

	public void setAmoney(int amoney) {
		this.amoney = amoney;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}


	@Override
	public String toString() {
		return "AccountbookDto [ano=" + ano + ", acontent=" + acontent + ", amoney=" + amoney + ", adate=" + adate
				+ "]";
	}
	
	
	
	
}
