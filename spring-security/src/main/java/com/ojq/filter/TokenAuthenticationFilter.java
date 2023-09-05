package com.ojq.filter;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-07-09 13:55
 * @Version 1.0.0
 **/

//import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSON;
import com.ojq.constValue.RedisKey;
import com.ojq.jwt.JwtHelper;
import com.ojq.result.Result;
import com.ojq.result.ResultCodeEnum;

import com.ojq.service.AdminService;
import com.ojq.service.impl.AdminServiceImpl;
import com.ojq.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.ojq.constValue.RedisKey.USER_AUTHORITY;

/**
 * <p>
 * 认证解析token过滤器
 * </p>
 */
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private RedisTemplate redisTemplate;

    public TokenAuthenticationFilter(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("uri:" + request.getRequestURI() + "正在访问");
        //如果是登录接口，直接放行
        if ("/admin/system/index/login".equals(request.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (null != authentication) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } else {
            ResponseUtil.out(response, Result.build(null, ResultCodeEnum.LACK_LOGIN_AUTH));
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        // token置于header里
        String token = request.getHeader("token");
        logger.info("token:"+token);

        if (!StringUtils.isEmpty(token)){
            //token不为空，可以验证token
            String username = JwtHelper.getUsername(token);
            logger.info("useruame:"+username);

            if (!StringUtils.isEmpty(username)) {
                //username不为空，可以验证username
                String authoritiesString = (String) redisTemplate.opsForValue().get(USER_AUTHORITY +username);
                List<Map> mapList = JSON.parseArray(authoritiesString, Map.class);
                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                for (Map map : mapList) {
                    authorities.add(new SimpleGrantedAuthority((String)map.get("authority")));
                }
                return new UsernamePasswordAuthenticationToken(username, null, authorities);
            }else {
                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            }
        }
        return null;
    }
}


// TODO: 2023-07-09  这里可以去数据库中将权限查询出来
//或者直接将权限放到jwt中，从jwt中获取

//记录问题：如果service不放在security模块中，这样写会有问题，因为会导致security模块和service模块的循环依赖
//记录问题：此处不能直接像下面这样调用adminService查数据库对应用户的权限。因为security模块是被其他模块依赖的，如果这里直接写代码查数据库，是站在其他模块的角度上完成的，而其他模块上的数据库没有admin这个表，因此会报错
//                List<String> userPermsList = adminService.findUserPermsList(userId);
//                List<SimpleGrantedAuthority> authorityList = userPermsList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

//正确做法是要在redis中读取权限数据

