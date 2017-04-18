package SpringJDBC.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import SpringJDBC.entity.Person;

public class PersonDaoImpl extends SqlSessionDaoSupport {
	  
	  public SqlSessionFactory sqlSessionFactory;
	  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	        // TODO Auto-generated method stub
	       super.setSqlSessionFactory(sqlSessionFactory);
	  }
	  
	  public Person getPersonSupport(int id) {
	        return this.getSqlSession().selectOne("SpringJDBC.dao.PersonMapper.getuser", id);
	    }

}
