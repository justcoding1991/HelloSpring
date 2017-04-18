package SpringJDBC.common;

import org.mybatis.spring.SqlSessionTemplate;

public class BaseDao {
	protected SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

}
