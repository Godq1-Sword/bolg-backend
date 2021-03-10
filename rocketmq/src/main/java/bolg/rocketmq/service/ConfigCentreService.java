package bolg.rocketmq.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author God_q1
 * date 2020/7/3
 * description 配置中心Service
 */
@Service
public interface ConfigCentreService {
	/**
	 * 方法简述:更新配置文件
	 *
	 * @param nameSrvAddrs 注册中心集群
	 * @author gdq date 2020/7/3
	 */
	void updateConfigCentre(List<String> nameSrvAddrs);
}
