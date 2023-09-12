package com.ojq.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ojq.domain.dto.product.AttrGroupQueryDto;
import com.ojq.domain.po.product.AttrGroup;
import com.ojq.result.Result;
import com.ojq.service.AttrGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性分组 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-04-04
 */
@RestController
@RequestMapping("/admin/product/attrGroup")
//@CrossOrigin
public class AttrGroupController {

    @Autowired
    private AttrGroupService attrGroupService;

//    url: `${api_name}/${page}/${limit}`,
//    method: 'get',
//    params: searchObj
    @ApiOperation("平台属性分组列表")
    @GetMapping("{page}/{limit}")
    public Result list(@PathVariable Long page,
                       @PathVariable Long limit,
                       AttrGroupQueryDto attrGroupQueryDto) {
        Page<AttrGroup> pageParam = new Page<>(page,limit);
        IPage<AttrGroup> pageModel = attrGroupService.selectPageAttrGroup(pageParam,attrGroupQueryDto);
        return Result.success(pageModel);
    }

    //查询所有平台属性分组列表
//    url: `${api_name}/findAllList`,
//    method: 'get'
    @ApiOperation("查询所有平台属性分组列表")
    @GetMapping("findAllList")
    public Result findAllList() {
        List<AttrGroup> list = attrGroupService.findAllListAttrGroup();
        return Result.success(list);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        AttrGroup attrGroup = attrGroupService.getById(id);
        return Result.success(attrGroup);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody AttrGroup attrGroup) {
        attrGroupService.save(attrGroup);
        return Result.success(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody AttrGroup attrGroup) {
        attrGroupService.updateById(attrGroup);
        return Result.success(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        attrGroupService.removeById(id);
        return Result.success(null);
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        attrGroupService.removeByIds(idList);
        return Result.success(null);
    }
}

