package net.ibizsys.model.app.view;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityObject;

/**
 * 应用实体视图对象接口
 * @author lionlau
 *
 */
public interface IPSAppDEView extends IPSAppView,IPSDataEntityObject
{

	
	/**
	 * 获取实体视图标识
	 * @return
	 */
	String getPSDEViewId();
	
	
	/**
	 * 获取实体视图名称
	 * @return
	 */
	String getPSDEViewName();
	
	
	
	
	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject#getPSDataEntity()
	 */
	IPSDataEntity getPSDataEntity();
	

	
	/**
	 * 获取视图临时数据模式，值参考  net.ibizsys.paas.ctrlhandler.ICtrlHandler.TEMPMODE_XXX 定义
	 * @return
	 */
	int getTempMode();
	
	
	
	/**
	 * 是否为实体工作流界面
	 * @return
	 */
	boolean isEnableWF();
	

	
	
}
