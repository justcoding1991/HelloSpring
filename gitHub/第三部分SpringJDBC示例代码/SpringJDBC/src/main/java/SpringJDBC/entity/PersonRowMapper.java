package SpringJDBC.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper {

	public Object mapRow(ResultSet set, int arg1) throws SQLException {
		  Person person = new Person(set.getInt("id"), set.getString("name"), set
	                .getInt("age"), set.getString("sex"));
	        return person;
	}

}
