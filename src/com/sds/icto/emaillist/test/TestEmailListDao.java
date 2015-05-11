package com.sds.icto.emaillist.test;

import java.util.List;

import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;

public class TestEmailListDao {

	public static void main(String[] args) {
		try {
			testDelete();
			testInsert();
			testFetchList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testInsert() throws Exception{
		EmailListVo vo=new EmailListVo();
		vo.setFirstName("lee");
		vo.setLastName("jungan");
		vo.setEmail("lee@gmail.com");
		EmailListDao dao=new EmailListDao();
		dao.insert(vo);
	}
	public static void testDelete() throws Exception{
		EmailListDao dao=new EmailListDao();
		dao.delete();
	}
	public static void testFetchList() throws Exception{
		EmailListDao dao=new EmailListDao();
		List<EmailListVo> list=dao.fetchList();
		for(EmailListVo vo:list){
			System.out.println(vo.getNo()+":"+vo.getFirstName()+":"+vo.getLastName()+":"+vo.getEmail());
		}
	}

}
