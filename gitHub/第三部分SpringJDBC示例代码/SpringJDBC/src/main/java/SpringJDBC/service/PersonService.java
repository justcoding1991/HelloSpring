package SpringJDBC.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import SpringJDBC.entity.Person;

public interface PersonService {
	
	/**
     * 新增Person
     * 
     * @param person
*/
    public  void save(Person person);

    /**
     * 更新Person
     * 
     * @param person
*/
    public  void update(Person person);

    /**
     * 通过ID得到用户信息Person
     * 
     * @param id
     * @return
*/
    public  Person getPerson(Integer id);

    /**
     * 得到所有的用户信息
     * 
     * @return
*/
    public  List getPersonAll();

    /**
     * 根据ID 删除用户信息
     * 
     * @param id
     */
    public  void delete(Integer id);

    /**
     * 通过ID得到人员信息
     */
    public Person getuser(int id);
    


}
