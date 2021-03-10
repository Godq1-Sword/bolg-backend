package bolg.rocketmq.service.impl;

import bolg.rocketmq.service.TopicService;
import bolg.rocketmq.uitl.ConfigCentre;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.springframework.util.ObjectUtils;

/**
 * @author God_q1
 * date 2020/7/3
 * description
 */
public class TopicServiceImpl implements TopicService {

	@Override
	public TopicList queryAllTopic() {
		TopicList topicList = null;
		// NameSrv集群
		if (!ObjectUtils.isEmpty(ConfigCentre.nameSrvAddrs)) {
			for (String nameSrvAddr : ConfigCentre.nameSrvAddrs.get()) {
				// 查询
				DefaultMQAdminExt defaultMQAdminExt = new DefaultMQAdminExt();
				defaultMQAdminExt.setNamesrvAddr(nameSrvAddr);
				try {
					topicList = defaultMQAdminExt.fetchAllTopicList();
				} catch (RemotingException | MQClientException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return topicList;
	}
}
