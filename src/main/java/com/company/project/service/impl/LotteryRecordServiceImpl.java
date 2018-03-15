package com.company.project.service.impl;

import com.company.project.dao.LotteryRecordMapper;
import com.company.project.domain.model.LotteryRecord;
import com.company.project.service.LotteryRecordService;
import com.company.project.core.common.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
* @ClassName: LotteryRecordServiceImpl
* @Description: TODO
* @author duanzhiwei
* @date 2018年03月15日 PM 09点19分10秒
*
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class LotteryRecordServiceImpl extends AbstractService<LotteryRecord> implements LotteryRecordService {
    @Resource
    private LotteryRecordMapper lotteryRecordMapper;

}
