package net.ibizsys.paas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.web.IWebContext;

/**
 * 动态视图控制器实例
 * @author Administrator
 *
 */
public interface IDynaViewControllerInst extends IViewController {
	
	/**
	 * 界面模型属性：部件集合
	 */
	final static String ATTR_CTRLS = "ctrls";
	
	/**
	 * 界面模型属性：界面行为集合
	 */
	final static String ATTR_UIACTIONS = "uiactions";
	
	
	/**
	 * 初始化
	 * @param iDynaViewController
	 * @param dsDynaViewInst
	 * @param iDynaViewSetting 动态视图设置对象
	 * @throws Exception
	 */
	void init(IDynaViewController iDynaViewController,IEntity dsDynaViewInst,IDynaViewSetting iDynaViewSetting)throws Exception;
	
	
	
	/**
	 * 实例处理请求
	 * @param request
	 * @param response
	 * @param iWebContext
	 * @return 已处理返回 true，否则返回false，交由视图继续处理
	 * @throws Exception
	 */
	boolean process(HttpServletRequest request, HttpServletResponse response, IWebContext iWebContext) throws Exception;
	
	
	
	/**
	 * 获取动态视图控制器对象
	 * @return
	 */
	IDynaViewController getDynaViewController();
	
	
	
	/**
	 * 获取动态视图设置对象
	 * @return
	 */
	IDynaViewSetting getDynaViewSetting();
	
	
	
	/**
	 * 获取对应的视图模式
	 * @return
	 */
	String getDynaViewMode();
}
