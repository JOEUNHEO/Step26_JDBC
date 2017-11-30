package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass03 {
	public static void main(String[] args) {
		//�ʿ��� ��ü�� ���� ���� �����
		Connection conn=null;
		try{
			//����Ŭ ����̹� �ε��ϱ�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//������ oracle DB url ����
			String url="jdbc:oracle:thin:@localhost:1521:xe";//1521�� oracle �⺻��Ʈ��
			//Connection ��ü�� ������ ������
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB ���� ����!");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		// 1�� ȸ���� ������ ������ ������.
		int num = 1;
		String addr = "����";
		
		//�ʿ��� ��ü�� ���� ���� �����
		PreparedStatement pstmt = null;
		try {
			//������ SQL ���� ���� �����ϱ�
			String sql = "UPDATE member SET addr=? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			System.out.println("ȸ�������� �����߽��ϴ�.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {}
		}
	}
}