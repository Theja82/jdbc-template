import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class test_jdbc_template {

	public static void main(String[] args) {
		String s = "create table user(id int not null,name varchar(25) not null ,phone bigint(20) not null unique,password varchar(25) not null,primary key(id))";
		ApplicationContext c = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = c.getBean("jdbcTemplate", JdbcTemplate.class);
		template.execute(s);
		System.out.println("table created");
		System.out.println(template);
	}

}
