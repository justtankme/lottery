package com.company.project.domain.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "lottery_award")
public class LotteryAward {
    @Id
    @Column(name = "award_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer awardId;

    @Column(name = "award_name")
    private String awardName;

    /**
     * 中奖率
     */
    @Column(name = "award_percent")
    private BigDecimal awardPercent;

    /**
     * 奖品总数量
     */
    @Column(name = "award_num")
    private Integer awardNum;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return award_id
     */
    public Integer getAwardId() {
        return awardId;
    }

    /**
     * @param awardId
     */
    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    /**
     * @return award_name
     */
    public String getAwardName() {
        return awardName;
    }

    /**
     * @param awardName
     */
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    /**
     * 获取中奖率
     *
     * @return award_percent - 中奖率
     */
    public BigDecimal getAwardPercent() {
        return awardPercent;
    }

    /**
     * 设置中奖率
     *
     * @param awardPercent 中奖率
     */
    public void setAwardPercent(BigDecimal awardPercent) {
        this.awardPercent = awardPercent;
    }

    /**
     * 获取奖品总数量
     *
     * @return award_num - 奖品总数量
     */
    public Integer getAwardNum() {
        return awardNum;
    }

    /**
     * 设置奖品总数量
     *
     * @param awardNum 奖品总数量
     */
    public void setAwardNum(Integer awardNum) {
        this.awardNum = awardNum;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}