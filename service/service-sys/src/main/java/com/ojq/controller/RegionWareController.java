package com.ojq.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ojq.domain.po.sys.RegionWare;
import com.ojq.domain.vo.sys.RegionWareQueryVo;
import com.ojq.result.Result;
import com.ojq.service.RegionWareService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 城市仓库关联表 前端控制器
 * </p>
 *
 * @author ojq
 * @since 2023-09-11
 */
@RestController
@RequestMapping("/admin/regionWare")
public class RegionWareController {

    @Autowired
    private RegionWareService regionWareService;

    //开通区域列表
//    url: `${api_name}/${page}/${limit}`,
//    method: 'get',
//    params: searchObj
    @ApiOperation("开通区域列表")
    @GetMapping("{page}/{limit}")
    public Result list(@PathVariable Long page,
                       @PathVariable Long limit,
                       RegionWareQueryVo regionWareQueryVo) {
        Page<RegionWare> pageParam = new Page<>(page,limit);
        IPage<RegionWare> pageModel = regionWareService.selectPageRegionWare(pageParam,regionWareQueryVo);
        return Result.success(pageModel);
    }

    //添加开通区域
//    url: `${api_name}/save`,
//    method: 'post',
//    data: role
    @ApiOperation("添加开通区域")
    @PostMapping("save")
    public Result addRegionWare(@RequestBody RegionWare regionWare) {
        regionWareService.saveRegionWare(regionWare);
        return Result.success(null);
    }

    //删除开通区域
//    url: `${api_name}/remove/${id}`,
//    method: 'delete'
    @ApiOperation("删除开通区域")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        regionWareService.removeById(id);
        return Result.success(null);
    }

    //取消开通区域
//    url: `${api_name}/updateStatus/${id}/${status}`,
//    method: 'post'
    @ApiOperation("取消开通区域")
    @PostMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id,
                               @PathVariable Integer status) {
        regionWareService.updateStatus(id,status);
        return Result.success(null);
    }

}
