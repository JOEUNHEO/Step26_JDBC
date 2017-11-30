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
		 * 	��ȣ: 999
		 * 	�̸�: ������
		 * 	�ּ�: ����
		 * 
		 *  ���� ������ MemberDto ��ü�� ���� ����
		 *  MemberDto ��ü�� ��� ������ �����ؼ�
		 *  �ش� ������ DB �� ������ ������.
		 */
		
		MemberDto dto = new MemberDto(999,"������","����");
		//Connection ��ü�� ������ ������
		Connection conn = new DBConnect().getConn();
		//�ʿ��� ��ü�� ���� ���� �����
		PreparedStatement ps = null;
		
		try {
			//������ SQL ���� ���� �����ϱ�
			String sql = "INSERT INTO member(num,name,addr)" + "VALUES(?,?,?)";
			ps = conn.prepareStatement(sql);
			//java�� ������ ���̽��� sql���� �̿��Ͽ� ����,����,���� �� ��� commit�� �ڵ� ����ȴ�.
			//�������� commit�� �������� conn.setAutoCommit(false) �޼ҵ带 �����ϰ�
			//�����͸� �������� conn.commit() �޼ҵ带 �����ϸ� �ȴ�.
			ps.setInt(1, dto.getNum());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getAddr());
			ps.executeUpdate();
			System.out.println("DB �� dto �� �����߽��ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)conn.close();
				if(ps != null)ps.close();
				//MemberDto ��ü�� main() �޼ҵ尡 ������ �ڵ����� ��������.
				//MemberDto ��ü �ȿ� �����ִ� �޼ҵ尡 �����Ƿ�, �ݾ� �� �ʿ䰡 ����.
			} catch (Exception e) {}
		}
	}
}
