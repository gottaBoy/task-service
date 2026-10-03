package net.ibizsys.model.control.calendar;

import java.util.ArrayList;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.control.IPSControlMDataContainer;
import net.ibizsys.model.control.IPSControlXDataContainer;
import net.ibizsys.model.control.toolbar.IPSDEContextMenu;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.ctrlmodel.ICalendarItemModel;

import com.fasterxml.jackson.databind.node.ObjectNode;



/**
 * 日历部件项对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSCalendarItem extends IPSModelObject, ICalendarItemModel, IPSControlXDataContainer, IPSControlMDataContainer {

	/**
	 * 获取实体
	 * 
	 * @return
	 */
	IPSDataEntity getPSDataEntity();

	/**
	 * 获取嵌入视图编号
	 * 
	 * @return
	 */
	String getEmbedViewId();

	/**
	 * 获取导航实体视图
	 * 
	 * @return
	 */
	String getNavPSDEViewId();

	/**
	 * 获取导航视图
	 * 
	 * @return
	 */
	IPSAppView getNavPSAppView();

	/**
	 * 获取导航视图参数
	 * 
	 * @return
	 */
	ObjectNode getNavViewParam();

	/**
	 * 获取系统图标
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();

	/**
	 * 获取上下文菜单对象
	 * 
	 * @return
	 */
	IPSDEContextMenu getPSDEContextMenu();

	/* INTERNAL-BEGIN */

	/**
	 * 填充相关的应用视图
	 * 
	 * @param relatedAppViewList
	 * @throws Exception
	 */
	void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception;

	/* INTERNAL-END */

	
	/**
	 * 获取日历项建立行为名称
	 * 
	 * @return
	 */
	String getCreatePSDEActionName();

	/**
	 * 获取日历项建立权限名称
	 * 
	 * @return
	 */
	String getCreatePSDEOPPrivName();
	
	
	/**
	 * 获取日历项更新行为名称
	 * 
	 * @return
	 */
	String getUpdatePSDEActionName();

	/**
	 * 获取日历项更新权限名称
	 * 
	 * @return
	 */
	String getUpdatePSDEOPPrivName();
	
	
	/**
	 * 获取日历项删除行为名称
	 * 
	 * @return
	 */
	String getRemovePSDEActionName();

	/**
	 * 获取日历项删除权限名称
	 * 
	 * @return
	 */
	String getRemovePSDEOPPrivName();

//	/**
//	 * 获取名称的语言资源
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getNamePSLanguageRes();

	
	
	/**
	 * 获取日历项数据项集合
	 * @return
	 */
	java.util.Iterator<IPSCalendarItemDataItem> getPSCalendarItemDataItems();
	
	
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
	 * 获取日历项模型对象
	 * @return
	 */
	String getModelObj();
}
