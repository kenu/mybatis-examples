package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.Blog;
import org.mybatis.example.BlogMapper;

/**
 * http://mybatis.github.io/mybatis-3/ko/getting-started.html
 * @author kenu
 *
 */
public class MyBatisGSTest {

	public static void main(String[] args) throws IOException {
		String resource = "org/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
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
