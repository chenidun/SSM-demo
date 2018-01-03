package ssm.project.pojo;

import java.util.Date;

public class User {

	private Long uid;
	private String username;
	private Integer age;
	private String sex;
	private String mobile;
	private String email;
	private String des;
	private Date jointime;

	// public User(String name) {
	// this.name=name;
	// }
	public Long getUid() {
		return  uid;
	}

	public void setUId(Long  uid) {
		this.uid =  uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJointime() {
		return jointime;
	}

	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", age=" + age
				+ ", sex=" + sex + ", mobile=" + mobile + ", email=" + email
				+ ", des=" + des + ", jointime=" + jointime + "]";
	}

	

	
	

}
