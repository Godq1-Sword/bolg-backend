package bolg.rocketmq.uitl;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author God_q1
 * date 2020/7/3
 * description RocketMQ配置中心
 */
public class ConfigCentre {
	// 注册中心集群
	public static AtomicReference<List<String>> nameSrvAddrs = null;

	public static void setNameSrvAddrs(List<String> nameSrvAddrs) {
		ConfigCentre.nameSrvAddrs.set(nameSrvAddrs);
	}
}
