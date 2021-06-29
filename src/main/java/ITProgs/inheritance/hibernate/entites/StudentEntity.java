package ITProgs.inheritance.hibernate.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Students")
public class StudentEntity extends AbstractUserEntity {

	@Column(nullable = false)
	private String schoolID;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name ="ParentsChildren", joinColumns = {@JoinColumn(name = "studentID", nullable=false, updatable=false)}, inverseJoinColumns = {@JoinColumn(name = "parentID", nullable=false, updatable=false)})
	private List<ParentEntity> parents = new ArrayList<>();

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<ParentEntity> getParents() {
		return parents;
	}

	public void setParents(List<ParentEntity> parents) {
		this.parents = parents;
	}

}
