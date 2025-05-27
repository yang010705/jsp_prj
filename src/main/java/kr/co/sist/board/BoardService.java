package kr.co.sist.board;

import java.sql.SQLException;
import java.util.List;

public class BoardService {
	
	/**
	 * 1. 총 레코드의 수
	 * @param rDTO
	 * @return 레코드의 수
	 */
	public int totalCount(RangeDTO rDTO) {
		
		int cnt = 0;
		BoardDAO bDAO = BoardDAO.getInstance();
		try {
			cnt = bDAO.selectTotalCount(rDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}//totalCount
	
	/**
	 * 한 화면에 보여줄 게시물의 수
	 * @return한 화면에 보여줄 게시물의 수
	 */
	public int pageScale() {
		
		int pageScale=10;
		
		return pageScale;
		
	}//pageScale
	
	/**
	 * 총 페이지 수
	 * @param totalCount 총 게시물의 수
	 * @param pageScale 한 화면에 보여줄 게시글의 수
	 * @return
	 */
	public int totalPage(int totalCount, int pageScale) {
		
		int totalPage = 0;
		totalPage=(int)Math.ceil((double)totalCount/pageScale);
		
		return totalPage;
		
	}//totalPage
	
	/**
	 * pagination 을 클릭했을 때의 번호를 사용하여 해당 페이지의 시작 번호를 구하기
	 * 예 1 - 1, 2 - 11, 3 - 21, 4 - 31, 5 - 41
	 * @param pageScale
	 * @param rDTO
	 * @return
	 */
	public int startNum(int pageScale, RangeDTO rDTO) {
		
		int startNum = 1;
		
		startNum = rDTO.getCurrentPage() * pageScale - pageScale + 1;
		rDTO.setStartNum(startNum);
		
		return startNum;
		
	}//startNum
	
	/**
	 * pagination 을 클릭했을 때의 번호를 사용하여 해당 페이지의 끝 번호를 구하기
	 * @param pageScale
	 * @param rDTO
	 * @return
	 */
	public int endNum(int pageScale, RangeDTO rDTO) {
		
		int endNum = 0;
		
		endNum = rDTO.getStartNum() + pageScale - 1;
		rDTO.setEndNum(endNum);
		
		return endNum;
		
	}//endNum
	
	public List<BoardDTO> searchBoard(RangeDTO rDTO){
		
		List<BoardDTO> list = null;
		
		BoardDAO bDAO = BoardDAO.getInstance();
		try {
			list = bDAO.selectBoard(rDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}//searchBoard
	
	public boolean writeBoard(BoardDTO bDTO) {
		
		boolean flag = false;
		
		BoardDAO bDAO = BoardDAO.getInstance();
		try {
			bDAO.insertBoard(bDTO);
			flag=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//writeBoard
	
	/**
	 * 선택된 게시물 하나 읽기
	 * @param num
	 * @return
	 */
	public BoardDTO searchOneBoard(int num) {		
		
		BoardDTO bDTO = null;
		
		BoardDAO bDAO = BoardDAO.getInstance();
		try {
			bDTO = bDAO.selectOneBoard(num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bDTO;
		
	}//searchOneBoard
	
	/**
	 * 조회수 증가
	 * @param num
	 */
	public void modifyCnt(int num) {
		
		BoardDAO bDAO = BoardDAO.getInstance();
		
		try {
			bDAO.updateCnt(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//modifyCnt
	
	/**
	 * 글삭제
	 * @param bDTO
	 * @return
	 */
	public boolean deleteBoard(BoardDTO bDTO) {
		
		boolean flag = false;
		
		BoardDAO bDAO = BoardDAO.getInstance();
		try {
			flag = bDAO.deleteBoard(bDTO) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//deleteBoard

	public boolean modifyBoard(BoardDTO bDTO) {
		
		boolean flag = false;
		
		BoardDAO bDAO = BoardDAO.getInstance();
		try {
			flag = bDAO.updateBoard(bDTO) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return flag;
	}//modifyBoard
}//class
