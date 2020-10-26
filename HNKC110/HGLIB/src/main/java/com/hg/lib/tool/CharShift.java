package com.hg.lib.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符转换工具类
 */
public class CharShift {

    //将字符串类型更改为int类型
    public static int strToInt(String intstr) {
        try {
            return Integer.valueOf(intstr);
        } catch (Throwable e) {
            return 0;
        }
    }

    //将int类型更改为string类型
    public static String intToStr(int value) {
        try {
            return Integer.toString(value);
        } catch (Throwable e) {
            return null;
        }
    }

    //将浮点类型更改为字符串类型
    public static String floatToStr(float value) {
        try {
            return Float.toString(value);
        } catch (Throwable e) {
            return null;
        }
    }

    //将字符串转成Double
    public static double strToDouble(String str) {
        if (str != null) {
            return Double.parseDouble(str);
        } else {
            return 0.0;
        }
    }

    //将double类型更改为string类型
    public static String douToStr(double value) {
        try {
            return String.valueOf(value);
        } catch (Throwable e) {
            return "";
        }
    }

    /**
     * 提取text中的手机号码
     *
     * @param str
     * @return
     */
    public static List<String> getCellphone(String str) {
        // 将给定的正则表达式编译到模式中
        Pattern pattern = Pattern.compile("((?<!\\d)0{0,1}(13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-9])[0-9]{8}(?!\\d))");
        List<String> strList = new ArrayList<>();
        // 创建匹配给定输入与此模式的匹配器。
        Matcher matcher = pattern.matcher(str);
        //查找字符串中是否有符合的子字符串
        while (matcher.find()) {
            //查找到符合的即输出
            strList.add(matcher.group());
        }
        return strList;
    }

    /**
     * 查询符合的固定电话
     *
     * @param str
     */
    public static List<String> getTelephone(String str) {
        List<String> strList = new ArrayList<>();
        // 将给定的正则表达式编译到模式中
        Pattern pattern = Pattern.compile("(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)");
        // 创建匹配给定输入与此模式的匹配器。
        Matcher matcher = pattern.matcher(str);
        //查找字符串中是否有符合的子字符串
        while (matcher.find()) {
            //查找到符合的即输出
            strList.add(matcher.group());
        }
        return strList;
    }

    /**
     * 提取text中的身份证号
     *
     * @param str
     * @return
     */
    public static List<String> getIdNumber(String str) {
        List<String> strList = new ArrayList<>();
        String strs = "\\d{6}((19|20)\\d{2})((0[0-9])|(1[0-2]))((([012])[0-9])|(3[0,1]))\\d{3}[xX\\d]";
        Pattern pattern = Pattern.compile(strs);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            strList.add(matcher.group());
        }
        return strList;
    }

    /**
     * 提取text中的车牌号
     *
     * @param str
     * @return
     */
    public static List<String> getCarnumber(String str) {
        /*
         1.常规车牌号：仅允许以汉字开头，后面可录入六个字符，由大写英文字母和阿拉伯数字组成。如：粤B12345；
         2.武警车牌：允许前两位为大写英文字母，后面可录入五个或六个字符，由大写英文字母和阿拉伯数字组成，其中第三位可录汉字也可录大写英文字母及阿拉伯数字，第三位也可空，如：WJ警00081、WJ京1234J、WJ1234X。
         3.最后一个为汉字的车牌：允许以汉字开头，后面可录入六个字符，前五位字符，由大写英文字母和阿拉伯数字组成，而最后一个字符为汉字，汉字包括“挂”、“学”、“警”、“军”、“港”、“澳”。如：粤Z1234港。
         4.新军车牌：以两位为大写英文字母开头，后面以5位阿拉伯数字组成。如：BA12345。
         */
        List<String> strList = new ArrayList<>();
        String strs = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}(([A-HJ-Z]{1}[A-HJ-NP-Z0-9]{5})|([A-HJ-Z]{1}(([DF]{1}[A-HJ-NP-Z0-9]{1}[0-9]{4})|([0-9]{5}[DF]{1})))|([A-HJ-Z]{1}[A-D0-9]{1}[0-9]{3}警)))|([0-9]{6}使)|((([沪粤川云桂鄂陕蒙藏黑辽渝]{1}A)|鲁B|闽D|蒙E|蒙H)[0-9]{4}领)|(WJ[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼·•]{1}[0-9]{4}[TDSHBXJ0-9]{1})|([VKHBSLJNGCE]{1}[A-DJ-PR-TVY]{1}[0-9]{5})";
        Pattern pattern = Pattern.compile(strs);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            strList.add(matcher.group());
        }
        return strList;
    }
}
