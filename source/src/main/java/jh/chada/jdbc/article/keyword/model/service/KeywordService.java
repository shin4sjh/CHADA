package jh.chada.jdbc.article.keyword.model.service;

import static jh.chada.jdbc.common.temp.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import jh.chada.jdbc.article.keyword.model.dao.KeywordDao;
import jh.chada.jdbc.article.keyword.model.dto.KeywordDto;

public class KeywordService {


		private KeywordDao dao = new KeywordDao();
		
		public List<KeywordDto> selectList(){
			List<KeywordDto> result = null;
			Connection conn = getConnection();
			result = dao.selectList(conn);
			close(conn);
			return result;
		}
		
		
		
		
		
		// 한 행 읽기 - PK로where조건
		public KeywordDto selectOne(int keywordCode){
			KeywordDto result = null;
			Connection conn = getConnection();
			result = dao.selectOne(conn, keywordCode);
			
			close(conn);
			return result;
		}
		
		
		
		// 한 행 삭제 - 주로 PK로 where조건
		public int delete(String keywordCode, String keywordName ){
			int result = 0;
			Connection conn = getConnection();
			result = dao.delete(conn, keywordCode, keywordName);
			close(conn);
			return result;
		}
		
		
	
}
	