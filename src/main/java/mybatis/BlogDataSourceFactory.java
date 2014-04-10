package mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class BlogDataSourceFactory {

	public static DataSource getBlogDataSource() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/javatest";
		String username = "javauser";
		String password = "javadude";
		DataSource ds = new PooledDataSource(driver, url, username, password);
		return ds;
	}

}
