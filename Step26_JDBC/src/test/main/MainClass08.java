package test.main;

import java.util.List;

import dto.MemberDto;
import test.dao.MemberDao;

public class MainClass08 {
	public static void main(String[] args) {
		//�Ʒ��� ������ DB �� �����Ϸ���?
		int num = 999;
		String name = "������";
		String addr = "����";
		
		//������ ȸ�������� MemberDto ��ü�� ���
		MemberDto dto = new MemberDto(num, name, addr);
		//MemberDao ��ü�� ������ ������
		MemberDao dao = MemberDao.getInstance();
		//�����ϱ�
		boolean isSuccess = dao.insert(dto);
		if(isSuccess) {
			System.out.println("���� ����!");
		}else {
			System.out.println("���� ����!");
		}
	}
}
