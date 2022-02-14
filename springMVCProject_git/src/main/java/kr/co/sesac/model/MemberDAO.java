package kr.co.sesac.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sesac.vo.MemberVO;

@Repository //@Component + DB사용
public class MemberDAO {
	
	@Autowired //생성하겠다고 설정한 type이 같으면 Injection주입
	DataSource dataSource; //action-dbSource.xml 에 선언한 대로 타입이 같으면 생성
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	   /**
	    * 1. 전체 회원 조회 메서드
	    */
	   public List<MemberVO> selectAllMember() {

	      List<MemberVO> list = new ArrayList<>();

	      try {
	         conn = dataSource.getConnection();
	         StringBuilder sql = new StringBuilder();
	         sql.append("select id, name, email_id || '@' || email_domain as email ");
	         sql.append(" , tel1 || '-' || tel2 || '-' || tel3 as tel ");
	         sql.append(" , post, basic_addr || detail_addr as addr, type, to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
	         sql.append(" from tbl_member ");
	         sql.append(" order by reg_date desc ");
	         
	         pstmt = conn.prepareStatement(sql.toString());
	         ResultSet rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	String id = rs.getString("id");
	     		String name = rs.getString("name");
	     		String email = rs.getString("email");
	     		String tel = rs.getString("tel");
	     		String post = rs.getString("post");
	     		String addr = rs.getString("addr");
	     		String type = rs.getString("type");
	     		String regDate = rs.getString("reg_date");
	     		
	     		MemberVO member = new MemberVO(id, name, email, tel, post, addr, type, regDate);
	     		list.add(member);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         
	      }
	      return list;
	   }
	   
	   
	   /**
	    * 2. 회원가입 메소드
	    * @param member
	    */
	   public int insertMember(MemberVO member) {
		   int result=0;
	      try {

	    	  Connection conn = dataSource.getConnection();
	    		StringBuilder sql = new StringBuilder();
	    		sql.append("insert into tbl_member(id, name, password, email_id, email_domain, "
	    				+ "tel1, tel2, tel3, post, basic_addr, detail_addr) ");
	    		sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
	    		
	    		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    		pstmt.setString(1, member.getId());
	    		pstmt.setString(2, member.getName());
	    		pstmt.setString(3, member.getPassword());
	    		pstmt.setString(4, member.getEmailId());
	    		pstmt.setString(5, member.getEmailDo());
	    		pstmt.setString(6, member.getTelA());
	    		pstmt.setString(7, member.getTelB());
	    		pstmt.setString(8, member.getTelC());
	    		pstmt.setString(9, member.getPost());
	    		pstmt.setString(10, member.getBasicAddr());
	    		pstmt.setString(11, member.getDetailAddr());
	    		
	    		result = pstmt.executeUpdate();
	    		
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	      
	      }
	      return result;
	   }

}
