package net.ibizsys.model.pf;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.sf.json.JSONObject;

/**
 * AngularJS 状态项接口
 * @author Administrator
 *
 */
public interface IPSNGState extends IPSModelObject {
	
	/**
	 * 获取完整的状态名称
	 * @return
	 */
	String getFullStateName();
	
	/**
	 * 获取父状态
	 * @return
	 */
	IPSNGState getParentState();
	
	/**
	 * 获取应用视图
	 * @return
	 */
	IPSAppView getPSAppView();
	
	
	
	/**
	 * 获取子状态集合
	 * @return
	 */
	java.util.Iterator<IPSNGState> getChildStates();
	
	
	/**
	 * 获取层级值
	 * @return
	 */
	int getLevel();
	
	
	
	/**
	 * 获取容器标识
	 * @return
	 */
	String getCId();
	
	
	/**
	 * 获取视图参数JO
	 * @return
	 */
	JSONObject getViewParamJO();
	
	
	
	/**
	 * 获取视图Json字符串
	 * @return
	 */
	String getViewParamJOString();
}
