import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class update_jdbctemplate_placeholder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("update user set name=?,phone=?,password=? where id=?");
		String q = "update user set name=?,phone=?,password=? where id=?";
		int id = s.nextInt();
		String name = s.next(), password = s.next();
		long phone = s.nextLong();
		ApplicationContext c = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = c.getBean("jdbcTemplate", JdbcTemplate.class);
		int r = template.update(q, name, phone, password, id);
		if (r == 1) {
			System.out.println("row inserted");
		} else {
			System.out.println("invalid id");
		}
		System.out.println(template);
	}

}
