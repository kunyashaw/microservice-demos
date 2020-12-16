package com.tsino.sentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tsino.sentinelservice.api.CommonResult;
import com.tsino.sentinelservice.handler.CustomBlockHandler;
import com.tsino.sentinelservice.handler.MyUrlBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 限流功能
 * Created by macro on 2019/11/7.
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

//    /**
//     * 按资源名称限流，需要指定限流处理逻辑
//     */
//    @GetMapping("/byResource")
//    @SentinelResource(value = "byResource",blockHandler = "handleException")
//    public CommonResult byResource() {
//        return  CommonResult.success(200,"按资源名称限流");
//    }
//
//    /**
//     * 按URL限流，有默认的限流处理逻辑
//     */
//    @GetMapping("/byUrl")
//    @SentinelResource(value = "byUrl",blockHandler = "handleException")
//    public CommonResult byUrl() {
//        return  CommonResult.success(200,"按url限流");
//    }
//
//    public CommonResult handleException(BlockException exception){
//        return  CommonResult.success(200,exception.getClass().getCanonicalName());
//    }

    /**
     * 自定义通用的限流处理逻辑 注意handlerException得是static的
     */
    @GetMapping("/123")
    @SentinelResource(value = "customBlockHandler", blockHandler = "handleException",
            blockHandlerClass = CustomBlockHandler.class)
    public  CommonResult blockHandler() {
        return CommonResult.success("test","请求成功的数据");
    }

    /**
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/456")
    public  CommonResult test() {
        return CommonResult.success("test","请求成功的数据");
    }
}
