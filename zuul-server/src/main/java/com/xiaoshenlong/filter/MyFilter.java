package com.xiaoshenlong.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class MyFilter extends ZuulFilter{
    @Override
    public String filterType() {
        //前置过滤器
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String loginFlag = request.getParameter("loginFlag");
        if(StringUtils.isBlank(loginFlag)){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
            System.out.println("拦截器已拦截请求");
        }
        return null;
    }
}
