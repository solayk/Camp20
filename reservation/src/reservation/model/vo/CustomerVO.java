package reservation.model.vo;

public class CustomerVO {
	
	String memberID;
	String memberTel;
	String memberPw;
	String memberName;
	String memberEmail;
	String memberAddr;
	
	public CustomerVO() {
		super();
	}

	public CustomerVO(String memberID, String memberTel, String memberPw, String memberName, String memberEmail,
			String memberAddr) {
		super();
		this.memberID = memberID;
		this.memberTel = memberTel;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberAddr = memberAddr;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	
}
