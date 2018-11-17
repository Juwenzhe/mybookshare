package com.hebut.bookshare.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 * <p>Class Name: RequestToBean</p>
 * <P>Package: com.hebut.bookshare.utils</p>
 * <p>Description: 自动封装请求参数，包含两个部分：1.处理时间的静态块；2.完成自动封装的静态方法</p>
 * <p>CopyRight: Hebut</p>
 * @author Administrator
 * @date 2016年12月6日 下午8:33:36
 */
public class RequestToBean {

	static{
		//创建一个可识别的时间格式
		String[] patterns = {"yyyy-MM-dd", "yyyy/MM/dd", "yyyy年MM月dd日"};
		//利用[org.apache.commons.beanutils.converters.DateConverter]新出的类，时间格式转换类
		DateConverter converter = new DateConverter();
		converter.setPatterns(patterns);
		//转换时间格式
		ConvertUtils.register(converter, java.util.Date.class);
	}
	
	/**
	 * @description: 利用org.apache.commons.beanutils.BeanUtils类完成自动封装，Object就是待封装成的类
	 * @author: Administrator
	 * @param
	 * @return void
	 * @exception
	 * @date 2016年12月6日 下午8:57:57
	 */
	public static void populate(HttpServletRequest request, Object bean){
		
		//首先获取请求里的每个属性及属性值，装载到一个Map集合中
		Map<String, String[]> properties = request.getParameterMap();
		try {
			//利用org.apache.commons.beanutils.BeanUtils类自动封装
			BeanUtils.populate(bean, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
