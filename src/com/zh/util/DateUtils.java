package com.zh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @描述 日期时间工具<br>
 * @author 陈之晶
 * @版本 v1.0.0
 * @日期 2017-6-8
 */
public class DateUtils {

	private static final String CURRENT_DATE_STR = "yyyy-MM-dd";
	private static final String CURRENT_TIME_STR = "yyyy-MM-dd HH:mm:ss";

	public static Date getCurrentDate() {
		Date date = new Date();
		return date;
	}

	/**
	 * @描述 获取字符串格式的当前<br>
	 * @return XXXX-XX-XX XX:XX:XX
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-13
	 */
	public static String getCurrentTimeStr() {
		SimpleDateFormat format = new SimpleDateFormat(CURRENT_TIME_STR);
		return format.format(new Date());
	}

	/**
	 * @描述 获取字符串格式的当前<br>
	 * @return XXXX-XX-XX
	 * @author 李娜
	 * @版本 v1.0.0
	 * @日期 2017-6-17
	 */
	public static String getCurrentDateStr() {
		SimpleDateFormat format = new SimpleDateFormat(CURRENT_DATE_STR);
		return format.format(new Date());
	}

	/**
	 * @描述 字符串转时间 例：XXXX-XX-XX XX:XX:XX<br>
	 * @param str
	 * @return
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-17
	 */
	public static Date strToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * @描述 计算机两个时间相差天数<br>
	 * @param date
	 *            字符串格式日期时间,例：XXXX-XX-XX XX:XX:XX
	 * @return
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-17
	 */
	public static int daysBetween(String dateStr) {
		Date after = strToDate(dateStr);
		Calendar cal = Calendar.getInstance();
		Date before = cal.getTime();
		long afterMillis = after.getTime();
		long beforeMillis = before.getTime();
		long between_days = (beforeMillis - afterMillis) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * @描述 计算机两个时间相差小时数<br>
	 * @param date
	 *            字符串格式日期时间,例：XXXX-XX-XX XX:XX:XX
	 * @return
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-6-17
	 */
	public static int hoursBetween(String dateStr) {
		Date after = strToDate(dateStr);
		Calendar cal = Calendar.getInstance();
		Date before = cal.getTime();
		long afterMillis = after.getTime();
		long beforeMillis = before.getTime();
		long between_days = (beforeMillis - afterMillis) / (1000 * 3600);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * @描述 获取当前月份第一天<br>
	 * @return
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-7-5
	 */
	public static String getCurrentMonthStartDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		 String startDay = format.format(cal_1.getTime());
		return startDay+" 00:00:00";
	}

	/**
	 * @描述 获取当前月份第一天<br>
	 * @return
	 * @author 陈之晶
	 * @版本 v1.0.0
	 * @日期 2017-7-5
	 */
	public static String getCurrentMonthEndDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);// 设置为1号,当前日期既为本月第一天
		String endDay = format.format(cale.getTime());
		return endDay+" 23:59:59";
	}
	/**
     * date2比date1多的天数
     * @param date1    
     * @param date2
     * @return    
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
       int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
//            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }

	public static void main(String[] args) {
		String string = "2018-10-24 21:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			System.out.println(sdf.parse(string));
			System.out.println(differentDays(sdf.parse(string),getCurrentDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
