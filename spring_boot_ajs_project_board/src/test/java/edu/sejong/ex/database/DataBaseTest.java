package edu.sejong.ex.database;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class DataBaseTest {

	
	@Autowired
	private DataSource dataSource;
	
	@Disabled
	@Test
	@DisplayName("커넥션 풀 테스트")
	void testConnectionPool() throws SQLException {
		log.info("커넥션풀 테스트..");
		log.info("DS = {}", dataSource);
		log.info("GetConnection!! {}", dataSource.getConnection());
	}
	
	@Test
	@DisplayName("커넥션 테스트")
	void testConnection() throws SQLException {
		Connection conn = dataSource.getConnection() ;
		log.info("GetConnection!! {}", conn);
		
		assertThat(conn).isInstanceOf(Connection.class);
		assertEquals(100, getLong(conn,"select 100 from dual"));
	}
	public long getLong(Connection conn, String sql) {
		long result = 0;
		try (Statement stmt= conn.createStatement();){
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next()) {
					result = rs.getLong(1);
				}
			
		} catch (Exception e) {
		}
		return result;
	}
}
