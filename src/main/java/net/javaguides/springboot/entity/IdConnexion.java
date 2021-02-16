package net.javaguides.springboot.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="IdConnexion")
public class IdConnexion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_client")
    private Clients idClient;
	
	
	@Column(name="username", columnDefinition="varchar(191)")
	private String username;
	
	@Column(name="password", columnDefinition="varchar(191)")
	private String password;
	
	@Column(name="created_at",columnDefinition="TIMESTAMP",nullable = false, updatable = false)
	private Date created_at=new Date();
	
	@Column(name="updated_at",columnDefinition="TIMESTAMP",nullable = false, updatable = false)
	private Date updated_at =new Date();

	public IdConnexion() {
		super();
		
	}

	public IdConnexion(Clients idClient, String username, String password) {
		super();
		this.idClient = idClient;
		this.username = username;
		this.password = password;
		//this.created_at = created_at;
		//this.updated_at = updated_at;
		this.idClient.setIdConnexion(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clients getIdClient() {
		return idClient;
	}

	public void setIdClient(Clients idClient) {
		this.idClient = idClient;
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
	
	
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at( ) {
		this.created_at = new Date();
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at( ) {
		this.updated_at = new Date();
	}

	
	
	
	
}
