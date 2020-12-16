package com.tsino.sentinelservice.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tsino.sentinelservice.api.CommonResult;

/**
 * @Author: admin
 * @Description: TODO
 * @Date: 2020/12/16 13:38
 */
public class CustomBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return  CommonResult.success("122","自定义限流信息");
    }
}
