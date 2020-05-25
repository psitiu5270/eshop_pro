/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: ICxjEnum.java
 * Author:   Zejun.Dong
 * Date:     2015年3月26日 下午5:42:11
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.online.nhy.enums;

/**
 * 车享平台通用枚举接口
 *
 * @author ninghaiyang
 */
public interface IEnum<E extends Enum<?>> {

    /**
     * 获取枚举值
     *
     * @return 枚举值
     */
    public String getValue();

    /**
     * 获取枚举名
     *
     * @return 枚举名
     */
    public String getName();


    /**
     * 判断传入的枚举值(value)与当前的枚举值是否相等
     *
     * @param value 枚举值
     * @return 传入的枚举值与当前的枚举值相等返回true，否则返回false
     * @author dongzejun 2015年6月8日
     */
    public boolean equals(String value);
}
