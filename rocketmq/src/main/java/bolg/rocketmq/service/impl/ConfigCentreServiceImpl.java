package bolg.rocketmq.service.impl;

import bolg.rocketmq.service.ConfigCentreService;
import bolg.rocketmq.uitl.ConfigCentre;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author God_q1
 * date 2020/7/3
 * description 配置中心ServiceImpl
 */
@Service
public class ConfigCentreServiceImpl implements ConfigCentreService {
	@Override
	public void updateConfigCentre(List<String> nameSrvAddrs) {
		ConfigCentre.setNameSrvAddrs(nameSrvAddrs);
	}
}
