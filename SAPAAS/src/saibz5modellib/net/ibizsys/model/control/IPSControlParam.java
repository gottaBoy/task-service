package net.ibizsys.model.control;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;

/**
 * 控件参数对象接口
 * @author Administrator
 *
 */
public interface IPSControlParam extends IPSModelObject {

	/**
	 * 获取应用视图
	 * 
	 * @return
	 */
	IPSAppView getPSAppView();

	/**
	 * 获取页面参数
	 * 
	 * @param strParamName
	 * @return
	 */
	Object getCtrlParam(String strParamName);

	/**
	 * 包括指定的控件参数
	 * 
	 * @param strParamName
	 * @return
	 */
	boolean containsCtrlParam(String strParamName);

	/**
	 * 获取页面参数
	 * 
	 * @param strParamName
	 * @return
	 */
	String getCtrlParam(String strParamName, String strDefault);

	/**
	 * 获取页面参数
	 * 
	 * @param strParamName
	 * @return
	 */
	boolean getCtrlParam(String strParamName, boolean bDefault);

	/**
	 * 获取页面参数
	 * 
	 * @param strParamName
	 * @param nDefault
	 * @return
	 */
	int getCtrlParam(String strParamName, int nDefault);

	/**
	 * 获取页面参数名称集合
	 * 
	 * @return
	 */
	java.util.Iterator<String> getCtrlParamNames();

	/**
	 * 获取宽度
	 * 
	 * @return
	 */
	Double getWidth();

	/**
	 * 获取高度
	 * 
	 * @return
	 */
	Double getHeight();

	/**
	 * 获取控件的排序值
	 * 
	 * @return
	 */
	Integer getOrderValue();

	/**
	 * 获取附件控件参数
	 * 
	 * @return
	 */
	String getCtrlParam();

	/**
	 * 获取附件控件参数2
	 * 
	 * @return
	 */
	String getCtrlParam2();



	/**
	 * 是否为视图默认部件
	 * 
	 * @return
	 */
	Boolean isDefaultCtrl();
	
	
	/**
	 * 是否为动态部件
	 * 
	 * @return
	 */
	Boolean isDynamicCtrl();
	
	
	
	/**
	 * 获取部件样式标识
	 * 
	 * @return
	 */
	String getPSSysCssId();
	
}
