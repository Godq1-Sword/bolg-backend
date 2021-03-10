package bolg.rocketmq.uitl;

import bolg.rocketmq.uitl.ProducterFactory;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author God_q1
 * date 2020/7/1
 * description
 */
public class SynProducer {
	private static String groupName = "testGroup";
	private static String nameSrvAddr = "192.168.21.3:9876";

	public static void main(String[] args) {
		DefaultMQProducer defaultMQProducer = ProducterFactory.generateDefaultMQProducter(groupName, nameSrvAddr);
		Message message = new Message();
		message.setTopic("test_topic");
		message.setTags("test");
		message.setBody("testBody".getBytes());
		try {
			SendResult sendResult = defaultMQProducer.send(message);
			defaultMQProducer.shutdown();
		} catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
