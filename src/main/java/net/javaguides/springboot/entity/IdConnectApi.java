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
@Table(name="IdConnectApi")
public class IdConnectApi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_api")
    private Api idApi;
	
	@Column(name="username", columnDefinition="varchar(191)")
	private String username;

	@Column(name="url", columnDefinition="varchar(191)")
	private String url;
	
	@Column(name="numero_compte", columnDefinition="varchar(191)")
	private String numero_compte;
	
	@Column(name="password", columnDefinition="varchar(191)")
	private String password;

	@Column(name="created_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date created_at =new Date();
	
	@Column(name="updated_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date updated_at=new Date();

	public IdConnectApi() {
		super();
		
	}

	public IdConnectApi(Api idApi, String username, String url, String numero_compte, String password,
			String created_at, String updated_at) {
		super();
		this.idApi = idApi;
		this.username = username;
		this.url = url;
		this.numero_compte = numero_compte;
		this.password = password;
		//this.created_at = created_at;
		//this.updated_at = updated_at;
		this.idApi.setIdConnectApi(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Api getIdApi() {
		return idApi;
	}

	public void setIdApi(Api idApi) {
		this.idApi = idApi;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNumero_compte() {
		return numero_compte;
	}

	public void setNumero_compte(String numero_compte) {
		this.numero_compte = numero_compte;
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
