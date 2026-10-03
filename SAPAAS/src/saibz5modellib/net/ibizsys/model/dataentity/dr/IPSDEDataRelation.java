package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;


/**
 * 实体数据关系对象接口
 * @author lionlau
 *
 */
public interface IPSDEDataRelation extends IPSDataEntityObject
{
	
	
	/**
	 * 获取关系项集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEDRDetail> getPSDEDRDetails();
	
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	
	
	/**
	 * 获取系统计数器标识
	 * @return
	 */
	String getPSSysCounterId();
	
	
	
	
	/**
	 * 获取承载表单的视图标识
	 * @return
	 */
	String getFormPSDEViewBaseId();
	
	
	/**
	 * 获取表单项的标题
	 * @return
	 */
	String getFormCaption();
	
	
	
	/**
	 * 获取表单项的标题语言标题
	 * @return
	 */
	IPSLanguageRes getFormCapPSLanguageRes();
	
	
	/**
	 * 获取表单项的图标资源
	 * @return
	 */
	IPSSysImage getFormPSSysImage();
	
	/**
	 * 是否影响默认的编辑项
	 * @return
	 */
	boolean isHideEditItem();
}
