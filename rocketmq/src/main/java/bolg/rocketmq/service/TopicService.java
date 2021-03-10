package bolg.rocketmq.service;

import org.apache.rocketmq.common.protocol.body.TopicList;
import org.springframework.stereotype.Service;

/**
 * @author God_q1
 * date 2020/7/3
 * description
 */
@Service
public interface TopicService {
	TopicList queryAllTopic();
}
