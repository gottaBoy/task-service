package net.ibizsys.model.app.view;

/**
 * 应用导航视图对象接口
 * @author lionlau
 *
 */
public interface IPSAppExplorerView  extends IPSAppView
{
	/**
	 * 视图引用模式，导航项
	 */
	public final static String VIEWREFMODE_EXPITEM = "EXPITEM";
	
	
	/**
	 * 是否为Frame模式
	 * @return
	 */
	boolean isIFrameMode();
}
