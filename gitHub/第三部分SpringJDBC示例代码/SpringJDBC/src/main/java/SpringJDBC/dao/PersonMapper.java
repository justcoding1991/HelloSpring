package SpringJDBC.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import SpringJDBC.entity.Person;

@Repository
public interface PersonMapper {
	public Person getPersonById(int i);
	public List<Person> getPersonAll();
	public Person getuser(int id);
}
