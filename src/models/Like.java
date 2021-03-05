package models;

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

@Table(name = "yoines")
@NamedQueries({
@NamedQuery(
        name = "getAllYoines",
        query = "SELECT l.report_id FROM Like AS l ORDER BY l.report_id DESC"
    )
})
@Entity
public class Like {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "yoine", nullable = false)
    private Integer yoine ;

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    private Report report_id  ;

	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getYoine() {
		return yoine;
	}

	public void setYoine(Integer yoine) {
		this.yoine = yoine;
	}

	public Report getReport_id() {
		return report_id;
	}

	public void setReport_id(Report report_id) {
		this.report_id = report_id;
	}


}