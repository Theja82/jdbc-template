import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class insertdata_jdbctemplate {
	public static void main(String[] args) {
		String s = "insert into user values(2,'theja',667837666,'pas4s')";
		ApplicationContext c = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = c.getBean("jdbcTemplate", JdbcTemplate.class);
		template.execute(s);
		System.out.println("row inserted");
		System.out.println(template);
	}

}
