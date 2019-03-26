package com.wumu.fabric.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wangzemin
 * @Date: 19-1-31 下午12:10
 * @Version: 1.font-awesome
 * @Description:
 */
@RestController
public class IndexController {

    /**
     * 获取授权之后的根目录，对于不同的用户应该有不同的界面
     */

    @ApiOperation(value = "根目录")
    @RequestMapping("/")
    public String root() {
        return "/manager/index";
    }

    @ApiOperation(value = "根目录")
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "login";
    }
}
