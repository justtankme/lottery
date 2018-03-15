package com.company.project.web;

import com.company.project.core.common.Result;
import com.company.project.domain.model.LotteryRecord;
import com.company.project.service.LotteryRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
* @ClassName: LotteryRecordController
* @Description: TODO
* @author duanzhiwei
* @date 2018年03月15日 PM 09点19分10秒
*
 */
@RestController
@RequestMapping("/lottery/record")
public class LotteryRecordController {
    @Resource
    private LotteryRecordService lotteryRecordService;

    /**  
    * 自动生成的新增方法
    * @Title: add  
    * @param @param lotteryRecord
    * @param @return    参数
    * @return Result<LotteryRecord>    返回类型  
    * @throws  
    */
    @PostMapping
    public Result<LotteryRecord> add(@RequestBody LotteryRecord lotteryRecord) {
        lotteryRecordService.save(lotteryRecord);
        return Result.ok(lotteryRecord);
    }

    /**  
    * 自动生成的删除方法
    * @Title: delete  
    * @param @param id
    * @param @return    参数
    * @return Result<Integer>    返回类型  
    * @throws  
    */
    @DeleteMapping("/{id}")
    public Result<Integer> delete(@PathVariable Integer id) {
        lotteryRecordService.deleteById(id);
        return Result.ok(id);
    }

    /**  
    * 自动生成的更新方法
    * @Title: update  
    * @param @param lotteryRecord
    * @param @return    参数
    * @return Result<LotteryRecord>    返回类型  
    * @throws  
    */
    @PutMapping
    public Result<LotteryRecord> update(@RequestBody LotteryRecord lotteryRecord) {
        lotteryRecordService.update(lotteryRecord);
        return Result.ok(lotteryRecord);
    }

    /**  
    * 自动生成的查询明细方法
    * @Title: detail  
    * @param @param id
    * @param @return    参数
    * @return Result<LotteryRecord>    返回类型  
    * @throws  
    */
    @GetMapping("/{id}")
    public Result<LotteryRecord> detail(@PathVariable Integer id) {
        LotteryRecord lotteryRecord = lotteryRecordService.findById(id);
        return Result.ok(lotteryRecord);
    }

    /**  
    * 自动生成的分页查询列表方法
    * @Title: list  
    * @param @param page
    * @param @param size
    * @param @return    参数
    * @return Result<PageInfo<LotteryRecord>>    返回类型  
    * @throws  
    */
    @GetMapping
    public Result<PageInfo<LotteryRecord>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<LotteryRecord> list = lotteryRecordService.findAll();
        PageInfo<LotteryRecord> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }
}
