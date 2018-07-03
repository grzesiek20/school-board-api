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
public class LuckyNumber implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private int number;
	@Column
	//@Basic(optional=false)
	//@Temporal(TemporalType.DATE) //DATE
	private boolean active;
	@Column
	//@Basic(optional=false)
	//@Temporal(TemporalType.DATE)
	private boolean drawn;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_body")
	private Body body;
}