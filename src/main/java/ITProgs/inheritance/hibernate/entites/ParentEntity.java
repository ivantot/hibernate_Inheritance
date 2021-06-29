package ITProgs.inheritance.hibernate.entites;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Parents")
public class ParentEntity extends AbstractUserEntity {

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String phoneNumber;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "ParentsChildren", joinColumns = {
			@JoinColumn(name = "parentID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "studentID", nullable = false, updatable = false) })
	private List<StudentEntity> children = new ArrayList<>();

	public ParentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<StudentEntity> getChildren() {
		return children;
	}

	public void setChildren(List<StudentEntity> children) {
		this.children = children;
	}

}
