package com.company.project.service.impl;

import com.company.project.dao.LotteryAwardMapper;
import com.company.project.domain.model.LotteryAward;
import com.company.project.service.LotteryAwardService;
import com.company.project.core.common.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
* @ClassName: LotteryAwardServiceImpl
* @Description: TODO
* @author duanzhiwei
* @date 2018年03月15日 PM 09点19分10秒
*
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class LotteryAwardServiceImpl extends AbstractService<LotteryAward> implements LotteryAwardService {
    @Resource
    private LotteryAwardMapper lotteryAwardMapper;

}
