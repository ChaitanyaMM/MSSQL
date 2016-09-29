package com.mssql.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mssql.Dao.UserDao;
import com.mssql.Objects.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired(required=false)
    @Qualifier("dataSource")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	 
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// public JdbcTemplate getJdbcTemplate() {
	// return jdbcTemplate;
	// }

	// @Autowired(required =false)
	// private DataSource dataSource;
	// @Autowired(required =false)
	// private JdbcTemplate jdbcTemplate;
	//
	// public DataSource getDataSource() {
	// return dataSource;
	// }
	//
	// @Autowired

	//
	// public JdbcTemplate getJdbcTemplate() {
	// return jdbcTemplate;
	// }
	//
	//
	// public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	// this.jdbcTemplate = jdbcTemplate;
	// }

	@Override
	public String sample() {
		// System.out.println("dataSource<><<<<<<<<<<"+dataSource);
	    System.out.println("jdbcTemplate<><<<<<<<<<<" + jdbcTemplate);
		// String Sql="select * from sys.dm_exec_query_stats";
		// System.out.println(""+Sql.toString());
		// jdbcTemplate.execute(Sql);
		return "Hai Chaitu !...";
	}

	@Override
	public User add(User user) {
		System.out.println("User Dao Impl is Calling !!!!");
	//	System.out.println("jdbcjdbcTemplate is Checking <<><>><" + jdbcTemplate);
		System.out.println("dataSource @@@@@@@@@" + dataSource);
		String sql = "INSERT INTO user (id, name, age)" + " VALUES (?, ?, ?)";
		System.out.println("SQL instertion <><>" + sql);
		System.out.println("SQL age retreiving  <><>" + user.getAge());
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		insert.update(sql, user.getName(), user.getAge(), user.getId());

		// this.jdbcTemplate.update(sql, user.getName(), user.getAge(),
		// user.getId());
		return user;

	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public User get(int id) {
//		System.out.println("get in DaoIMpl is Calling !!!");
//		User user = this.jdbcTemplate.queryForObject("SELECT * FROM User WHERE ID = ?", new Object[] { 1212L },
//				new RowMapper<User>() {
//					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//						User user1 = new User();
//						user1.setId(rs.getInt("ID"));
//
//						return user1;
//					}
//				});
//		return user;
//
//	}

	// public User get(int id) {
	//
	// String sql = "SELECT * FROM User WHERE ID = ?";
	//
	// jdbcTemplate = new JdbcTemplate(dataSource);
	//
	// User user = (User) jdbcTemplate.queryForObject(
	//
	// sql, new Object[] { id }, new BeanPropertyRowMapper(User.class));
	//
	// return user;
	//
	// }

}
