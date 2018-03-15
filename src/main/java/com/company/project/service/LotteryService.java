package com.company.project.service;

import com.company.project.domain.model.LotteryRecord;
import com.company.project.domain.vo.LotteryAwardVO;

/**
 * 抽奖接口
 * @author duanzhiwei
 *
 */
public interface LotteryService {

	/**
	 * 抽奖，这里其实只是保存了一个抽奖记录，同时向MQ放了一个抽奖任务数据
	 * @param lotteryAwardVO
	 * @return
	 */
	public LotteryAwardVO lottery(LotteryAwardVO lotteryAwardVO);
	
	/**
	 * 用户抽奖，中奖了就返回中奖信息，否则返回null
	 * @param userId
	 * @return
	 */
	public LotteryAwardVO lottery(LotteryRecord record);
}
