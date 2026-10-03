package net.ibizsys.model.control.ajax;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;

/**
 * 异步处理对象接口
 * @author Administrator
 *
 */
public interface IPSAjaxHandler extends IPSModelObject {

	
	
	
	/**
	 * 获取处理器对象
	 * @return
	 */
	String getHandlerObj();
	
	
	
	
	/**
	 * 获取后台处理行为集合
	 * @return
	 */
	java.util.Iterator<IPSAjaxHandlerAction> getPSAjaxHandlerActions();
	
	
	
	/**
	 * 获取后台处理行为对象
	 * @param strName
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSAjaxHandlerAction getPSAjaxHandlerAction(String strName,boolean bTryMode)throws Exception;
	
	
	
	
	/**
	 * 获取应用视图对象
	 * @return
	 */
	IPSAppView getPSAppView();
	
	
	/**
	 * 获取用户标记
	 * @return
	 */
	String getUserTag();
	
	
	/**
	 * 获取用户标记2
	 * @return
	 */
	String getUserTag2();
	
	
	/**
	 * 获取用户标记3
	 * @return
	 */
	String getUserTag3();
	
	/**
	 * 获取用户标记4
	 * @return
	 */
	String getUserTag4();
}
