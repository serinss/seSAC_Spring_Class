package kr.co.sesac.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sesac.vo.BoardFileVO;
import kr.co.sesac.vo.BoardVO;


@Repository 
public class BoardDAO_Mybatis {
	
	@Autowired
	SqlSession session; //sqlSession: sql문장을 실행하는 단위
	
	final String namespace = "com.sesac.board.";
	//namespace는 변경이 가능하므로 따로 빼주는 것을 권장 (무조건 유지보수 편하게)
	
	public List<BoardVO> selectAllBoard(String keyword, String contents){
		
		Map<String, String> mymap = new HashMap<String, String>();
		mymap.put("keyword", keyword);
		mymap.put("contents", "%"+contents+"%");
		
		//select를 여러번 해서 자동으로 List를 만든다
		return session.selectList(namespace + "selectAll", mymap); //파라미터는 하나밖에 전달을 못함 -> Map으로 묶자
		
//		List<BoardVO> blist = session.selectList(namespace + "selectAll");
//		blist.forEach(b->{syso(b);});
//		return blist; -> 이런식으로 쓸 수도 있다 정도 알아두기 
	}
	
	public int selectBoardNo() {
		return session.selectOne(namespace + "selectBoardNo");
	}
	
	public int insertBoard(BoardVO board) {
		return session.insert(namespace + "insertBoard", board);
		//실행할 id, 가져갈 parameterType 둘다 작성
	}
	
	public int viewCnt(int boardNo) {
		return session.update(namespace + "viewCnt", boardNo);
	}
	
	public BoardVO selectBoardByNo(int boardNo) {
		return session.selectOne(namespace + "selectBoardByNo", boardNo);
	}
	
	public int deleteByNo(int boardNo) {
		return session.delete(namespace + "deleteByNo", boardNo);
	}
 
	public int updateBoard(BoardVO board) {
		return session.update(namespace + "updateBoard", board);
	}
 
	public int boardCnt() {
		return session.selectOne(namespace + "boardCnt");
	}
 
	public int insertFile(BoardFileVO fileVO) {
		return session.insert(namespace + "insertFile", fileVO);
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo) {
		return session.selectList(namespace + "selectFileByNo", boardNo);
	}
	
}
