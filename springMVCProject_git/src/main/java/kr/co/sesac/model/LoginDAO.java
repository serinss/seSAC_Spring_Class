package kr.co.sesac.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import kr.co.sesac.vo.LoginVO;



public class LoginDAO {
//MemberDAO와 나중에 합치기
	 
	@Autowired //생성하겠다고 설정한 type이 같으면 Injection주입
	DataSource ds;
	
	
	//login기록을 기억해둬야 하므로 리턴 타입은 LoginVO
	/**
	 * 로그인 서비스
	 * @param loginVO (사용자가 입력한id, password 저장)
	 * @return userVO(id, password로 조회된 회원정보)
	 */
	public LoginVO login(LoginVO loginVO) {
		
		//1.7버전 try문 사용해보기 --> try(변수 선언 가능)
		//선언할 변수의 타입 = 참조 자료형, 무조건 autocloseable(try문이 종료될 때 자동으로 close()를 호출하는 클래스)상속
		//                        -> finally{ JDBCClose.close()} 필요 없음
		//The resource type StringBuilder does not implement java.lang.AutoCloseable
		//autocloseable을 상속받지 않는 변수는 try문 바깥에서 선언 -> StringBuilder 는 바깥에서 선언함
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, type ");
		sql.append(" from tbl_member ");
		sql.append(" where id = ? and password = ? ");
		
		LoginVO userVO = null;
		
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
				pstmt.setString(1, loginVO.getId());
				pstmt.setString(2, loginVO.getPassword());
				ResultSet rs =  pstmt.executeQuery();
				
				if(rs.next()) {
					userVO = new LoginVO();
					userVO.setId(rs.getString("id"));
					userVO.setPassword(rs.getString("password"));
					userVO.setType(rs.getString("type"));
				
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userVO;
		
	}
}
