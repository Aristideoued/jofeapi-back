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
@Table(name="Clients")
public class Clients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "idClient")
    private Historique historique;
	
	@OneToOne(mappedBy = "idClient")
    private IdConnexion idConnexion;

	@Column(name="nom", columnDefinition="varchar(191)")
	private String nom;
	
	@Column(name="prenom", columnDefinition="varchar(191)")
	private String prenom;
	
	@Column(name="email", columnDefinition="varchar(191)")
	private String email;
	
	@Column(name="telephone", columnDefinition="varchar(191)")
	private String telephone;
	
	@Column(name="site", columnDefinition="varchar(191)")
	private String site;
	
	@Column(name="numero_compte", columnDefinition="varchar(191)")
	private String numero_compte;
	
	@Column(name="password", columnDefinition="varchar(191)")
	private String password;
	
	@Column(name="created_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date created_at=new Date();
	
	@Column(name="updated_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date updated_at=new Date();

	public Clients() {
		super();
		
	}

	public Clients(Historique historique, IdConnexion idConnexion, String nom, String prenom, String email,
			String telephone, String site, String numero_compte, String password) {
		super();
		this.historique = historique;
		this.idConnexion = idConnexion;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.site = site;
		this.numero_compte = numero_compte;
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

	public Historique getHistorique() {
		return historique;
	}

	public void setHistorique(Historique historique) {
		this.historique = historique;
	}

	public IdConnexion getIdConnexion() {
		return idConnexion;
	}

	public void setIdConnexion(IdConnexion idConnexion) {
		this.idConnexion = idConnexion;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
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
