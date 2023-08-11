package jh.chada.jdbc.notice.model.dao;

import static jh.chada.jdbc.common.temp.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jh.chada.jdbc.notice.model.dto.NoticeDto;

public class NoticeDao {

	public List<NoticeDto> selectNotice(Connection conn) {
		System.out.println("select list");
		List<NoticeDto> result = new ArrayList<NoticeDto>();
	
		String query = " select MEMBER_NO , NOTICECONTENT from TB_NOTICE";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while (rs.next() ==true) {
				NoticeDto dto = new NoticeDto(
				rs.getString("MEMBER_NO"),
				rs.getString("NOTICECONTENT")
				);
				result.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}
		System.out.println(result);
		return result;
	}

	
}
