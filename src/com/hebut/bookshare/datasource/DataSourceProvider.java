package com.hebut.bookshare.datasource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * <p>Class Name: DataSourceProvider</p>
 * <P>Package: com.hebut.bookshare.datasource</p>
 * <p>Description:数据库连接提供者 </p>
 * <p>CopyRight: Hebut</p>
 * @author Administrator
 * @date 2016年12月6日 上午10:48:31
 */
public class DataSourceProvider {

	//首先，该类是基于单例模式写的一个类，存在于客户端与数据库连接池之间
	//单例模式必有的一个“自身私有静态”属性、“私有构造方法”和“一个共有的实例化get方法”
	private static DataSourceProvider instance;
	private BasicDataSource basicDataSource;//基本数据源供获取连接
	
	private DataSourceProvider() {
		super();
	}

	public BasicDataSource getBasicDataSource() {
		System.out.println("connectionManager正在取数据源");
		if(basicDataSource !=null){
		return this.basicDataSource;}
		else{
			System.out.println("basicDataSource==null");
			return null;
		}
	}

	public void setBasicDataSource(BasicDataSource basicDataSource) {
		System.out.println("监听器正在提供数据源...");
		this.basicDataSource = basicDataSource;
	}

	/**
	 * @description: 单例获取数据库提供者
	 * @author: Administrator
	 * @param: null
	 * @return DataSourceProvider
	 * @exception
	 * @date 2016年12月6日 上午10:49:12
	 */
	public static DataSourceProvider getInstance() {
		if(instance == null){
			instance = new DataSourceProvider();
			return instance;
		}else{
			return instance;
		}
	}
	
	
	
	
}
