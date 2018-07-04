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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table
public class Body implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String content;
	@Column
	//@Basic(optional=false)
	//@Temporal(TemporalType.DATE) //DATE
	private String startDate;
	@Column
	//@Basic(optional=false)
	//@Temporal(TemporalType.DATE)
	private String endDate;
	@Column
	private boolean visible;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_panel")
	private Panel panel;
	
	
	
	public Body() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

//	public Panel getPanel() {
//		return panel;
//	}

//	public void setPanel(Panel panel) {
//		this.panel = panel;
//	}
   
}
