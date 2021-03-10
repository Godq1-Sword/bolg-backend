package bolg.core.service.impl;

import org.gdq.bolg.core.CoreApplication;
import org.gdq.bolg.core.model.po.UserPO;
import org.gdq.bolg.core.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest(classes = CoreApplication.class)
class UserServiceImplTest {

	@Resource
	UserService userService;

	@Test
	void queryUserByUsername() {
	}

	@Test
	void insertUser() {
		UserPO userPO = new UserPO();
		userPO.setUsername("admin");
		userPO.setPassword("admin");
		boolean bool = userService.insertUser(userPO);
		if (bool)
			System.out.println(userPO.getId());
	}
}