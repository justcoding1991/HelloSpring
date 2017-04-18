package SpringJDBC;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@MapperScan("SpringJDBC.dao.PersonMapper")
public class PersonConfig {

}
