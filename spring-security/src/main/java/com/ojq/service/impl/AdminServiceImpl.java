package com.ojq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ojq.domain.dto.acl.AdminQueryDto;
import com.ojq.domain.po.acl.Admin;
import com.ojq.mapper.AdminMapper;
import com.ojq.result.Result;
import com.ojq.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ojq.utils.MD5Encoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<String> findUserPermsList(Long userId) {
        List<String> userPermsList = adminMapper.findUserPermsListByUserId(userId);
        if (userPermsList == null || userPermsList.isEmpty()){
            throw new RuntimeException("该用户无任何权限，请联系管理员添加权限");
        }
        return userPermsList;
    }

    @Override
    public Admin getUserByUsername(String username) {
        LambdaQueryWrapper<Admin> lqw = new LambdaQueryWrapper<Admin>().eq(!StringUtils.isEmpty(username), Admin::getUsername, username);
        Admin user = getOne(lqw);
        return user;
    }

    @Override
    public Map<String,Object> selectAllUserByPage(Long current, Long limit, AdminQueryDto adminQueryDto) {
        LambdaQueryWrapper<Admin> lqw = new LambdaQueryWrapper<Admin>().eq(!StringUtils.isEmpty(adminQueryDto.getUsername()), Admin::getUsername, adminQueryDto.getUsername())
                .like(!StringUtils.isEmpty(adminQueryDto.getName()), Admin::getName, adminQueryDto.getName());

        Page<Admin> pageObject = new Page<>(current, limit);
        Page<Admin> pageData = page(pageObject, lqw);
        //返回分页数据的封装
        return getResultMap(pageData);

    }

    @Override
    public Result register(Admin admin) {

        //获取输入的密码
        String password = admin.getPassword();

        //对输入密码进行加密 MD5
        String passwordMD5 = MD5Encoder.encrypt(password);

        //设置到admin对象里面
        admin.setPassword(passwordMD5);

        //调用方法添加
        save(admin);

        return Result.success("注册成功");
    }


    /**
     * 分页返回数据的map封装
     * @param pageData
     * @return
     */
    private static HashMap<String, Object> getResultMap(Page<Admin> pageData) {
        HashMap<String, Object> resultData = new HashMap<>();
        resultData.put("pageNum", pageData.getCurrent());
        resultData.put("pageSize", pageData.getSize());
        resultData.put("total", pageData.getTotal());
        resultData.put("data", pageData.getRecords());
        return resultData;
    }
}
