package kr.co.sesac.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sesac.vo.MemberVO;

@Repository //@Component + DB사용
public class MemberDAO_Mybatis {
	
	@Autowired
	SqlSession session;
	
	final String namespace = "com.sesac.member.";

   public List<MemberVO> selectAllMember() {
	   	return session.selectList(namespace + "selectAllMember");
   }
	   
   public MemberVO selectById(String id) {
	   return session.selectOne(namespace + "selectById", id);
   }
   
   public int insertMember(MemberVO member) {
	   return session.insert(namespace + "insertMember", member);
   }
   
   public int update(MemberVO member) {
	   return session.update(namespace + "update", member);
   }
   
   public int delete(String id) {
	   return session.delete(namespace + "delete", id);
   }

}
