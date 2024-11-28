package kr.co.biz.board;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="BOARD")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int boardNo;
	
	@Column(length = 200)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(length = 50)
	private String writer;
	
	@Column(name="REG_DATE")
	private LocalDateTime regDate;
	
	@Transient  //테이블 생성 필드에서 제외
	private String regDateStr;
}
