package net.ibizsys.paas.appmodel;

/**
 * 应用程序运行时
 * @author Administrator
 *
 */
public interface IApplicationRuntime {

	/**
	 * 获取应用程序的根路径
	 * @return
	 */
	String getApplicationUrl();
	
	
	/**
	 * 获取引用Html路径
	 * @return
	 */
	String getHtmlUrl(String strTag);
}
