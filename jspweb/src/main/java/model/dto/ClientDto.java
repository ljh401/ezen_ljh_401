package model.dto;

import javax.websocket.Session;

public class ClientDto {	// 현재 서버소켓의 접속된 클라이언트의 상태 정보를 설계한 클래스

	private Session session;	// 클라이언트 소켓
	private String mid;			// 클라이언트 소켓을 사용하는 회원아이디 
	
	 public ClientDto() {
		// TODO Auto-generated constructor stub
	}

	public ClientDto(Session session, String mid) {
		super();
		this.session = session;
		this.mid = mid;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "ClientDto [session=" + session + ", mid=" + mid + "]";
	}
	 
	
}
