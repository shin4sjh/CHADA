package jh.chada.jdbc.login.controller.model.dao;

import static jh.chada.jdbc.common.temp.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jh.chada.jdbc.login.controller.model.dto.LoginDto;
import jh.chada.jdbc.login.controller.model.dto.Member;

public class MemberDao {
	// 모든 행 읽기
	public List<Member> selectList(Connection conn) {
		System.out.println("[Member Dao selectList]");
		List<Member> result = new ArrayList<Member>();
		String query = "select * from tb_member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next() == true) {
				Member dto = new Member(rs.getString("MEMBER_NO"), rs.getString("MEMBER_ID"),
						rs.getString("MEMBER_PASSWORD"), rs.getString("MEMBER_RANK"),
						rs.getString("MEMEBER_PHONE_NUMBER"), rs.getString("MEMEBER_PHONE_NUMBER2"),
						rs.getString("MEMBER_EMAIL"), rs.getString("MEMBER_EMAIL2"), rs.getString("MEMBER_SIGN_DATE"),
						rs.getString("MEMBER_NAME"), rs.getInt("MEMBER_GENDER"), rs.getString("MEMBER_BIRTH"),
						rs.getString("ADDRESS"), rs.getString("ADDRESS2"));
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Member Dao selectList] return:" + result);
		return result;
	}

	// 한 행 읽기 - PK로where조건
	public Member selectOne(Connection conn, String memberNo) {
		System.out.println("[Member Dao selectOne] bno:" + memberNo);
		Member result = null;
		String query = "select MEMBER_NO,MEMBER_ID,MEMBER_PASSWORD,MEMBER_RANK,MEMEBER_PHONE_NUMBER,MEMEBER_PHONE_NUMBER2,MEMBER_EMAIL,MEMBER_EMAIL2,MEMBER_SIGN_DATE,MEMBER_NAME,MEMBER_GENDER,MEMBER_BIRTH,ADDRESS,ADDRESS2 from tb_member where MEMBER_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new Member(rs.getString("MEMBER_NO"), rs.getString("MEMBER_ID"),
						rs.getString("MEMBER_PASSWORD"), rs.getString("MEMBER_RANK"), rs.getString("MEMEBER_PHONE_NUMBER"), rs.getString("MEMEBER_PHONE_NUMBER2"), rs.getString("MEMBER_EMAIL"), rs.getString("MEMBER_EMAIL2"), rs.getString("MEMBER_SIGN_DATE"), rs.getString("MEMBER_NAME"), rs.getInt("MEMBER_GENDER"), rs.getString("MEMBER_BIRTH"), rs.getString("ADDRESS"), rs.getString("ADDRESS2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("[Member Dao selectOne] return:"+result);
		return result;
	}

	

	// 한 행 삽입 - Member 자료형을 받아와야 함.
	public int insert(Connection conn, Member dto) {
		System.out.println("[Member Dao insert] dto:" + dto);
		int result = 0;
		// TODO
		String query = "insert into tb_member MEMBER_NO,MEMBER_ID,MEMBER_PASSWORD,MEMBER_RANK,MEMEBER_PHONE_NUMBER,MEMEBER_PHONE_NUMBER2,MEMBER_EMAIL,MEMBER_EMAIL2,MEMBER_SIGN_DATE,MEMBER_NAME,MEMBER_GENDER,MEMBER_BIRTH,ADDRESS,ADDRESS2"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			result = pstmt.executeUpdate();
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dto.getMemberNo());
				pstmt.setString(2, dto.getMemberId());
				pstmt.setString(3, dto.getMemberPassword());
				pstmt.setString(4, dto.getMemberRank());
				pstmt.setString(5, dto.getMemberPhoneNumber());
				pstmt.setString(6, dto.getMemberPhoneNumber2());
				pstmt.setString(7, dto.getMemberEmail());
				pstmt.setString(8, dto.getMemberEmail2());
				pstmt.setString(9, dto.getMemberSignDate());
				pstmt.setString(10, dto.getMemberName());
				pstmt.setInt(11, dto.getMemberGender());
				pstmt.setString(12, dto.getMemberBirth());
				pstmt.setString(13, dto.getAddress());
				pstmt.setString(14, dto.getAddress2());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Member Dao insert] return:" + result);
		return result;
	}

	// 한 행 수정 - Member 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
	public int update(Connection conn, Member dto) {
		System.out.println("[Member Dao update] dto:" + dto);
		int result = -1;
		// TODO
		String query = "";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Member Dao update] return:" + result);
		return result;
	}

	// 한 행 삭제 - 주로 PK로 where조건
	public int delete(Connection conn, int bno) {
		System.out.println("[Member Dao delete] bno:" + bno);
		int result = 0;
		// TODO
		System.out.println("[Member Dao delete] return:" + result);
		return result;
	}

	// 추가
	// login : 성공 :1, 실패시:0 --> 암호화 적용 힘든 방식
	public int login(Connection conn, LoginDto vo) {
		System.out.println("[Member Dao login] vo:" + vo);

		int result = 0;
		String query = "select count(*) cnt from member where memberId=? and memberPassword=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getMemberId());
			pstmt.setString(2, vo.getMemberPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// result = rs.getInt(1);
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Member Dao login] return:" + result);
		return result;
	}

	// login : mpwd를 return 함. id 존재하지 않으면 return null
	public String login(Connection conn, String memberId) {
		System.out.println("[Member Dao login] mid:" + memberId);

		String result = null;
		String query = "select memberPassword from member where memberId=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("memberId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("[Member Dao login] return:" + result);
		return result;
	}
}