package com.company.project.core.mq;

import javax.jms.Destination;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.company.project.domain.model.LotteryRecord;

/**
 * 消息生产者
 * @author duanzhiwei
 *
 */
@Service
public class JmsProducer {
	@Autowired
    private Queue queue;
	/**
	 * 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
	 */
	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	
	/**
	 * 发送消息，destination是发送到的队列，message是待发送的消息
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination, final String message) {
		jmsTemplate.convertAndSend(destination, message);
	}
	
	/**
	 * 发送抽奖消息
	 * @param record
	 */
	public void sendLotteryMessage(LotteryRecord record) {
		sendMessage(queue, JSON.toJSONString(record));
	}
}
