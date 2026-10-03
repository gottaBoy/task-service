package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.res.IPSLanguageRes;

import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * 关系部件关系项对象接口
 * @author lionlau
 *
 */
public interface IPSDEDRCtrlItem extends IPSModelObject
{


	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();
	
	
	/**
	 * 获取数据关系成员对象
	 * @return
	 */
	IPSDEDRDetail getPSDEDRDetail();
	
	
	
	/**
	 * 获取关系页面对象
	 * @return
	 */
	IPSAppView getPSAppView();
	
	
	/**
	 * 获取嵌入视图编号
	 * @return
	 */
	String getEmbedViewId();
	
	/**
	 * 获取数据关系项对象
	 * @return
	 */
	IPSDEDRItem getPSDEDRItem();
	
	
	
	/**
	 * 获取视图参数JsonObject
	 * @return
	 */
	ObjectNode getViewParamJO();
	
	
	
	/**
	 * 获取标题语言资源对象
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();
}
