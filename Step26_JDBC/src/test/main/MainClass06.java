package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDto;
import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 	번호: 999
		 * 	이름: 누구게
		 * 	주소: 어디게
		 * 
		 *  위의 정보를 MemberDto 객체에 담은 다음
		 *  MemberDto 객체가 담긴 변수를 참조해서
		 *  해당 정보를 DB 에 저장해 보세요.
		 */
		
		MemberDto dto = new MemberDto(999,"누구게","어디게");
		//Connection 객체의 참조값 얻어오기
		Connection conn = new DBConnect().getConn();
		//필요한 객체를 담을 변수 만들기
		PreparedStatement ps = null;
		
		try {
			//실행할 SQL 문의 뼈대 구성하기
			String sql = "INSERT INTO member(num,name,addr)" + "VALUES(?,?,?)";
			ps = conn.prepareStatement(sql);
			//java로 데이터 베이스에 sql문을 이용하여 삽입,수정,삭제 할 경우 commit이 자동 실행된다.
			//수동으로 commit을 넣으려면 conn.setAutoCommit(false) 메소드를 실행하고
			//데이터를 넣은다음 conn.commit() 메소드를 실행하면 된다.
			ps.setInt(1, dto.getNum());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getAddr());
			ps.executeUpdate();
			System.out.println("DB 에 dto 를 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(ps != null)ps.close();
				//MemberDto 객체는 main() 메소드가 끝나면 자동으로 없어진다.
				//MemberDto 객체 안에 열려있는 메소드가 없으므로, 닫아 줄 필요가 없다.
			} catch (Exception e) {}
		}
	}
}
