package jh.chada.jdbc.article.model.dao;

import static jh.chada.jdbc.common.temp.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jh.chada.jdbc.article.file.model.dto.AattachFileDto;
import jh.chada.jdbc.article.model.dto.ArticleDto;
import jh.chada.jdbc.article.model.dto.ArticleListDto;

public class ArticleDao {

	// 모든 행 읽기
		public List<ArticleListDto> selectList(Connection conn) {
			System.out.println("[Board Dao selectList]");
			List<ArticleListDto> result = new ArrayList<ArticleListDto>();

			String query = " select ARTICLE_CODE, MEMBER_NO, ARTICLE_TITLE ,to_char(ARTICLE_TIME, 'yyyy-mm-dd hh24:mi:ss') ARTICLE_TIME from TB_ARTICLE ";
			query += " order by ARTICLE_TIME asc"; // 정렬순서

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
					ArticleListDto dto = new ArticleListDto(
							rs.getInt("ARTICLE_CODE"),
							rs.getString("MEMBER_NO"),
							rs.getString("ARTICLE_TITLE"),
							rs.getString("KEYWORD_CODE"),
							rs.getString("ARTICLE_TIME")								
							);
					result.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			System.out.println("[Board Dao selectList] return:" + result);
			return result;
		}

		// 한 행 읽기 - PK로where조건
		public ArticleDto selectOne(Connection conn, int articleCode) {
			System.out.println("[Board Dao selectOne] articleCode:" + articleCode);
			ArticleDto result = null;
			String query = " select ARTICLE_CODE, MEMBER_NO, ARTICLE_TITLE ,to_char(ARTICLE_TIME, 'yyyy-mm-dd hh24:mi:ss') ARTICLE_TIME, ARTICLE_CONTENT from TB_ARTICLE ";
			query += " where ARTICLE_CODE=?"; 

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, articleCode);
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
					result = new ArticleDto(
							rs.getInt("ARTICLE_CODE"),
							rs.getString("MEMBER_NO"),
							rs.getString("ARTICLE_TITLE"),
							rs.getString("KEYWORD_CODE"),
							rs.getString("ARTICLE_TIME"),
							rs.getString("ARTICLE_CONTENT")										
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
		// 원본글작성
		public int insert(Connection conn, ArticleDto dto, int nextval) {
			System.out.println("[Board Dao insert] dto:" + dto + ", "+ nextval);
			int result = 0;
			String query = "";
			query = "insert into BOARD values (?, ?, ?, ?, default, ? )";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, nextval);
				pstmt.setString(2, dto.getMemberNo());
				pstmt.setString(3, dto.getArticleTitle());
				pstmt.setString(4, dto.getKeywordCode());
				pstmt.setString(5, dto.getAritcleContent());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("[Board Dao insert] return:" + result);
			return result;
		}

		
		public int update(Connection conn, ArticleDto dto) {
			System.out.println("[Board Dao update] dto:" + dto);
			int result = -1;  // update 경우 0도 정상 결과값일 수 있으므로 -1을 초기값
			String query = "update board set BRE_STEP = BRE_STEP + 1 where BRE_STEP > (select bre_step from board where bno=?)  and BREF = (select bref from board where bno=?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, dto.getArticleCode());
				pstmt.setInt(2, dto.getArticleCode());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("[Board Dao update] return:" + result);
			return result;
		}
		

		// 한 행 삭제 - 주로 PK로 where조건
		public int delete(Connection conn, int articleCode) {
			System.out.println("[Board Dao delete] articleCode:" + articleCode);
			int result = 0;
			// TODO
			System.out.println("[Board Dao delete] return:" + result);
			return result;
		}
	//// 추가
		// 페이징 처리(pageSize!=0아닐때) + 검색(있다면 where처리)
		public int getTotalCount(Connection conn, String searchWord) {
			System.out.println("[Board Dao getTotalCount] searchWord:" + searchWord);

			int result = 0;
			String query = "select count(*) cnt from tb_board ";
			if (searchWord != null) { // 검색(있다면 where처리)
				query += " where btitle like ? or bcontent like ? or mid like ? ";
				searchWord = "%" + searchWord + "%";
			}
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				if (searchWord != null) { // 검색(있다면 where처리)
					pstmt.setString(1, searchWord);
					pstmt.setString(2, searchWord);
					pstmt.setString(3, searchWord);
				}
				rs = pstmt.executeQuery();

				if (rs.next()) {
					result = rs.getInt("cnt");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("[Board Dao getTotalCount] return:" + result);
			return result;
		}

		public List<ArticleListDto> selectList(Connection conn, int currentPage, int pageSize, int totalCount,
				String searchWord) {
			System.out.println("[Board Dao selectList] currentPage:" + currentPage + ",pageSize:" + pageSize + ",totalCount:"
					+ totalCount + ",searchWord:" + searchWord);

			// 페이징처리 방정식
			int startRownum = 0;
			int endRownum = 0;
			if (pageSize > 0) { // 페이징 처리(pageSize!=0아닐때)
				startRownum = (currentPage - 1) * pageSize + 1;
				endRownum = ((currentPage * pageSize) > totalCount) ? totalCount : (currentPage * pageSize);
				System.out.println("startRownum:" + startRownum + ", endRownum:" + endRownum);
			}

			List<ArticleListDto> result = new ArrayList<ArticleListDto>();
			String subquery = " select ARTICLE_CODE, ARTICLE_TITLE, to_char(ARTICLE_TIME, 'yyyy-mm-dd hh24:mi:ss') ARTICLE_TIME, MEMBER_ID, KEYWORD_CODE from TB_BOARD ";
			if (searchWord != null) { // 검색(있다면 where처리)
				subquery += " where ARTICLE_TITLE like ? or ARTICLE_CONTENT like ? or MEMBER_ID like ? ";
				searchWord = "%" + searchWord + "%";
			}
			subquery += " order by ARTICLE_TIME"; // 정렬순서
			String query = subquery;
			if (pageSize > 0) { // 페이징 처리(pageSize!=0아닐때)
				query = " select * from ( select ROWNUM rnum, tb1.* from " + "(" + subquery + ") tb1 " + " )";
				query += " where rnum between ? and ?";
			}

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				if (searchWord != null) { // 검색(있다면 where처리)
					pstmt.setString(1, searchWord);
					pstmt.setString(2, searchWord);
					pstmt.setString(3, searchWord);
				}
				if (searchWord != null && pageSize > 0) { // 검색(있다면 where처리) // 페이징 처리(pageSize!=0아닐때)
					pstmt.setInt(4, startRownum);
					pstmt.setInt(5, endRownum);
				} else if (searchWord == null && pageSize > 0) {// 페이징 처리(pageSize!=0아닐때)
					pstmt.setInt(1, startRownum);
					pstmt.setInt(2, endRownum);
				}
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
//					BNO         NOT NULL NUMBER         
//					BTITLE      NOT NULL VARCHAR2(300)  
//					BCONTENT             VARCHAR2(4000) 
//					BWRITE_DATE NOT NULL TIMESTAMP(6)   
//					MID         NOT NULL VARCHAR2(20)   
//					BREF        NOT NULL NUMBER         
//					BRE_LEVEL   NOT NULL NUMBER         
//					BRE_STEP    NOT NULL NUMBER
					ArticleListDto dto = new ArticleListDto(
							rs.getInt("ARTICLE_CODE"),
							rs.getString("MEMBER_NO"),
							rs.getString("ARTICLE_TITLE"),
							rs.getString("KEYWORD_CODE"),
							rs.getString("ARTICLE_TIME")					
							);
					result.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			System.out.println("[Board Dao selectList] return:" + result);
			return result;
		}
		
		
		// 첨부파일들 저장
		public int insertAttachFileList(Connection conn, List<AattachFileDto> dtoList, int articleCode) {
			System.out.println("[Board Dao insertAttachFileList] dto:" + dtoList+", articleCode:"+articleCode);
			int result = 0;
			String query = "";
			query = "insert all ";
			for(int i=0; i<dtoList.size(); i++) {
				query += " into ATTACH_FILE (FILEPATH, ARTICLE_CODE) values (?, ?) ";
			}
			query += " select * from dual ";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				for(int i=0; i<dtoList.size(); i++) {
					pstmt.setString((2*i)+1, dtoList.get(i).getAfilePath());
					pstmt.setInt((2*i)+2, articleCode);
				}
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("[Board Dao insertAttachFileList] return:" + result);
			return result;
		}
		
		public int getSeqBoardArticleCodeNexVal(Connection conn) {
			System.out.println("[Board Dao getSeqBoardArticleCodeNexVal] ");
			int result = 0;
			String query ="select SEQ_TB_BOARD_ARTICLE_CODE.nextval articleCodenextval from dual";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt("articleCodenextval");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			System.out.println("[Board Dao getSeqBoardArticleCodeNexVal] return:" + result);
			return result;
		}
		
		// 첨부파일들 읽기
		public List<AattachFileDto> selectAttachFileList(Connection conn, int articleCode) {
			System.out.println("[Board Dao selectOne] articleCode:" + articleCode);
			List<AattachFileDto> result = new ArrayList<AattachFileDto>();
			String query = " select filepath from ARTICLE_FILE ";
			query += " where ARTICLE_CODE=?"; 

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, articleCode);
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
					AattachFileDto dto = new AattachFileDto(rs.getString("afilePath"));
					result.add(dto);
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

	}
