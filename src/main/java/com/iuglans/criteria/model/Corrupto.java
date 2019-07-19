package com.iuglans.criteria.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "corruptos")
@NamedQueries({
		@NamedQuery(name = "Corrupto.todosPorPartido", query = "select c from Corrupto c where c.partido <>'*' order by c.partido, c.nome asc"),
		@NamedQuery(name = "Corrupto.buscarAsunto", query = "select c from Corrupto c where c.asunto like concat('%', :asunto,'%') ") })
public class Corrupto implements Serializable {

	private static final long serialVersionUID = -7521709863717195763L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "corrupto_id")
	private Long corruptoId;
	@Column(name = "nome")
	private String nome;
	@Column(name = "partido")
	private String partido;
	@Column(name = "asunto")
	private String asunto;
	@Column(name = "condena")
	private Long condena;
	@OneToMany(mappedBy = "corrupto", cascade = CascadeType.ALL)
	private List<Actividade> actividades;
	public Corrupto() {
	}

	public Corrupto(Long corruptoId, String nome, String partido, String asunto, Long condena) {
		super();
		this.corruptoId = corruptoId;
		this.nome = nome;
		this.partido = partido;
		this.asunto = asunto;
		this.condena = condena;
	}

	public Long getCondena() {
		return condena;
	}

	public void setCondena(long i) {
		this.condena = i;
	}

	public Long getCorruptoId() {
		return corruptoId;
	}

	public void setCorruptoId(Long corruptoId) {
		this.corruptoId = corruptoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	@Override
	public String toString() {
		return "Corrupto [corruptoId=" + corruptoId + ", nome=" + nome + ", partido=" + partido + ", asunto=" + asunto
				+ ", condena=" + condena + "]";
	}
	

}
