package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.core.IPSModelObject;


/**
 * 系统预置视图对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSSysPDTView extends IPSSystemObject,IPSModelObject {
	

	/**
	 * 获取云平台预置视图标识
	 * 
	 * @return
	 */
	String getPSPDTViewId();

	/**
	 * 获取关联的实体视图标识
	 * 
	 * @return
	 */
	String getPSDEViewBaseId();

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption(String strLanguage);
}
