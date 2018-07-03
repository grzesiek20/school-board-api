package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String classes;
	@Column
	//@Basic(optional=false)
	//@Temporal(TemporalType.DATE) //DATE
	private java.sql.Time startTime;
	@Column
	//@Basic(optional=false)
	//@Temporal(TemporalType.DATE)
	private java.sql.Time endTime;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_body")
	private Body body;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public java.sql.Time getStartTime() {
		return startTime;
	}
	public void setStartTime(java.sql.Time startTime) {
		this.startTime = startTime;
	}
	public java.sql.Time getEndTime() {
		return endTime;
	}
	public void setEndTime(java.sql.Time endTime) {
		this.endTime = endTime;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	
	
}
