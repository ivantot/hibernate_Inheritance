package ITProgs.inheritance.hibernate.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Teachers")
public class TeacherEntity extends AbstractUserEntity {

	@Column(nullable = false)
	private String teacherID;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate startOfEmployment;

	@Column(nullable = false)
	private Double salary;

	public TeacherEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public LocalDate getStartOfEmployment() {
		return startOfEmployment;
	}

	public void setStartOfEmployment(LocalDate startOfEmployment) {
		this.startOfEmployment = startOfEmployment;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
