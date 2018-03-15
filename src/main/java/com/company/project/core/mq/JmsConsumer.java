package com.company.project.core.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.company.project.domain.model.LotteryRecord;
import com.company.project.service.LotteryService;

@Component
public class JmsConsumer {
	@Autowired
	private LotteryService lotteryService;
	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	@JmsListener(destination = "${lottery.mq}")
	public void consumLottery(String text) {
		System.out.println("Consumer收到的报文为:" + text);
		lotteryService.lottery(JSON.parseObject(text, LotteryRecord.class));
	}
}
