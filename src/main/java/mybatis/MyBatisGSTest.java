package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.Blog;
import org.mybatis.example.BlogMapper;

public class MyBatisGSTest {

	public static void main(String[] args) throws IOException {
		String resource = "org/mybatis/example/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  BlogMapper mapper = session.getMapper(BlogMapper.class);
		  Blog blog = mapper.selectBlog(101);
		} finally {
		  session.close();
		}
	}

}
