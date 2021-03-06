package com.tsino.sentinelservice.configuration;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

/**
 * @Author: admin
 * @Description: TODO
 * @Date: 2020/12/16 15:36
 */
@Configuration
public class SentinelConfiguration {
    @Bean
    public BlockExceptionHandler sentinelBlockExceptionHanlder(){
        return (request,response,e) ->{
            MyResponse errorResponse = null;
            // 不同的异常返回不同的提示语
            if (e instanceof FlowException) {
                errorResponse = MyResponse.builder()
                        .status(100).msg("接口限流了")
                        .build();
            } else if (e instanceof DegradeException) {
                errorResponse = MyResponse.builder()
                        .status(101).msg("服务降级了")
                        .build();
            } else if (e instanceof ParamFlowException) {
                errorResponse = MyResponse.builder()
                        .status(102).msg("热点参数限流了")
                        .build();
            } else if (e instanceof SystemBlockException) {
                errorResponse = MyResponse.builder()
                        .status(103).msg("触发系统保护规则")
                        .build();
            } else if (e instanceof AuthorityException) {
                errorResponse = MyResponse.builder()
                        .status(104).msg("授权规则不通过")
                        .build();
            }

            response.setStatus(500);
            response.setCharacterEncoding("utf-8");
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            new ObjectMapper().writeValue(response.getWriter(), errorResponse);
        };
    }
}
/**
 * 简单的响应结构体
 */
@Data
@Builder
class MyResponse {
    private Integer status;
    private String msg;
}
