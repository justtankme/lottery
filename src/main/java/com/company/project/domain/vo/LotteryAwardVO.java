package com.company.project.domain.vo;

import java.util.Date;

import com.company.project.domain.model.LotteryRecord;

public class LotteryAwardVO {
	/**
	 * 抽奖id，唯一ID
	 */
	private Integer loterryId;
	private Integer userId;
    private Integer awardId;
    private Date lotteryTime;
	public Integer getLoterryId() {
		return loterryId;
	}
	public void setLoterryId(Integer loterryId) {
		this.loterryId = loterryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAwardId() {
		return awardId;
	}
	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}
	public Date getLotteryTime() {
		return lotteryTime;
	}
	public void setLotteryTime(Date lotteryTime) {
		this.lotteryTime = lotteryTime;
	}

    public LotteryRecord toRecord() {
    		LotteryRecord lotteryRecord = new LotteryRecord();
    		lotteryRecord.setUserId(getUserId());
    		lotteryRecord.setCreateTime(new Date());
    		return lotteryRecord;
    }
    
}