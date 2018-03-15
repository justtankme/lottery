package com.company.project.domain.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "lottery_record")
public class LotteryRecord {
    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "award_id")
    private Integer awardId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return record_id
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * @param recordId
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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