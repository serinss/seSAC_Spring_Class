package kr.co.sesac.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sesac.vo.BoardFileVO;
import kr.co.sesac.vo.BoardVO;



@Service 
public class BoardService {
	
	@Autowired
	BoardDAO dao;
 
	public List<BoardVO> selectAllBoard() {
		 return dao.selectAllBoard();
	}
 
	public int selectBoardNo() {
		 return dao.selectBoardNo();
	}
 
	public int insertBoard(BoardVO board) {
		return dao.insertBoard(board);
	}
	
	public int viewCnt(int boardNo) {
		 return dao.viewCnt(boardNo);
	}
	
	public BoardVO selectBoardByNo(int boardNo) {
		return dao.selectBoardByNo(boardNo) ;
	}
	
	public int updateBoard(BoardVO board) {
		 return dao.updateBoard(board);
	}
 
	public int boardCnt() {
		 return dao.boardCnt();
	}
 
	public int insertFile(BoardFileVO fileVO) {
		return dao.insertFile(fileVO);
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo) {
		 return dao.selectFileByNo(boardNo);
	}
	
	public int deleteByNo(int boardNo) {
		return dao.deleteByNo(boardNo);
	}
}
