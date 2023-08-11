package jh.chada.jdbc.article.keyword.model.dao;

import static jh.chada.jdbc.common.temp.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jh.chada.jdbc.article.keyword.model.dto.KeywordDto;

public class KeywordDao {

	public List<KeywordDto> selectList(Connection conn) {
		System.out.println("[Board Dao selectList]");
		List<KeywordDto> result = new ArrayList<KeywordDto>();
		
		String query = " select KEYWORD_CODE, KEYWORD_NAME from TB_KEYWORD ";
		query += " order by KEYWORD_CODE desc"; // 정렬순서
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				KeywordDto dto = new KeywordDto(
						
							rs.getString("KEYWORD_CODE"),
							rs.getString("KEYWORD_NAME")									
			);
				result.add(dto);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	} finally {
		close(rs);
		close(pstmt);
	}
	System.out.println("[Board Dao selectList] return:" + result);
	return result;
	
	}
	
	
	public KeywordDto selectOne(Connection conn, int keywordCode) {
		System.out.println("[Board Dao selectOne] bno:" + keywordCode);
		KeywordDto result = null;
		String query = " KEYWORD_CODE , KEYWORD_NAME from TB_KEYWORD ";
		query += " where KEYWORD_CODE=?"; 

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, keywordCode);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				result = new KeywordDto(
						rs.getString("KEYWORD_CODE"),
						rs.getString("KEYWORD_NAME")				
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Board Dao selectOne] return:" + result);
		return result;
	}
	
	public int delete(Connection conn, String keywordCode , String keywordName) {
		System.out.println("[Board Dao delete] bno:" + keywordCode);
		int result = 0;
		String query= "delete from tb_notice where keywordCode = ? and keywordName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keywordCode);
			pstmt.setString(2, keywordName);
			result=pstmt.executeUpdate();
			result=0;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;

	}
	
	
	
}
	
