package net.javaguides.springboot.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="utilisateur")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "idUser")
    private Historique historique;
	
	@Column(name="numero_compte", columnDefinition="varchar(191)")
	private String numero_compte;
	
	@Column(name="created_at",columnDefinition="TIMESTAMP",nullable = false, updatable = false)
	private Date created_at=new Date();
	
	@Column(name="updated_at",columnDefinition="TIMESTAMP",nullable = false, updatable = false)
	private Date updated_at=new Date();

	public User() {
		super();
		
	}

	public User(String numero_compte) {
		super();
		this.numero_compte = numero_compte;
		//this.created_at = created_at;
		//this.updated_at = updated_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setHistorique(Historique historique) {
		this.historique = historique;
	}

	public String getNumero_compte() {
		return numero_compte;
	}

	public void setNumero_compte(String numero_compte) {
		this.numero_compte = numero_compte;
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
