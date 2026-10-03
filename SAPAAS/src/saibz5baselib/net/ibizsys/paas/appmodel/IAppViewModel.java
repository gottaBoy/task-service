package net.ibizsys.paas.appmodel;

import net.ibizsys.paas.core.IModelBase;

/**
 * 应用视图模型接口
 * 
 * @author Administrator
 *
 */
public interface IAppViewModel extends IModelBase {
	/**
	 * 获取视图标题
	 * 
	 * @return
	 */
	String getTitle();

	/**
	 * 获取模块代码名称
	 * 
	 * @return
	 */
	String getModuleName();

	/**
	 * 获取打开模式
	 * 
	 * @return
	 */
	String getOpenMode();

	/**
	 * 获取视图宽度
	 * 
	 * @return
	 */
	int getWidth();

	/**
	 * 获取视图高度
	 * 
	 * @return
	 */
	int getHeight();
	
	
	
	
	/**
	 * 获取视图路径
	 * @return
	 */
	String getViewUrl();
	
	
	/**
	 * 获取应用标识
	 * @return
	 */
	String getAppId();
	
	
	/**
	 * 获取用户数据
	 * @return
	 */
	Object getUserData();
	
	
	
	
	/**
	 * 获取用户数据
	 * @return
	 */
	Object getUserData2();
}
