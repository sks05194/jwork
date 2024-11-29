package kr.co.biz.dept;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "dept")
public class Dept {
	
	@Id
	@Column(name="DEPTNO")
	private int deptno;
	
	@Column(length = 200)
	private String deptnm;
	
	@Column(length = 50)
	private String loc;
	
//	@Transient
//	@OneToMany(mappedBy = "dept")
//	ArrayList<Member> member;	
}
