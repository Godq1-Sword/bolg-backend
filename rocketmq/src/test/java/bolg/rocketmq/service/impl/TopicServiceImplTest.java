package bolg.rocketmq.service.impl;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.junit.jupiter.api.Test;

class TopicServiceImplTest {

	private String nameSrvAddr = "192.168.21.3:9876";

	@Test
	void queryAllTopic() {
		DefaultMQAdminExt defaultMQAdminExt = new DefaultMQAdminExt(50000);
		defaultMQAdminExt.setNamesrvAddr(nameSrvAddr);
		TopicList topicList = null;
		try {
			defaultMQAdminExt.start();
			topicList = defaultMQAdminExt.fetchAllTopicList();
			System.out.println(topicList.getTopicList());
			defaultMQAdminExt.shutdown();
		} catch (RemotingException | MQClientException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}