package com.company.project.service.impl;

import com.company.project.dao.LotteryUserMapper;
import com.company.project.domain.model.LotteryUser;
import com.company.project.service.LotteryUserService;
import com.company.project.core.common.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
* @ClassName: LotteryUserServiceImpl
* @Description: TODO
* @author duanzhiwei
* @date 2018年03月15日 PM 09点23分17秒
*
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class LotteryUserServiceImpl extends AbstractService<LotteryUser> implements LotteryUserService {
    @Resource
    private LotteryUserMapper lotteryUserMapper;

}
