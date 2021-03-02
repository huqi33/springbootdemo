package com.huqi.utils;


import org.apache.commons.lang3.ObjectUtils;
import org.apache.log4j.Logger;


/**
 * 日志工具类
 * @author 胡琦
 */
public class LoggerUtils {
    // 准备模仿公司的工具类来写一个来玩玩
    // 主要是要重写info,error,等方法,方便的使用
    /**
     * 日志打印对象
     */
    private static Logger LOGGER = Logger.getLogger(LoggerUtils.class);

    /**
     * info日志
     * @param logger
     * @param strings
     */
    public static void info(Logger logger, String... strings) {
        if (ObjectUtils.isEmpty(logger)) {
            LOGGER.warn("日志打印异常");
            return;
        }
        String spl = spl(strings);
        logger.info(spl);
    }

    /**
     * warn日志
     * @param logger
     * @param strings
     */
    public static void warn(Logger logger, String... strings) {
        if (ObjectUtils.isEmpty(logger)) {
            LOGGER.warn("日志打印异常");
            return;
        }
        String spl = spl(strings);
        logger.warn(spl);
    }

    /**
     * worn日志,带异常
     * @param e
     * @param logger
     * @param strings
     */
    public static void warn(Exception e, Logger logger, String... strings) {
        if (ObjectUtils.isEmpty(logger)) {
            LOGGER.warn("日志打印异常");
            return;
        }
        String spl = spl(strings);
        logger.warn(spl);
        // 打印异常
        e.printStackTrace();
    }

    /**
     * error日志
     * @param logger
     * @param strings
     */
    public static void error(Logger logger, String... strings) {
        if (ObjectUtils.isEmpty(logger)) {
            LOGGER.warn("日志打印异常");
            return;
        }
        String spl = spl(strings);
        logger.error(spl);
    }

    /**
     * error日志,带异常
     * @param e
     * @param logger
     * @param strings
     */
    public static void error(Exception e, Logger logger, String... strings) {
        if (ObjectUtils.isEmpty(logger)) {
            LOGGER.warn("日志打印异常");
            return;
        }
        String spl = spl(strings);
        logger.error(spl);
        e.printStackTrace();
    }

    /**
     * info日志
     * @param logger
     * @param strings
     */
    public static void debug(Logger logger, String... strings) {
        if (ObjectUtils.isEmpty(logger)) {
            LOGGER.warn("日志打印异常");
            return;
        }
        String spl = spl(strings);
        logger.debug(spl);
    }

    /**
     * 对字符串进行拆分
     * @param strings
     * @return
     */
    private static String spl(String... strings) {
        // 可以进行解析字符串  解析{x} 其中x代表了后面需要填充的数据
        String info = "";
        // 对字符串进行拆分
        if (ObjectUtils.allNotNull(strings) && strings.length >= 1) {
            // 日志需要填充的语句
            StringBuilder sb = new StringBuilder();
            String string = strings[0];
            // 对string进行解析
            char[] chars = null;
            try {
                chars = string.toCharArray();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < chars.length; i++) {
                char by = chars[i];
                if (by == '{') {
                    char aByte = chars[i + 1];
                    Integer integer = null;
                    try {
                        integer = aByte - '0';
                    }catch (Exception e) {
                        LOGGER.error("类型转换错误...");
                    }
                    if (ObjectUtils.allNotNull(integer)) {
                        sb.append(strings[integer]);
                    }
                    continue;
                }
                if (i != 0 && chars[i - 1] == '{' || by == '}') {
                    continue;
                }
                sb.append(by);
            }
            info = sb.toString();
        }
        return info;
    }

}
