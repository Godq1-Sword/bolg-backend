package bolg.rocketmq.controller;

import bolg.rocketmq.uitl.ConfigCentre;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author God_q1
 * date 2020/7/3
 * description
 */
@RestController
@RequestMapping("/rocketmq/config")
public class ConfigCentreController {

	@PutMapping
	public void updateConfigCentre(List<String> nameSrvAddrs) {
		ConfigCentre.setNameSrvAddrs(nameSrvAddrs);
	}
}
