package com.springTest.Dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.springTest.Dao.PersonDao;
import com.springTest.entity.Person;

public class PersonDaoImpl implements PersonDao {
	 private static SqlMapClient sqlMapClient = null;
	 static {
		 try{
			 Reader reader = Resources.getResourceAsReader("config/SqlMapconfig.xml");
			 sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			 reader.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
	 }
	 
	@Override
	public List<Person> queryAllPersonInfo() {
		// 查询所有的人员信息
		 List<Person> persons=null;
		         try {
		        	 persons=sqlMapClient.queryForList("queryAllPersonInfo", null);
		       } catch (SQLException e) {
		           e.printStackTrace();
		        }
		      return persons;
	}

	@Override
	public int deletePersonInfoById(int id) {
		Object object = null;
		try {
			object = sqlMapClient.delete("deletePersonInfoById", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (object==null?1:0);
	}

	
	
}
