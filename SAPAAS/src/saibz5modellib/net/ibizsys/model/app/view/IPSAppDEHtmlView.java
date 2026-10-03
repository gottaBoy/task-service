package net.ibizsys.model.app.view;

/**
 * 应用实体Html视图
 * @author Administrator
 *
 */
public interface IPSAppDEHtmlView extends IPSAppDEView {

	/**
	 * Html路径
	 */
	public final static String VIEWPARAM_UI_HTMLURL = "UI.HTMLURL";
	
	/**
	 * Html路径配置键值
	 */
	public final static String VIEWPARAM_UI_HTMLURLKEY = "UI.HTMLURLKEY";
	
	/**
	 * 获取网页路径
	 * @return
	 */
	String getHtmlUrl();
}
