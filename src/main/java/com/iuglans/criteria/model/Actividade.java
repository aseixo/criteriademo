/**
 * 
 */
package com.iuglans.criteria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author arturo
 *
 */
@Entity
@Table(name = "actividade")
@NamedQueries({
	@NamedQuery(name = "Actividade.todos", query = "select a from Actividade a"),
	@NamedQuery(name = "Actividade.buscarDesc", query = "select a from Actividade a where a.descricion like concat('%', :descrip,'%') ") 
	})
public class Actividade implements Serializable {

	private static final long serialVersionUID = 9177910694440608236L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actividade_id")
	private Long actividadeId;
	@Column(name = "descricion")
	private String descricion;
	@Column(name = "data_actividade")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataActividade;
	@Column(name = "data_control")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataControl;
	
	@ManyToOne
	@JoinColumn
	private Corrupto corrupto;
	
	public Actividade() {
		super();
	}

	public long getActividadeId() {
		return actividadeId;
	}

	public void setActividadeId(long actividadeId) {
		this.actividadeId = actividadeId;
	}

	public String getDescricion() {
		return descricion;
	}

	public void setDescricion(String descricion) {
		this.descricion = descricion;
	}

	public Date getDataActividade() {
		return dataActividade;
	}

	public void setDataActividade(Date dataActividade) {
		this.dataActividade = dataActividade;
	}

	public Date getDataControl() {
		return dataControl;
	}

	public void setDataControl(Date dataControl) {
		this.dataControl = dataControl;
	}

	public Corrupto getCorrupto() {
		return corrupto;
	}

	public void setCorrupto(Corrupto corrupto) {
		this.corrupto = corrupto;
	}

	@Override
	public String toString() {
		return "Actividade [actividadeId=" + actividadeId + ", descricion=" + descricion + ", dataActividade="
				+ dataActividade + ", dataControl=" + dataControl + ", corrupto=" + corrupto + "]";
	}

	
	
}
