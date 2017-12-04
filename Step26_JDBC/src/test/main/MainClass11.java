package test.main;

import java.util.List;

import dto.MemberDto;
import test.dao.MemberDao;

public class MainClass11 {
	public static void main(String[] args) {
		//회원 목록을 불러오려면?
		MemberDao dao = MemberDao.getInstance();
		List<MemberDto> list = dao.getList();
		
		//콘솔에 출력
		for(MemberDto tmp:list) {
			int num = tmp.getNum();
			String name = tmp.getName();
			String addr = tmp.getAddr();
			System.out.println("num: "+num+", name: "+name+", addr: "+addr);
		}
	}
}
