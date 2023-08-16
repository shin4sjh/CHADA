package jh.chada.jdbc.article.model.service;

import static jh.chada.jdbc.common.temp.JdbcTemplate.close;
import static jh.chada.jdbc.common.temp.JdbcTemplate.getConnection;
import static jh.chada.jdbc.common.temp.JdbcTemplate.setAutoCommit;
import static jh.chada.jdbc.common.temp.JdbcTemplate.commit;
import static jh.chada.jdbc.common.temp.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import jh.chada.jdbc.article.file.model.dto.AattachFileDto;
import jh.chada.jdbc.article.model.dao.ArticleDao;
import jh.chada.jdbc.article.model.dto.ArticleDto;
import jh.chada.jdbc.article.model.dto.ArticleListDto;
import jh.chada.jdbc.login.model.dao.MemberDao;

public class ArticleService {

	private ArticleDao dao = new ArticleDao();
	private MemberDao mdao = new MemberDao();
	
	public List<ArticleListDto> selectList(){
		List<ArticleListDto> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	// 한 행 읽기 - PK로where조건
	public ArticleDto selectOne(int articleCode){
		ArticleDto result = null;
		Connection conn = getConnection();
		result = dao.selectOne(conn, articleCode);
		if(result != null) {
			// 첨부파일들 읽어서 result에 넣기
			List<AattachFileDto> fileList = dao.selectAttachFileList(conn, articleCode);
			result.setAattachFileList(fileList);
		}
		close(conn);
		return result;
	}
	// 한 행 삽입 - BoardDto 자료형을 받아와야 함.
	public int insert(ArticleDto dto, List<AattachFileDto> fileList){
		int result = 0;
		Connection conn = getConnection();
		setAutoCommit(conn, false);
		int nextval = dao.getSeqBoardArticleCodeNexVal(conn);
		if(dto.getArticleCode() == 0) { // 원본글작성
			result = dao.insert(conn, dto, nextval);
			if(fileList!=null && fileList.size()>0) {
				result = dao.insertAttachFileList(conn, fileList, nextval);
			}
		
		}
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	// 한 행 수정 - BoardDto 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
	public int update(ArticleDto dto){
		int result = 0;
		Connection conn = getConnection();
		result = dao.update(conn, dto);
		close(conn);
		return result;
	}
	// 한 행 삭제 - 주로 PK로 where조건
	public int delete(int articleCode){
		int result = 0;
		Connection conn = getConnection();
		result = dao.delete(conn, articleCode);
		close(conn);
		return result;
	}
	
	//// 추가 
	// 페이징 처리 + 검색
	public int getTotalCount(String searchWord) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.getTotalCount(conn, searchWord);
		close(conn);
		return result;
	}
	public List<ArticleListDto> selectList(int currentPage, int pageSize, String searchWord){
		List<ArticleListDto> result = null;
		Connection conn = getConnection();
		int totalCount = getTotalCount(searchWord);
		result = dao.selectList(conn, currentPage, pageSize, totalCount, searchWord);
		close(conn);
		return result;
	}
}
