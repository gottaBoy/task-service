package net.ibizsys.paas.controller;

import net.ibizsys.paas.appmodel.IAppViewModel;

/**
 * 重定向视图控制器接口
 * 
 * @author Administrator
 *
 */
public interface IRedirectViewController extends IViewController {
	
	/**
	 * 获取重定向视图请求
	 */
	final static String VIEWACTION_GETRDVIEW = "GETRDVIEW";
	
	/**
	 * 获取重定向视图请求（直接获取URL)
	 */
	final static String VIEWACTION_GETRDVIEWURL = "GETRDVIEWURL";
	
	
	/**
	 * 获取是否支持工作流
	 * @return
	 */
	boolean isEnableWorkflow();
	
	/**
	 * 获取指定数据的重定向页面模型
	 * 
	 * @param strKeyValue 数据主键
	 * @return
	 * @throws Exception
	 */
	IAppViewModel getRDAppViewModel(String strKeyValue) throws Exception;
}
