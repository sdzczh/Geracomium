package com.zh.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @描述 计算工具类<br>
 * @author 
 * @版本 v1.0.0
 * @日期 2017-6-16
 */
public class MatchUtils {
	
	/**
	 * @描述 替换公式中n<br>
	 * @param nval 公式n的取值
	 * @param formulaStr 公式
	 * @return 格式化公式
	 * @author 
	 * @版本 v1.0.0
	 * @日期 2017-6-19
	 */
	private static String transformationFormulaA(String nval,String formulaStr){
		formulaStr = formulaStr.replace("n", nval);
		return formulaStr;
	}
	
	/**
	 * @描述 替换公式中n和y<br>
	 * @param nval 公式n的取值
	 * @param yval 公式y的取值
	 * @param formulaStr 公式
	 * @return 格式化公式
	 * @author 
	 * @版本 v1.0.0
	 * @日期 2017-6-19
	 */
	private static String transformationFormulaB(String nval,String yval,String formulaStr){
		formulaStr = formulaStr.replace("n", nval);
		formulaStr = formulaStr.replace("y", yval);
		return formulaStr;
	}
	
	/**
	 * @描述 加法<br>
	 * @param d1 加数
	 * @param d2 加数
	 * @return 和
	 * @author 
	 * @版本 v1.0.0
	 * @日期 2017-6-19
	 */
	public static Double add(Double d1,Double d2){
		BigDecimal bd1 = new BigDecimal(d1.toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal bd2 = new BigDecimal(d2.toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		return bd1.add(bd2).doubleValue();
	}
	
	/**
	 * @描述 减法<br>
	 * @param d1 减数
	 * @param d2 减数
	 * @return 差
	 * @author 
	 * @版本 v1.0.0
	 * @日期 2017-6-19
	 */
	public static Double subtract(Double d1,Double d2){
		BigDecimal bd1 = new BigDecimal(d1.toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal bd2 = new BigDecimal(d2.toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		return bd1.subtract(bd2).doubleValue();
	}
	
	/**
	 * @描述 乘法<br>
	 * @param d1 被乘数
	 * @param d2 乘数
	 * @return 积
	 * @author 
	 * @版本 v1.0.0
	 * @日期 2017-6-19
	 */
	public static Double multiply (Double d1,Double d2){
		BigDecimal bd1 = new BigDecimal(d1.toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal bd2 = new BigDecimal(d2.toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		return bd1.multiply(bd2).doubleValue();
	}
	
	/**
	 * @描述 除法<br>
	 * @param d1 被除数
	 * @param d2 除数
	 * @return 商
	 * @author 
	 * @版本 v1.0.0
	 * @日期 2017-6-19
	 */
	public static Double divide(Double d1,Double d2){
		BigDecimal bd1 = new BigDecimal(d1.toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		BigDecimal bd2 = new BigDecimal(d2.toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
		return bd1.divide(bd2).doubleValue();
	}

	/**
	 * @描述 公式代入<br>
	 * @param params n值
	 * @param formulaStr 公式，包涵一个未知函数n,格式：(1+1+0.1*(n-1))*(n/2)* (500*0.01)
	 * @return 运算结果
	 * @author 
	 * @版本 v1.0.0
	 * @日期 2017-6-16
	 */
	public static double doCalculationA(String n,String formulaStr){
		formulaStr = transformationFormulaA(n, formulaStr);
		Formula formula = new Formula(formulaStr);
		return formula.getResult();
	}

	/**
	 * @描述 公式代入<br>
	 * @param n n值
	 * @param y y值
	 * @param formulaStr 公式，包涵一个未知函数n,格式：(1+1+0.1*(n-1))*(n/2)* (y*0.01)
	 * @return 运算结果
	 * @author 
	 * @版本 v1.0.0
	 * @日期 2017-6-16
	 */
	public static double doCalculationB(String n,String y,String formulaStr){
		formulaStr = transformationFormulaB(n, y, formulaStr);
		Formula formula = new Formula(formulaStr);
		return formula.getResult();
	}
	
	/**
	 * @描述 计算机收益下降<br>
	 * @param day
	 * @return map down:距离下次下降天数  profit:当前收益指数 after:将要下降指数
	 * @author 
	 * @版本 v1.0.0
	 * @日期 2017-6-17
	 */
	public static Map<String,Object> checkProfit(int day,int count){
		String profit="";
		String after="";
		int down=0;
		if(day<=count||day==0){
			profit="100%";
			down = count-day;
			after = "1/3";
		}else{
			if(day>count&&count<=30){
				profit = "2/3";
				down = (count*2)-day;
				after = "2/3";
			}
			if(day>(count*2)&&day<=(count*3)){
				profit = "1/3";
				down = (count*3)-day;
				after = "100%";
			}
			
			if(day>=(count*3)){
				profit = "0";
				down = 0;
				after = "100%";
			}
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("profit", profit);
		map.put("down", down);
		map.put("after", after);
		return map;
	}
	
	public static void main(String[] args) {
//		String s = transformationFormulaA("4", "(1+1+0.1*(n-1))*(n/2)*(500*0.01)");
//		System.out.println(s);
/*		int day = 14;
		Map<String,Object> map = checkProfit(day,15);
		String profit = map.get("profit").toString();
		String after = map.get("after").toString();
		String down = map.get("down").toString();
		System.out.println("天数："+day+";当前获得收益："+profit+";还有"+down+"天;全部收益下降"+after);
		*/
		Double a = MatchUtils.doCalculationB(String.valueOf("5"), "500", "(1+1+0.1*(n-1))*(n/2)*(y*0.01)");
		Double c = MatchUtils.doCalculationB(String.valueOf("6"), "500", "(1+1+0.1*(n-1))*(n/2)*(y*0.01)");
		System.out.println(a);
		System.out.println(c);
	}
}
