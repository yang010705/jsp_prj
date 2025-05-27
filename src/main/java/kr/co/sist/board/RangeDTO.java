package kr.co.sist.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RangeDTO {
	private String field;//검색 필드
	private String keyword;//검색 키워드
	private int currentPage = 1; //현재 페이지
	private int startNum; //시작번호
	private int endNum; //끝번호
	
	private String[] fieldText = {"제목", "내용", "작성자"};
	
	
	public String getFieldName() {
		String fieldName = "subject";
		
		if("1".equals(field)) {
			fieldName="content";
		}//end if
		
		if("2".equals(field)) {
			fieldName="id";
		}//end if
		
		return fieldName;
	}//getFieldName
}//class