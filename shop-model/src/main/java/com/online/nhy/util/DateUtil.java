/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: DateUtil.java
 * Author:   pengyao
 * Date:     2015年1月30日 上午10:46:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.online.nhy.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 日期关联的通用Util方法
 *
 * @author pengyao
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateUtil {

	/** 星期天 **/
	public static final int DAY_OF_WEEK_OF_SUN_DAY = 1;

	/** 一周天数 **/
	public static final int DAYS_OF_WEEK = 7;

	public static final String FORMAT_DEFAULT = "yyyy-MM-dd";
	public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String FORMAT_YYYYMMDDHH = "yyyyMMddHH";
	public static final String FORMAT_YYYYMM = "yyyyMM";
	public static final String FORMAT_HHMMSS = "HH:mm:ss";
	public static final String FORMAT_YYYYMMDDHHMISS = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_YYYYMMDDHHMISS_2 = "yyyy/MM/dd HH:mm:ss";
	public static final String FORMAT_YYYYMMDDHHMISS_3 = "yyyy/MM/dd HH:mm";
	public static final String FORMAT_YYMMDDHHMISS = "yyMMddHHmmss";

	public static final String FORMAT_YYYYMMDDHHMISS_14 = "yyyyMMddHHmmss";

	public static final String FORMAT_YYMMDD = "yyMMdd";
	public static final String FORMAT_YYYY = "yyyy";
	public static final String FORMAT_MM = "MM";
	public static final String FORMAT_DD = "dd";
	public static final String FORMAT_E = "E";
	public static final String FORMAT_YYYY_MM = "yyyy-MM";
	public static final String FORMAT_DEFAULT_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String FORMAT_HHMM = "HH:mm";

	/**
	 * 获取当前系统日期
	 *
	 * @return Date 当前系统日期
	 */
	public static Date getCurrentDate() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 获取当前系统日期
	 *
	 * @param pattern
	 *            日期格式描述
	 * @return String 当前系统日期
	 */
	public static String getCurrentDateAsString(String pattern) {
		return format(Calendar.getInstance().getTime(), pattern);
	}

	/**
	 * 获取指定日期字符串的年信息
	 *
	 * @param text
	 *            日期字符串
	 * @return 年信息
	 */
	public static String getYear(String text) {
		return getYear(text, FORMAT_DEFAULT);
	}

	/**
	 * 获取指定日期字符串的年信息
	 *
	 * @param text
	 *            日期字符串
	 * @param pattern
	 *            日期格式描述
	 * @return 年信息
	 */
	public static String getYear(String text, String pattern) {
		return format(parseDate(text, pattern), FORMAT_YYYY);
	}

	/**
	 * 获取指定日期字符串的月信息
	 *
	 * @param text
	 *            日期字符串
	 * @return 月信息
	 */
	public static String getMonth(String text) {
		return getMonth(text, FORMAT_DEFAULT);
	}

	/**
	 * 获取指定日期字符串的月信息
	 *
	 * @param text
	 *            日期字符串
	 * @param pattern
	 *            日期格式描述
	 * @return 月信息
	 */
	public static String getMonth(String text, String pattern) {
		return format(parseDate(text, pattern), FORMAT_MM);
	}

	/**
	 * 获取指定日期字符串的日信息
	 *
	 * @param text
	 *            日期字符串
	 * @return 日信息
	 */
	public static String getDay(String text) {
		return getDay(text, FORMAT_DEFAULT);
	}

	/**
	 * 获取指定日期字符串的日信息
	 *
	 * @param text
	 *            日期字符串
	 * @param pattern
	 *            日期格式描述
	 * @return 日信息
	 */
	public static String getDay(String text, String pattern) {
		return format(parseDate(text, pattern), FORMAT_DD);
	}

	/**
	 * 获取指定日期字符串的星期信息
	 *
	 * @param text
	 *            日期字符串
	 * @return 星期信息
	 */
	public static String getWeekDay(String text) {
		return getWeekDay(text, FORMAT_DEFAULT);
	}

	/**
	 * 获取指定日期字符串的星期信息
	 *
	 * @param text
	 *            日期字符串
	 * @param pattern
	 *            日期格式描述
	 * @return 星期信息
	 */
	public static String getWeekDay(String text, String pattern) {
		return format(parseDate(text, pattern), FORMAT_E);
	}

	/**
	 * String类型转换成Date
	 *
	 * @param text
	 *            String型日期
	 * @param pattern
	 *            格式要求
	 * @return 日期文字描述
	 * @author dongzejun
	 */
	public static Date parseDate(String text, String pattern) {
		if (null == text || "".equals(text)) {
			return null;
		}
		DateFormat formatter = getDateFormat(pattern);
		try {
			return formatter.parse(text);
		} catch (ParseException e) {
			// throw new ParseException("error.common.util.datestring", 0);
		}
		return null;
	}

	/**
	 * Date类型转换成String
	 *
	 * @param date
	 *            Date型日期
	 * @param pattern
	 *            格式要求
	 * @return 日期文字描述
	 * @author dongzejun
	 */
	public static String format(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		DateFormat formatter = getDateFormat(pattern);
		return formatter.format(date);
	}

	/**
	 * Calendar类型转换成String
	 *
	 * @param date
	 *            Calendar型日期
	 * @param pattern
	 *            格式要求
	 * @return 日期文字描述
	 * @author dongzejun
	 */
	public static String format(Calendar date, String pattern) {
		return format(date.getTime(), pattern);
	}

	/*
	 * 获取正确的DateFormat对象
	 * 
	 * @author dongzejun
	 */
	private static DateFormat getDateFormat(String pattern) {
		DateFormat df = new SimpleDateFormat(pattern, getCurrentLocale());
		df.setTimeZone(TimeZone.getDefault());
		return df;
	}

	/**
	 * 当前日期加减天
	 *
	 * @param days
	 * @return
	 * @author tantun
	 */
	public static Date addDay(int days) {
		Calendar strDate = Calendar.getInstance();
		strDate.add(Calendar.DATE, days);// 如果不够减会将月变动
		return strDate.getTime();
	}

	/**
	 * 当前日期加减月
	 *
	 * @param months
	 * @return
	 * @author tantun
	 */
	public static Date addMonth(int months) {
		Calendar strDate = Calendar.getInstance();
		strDate.add(Calendar.MONTH, months);// 如果不够减会将月变动
		return strDate.getTime();
	}

	/**
	 * 
	 * 指定日期加减填
	 *
	 * @param date
	 * @param field
	 * @param amount
	 * @return
	 * @author tantun
	 */
	public static Date addDay(Date date, int days) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 根据传入的日期加减月
	 *
	 * @param date
	 * @param months
	 * @return
	 * @author tantun
	 */
	public static Date addMonth(Date date, int months) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, months);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取指定日期的最晚时间
	 *
	 * @param date
	 *            指定日期
	 * @return 指定日期的最晚时间
	 * @author dongzejun
	 */
	public static Date getEndOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 000);
		return c.getTime();
	}

	/**
	 * 获取指定日期的最早时间
	 *
	 * @param date
	 *            指定日期
	 * @return 指定日期的最早时间
	 * @author qianjing
	 */
	public static Date getStartOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 
	 * @Description:获取16位时间戳
	 * @return String
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public static String getTimestampWithLength() {
		String timeInMillis = String.valueOf(Calendar.getInstance().getTimeInMillis());
		String last = timeInMillis.substring(timeInMillis.length() - 4, timeInMillis.length());
		return format(getCurrentDate(), FORMAT_YYMMDDHHMISS) + last;
	}

	/**
	 * Test function
	 */
	public static void main(String[] args) {
		// System.out.println(DateUtil.getStartOfDay(new Date()));
		// System.out.println(DateUtil.getTimestampWithLength());
		// System.out.println(getWeekDay("2015-04-17"));
		// System.out.println(format(new Date(), FORMAT_HHMMSS));
		// System.out.println(format(addDay(1),DateUtil.FORMAT_DEFAULT));
		// System.out.println(format(addMonth(1),DateUtil.FORMAT_DEFAULT));
		// System.out.println(format(addDay(new
		// Date(),2),DateUtil.FORMAT_DEFAULT));
		// System.out.println(format(addMonth(new
		// Date(),2),DateUtil.FORMAT_DEFAULT));
		// System.out.println(addMonth(1));
		// System.out.println(addDay(new Date(),2));
		// System.out.println(addMonth(new Date(),2));
		System.out.println(format(getCurrentMonthFristDayOfMonth(), FORMAT_DEFAULT));
		System.out.println(format(getCurrentMonthEndDayOfMonth(), FORMAT_DEFAULT));
	}

	/**
	 * 获取指定日期的当年最后一天的日期
	 *
	 * @param date
	 *            指定日期
	 * @return 获取指定日期的当年最后一天的日期
	 * @author qianjing
	 */
	public static Date getEndOfYear(Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DAY_OF_MONTH, 31);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取指定日期月份的第一天
	 *
	 * @param date
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public static Date getStartDayOfMonth(Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		Date first = c.getTime();
		return getStartOfDay(first);
	}

	/**
	 * 传入一个日期和今天相比较 比今天早返回-1 等于今天返回0 比今天晚返回1
	 *
	 * @param date
	 * @return
	 * @author zhangkoule
	 */
	public static String compareDateWithToday(Date date) {
		if (date == null) {
			return null;
		}
		Date today = new Date();
		today = DateUtil.getStartOfDay(today);

		date = DateUtil.getStartOfDay(date);
		if (date.getTime() > today.getTime()) {
			return "1";
		} else if (date.getTime() == today.getTime()) {
			return "0";
		} else if (date.getTime() < today.getTime()) {
			return "-1";
		}
		return null;
	}

	/**
	 * 得到一周的第一天
	 * 
	 * @author zhangliang
	 * @param date
	 * @return
	 */
	public static Date getStartDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		Date beginDate = null;
		if (dayOfWeek == DAY_OF_WEEK_OF_SUN_DAY)
			beginDate = DateUtil.addDay(date, dayOfWeek - DAYS_OF_WEEK);
		else
			beginDate = DateUtil.addDay(date, 2 - dayOfWeek);
		return DateUtil.getStartOfDay(beginDate);
	}

	/**
	 * 获取指定日期的周序号（一年中的第几周）
	 * 
	 * @param date
	 * @return
	 */
	public static Integer getWeekIdx(Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取某年的第几周的开始日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Integer year, Integer week) {
		if (year == null || week == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal.getTime();
	}

	/**
	 * 获取某年的第几周的结束日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Integer year, Integer week) {
		if (year == null || week == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		return cal.getTime();
	}

	/**
	 * 
	 * 功能描述:获取上月最后一天 使用场景:
	 * 
	 * @author zhangliang
	 * @param date
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public static Date getPreMonthEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return DateUtil.getEndOfDay(calendar.getTime());
	}

	/**
	 * 
	 * 功能描述:获取当前月最后一天 使用场景:
	 * 
	 * @author wangjun
	 * @param date
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public static Date getCurrentMonthEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return DateUtil.getEndOfDay(calendar.getTime());
	}

	/**
	 * 
	 * 功能描述:获取当前月第天 使用场景:
	 * 
	 * @author wangjun
	 * @param date
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public static Date getCurrentMonthFristDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return DateUtil.getEndOfDay(calendar.getTime());
	}

	/**
	 * 获取指定日期时间字符串的日信息
	 *
	 * @param text
	 *            日期字符串
	 * @param pattern
	 *            日期格式描述
	 * @return 日信息
	 */
	public static String getDateTime(String text, String pattern) {
		return format(parseDate(text, pattern), pattern);
	}

	/**
	 * 获取指定日期之间的天数
	 *
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return 日信息
	 */
	public static int daysBetween(Date startDate, Date endDate) {
		startDate = parseDate(format(startDate, FORMAT_DEFAULT), FORMAT_DEFAULT);
		endDate = parseDate(format(endDate, FORMAT_DEFAULT), FORMAT_DEFAULT);
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(endDate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	public static Date parseDateAuto(String text, String pattern) {
		if (null == text || "".equals(text)) {
			return null;
		}
		DateFormat formatter = getDateFormat(pattern);
		try {
			return formatter.parse(text);
		} catch (ParseException e) {
			return DateUtil.parseDate(text, FORMAT_DEFAULT);
		}
	}

	public static Locale getCurrentLocale() {
		return Locale.CHINA;
	}

}
