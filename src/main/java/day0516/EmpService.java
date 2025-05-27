package day0516;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EmpService {
	
	/**
	 * 복합형태의 JSONObject 를 반환
	 * @return
	 */
	public String searchEmp(int deptno) {
		String strJSON="";
		List<EmpDTO> list = null;
		
		EmpDAO dDAO = EmpDAO.getInstance();
		try {
			list = dDAO.selectEmp(deptno); //데이터 조회
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//1. JSONObject 생성(데이터의 부가적인 정보, 데이터를 가질 때 사용)
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("resultFlag", !list.isEmpty());//검색 정보가 존재
			jsonObj.put("pubDate", sdf.format(new Date()));//검색 정보가 존재
			jsonObj.put("dataLength", list.size());//검색 정보가 존재
			
			//2. 데이터 채우기
			//JSONArray 생성(데이터를 저장)
			JSONArray jsonArr = new JSONArray();
			
			JSONObject jsonTemp = null;
			for(EmpDTO empDto : list) {
				//DB에서 검색된 데이터로 JSONObject 을 생성하여 JSONArray 에 할당
				jsonTemp = new JSONObject();
				jsonTemp.put("empno", empDto.getDeptno());
				jsonTemp.put("ename", empDto.getEname());
				jsonTemp.put("job", empDto.getJob());
				jsonTemp.put("hiredate", empDto.getHiredate());
				jsonTemp.put("sal", empDto.getSal());
				jsonArr.add(jsonTemp);
			}//end for
			
			//JSONArray 를 JSONObject 할당
			jsonObj.put("data", jsonArr);
			
			//데이터와 부가적인 정보를 가진 JSONObject 을 문자열로 얻기
			strJSON = jsonObj.toJSONString();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		
		return strJSON;
	}//jsonObj
}
