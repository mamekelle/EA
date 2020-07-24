package edu.mum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Credentials")
public class UserCredentials {

	@Id
	@Column(name = "USER", nullable = false, unique = true, length = 127)
	String userName;
	@Column(name = "PASSWORD", nullable = false, length = 32)
	String password;
	@Column(nullable = false, length = 32)
	String verifyPassword;
	Boolean enabled;
	@OneToMany
	List<Authority> authority = new ArrayList<Authority>();
	private User user;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public void addUser(User user2) {
		// TODO Auto-generated method stub
		
	}

}
