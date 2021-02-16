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
@Table(name="Historique")
public class Historique {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_client")
    private Clients idClient;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_api")
    private Api idApi;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_user")
    private Api idUser;

	@Column(name="created_at",columnDefinition="TIMESTAMP",nullable = false, updatable = false)
	private Date created_at=new Date();
	
	@Column(name="updated_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date updated_at=new Date();

	public Historique() {
		super();
		
	}

	public Historique(Clients idClient, Api idApi, Api idUser) {
		super();
		this.idClient = idClient;
		this.idApi = idApi;
		this.idUser = idUser;
		//this.created_at = created_at;
		//this.updated_at = updated_at;
		this.idUser.setHistorique(this);
		this.idApi.setHistorique(this);
		this.idClient.setHistorique(this);
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

	public Api getIdApi() {
		return idApi;
	}

	public void setIdApi(Api idApi) {
		this.idApi = idApi;
	}

	public Api getIdUser() {
		return idUser;
	}

	public void setIdUser(Api idUser) {
		this.idUser = idUser;
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
