package 과제.과제11.model.dto;

public class LetterDto {
	private int pno;
	private int bno;
	private int mno;
	private String pcontent;
	private String pdate;
	private String preply;
	
	public LetterDto() {}

	public LetterDto(int pno, int bno, int mno, String pcontent, String pdate, String preply) {
		super();
		this.pno = pno;
		this.bno = bno;
		this.mno = mno;
		this.pcontent = pcontent;
		this.pdate = pdate;
		this.preply = preply;
	}

	public LetterDto(int pno, int mno, String pcontent, String pdate) {
		super();
		this.pno = pno;
		this.mno = mno;
		this.pcontent = pcontent;
		this.pdate = pdate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getPreply() {
		return preply;
	}

	public void setPreply(String preply) {
		this.preply = preply;
	}

	@Override
	public String toString() {
		return "LetterDto [pno=" + pno + ", bno=" + bno + ", mno=" + mno + ", pcontent=" + pcontent + ", pdate=" + pdate
				+ ", preply=" + preply + "]";
	}
	
	
}
