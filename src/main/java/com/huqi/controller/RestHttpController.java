package com.huqi.controller;


import com.huqi.utils.LoggerUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 胡琦
 */
@RestController
@RequestMapping(value = "/RestHttp")
public class RestHttpController extends BaseController{

    private final static Logger logger = Logger.getLogger(RestHttpController.class);

    @RequestMapping(value = "/test1/{hhh}")
    public String testController(@PathVariable("hhh") String value) {
        logger.info("value = {" + value + "}");
        logger.warn(value);
        LoggerUtils.info(logger, "这是日志打印的语句, 第一个 {1} , 第二个 {2}", value, "hello");
        LoggerUtils.error(logger, "这是日志打印的语句, 第一个 {1} , 第二个 {2}", value, "hello");
        LoggerUtils.warn(logger, "这是日志打印的语句, 第一个 {1} , 第二个 {2}", value, "hello");
        LoggerUtils.warn(new Exception("这是一个异常"), logger, "这是日志打印的语句, 第一个 {1} , 第二个 {2}", value, "hello");
        // LoggerUtils.debug(logger, "这是日志打印的语句, 第一个 {1} , 第二个 {2}", value, "hello");
        return "test1";
    }



}
