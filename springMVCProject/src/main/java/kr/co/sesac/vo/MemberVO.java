package kr.co.sesac.vo;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String email;
	private String emailId;
	private String emailDo;
	private String tel;
	private String telA;
	private String telB;
	private String telC;
	private String post;
	private String addr;
	private String basicAddr;
	private String detailAddr;
	private String type;
	private String regDate;
	
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public MemberVO(String id, String name, String email, String tel, String post, String addr, String type,
			String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.post = post;
		this.addr = addr;
		this.type = type;
		this.regDate = regDate;
	}

	public MemberVO(String id, String name, String password, String email, String emailId, String emailDo, String tel,
			String telA, String telB, String telC, String post, String addr, String basicAddr, String detailAddr,
			String type, String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.emailId = emailId;
		this.emailDo = emailDo;
		this.tel = tel;
		this.telA = telA;
		this.telB = telB;
		this.telC = telC;
		this.post = post;
		this.addr = addr;
		this.basicAddr = basicAddr;
		this.detailAddr = detailAddr;
		this.type = type;
		this.regDate = regDate;
	}







	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailDo() {
		return emailDo;
	}



	public void setEmailDo(String emailDo) {
		this.emailDo = emailDo;
	}



	public String getTelA() {
		return telA;
	}



	public void setTelA(String telA) {
		this.telA = telA;
	}



	public String getTelB() {
		return telB;
	}



	public void setTelB(String telB) {
		this.telB = telB;
	}



	public String getTelC() {
		return telC;
	}



	public void setTelC(String telC) {
		this.telC = telC;
	}



	public String getBasicAddr() {
		return basicAddr;
	}



	public void setBasicAddr(String basicAddr) {
		this.basicAddr = basicAddr;
	}



	public String getDetailAddr() {
		return detailAddr;
	}



	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
