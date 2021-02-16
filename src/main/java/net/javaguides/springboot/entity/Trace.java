package net.javaguides.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Trace")
public class Trace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name="numero", columnDefinition="varchar(191)")
	private String numero;

	@Column(name="montant", columnDefinition="varchar(11)")
	private String montant;
	
	@Column(name="created_at",columnDefinition="TIMESTAMP ",nullable = false, updatable = false)
	private Date created_at = new Date();

	public Trace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trace(String numero, String montant) {
		super();
		this.numero = numero;
		this.montant = montant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = new Date();
	}
	
	
}
