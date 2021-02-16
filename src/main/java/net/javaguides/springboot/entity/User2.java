/*package net.javaguides.springboot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="User2")
public class User2 {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="USER_ID")
private Long id;

@Column(name="name",unique=true,columnDefinition="varchar(191)")
private String username;

@Column(name="passord",columnDefinition="varchar(30)")
private String password;

private boolean enable;

@ManyToMany(fetch=FetchType.EAGER)
@JoinTable(name="USERS_ROLES",
joinColumns= {@JoinColumn(name="USER_ID")},
inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
private List<Role> roles;

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User2 other = (User2) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

public User2(String username, String password, boolean enable) {
	super();
	this.username = username;
	this.password = password;
	this.enable = enable;
}
public User2() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isEnable() {
	return enable;
}
public void setEnable(boolean enable) {
	this.enable = enable;
}
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}

}
*/