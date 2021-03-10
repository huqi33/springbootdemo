package com.huqi.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcelDemoVO {

    /**
     * 类名
     */
    @ExcelProperty("工具类名")
    private String className;

    /**
     * 包名
     */
    @ExcelProperty("所在包名")
    private String packName;
}
