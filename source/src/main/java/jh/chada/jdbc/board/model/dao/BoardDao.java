package jh.chada.jdbc.board.model.dao;

import static jh.chada.jdbc.common.temp.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jh.chada.jdbc.board.file.model.dto.BattachFileDto;
import jh.chada.jdbc.board.model.dto.BoardDto;



public class BoardDao {

		// 모든 행 읽기
		public List<BoardDto> selectList(Connection conn) {
			System.out.println("[Board Dao selectList]");
			List<BoardDto> result = new ArrayList<BoardDto>();

			String query = " select BOARD_CODE, BOARD_TITLE, to_char(BOARD_DATE, 'yyyy-mm-dd hh24:mi:ss') BOARD_DATE, MEMBER_NO, BOARD_REF, BOARD_LEVEL, BOARD_STEP, BOARD_CATEGORY, KEYWORD_CODE, TAG_NO  from TB_BOARD ";
			query += " order by BREF desc, BRE_STEP asc"; // 정렬순서

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
					BoardDto dto = new BoardDto(
							rs.getInt("BOARD_CODE"),
							rs.getString("BOARD_TITLE"),
							rs.getString("BOARD_DATE"),
							rs.getInt("BOARD_REF"),
							rs.getInt("BOARD_LEVEL"),
							rs.getInt("BOARD_STEP")	,				
							rs.getString("MEMBER_NO")	,				
							rs.getString("BOARD_CATEGORY")	,				
							rs.getString("KEYWORD_CODE"),					
							rs.getInt("TAG_NO")								
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
		public BoardDto selectOne(Connection conn, int boardCode) {
			System.out.println("[Board Dao selectOne] boardCode:" + boardCode);
			BoardDto result = null;
			String query = " select BOARD_CODE, BOARD_TITLE, to_char(BOARD_DATE, 'yyyy-mm-dd hh24:mi:ss') BOARD_DATE, MEMBER_NO, BOARD_REF, BOARD_LEVEL, BOARD_STEP, BOARD_CATEGORY, KEYWORD_CODE, TAG_NO  from TB_BOARD ";
			query += " where BOARD_CODE=?"; 

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, boardCode);
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
					result = new BoardDto(
							rs.getInt("BOARD_CODE"),
							rs.getString("BOARD_TITLE"),
							rs.getString("BOARD_CONTENT"),
							rs.getString("BOARD_DATE"),
							rs.getInt("BOARD_REF"),
							rs.getInt("BOARD_LEVEL"),
							rs.getInt("BOARD_STEP")	,				
							rs.getString("MEMBER_NO")	,				
							rs.getString("BOARD_CATEGORY")	,				
							rs.getString("KEYWORD_CODE"),					
							rs.getInt("TAG_NO")								
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

		// 한 행 삽입 - BoardDto 자료형을 받아와야 함.
		// 원본글작성
		public int insert(Connection conn, BoardDto dto, int nextval) {
			System.out.println("[Board Dao insert] ");
			int result = 0;
			String query = "";
			query = "insert into TB_BOARD values (?, ?, ?, default, ? , 0,0,?,?,?,?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, nextval);
				pstmt.setString(2, dto.getBoardTitle());
				pstmt.setString(3, dto.getBoardContent());
				pstmt.setInt(4, nextval);
				pstmt.setString(5, dto.getMemberNo());
				pstmt.setString(6, dto.getBoardCategory());
				pstmt.setString(7, dto.getKeywordCode());
				pstmt.setInt(8, dto.getTagNo());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("[Board Dao insert] return:" + result);
			return result;
		}
		// 답글작성
		public int insertReply(Connection conn, BoardDto dto, int nextval) {
			System.out.println("[Board Dao insertReply] dto:" + ", "+ nextval);
			int result = 0;
			String query = "insert into TB_BOARD values (?, ?, ?, default, (select BOARD_REF from tb_board where BOARD_CODE=?)    , (select BOARD_LEVEL+1 from tb_board where BOARD_CODE=?)    , (select BOARD_STEP+1 from tb_board where BOARD_CODE=?) ,? ,? ,? ,?  )";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, nextval);
				pstmt.setString(2, dto.getBoardTitle());
				pstmt.setString(3, dto.getBoardContent());
				pstmt.setInt(4, dto.getBoardCode());
				pstmt.setInt(5, dto.getBoardCode());
				pstmt.setInt(6, dto.getBoardCode());
				pstmt.setString(7, dto.getMemberNo());
				pstmt.setString(8, dto.getBoardCategory());
				pstmt.setString(9, dto.getKeywordCode());
				pstmt.setInt(10, dto.getTagNo());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			System.out.println("[Board Dao insertReply] return:" + result);
			return result;
		}
		// 한 행 수정 - BoardDto 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
		public int update(Connection conn, BoardDto dto) {
			System.out.println("[Board Dao update] dto:" + dto);
			int result = -1;  // update 경우 0도 정상 결과값일 수 있으므로 -1을 초기값
			String query = "update tb_board set BOARD_STEP = BOARD_STEP + 1 where BOARD_STEP > (select board_step from tb_board where BOARD_CODE=?)  and BORAD_REF = (select board_ref from tb_board where BOARD_CODE=?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, dto.getBoardCode());
				pstmt.setInt(2, dto.getBoardCode());
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
		public int delete(Connection conn,  int boardCode) {
			System.out.println("[Board Dao delete] board_code:" + boardCode);
			int result = 0;		
			String query = "delete from TB_BOARD where BOARD_CODE = ?  )";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1 , boardCode);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
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
				query += " where boardTitle like ? or boardContent like ? or memberNo like ? ";
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

		public List<BoardDto> selectList(Connection conn, int currentPage, int pageSize, int totalCount,
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

			List<BoardDto> result = new ArrayList<BoardDto>();
			String subquery = " select BOARD_CODE, BOARD_TITLE, to_char(BOARD_DATE, 'yyyy-mm-dd hh24:mi:ss') BOARD_DATE, MEMBERNO, BOARD_REF, BOARD_LEVEL, BOARD_STEP from TB_BOARD ";
			if (searchWord != null) { // 검색(있다면 where처리)
				subquery += " where BTITLE like ? or BCONTENT like ? or MID like ? ";
				searchWord = "%" + searchWord + "%";
			}
			subquery += " order by BOARD_REF desc, BOARD_STEP asc"; // 정렬순서
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

					BoardDto dto = new BoardDto(
							rs.getInt("BOARD_CODE"),
							rs.getString("BOARD_TITLE"),
							rs.getString("BWRITE_DATE"),
							rs.getInt("BOARD_REF"),
							rs.getInt("BOARD_LEVEL"),
							rs.getInt("BOARD_STEP")	,				
							rs.getString("MEMBER_NO"),
							rs.getString("BOARD_CATEGORY"),
							rs.getString("KEYWORD_CODE"),
							rs.getInt("TAG_NO")
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
		public int insertBattachFileList(Connection conn, List<BattachFileDto> dtoList, int boardCode) {
			System.out.println("[Board Dao insertAttachFileList] dto:" + dtoList+", boardCode:"+boardCode);
			int result = 0;
			String query = "";
			query = "insert all ";
			for(int i=0; i<dtoList.size(); i++) {
				query += " into ATTACH_FILE (FILEPATH, BOARD_CODE) values (?, ?) ";
			}
			query += " select * from dual ";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(query);
				for(int i=0; i<dtoList.size(); i++) {
					pstmt.setString((2*i)+1, dtoList.get(i).getBfilePath());
					pstmt.setInt((2*i)+2, boardCode);
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
		
		public int getSeqBoardBoardCodeNexVal(Connection conn) {
			System.out.println("[Board Dao getSeqBoardBoarCodeNexVal] ");
			int result = 0;
			String query ="select SEQ_BOARD_BOARD_CODE.nextval boardCodenextval from dual";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt("boardCodenextval");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			System.out.println("[Board Dao getSeqBoardBoardCodeNexVal] return:" + result);
			return result;
		}
		
		// 첨부파일들 읽기
		public List<BattachFileDto> selectBattachFileList(Connection conn, int boardCode) {
			System.out.println("[Board Dao selectOne] boardCode:" + boardCode);
			List<BattachFileDto> result = new ArrayList<BattachFileDto>();
			String query = " select bfile_path from Board_File ";
			query += " where BOARD_CODE=?"; 

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, boardCode);
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
					BattachFileDto dto = new BattachFileDto(rs.getString("bfilepath"));
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