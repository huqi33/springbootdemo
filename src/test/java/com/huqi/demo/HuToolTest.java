package com.huqi.demo;

import cn.hutool.Hutool;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.huqi.vo.ExcelDemoVO;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HuToolTest {

    @Test
    public void test1() {
        final Set<Class<?>> allUtils = Hutool.getAllUtils();

        // 输出数据到控制台
        allUtils.forEach(x -> System.out.println(
                StrUtil.padAfter(x.getSimpleName(), 20, " ") + "   ->   " + x.getPackage()
        ));

        List<ExcelDemoVO> list = new ArrayList<>();
        allUtils.forEach(x -> {
            ExcelDemoVO data = new ExcelDemoVO();
            data.setPackName(x.getPackage().toString());
            data.setClassName(x.getSimpleName());
            list.add(data);
        });

        // 使用easyExcel将数据输出到Excel文件输出
        write(list);
    }

    private void write(List list) {
        // 写法1
        String path = "D:\\临时文件\\";
        String fileName = path + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, ExcelDemoVO.class).sheet("模板").doWrite(list);
    }

}
