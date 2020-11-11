package com.iothings.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 
 * @author ZDL
 * @Description 字符串工具类
 */
public class StringUtil {

	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean existStrArr(String str,String []strArr){
		for(int i=0;i<strArr.length;i++){
			if(strArr[i].equals(str)){
				return true;
			}
		}
		return false;
	}
	
	//使用DecimalFormat,保留小数点后两位
	public static String format2(double value) {
		 
		 DecimalFormat df = new DecimalFormat("0.00");
		 df.setRoundingMode(RoundingMode.HALF_UP);
		 return df.format(value);
	}
	/**
	 * 截取参数长度
	 * @param str
	 * @param len
	 * @return 
	 */
	public static String subString(String str ,Integer len){
		String string = "";
		if(isNotEmpty(str)){
			if(str.length() < len){
				string = str.substring(0, str.length());
			}else{
				string = str.substring(0, len);
			}
		}
		return string;
	}
	
	/**
	 * 将数组中某个值取出
	 * @param json
	 * @param str
	 * @return
	 */
	public static String getArrayToString(String json, String str) {
		String jsonToStr = "";
		JSONArray array = JSON.parseArray("[" + json + "]");
		JSONObject object = JSON.parseObject(array.get(0) + "");
		Map<String, Object> map = object;
		for (Entry<String, Object> entry : map.entrySet()) {
			if (entry.getKey() == str || entry.getKey().equals(str)) {
				jsonToStr = entry.getValue() + "";
			}
		}
		return jsonToStr;
	}
	/**
	 * 可以指定字符串的某个位置是什么范围的值
	 * @param length
	 * @return
	 */
	public static String getRandomString2(int length){
	    Random random=new Random();
	    StringBuffer sb=new StringBuffer();
	    for(int i=0;i<length;i++){
	       int number=random.nextInt(3);
	       long result=0;
	       switch(number){
	          case 0:
	              result=Math.round(Math.random()*25+65);
	              sb.append(String.valueOf((char)result));
	              break;
	         case 1:
	             result=Math.round(Math.random()*25+97);
	             sb.append(String.valueOf((char)result));
	             break;
	         case 2:    
	             sb.append(String.valueOf(new Random().nextInt(10)));
	             break;
	        }
	     }
	     return sb.toString();
	 }
}
