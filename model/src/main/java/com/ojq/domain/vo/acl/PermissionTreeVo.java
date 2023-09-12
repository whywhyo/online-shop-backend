package com.ojq.domain.vo.acl;

import com.ojq.domain.po.acl.Permission;
import lombok.Data;

import java.util.List;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-11 20:00
 * @Version 1.0.0
 **/
@Data
public class PermissionTreeVo extends Permission {
    private List<PermissionTreeVo> childList;
}
