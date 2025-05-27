package day0430;

import java.util.ArrayList;
import java.util.List;

public class Service {

	public String name() {
		return "강태일";
	}//name
	
	public List<DataDTO> subject(){
		List<DataDTO> list = new ArrayList<DataDTO>();
		
		list.add(new DataDTO(1,"Java SE"));
		list.add(new DataDTO(1,"Oracle DBMS"));
		list.add(new DataDTO(1,"JDBC"));
		list.add(new DataDTO(1,"HTML"));
		list.add(new DataDTO(1,"CSS"));
		list.add(new DataDTO(1,"JavaScript"));
		list.add(new DataDTO(1,"JSP"));
		
		return list;
	}
}
