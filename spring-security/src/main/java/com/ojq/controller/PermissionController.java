package com.ojq.controller;


import com.ojq.domain.po.acl.Permission;
import com.ojq.domain.vo.acl.PermissionTreeVo;
import com.ojq.result.Result;
import com.ojq.service.PermissionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@RestController
@RequestMapping("/admin/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    //查询所有菜单
//    url: `${api_name}`,
//    method: 'get'
    @ApiOperation("查询所有菜单")
    @GetMapping
    public Result list() {
        List<PermissionTreeVo> list = permissionService.queryAllMenu();
        return Result.success(list);
    }

    //添加菜单
//    url: `${api_name}/save`,
//    method: "post",
//    data: permission
    @ApiOperation("添加菜单")
    @PostMapping("save")
    public Result save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return Result.success(null);
    }

    //修改菜单
//    url: `${api_name}/update`,
//    method: "put",
//    data: permission
    @ApiOperation("修改菜单")
    @PutMapping("update")
    public Result update(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return Result.success(null);
    }

    //递归删除菜单
//    url: `${api_name}/remove/${id}`,
//    method: "delete"
    @ApiOperation("递归删除菜单")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        permissionService.removeChildById(id);
        return Result.success(null);
    }

}
