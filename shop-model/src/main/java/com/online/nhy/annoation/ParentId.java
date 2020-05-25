/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: ParentId.java
 * Author:   dongzejun
 * Date:     2015年4月23日 下午5:27:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.online.nhy.annoation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 父表ID声明<BR>
 * 
 * 当存在父子表的时候，请在明细表中关联的父表ID字段的get方法上添加此annotation
 *
 * @author dongzejun
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface ParentId {

}
