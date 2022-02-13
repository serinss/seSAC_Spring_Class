package kr.co.sesac.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sesac.vo.MemberVO;

@Service
public class MemberService {
	@Autowired
	MemberDAO mdao;
	
	public int insertMember(MemberVO member) {
		return mdao.insertMember(member);
	}
	
	public List<MemberVO> selectAllMember(){
		return mdao.selectAllMember();
	}
	
	
}
