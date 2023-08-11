package jh.chada.jdbc.notice.model.service;

import static jh.chada.jdbc.common.temp.JdbcTemplate.*;


import java.sql.Connection;
import java.util.List;

import jh.chada.jdbc.notice.model.dao.NoticeDao;
import jh.chada.jdbc.notice.model.dto.NoticeDto;

public class NoticeService {

	private NoticeDao dao = new NoticeDao();
	
	public List<NoticeDto> noticeList() {
		List<NoticeDto> result =null;
		Connection conn = getConnection();
		result = dao.selectNotice(conn);
		close(conn);
		return result;
		
	}
	
}
