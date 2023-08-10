package jh.chada.jdbc.login.controller.model.service;

import static jh.chada.jdbc.common.temp.JdbcTemplate.close;
import static jh.chada.jdbc.common.temp.JdbcTemplate.commit;
import static jh.chada.jdbc.common.temp.JdbcTemplate.getConnection;
import static jh.chada.jdbc.common.temp.JdbcTemplate.rollback;
import static jh.chada.jdbc.common.temp.JdbcTemplate.setAutoCommit;

import java.sql.Connection;
import java.util.List;

import jh.chada.jdbc.login.controller.model.dao.MemberDao;
import jh.chada.jdbc.login.controller.model.dto.LoginDto;
import jh.chada.jdbc.login.controller.model.dto.Member;

public class MemberService {

	
		private MemberDao dao = new MemberDao();
		
		public List<Member> selectList(){
			List<Member> result = null;
			Connection conn = getConnection();
			result = dao.selectList(conn);
			close(conn);
			return result;
		}
		// 한 행 읽기 - PK로where조건
		public Member selectOne(int boardCode){
			Member result = null;
			Connection conn = getConnection();
			result = dao.selectOne(conn, boardCode);
			close(conn);
			return result;
		}
		// 한 행 삽입 - Member 자료형을 받아와야 함.
		public int insert(Member dto){
			int result = 0;
			Connection conn = getConnection();
			result = dao.insert(conn, dto);
			close(conn);
			return result;
		}
		// 한 행 수정 - Member 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
		public int update(Member dto){
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
		
		// 추가
		// login 
		public int login(LoginDto vo) {
			int result = 0;
			Connection conn = getConnection();
			result = dao.login(conn, vo);
			close(conn);
			return result;
		}
		// login 
		public String login(String memberId) {
			String result = null;
			Connection conn = getConnection();
			result = dao.login(conn, memberId);
			close(conn);
			return result;
		}
	}