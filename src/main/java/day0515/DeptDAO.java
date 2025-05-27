package day0515;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;

public class DeptDAO {
	private static DeptDAO dDAO;
	private DeptDAO() {
		
	}//deptDAO
	
	public static DeptDAO getInstance() {
		
		if(dDAO == null) {
			dDAO = new DeptDAO();
		}//end if
		
		return dDAO;
		
	}//getInstance
	
	public List<Dept> selectAllDept() throws SQLException{
		List<Dept> list = new ArrayList<Dept>();
		
		DbConnection dbCon = DbConnection.getInstance();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		//1. JNDI사용 객체 생성
		//2. DBCP에서 DataSource 얻기
		//3. Connection 얻기
			con = dbCon.getDbConn();
		//4. 쿼리문 생성객체 얻기
			String selectAllDept = "select deptno, dname, loc from dept";
			pstmt = con.prepareStatement(selectAllDept);
		//5. 바인드변수에 값 할당
		//6. 쿼리문 수행 후 결과 얻기
			rs=pstmt.executeQuery();
			
			Dept deptDTO = null;
			
			while(rs.next()) {
				deptDTO = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				
				list.add(deptDTO);
			}
		}finally {
			//7. 연견끊기
			dbCon.dbClose(rs, pstmt, con);
		}
		
		return list;
		
	}//selectAllDept
}
