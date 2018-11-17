package com.hebut.bookshare.datasource;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp2.BasicDataSource;


/**
 * <p>Class Name: DataSourceListener</p>
 * <P>Package: com.hebut.bookshare.datasource</p>
 * <p>Description: 上下文环境、数据库连接池获取连接监听器</p>
 * <p>CopyRight: Hebut</p>
 * @author Administrator
 * @date 2016年12月6日 上午10:50:04
 */
public class DataSourceListener implements ServletContextListener {


	
	public DataSourceListener() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* 初始化上下文环境时获取从数据库连接池中拿到数据库连接
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {

		try {
			//1.获取上下文环境
			Context mContext = new InitialContext();
			//2.根据上下文环境查找数据源资源存在的环境
			Context envContext = (Context) mContext.lookup("java:/comp/env");
			//3.根据数据源存在的环境查找相应的数据源
			BasicDataSource basicDataSource = (BasicDataSource) envContext.lookup("jdbc/bookshare");
			//打一下测试
			if(basicDataSource !=null)
				System.out.println("数据源存在！获取成功！");
			else
				System.out.println("从数据库连接池获取数据源失败！请查看数据源连接配置及数据库！");
			//4.因为DataSourceProvider是单例模式，为其提供数据源
			DataSourceProvider dataSourceProvider = DataSourceProvider.getInstance();
			dataSourceProvider.setBasicDataSource(basicDataSource);
			System.out.println("DataSourceProvider成功获取数据库连接源准备给客户提供连接！");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/* 销毁上下文环境时获取从数据连接提供者拿回数据库连接
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {

		//当上下文环境销毁的时候，监听器收回给客户的连接
		DataSourceProvider dataSourceProvider = DataSourceProvider.getInstance();
		BasicDataSource basicDataSource = dataSourceProvider.getBasicDataSource();

		try {
			basicDataSource.close();
			System.out.println("数据库连接返回数据库连接池成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接返回数据库连接池失败！");
		}
	}



}
