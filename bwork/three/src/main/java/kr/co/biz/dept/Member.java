package kr.co.biz.dept;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@Column(length = 200)
	private String uid;
	
	@Column(length = 200)
	private String unm;
	
	private int uage;
	
	private int deptno;
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//	@Transient
	@ManyToOne
    @JoinColumn(name="DEPTNO" , insertable = false, updatable = false)
	private Dept dept;

}
