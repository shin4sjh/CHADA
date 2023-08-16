package jh.chada.jdbc.store.model.dao;

import static jh.chada.jdbc.common.temp.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jh.chada.jdbc.store.file.model.dto.SattachFileDto;
import jh.chada.jdbc.store.model.dto.StoreItemDto;
import jh.chada.jdbc.store.model.dto.StoreOrderDto;

public class StoreDao {
	public List<StoreItemDto> selectList(Connection conn) {
		System.out.println("[Store Dao selectList]");
		List<StoreItemDto> result = new ArrayList<StoreItemDto>();

		String query = " select price_code, sell_no, sell_name, sell_stock, price_unit, price_cup, price_pot "
				+ " from tb_sell ts join tb_price tp using(price_code) ";
		query += " order by SELL_NO "; // 정렬순서

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				StoreItemDto dto = new StoreItemDto(rs.getInt("SELL_NO"), rs.getString("SELL_NAME"),
						rs.getInt("SELL_STOCK"), rs.getString("PRICE_CODE"), 
						rs.getInt("price_unit"), rs.getInt("price_cup"), rs.getInt("price_pot"));
				
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Store Dao selectList] return:" + result);
		return result;
	}

	// 한 행 읽기 - PK로where조건
	public StoreItemDto selectItem(Connection conn, int sellNo) {
		System.out.println("[StoreDao Dao selectOne] sellNo:" + sellNo);
		StoreItemDto result = null;
		String query = " select price_code, sell_no, sell_name, sell_stock, price_unit, price_cup, price_pot "
				+ " from tb_sell ts join tb_price tp using(price_code) ";
		query += " where SELL_NO=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sellNo);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				result = new StoreItemDto(rs.getInt("SELL_NO"), rs.getString("SELL_NAME"),
						rs.getInt("SELL_STOCK"), rs.getString("PRICE_CODE"), 
						rs.getInt("price_unit"), rs.getInt("price_cup"), rs.getInt("price_pot"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[StoreDao Dao selectOne] return:" + result);
		return result;
	}

//		order

	public StoreOrderDto selectOrder(Connection conn, int orderNo) {
		System.out.println("[StoreDao Dao selectOne] bno:" + orderNo);
		StoreOrderDto result = null;
		String query = " select ORDER_NO, ORDER_NAME, ORDER_ADDRESS, ORDER_PHONE_NUMBER, ORDER_REQUEST, ORDER_PRICE, to_char(ORDER_TIME, 'yyyy-mm-dd hh24:mi:ss') ORDER_TIME, MEMBER_NO from TB_ORDER ";
		query += " where ORDER_NO=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNo);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				result = new StoreOrderDto(rs.getInt("ORDER_NO"), rs.getString("ORDER_NAME"),
						rs.getString("ORDER_ADDRESS"), rs.getString("ORDER_PHONE_NUMBER"),
						rs.getString("ORDER_REQUEST"), rs.getInt("ORDER_PRICE"), rs.getString("ORDER_TIME"),
						rs.getString("MEMBER_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[StoreDao Dao selectOne] return:" + result);
		return result;
	}

	public int insert(Connection conn, StoreOrderDto dto, int nextval) {
		System.out.println("[StoreDao Dao insert] dto:" + dto + ", " + nextval);
		int result = 0;
		String query = "";
		query = "insert into BOARD values (?, ?, ?, ?, ?, ?, default, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nextval);
			pstmt.setString(2, dto.getOrderName());
			pstmt.setString(3, dto.getOrderAddress());
			pstmt.setString(4, dto.getOrderPhoneNumber());
			pstmt.setString(5, dto.getOrderRequest());
			pstmt.setInt(6, dto.getOrderPrice());
			pstmt.setString(7, dto.getMemberNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[StoreDao Dao insert] return:" + result);
		return result;
	}

	public int insertAttachFileList(Connection conn, List<SattachFileDto> dtoList, int bno) {
		System.out.println("[StoreDao Dao insertAttachFileList] dto:" + dtoList + ", bno:" + bno);
		int result = 0;
		String query = "";
		query = "insert all ";
		for (int i = 0; i < dtoList.size(); i++) {
			query += " into SATTACH_FILE (FILEPATH, BNO) values (?, ?) ";
		}
		query += " select * from dual ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			for (int i = 0; i < dtoList.size(); i++) {
				pstmt.setString((2 * i) + 1, dtoList.get(i).getFilePath());
				pstmt.setInt((2 * i) + 2, bno);
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[StoreDao Dao insertAttachFileList] return:" + result);
		return result;
	}

	public int getSeqBoardBnoNexVal(Connection conn) {
		System.out.println("[StoreDao Dao getSeqBoardBnoNexVal] ");
		int result = 0;
		String query = "select SEQ_BOARD_BNO.nextval bnonextval from dual";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("bnonextval");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[StoreDao Dao getSeqBoardBnoNexVal] return:" + result);
		return result;
	}
	
	public int getTotalCount(Connection conn, String searchWord) {
		System.out.println("[Board Dao getTotalCount] searchWord:" + searchWord);

		int result = 0;
		String query = "select count(*) cnt from tb_board ";
		if (searchWord != null) { // 검색(있다면 where처리)
			query += " where SELL_NAME ? ";
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

	public List<StoreItemDto> selectList(Connection conn, int currentPage, int pageSize, int totalCount,
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

		List<StoreItemDto> result = new ArrayList<StoreItemDto>();
		String subquery =  " select price_code, sell_no, sell_name, sell_stock, price_unit, price_cup, price_pot "
				+ " from tb_sell ts join tb_price tp using(price_code) ";
		if (searchWord != null) { // 검색(있다면 where처리)
			subquery += " where SELL_NAME ? ";
			searchWord = "%" + searchWord + "%";
		}
		subquery += " order by SELL_NO desc, PRICE_CODE asc"; // 정렬순서
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

				StoreItemDto dto =  new StoreItemDto(rs.getInt("SELL_NO"), rs.getString("SELL_NAME"),
						rs.getInt("SELL_STOCK"), rs.getString("PRICE_CODE"), 
						rs.getInt("price_unit"), rs.getInt("price_cup"), rs.getInt("price_pot"));
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

	// 첨부파일들 읽기
	public List<SattachFileDto> selectAttachFileList(Connection conn, int bno) {
		System.out.println("[StoreDao Dao selectAttachFileList] bno:" + bno);
		List<SattachFileDto> result = new ArrayList<SattachFileDto>();
		String query = " select file_path from sell_file ";
		query += " where sell_no=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				SattachFileDto dto = new SattachFileDto(rs.getString("file_path"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[StoreDao Dao selectAttachFileList] return:" + result);
		return result;
	}

}
