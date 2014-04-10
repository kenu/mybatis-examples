package mybatis;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.example.Blog;
import org.mybatis.example.BlogMapper;


/**
 * http://mybatis.github.io/mybatis-3/ko/getting-started.html
 * @author kenu
 *
 */
public class MyBatisGSTest {

	public static void main(String[] args) throws IOException {
		DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development",
				transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(BlogMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(configuration);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  BlogMapper mapper = session.getMapper(BlogMapper.class);
		  Blog blog = mapper.selectBlog(1);
		  System.out.println(blog);
		} finally {
		  session.close();
		}
	}

}
