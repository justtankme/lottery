package com.company.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.core.mq.JmsProducer;
import com.company.project.domain.model.LotteryRecord;
import com.company.project.domain.vo.LotteryAwardVO;
import com.company.project.service.LotteryRecordService;
import com.company.project.service.LotteryService;

@Service
@Transactional
public class LotteryServiceImpl implements LotteryService {
	@Autowired
	private LotteryRecordService lotteryRecordService;
	@Autowired
	private JmsProducer jmsProducer;

	@Override
	public LotteryAwardVO lottery(LotteryAwardVO lotteryAwardVO) {
		//这里主要是想给前端反馈一个唯一标识，用来查询某次抽奖的结果
		//TODO 其实可以放到MQ消息处理里面去做
		LotteryRecord record = lotteryAwardVO.toRecord();
		lotteryRecordService.save(record);
		jmsProducer.sendLotteryMessage(record);
		return null;
	}

	@Override
	public LotteryAwardVO lottery(LotteryRecord record) {
		//没有奖品了就不用抽了
//		if(awardRemaind()) {
//			return null;
//		}
//		//每个用户一个锁，防止并发请求
//		if(tryLock(userId)) {
//			//校验用户是否有剩余抽奖数
//			if(canLottery(userId)) {
//				//减少一次抽奖数
//				decrTimes(userId);
//				//抽奖
//				return doLottery(userId);
//				//更新抽奖记录表
//			}
//		}
		return null;
	}

}
