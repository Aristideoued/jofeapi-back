package net.javaguides.springboot.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nom", columnDefinition="varchar(191)")
	private String nom;

	@Column(name="prenom", columnDefinition="varchar(191)")
	private String prenom;

	@Column(name="email", columnDefinition="varchar(191)")
	private String email;
	
	@Column(name="password", columnDefinition="varchar(191)")
	private String password;
	
	@Column(name="created_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date created_at =new Date();
	
	@Column(name="updated_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date updated_at =new Date();

	public Admin() {
		super();
		
	}

	public Admin(String nom, String prenom, String email,String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		//this.created_at = created_at;
		//this.updated_at = updated_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_at() {
		return created_at;
	}
	@PreUpdate
	public void setCreated_at() {
		this.created_at = new Date();
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at() {
		this.updated_at = new Date();
	}

	
	
	
	
}
