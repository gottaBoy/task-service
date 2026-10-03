package net.ibizsys.paas.core;


/**
 * iBiz Runtime 功能插件接口对象
 * @author Administrator
 *
 */
public interface IPlugin {
	
	/**
	 * 进入行为（可替换）
	 */
	final int ACTIONPOS_ENTER = 0;
	
	
	/**
	 * onBefore 之前
	 */
	final int ACTIONPOS_BEFOREBEFORE = 30;
	
	
	/**
	 * onBefore 之后
	 */
	final int ACTIONPOS_AFTERBEFORE = 31;
	
	
	/**
	 * 实际操作（可替换）
	 */
	final int ACTIONPOS_ACTION = 40;
	
	
	/**
	 * 实际操作2（可替换）
	 */
	final int ACTIONPOS_ACTION2 = 45;
	
	
	
	/**
	 * 实际操作3（可替换）
	 */
	final int ACTIONPOS_ACTION3 = 50;
	
	
	
	/**
	 * onAfter 之前
	 */
	final int ACTIONPOS_BEFOREAFTER = 60;
	
	
	/**
	 * onAfter 之后
	 */
	final int ACTIONPOS_AFTERAFTER = 61;
	
	/**
	 * 离开行为
	 */
	final int ACTIONPOS_LEAVE = 99;
	
	
	/**
	 * 初始化插件
	 * @param strPluginParams
	 * @throws Exception
	 */
	void init(String strPluginParams)throws Exception;
	
	
	
	/**
	 * 设置上一个插件
	 * @param iPlugin
	 */
	void setPrevPlugin(IPlugin iPlugin);
}
