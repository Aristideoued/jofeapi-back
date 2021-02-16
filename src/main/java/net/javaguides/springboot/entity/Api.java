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
@Table(name="Api")
public class Api {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="designation", columnDefinition="varchar(191)")
	private String designation;

	@Column(name="logo", columnDefinition="varchar(191)")
	private String logo;
	
	@Column(name="created_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date created_at = new Date();
	
	@Column(name="updated_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date updated_at =new Date();
	
	@OneToOne(mappedBy = "idApi")
    private Historique historique;
	
	@OneToOne(mappedBy = "idApi")
    private IdConnectApi IdConnectApi;

	public Api() {
		super();
		
	}

	public Api(String designation, String logo) {
		super();
		this.designation = designation;
		this.logo = logo;
		//this.created_at = created_at;
		//this.updated_at = updated_at;
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public void setUpdated_at() {
		this.updated_at = new Date();
	}

	public Historique getHistorique() {
		return historique;
	}

	public void setHistorique(Historique historique) {
		this.historique = historique;
	}

	public IdConnectApi getIdConnectApi() {
		return IdConnectApi;
	}

	public void setIdConnectApi(IdConnectApi idConnectApi) {
		IdConnectApi = idConnectApi;
	}

	
	

}
