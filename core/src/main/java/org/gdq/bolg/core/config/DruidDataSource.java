package org.gdq.bolg.core.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.UUID;

/**
 * @author gdq
 * date 2020/7/7
 * description druid数据源
 */

public class DruidDataSource {
	/**
	 * description 创建数据源
	 *
	 * @return DataSource
	 * @author gdq date 2020/7/7
	 */
//	@Primary
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.druid")
	public DataSource dataSource() {
		return DruidDataSourceBuilder.create().build();
	}
}
