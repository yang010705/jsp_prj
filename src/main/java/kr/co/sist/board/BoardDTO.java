package kr.co.sist.board;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class BoardDTO {
	private int num;
	private String subject;
	private String content;
	private String id;
	private Date input_date;
	private String ip;
	private int cnt;
}
