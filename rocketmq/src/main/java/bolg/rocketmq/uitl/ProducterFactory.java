package bolg.rocketmq.uitl;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * @author God_q1
 * date 2020/7/1
 * description
 */
public class ProducterFactory {
	public static DefaultMQProducer generateDefaultMQProducter(String producerGroup, String namesrvAddr) {
		DefaultMQProducer defaultMQProducer = new DefaultMQProducer(producerGroup);
		defaultMQProducer.setNamesrvAddr(namesrvAddr);
		defaultMQProducer.setSendMsgTimeout(10000);
		try {
			defaultMQProducer.start();
		} catch (MQClientException e) {
			e.printStackTrace();
		}
		return defaultMQProducer;
	}
}
