package SpringJDBC.service;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import SpringJDBC.dao.PersonMapper;
import SpringJDBC.entity.Person;
import SpringJDBC.entity.PersonRowMapper;

@Service
public class PersonServiceImpl implements PersonService{
	
	    /**
	     * 定义dataSource
	     */
		
		private DataSource dataSource;
	    /**
	     * spring的jdbcTmplate
	     */
		private JdbcTemplate jdbcTemplate;
	 
        public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

        PersonMapper personMapper;

		public PersonMapper getPersonMapper() {
			return personMapper;
		}

		public void setPersonMapper(PersonMapper personMapper) {
			this.personMapper = personMapper;
		}

		private SqlSessionTemplate sqlSession;
	    
		public void setSqlSession(SqlSessionTemplate sqlSession) {
			this.sqlSession = sqlSession;
		}

		// 在DataSource中初始化jdbcTemplate
	     public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	    public void save(Person person) {
	        jdbcTemplate.update("insert into person(name,age,sex)values(?,?,?)",
	                new Object[] { person.getName(), person.getAge(),
	                        person.getSex() }, new int[] { java.sql.Types.VARCHAR,
	                        java.sql.Types.INTEGER, java.sql.Types.VARCHAR });
	    }

	    public void update(Person person) {
	        jdbcTemplate.update("update person set name=?,age=?,sex=? where id=?",
	                new Object[] { person.getName(), person.getAge(),
	                        person.getSex(), person.getId() }, new int[] {
	                        java.sql.Types.VARCHAR, java.sql.Types.INTEGER,
	                        java.sql.Types.VARCHAR, java.sql.Types.INTEGER });

	    }

	    public Person getPerson(Integer id) {
	        Person person = (Person) jdbcTemplate.queryForObject(
	                "select * from person where id=?", new Object[] { id },
	                new int[] { java.sql.Types.INTEGER }, new PersonRowMapper());
	        return person;

	    }

	    @SuppressWarnings("unchecked")
	    public List getPersonAll() {
	        List list = jdbcTemplate.queryForList("select count(name) from person", Person.class);
//	        jdbcTemplate.qu
	        return list;

	    }

	    public void delete(Integer id) {
	        jdbcTemplate.update("delete from person where id = ?", new Object[] { id },
	                new int[] { java.sql.Types.INTEGER });

	    }

	    public Person getuser(int id) {
			//mybatis org.mybatis.spring.mapper.MapperFactoryBean
	    	return personMapper.getPersonById(id);
//			return sqlSession.selectOne("SpringJDBC.dao.PersonMapper.getuser", id);	
	    	
		}


}
