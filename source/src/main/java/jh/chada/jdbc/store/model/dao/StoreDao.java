package jh.chada.jdbc.store.model.dao;


import static jh.chada.jdbc.common.temp.JdbcTemplate.close;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jh.chada.jdbc.store.model.dto.StoreItemDto;
import jh.chada.jdbc.store.model.dto.StoreOrderDto;

public class StoreDao {
	public List<StoreItemDto> selectList(Connection conn) {
		System.out.println("[Board Dao selectList]");
		List<StoreItemDto> result = new ArrayList<StoreItemDto>();

		String query = " select SELL_NO, SELL_NAME, SELL_STOCK, PRICE_CODE from TB_SELL ";
		query += " order by SELL_NO "; // 정렬순서

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				StoreItemDto dto = new StoreItemDto(
						rs.getInt("SELL_NO"),
						rs.getString("SELL_NAME"),
						rs.getInt("SELL_STOCK"),
						rs.getString("PRICE_CODE")		
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
		public StoreItemDto selectItem(Connection conn, int sellNo) {
			System.out.println("[Board Dao selectOne] sellNo:" + sellNo);
			StoreItemDto result = null;
			String query = " select SELL_NO, SELL_NAME, SELL_STOCK, PRICE_CODE from TB_SELL ";
			query += " where SELL_NO=?"; 

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, sellNo);
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
					result = new StoreItemDto(
							rs.getInt("SELL_NO"),
							rs.getString("SELL_NAME"),
							rs.getInt("SELL_STOCK"),
							rs.getString("PRICE_CODE")				
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
		
//		order
		
		public StoreOrderDto selectOrder(Connection conn, int orderNo) {
			System.out.println("[Board Dao selectOne] bno:" + orderNo);
			StoreOrderDto result = null;
			String query = " select ORDER_NO, ORDER_NAME, ORDER_ADDRESS, ORDER_PHONE_NUMBER, ORDER_REQUEST, ORDER_PRICE, to_char(ORDER_TIME, 'yyyy-mm-dd hh24:mi:ss') ORDER_TIME, MEMBER_NO from TB_ORDER ";
			query += " where BNO=?"; 

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, orderNo);
				rs = pstmt.executeQuery();

				while (rs.next() == true) {
					result = new StoreOrderDto(
							rs.getInt("ORDER_NO"),
							rs.getString("ORDER_NAME"),
							rs.getString("ORDER_ADDRESS"),
							rs.getString("ORDER_PHONE_NUMBER"),
							rs.getString("ORDER_REQUEST"),
							rs.getInt("ORDER_PRICE"),
							rs.getString("ORDER_TIME"),
							rs.getString("MEMBER_NO")					
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
		
		public int insert(Connection conn, StoreOrderDto dto, int nextval) {
			System.out.println("[Board Dao insert] dto:" + dto + ", "+ nextval);
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
			System.out.println("[Board Dao insert] return:" + result);
			return result;
		}
		
	
}
