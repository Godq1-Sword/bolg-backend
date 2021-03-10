package org.gdq.bolg.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
// SpringCache缓存开启
@EnableCaching
public class CoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}