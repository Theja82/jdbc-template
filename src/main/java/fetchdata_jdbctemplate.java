import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class fetchdata_jdbctemplate {
	public static void main(String[] args) {
		String qry = "select * from user";
		ApplicationContext c = new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate template = c.getBean("jdbcTemplate", JdbcTemplate.class);
		List<User> users=template.query(qry, new myresultsetextractor());
		for(User u:users) {
			System.out.println("id"+u.getId());
			System.out.println("name"+u.getName());
			System.out.println("phone"+u.getPhone());
			System.out.println("password"+u.getPassword());
			System.out.println("=========================");

		}
	}
}

class myresultsetextractor implements ResultSetExtractor<List<User>> {

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPhone(rs.getLong("phone"));
			u.setPassword(rs.getString("password"));
			users.add(u);

		}
		return users;
	}

}
