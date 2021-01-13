package model;

public class BoardBean {

	private int num;
	private String writer;
	private String email;
	private String subject;
	private String password;
	private String reg_date;
	private int ref;
	private int re_step;
	private int re_level;
	private int readcount;
	private String content;
	
	
	public BoardBean() {
	
	}


	/**
	 * @return the re_level
	 */
	public int getRe_level() {
		return re_level;
	}


	/**
	 * @param re_level the re_level to set
	 */
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}


	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}


	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}


	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}


	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}


	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the reg_date
	 */
	public String getReg_date() {
		return reg_date;
	}


	/**
	 * @param reg_date the reg_date to set
	 */
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}


	/**
	 * @return the ref
	 */
	public int getRef() {
		return ref;
	}


	/**
	 * @param ref the ref to set
	 */
	public void setRef(int ref) {
		this.ref = ref;
	}


	/**
	 * @return the re_step
	 */
	public int getRe_step() {
		return re_step;
	}


	/**
	 * @param re_step the re_step to set
	 */
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}


	/**
	 * @return the readcount
	 */
	public int getReadcount() {
		return readcount;
	}


	/**
	 * @param readcount the readcount to set
	 */
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
