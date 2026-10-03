package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;


/**
 * 视图数据关系部件对象接口
 * @author Administrator
 *
 */
public interface IPSDEDRCtrl extends IPSDRCtrl
{
	/**
	 * 获取界面关系项集合
	 * @return
	 */
	java.util.Iterator<IPSDEDRCtrlItem> getPSDEDRCtrlItems();
	
	
	/**
	 * 获取界面关系项集合长度
	 * @return
	 */
	int getPSDEDRCtrlItemCount();
	
	
	/**
	 * 获取指定的表单视图
	 * @return
	 */
	IPSAppView getFormPSAppView();
	
	
	
	/**
	 * 获取实体数据关系组
	 * @return
	 */
	IPSDEDataRelation getPSDEDataRelation();
	
	
	
	/**
	 * 是否隐藏默认编辑项
	 * @return
	 */
	boolean isHideEditItem();
	
	
	
}
