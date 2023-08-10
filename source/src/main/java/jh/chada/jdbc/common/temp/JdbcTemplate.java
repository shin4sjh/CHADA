package jh.chada.jdbc.common.temp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTemplate {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		Properties prop = new Properties();
		String currentPath = JdbcTemplate.class.getResource("/jh/chada/jdbc/common/driver").getPath();
		System.out.println("currentPath: "+currentPath);
//		currentPath: /C:/workspace/java/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/20230721_jdbc_kh/WEB-INF/classes/kh/test/jdbckh/common/jdbc/
		try {
			// driver.properties 파일 로딩함.
			prop.load(new BufferedReader(new FileReader(currentPath+"driver.properties")));
			// 1. driver 있다면 로딩함. // 없다면 ClassNotFoundException 오류 발생
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("jdbc.driver"));
			// 2. Connection 객체 생성 // dbms와 연결
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");
			conn = DriverManager.getConnection(prop.getProperty("jdbc.url"),prop.getProperty("jdbc.username"),prop.getProperty("jdbc.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(conn!=null) {
			System.out.println("DB 연결 성공");
		}else {
			System.out.println("DB 연결 실패");
		}
		return conn;
	}
	public static void close(Connection con) {
		try {
			if(con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if(rset!=null) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setAutoCommit(Connection conn, boolean auto) {
		try {
			conn.setAutoCommit(auto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}