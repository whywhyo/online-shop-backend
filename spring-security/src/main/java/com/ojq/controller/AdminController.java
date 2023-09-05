package com.ojq.controller;


import com.ojq.domain.dto.acl.AdminQueryDto;
import com.ojq.domain.po.acl.Admin;
import com.ojq.result.Result;
import com.ojq.service.AdminService;
import com.ojq.service.RoleService;
import com.ojq.utils.MD5Encoder;
import com.ojq.validation.group.RegisterGroup;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@RestController
@RequestMapping("/admin/user")
public class AdminController {

    @Resource
    private AdminService adminService;

    @ApiOperation("获取所有用户列表")
    @GetMapping("{current}/{limit}")
    public Result listAllUser(@PathVariable Long current, @PathVariable Long limit, AdminQueryDto adminQueryDto){
        Map<String,Object> pageModel = adminService.selectAllUserByPage(current,limit,adminQueryDto);
        return Result.success(pageModel);
    }

    @ApiOperation("根据id查询用户")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }


    @ApiOperation("添加(注册)用户")
    @PostMapping("save")
    public Result save(@RequestBody @Validated(RegisterGroup.class) Admin admin) {

        return adminService.register(admin);

    }


    @ApiOperation("修改用户")
    @PutMapping("update")
    public Result update(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return Result.success("修改成功");
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        adminService.removeById(id);
        return Result.success("删除成功");
    }

    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        adminService.removeByIds(idList);
        return Result.success("删除成功");
    }


}
