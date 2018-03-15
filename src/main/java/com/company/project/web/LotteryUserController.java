package com.company.project.web;

import com.company.project.core.common.Result;
import com.company.project.domain.model.LotteryUser;
import com.company.project.service.LotteryUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
* @ClassName: LotteryUserController
* @Description: TODO
* @author duanzhiwei
* @date 2018年03月15日 PM 09点23分17秒
*
 */
@RestController
@RequestMapping("/lottery/user")
public class LotteryUserController {
    @Resource
    private LotteryUserService lotteryUserService;

    /**  
    * 自动生成的新增方法
    * @Title: add  
    * @param @param lotteryUser
    * @param @return    参数
    * @return Result<LotteryUser>    返回类型  
    * @throws  
    */
    @PostMapping
    public Result<LotteryUser> add(@RequestBody LotteryUser lotteryUser) {
        lotteryUserService.save(lotteryUser);
        return Result.ok(lotteryUser);
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
        lotteryUserService.deleteById(id);
        return Result.ok(id);
    }

    /**  
    * 自动生成的更新方法
    * @Title: update  
    * @param @param lotteryUser
    * @param @return    参数
    * @return Result<LotteryUser>    返回类型  
    * @throws  
    */
    @PutMapping
    public Result<LotteryUser> update(@RequestBody LotteryUser lotteryUser) {
        lotteryUserService.update(lotteryUser);
        return Result.ok(lotteryUser);
    }

    /**  
    * 自动生成的查询明细方法
    * @Title: detail  
    * @param @param id
    * @param @return    参数
    * @return Result<LotteryUser>    返回类型  
    * @throws  
    */
    @GetMapping("/{id}")
    public Result<LotteryUser> detail(@PathVariable Integer id) {
        LotteryUser lotteryUser = lotteryUserService.findById(id);
        return Result.ok(lotteryUser);
    }

    /**  
    * 自动生成的分页查询列表方法
    * @Title: list  
    * @param @param page
    * @param @param size
    * @param @return    参数
    * @return Result<PageInfo<LotteryUser>>    返回类型  
    * @throws  
    */
    @GetMapping
    public Result<PageInfo<LotteryUser>> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<LotteryUser> list = lotteryUserService.findAll();
        PageInfo<LotteryUser> pageInfo = new PageInfo<>(list);
        return Result.ok(pageInfo);
    }
}
