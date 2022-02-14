package kr.co.sesac.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sesac.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	MemberDAO_Mybatis mdao;
	
	public List<MemberVO> selectAllMember(){
		return mdao.selectAllMember();
	}
	
	public MemberVO selectById(String id) {
		   return mdao.selectById(id);
	}
	
	public int insertMember(MemberVO member) {
		return mdao.insertMember(member);
	}
	
	public int update(MemberVO member) {
		return mdao.update(member);
	}
	
	public int delete(String id) {
		return mdao.delete(id);
	}
	
}
