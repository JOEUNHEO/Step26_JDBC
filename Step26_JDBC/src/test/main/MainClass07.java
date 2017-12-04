package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dto.MemberDto;
import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 	member 테이블에 있는 내용을
		 * 	List<MemberDto> 형태로 담아 보세요.
		 */
		
		Connection conn = new DBConnect().getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<MemberDto> members = null;
		
		String sql = "SELECT * FROM member";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			members = new ArrayList<>();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				
				MemberDto dto = new MemberDto(num,name,addr);
				members.add(dto);
			}
			
			// members 콘솔에 출력하기
			
			//1)
//			for(MemberDto tmp:members) {
//				System.out.println("num: "+tmp.getNum()+", name: "+tmp.getName()+", addr: "+tmp.getAddr());
//			}
			//2)
//			Iterator<MemberDto> member = members.iterator();
//			while(member.hasNext()) {
//				MemberDto tmp = member.next();
//				System.out.println("num: "+tmp.getNum()+", name: "+tmp.getName()+", addr: "+tmp.getAddr());
//			}
			//3)
			members.forEach(tmp ->{
				System.out.println("num: "+tmp.getNum()+", name: "+tmp.getName()+", addr: "+tmp.getAddr());
			});
												
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null)conn.close();
				if(ps != null)ps.close();
				if(rs != null)rs.close();
				if(members != null)members.clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
}
