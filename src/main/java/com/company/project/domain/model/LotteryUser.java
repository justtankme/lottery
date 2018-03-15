package com.company.project.domain.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "lottery_user")
public class LotteryUser {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_times")
    private Integer userTimes;

    /**
     * 用户权重
     */
    @Column(name = "user_priority")
    private Integer userPriority;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_times
     */
    public Integer getUserTimes() {
        return userTimes;
    }

    /**
     * @param userTimes
     */
    public void setUserTimes(Integer userTimes) {
        this.userTimes = userTimes;
    }

    /**
     * 获取用户权重
     *
     * @return user_priority - 用户权重
     */
    public Integer getUserPriority() {
        return userPriority;
    }

    /**
     * 设置用户权重
     *
     * @param userPriority 用户权重
     */
    public void setUserPriority(Integer userPriority) {
        this.userPriority = userPriority;
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