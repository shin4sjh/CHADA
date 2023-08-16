package jh.chada.jdbc.board.model.service;

import static jh.chada.jdbc.common.temp.JdbcTemplate.close;
import static jh.chada.jdbc.common.temp.JdbcTemplate.getConnection;
import static jh.chada.jdbc.common.temp.JdbcTemplate.setAutoCommit;
import static jh.chada.jdbc.common.temp.JdbcTemplate.commit;
import static jh.chada.jdbc.common.temp.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import jh.chada.jdbc.board.file.model.dto.BattachFileDto;
import jh.chada.jdbc.board.model.dao.BoardDao;
import jh.chada.jdbc.board.model.dto.BoardDto;



public class BoardService {
	
	
		private BoardDao dao = new BoardDao();
		
		public List<BoardDto> selectList(){
			List<BoardDto> result = null;
			Connection conn = getConnection();
			result = dao.selectList(conn);
			close(conn);
			return result;
		}
		// 한 행 읽기 - PK로where조건
		public BoardDto selectOne(int boardCode){
			BoardDto result = null;
			Connection conn = getConnection();
			result = dao.selectOne(conn, boardCode);
			if(result != null) {
				// 첨부파일들 읽어서 result에 넣기
				List<BattachFileDto> fileList = dao.selectBattachFileList(conn, boardCode);
				result.setBattachFileList(fileList);
			}
			close(conn);
			return result;
		}
		// 한 행 삽입 - BoardDto 자료형을 받아와야 함.
		public int insert(BoardDto dto, List<BattachFileDto> fileList){
			int result = 0;
			Connection conn = getConnection();
			setAutoCommit(conn, false);
			int nextval = dao.getSeqBoardCodeNexVal(conn);
			if(dto.getBoardCode() == 0) { // 원본글작성
				result = dao.insert(conn, dto, nextval);
				if(fileList!=null && fileList.size()>0) {
					result = dao.insertBattachFileList(conn, fileList, nextval);
				}
			}else {   // 답글작성
				result = dao.update(conn, dto);
				if(result > -1) {
					result = dao.insertReply(conn, dto, nextval);
				}
				if(fileList!=null && fileList.size()>0) {
					result = dao.insertBattachFileList(conn, fileList, nextval);
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
		public int update(BoardDto dto){
			int result = 0;
			Connection conn = getConnection();
			result = dao.update(conn, dto);
			close(conn);
			return result;
		}
		// 한 행 삭제 - 주로 PK로 where조건
		public int delete(int boardCode){
			int result = 0;
			Connection conn = getConnection();
			result = dao.delete(conn, boardCode);
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
		public List<BoardDto> selectList(int currentPage, int pageSize, String searchWord){
			List<BoardDto> result = null;
			Connection conn = getConnection();
			int totalCount = getTotalCount(searchWord);
			result = dao.selectList(conn, currentPage, pageSize, totalCount, searchWord);
			close(conn);
			return result;
		}
	}
	