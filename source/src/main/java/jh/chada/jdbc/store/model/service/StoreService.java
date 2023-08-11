package jh.chada.jdbc.store.model.service;

import static jh.chada.jdbc.common.temp.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import jh.chada.jdbc.store.file.model.dto.SattachFileDto;
import jh.chada.jdbc.store.model.dao.StoreDao;
import jh.chada.jdbc.store.model.dto.StoreItemDto;

public class StoreService {

	private StoreDao dao = new StoreDao();
	
	public List<StoreItemDto> selectList(){
		List<StoreItemDto> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		for(int i=0; i<result.size(); i++) {
			List<SattachFileDto> fileList = dao.selectAttachFileList(conn, result.get(i).getSellNo());
			result.get(i).setSattachFileList(fileList);
		}
		close(conn);
		System.out.println("[StoreService selectList] " + result);
		return result;
	}
	// 한 행 읽기 - PK로where조건
	public StoreItemDto selectItem(int sellNo ){
		StoreItemDto result = null;
		Connection conn = getConnection();
		result = dao.selectItem(conn, sellNo);
		if(result != null) {
			// 첨부파일들 읽어서 result에 넣기
			List<SattachFileDto> fileList = dao.selectAttachFileList(conn, sellNo);
			result.setSattachFileList(fileList);
		}
		close(conn);
		return result;
	}
//	// 한 행 삽입 - BoardDto 자료형을 받아와야 함.
//	public int insert(StoreItemDto dto, List<SattachFileDto> fileList){
//		int result = 0;
//		Connection conn = getConnection();
//		setAutoCommit(conn, false);
//		result = dao.insert(conn, dto);
//		if(fileList!=null && fileList.size()>0) {
//			result = dao.insertAttachFileList(conn, fileList, nextval);
//		}
//		if(result > 0) {
//			commit(conn);
//		} else {
//			rollback(conn);
//		}
//		close(conn);
//		return result;
//	}
//	// 한 행 수정 - BoardDto 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
//	public int update(StoreItemDto dto){
//		int result = 0;
//		Connection conn = getConnection();
//		result = dao.update(conn, dto);
//		close(conn);
//		return result;
//	}
//	// 한 행 삭제 - 주로 PK로 where조건
//	public int delete(int bno){
//		int result = 0;
//		Connection conn = getConnection();
//		result = dao.delete(conn, bno);
//		close(conn);
//		return result;
//	}
	
	//// 추가 
	// 페이징 처리 + 검색
//	public int getTotalCount() {
//		int result = 0;
//		Connection conn = getConnection();
//		result = dao.getTotalCount(conn);
//		close(conn);
//		return result;
//	}
//	public List<StoreItemDto> selectList(int currentPage, int pageSize, String searchWord){
//		List<StoreItemDto> result = null;
//		Connection conn = getConnection();
//		int totalCount = getTotalCount(searchWord);
//		result = dao.selectList(conn, currentPage, pageSize, totalCount, searchWord);
//		close(conn);
//		return result;
//	}
}
