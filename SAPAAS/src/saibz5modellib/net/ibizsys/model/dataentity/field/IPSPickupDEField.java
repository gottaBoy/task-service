package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.der.IPSDER1N;

/**
 * 实体外键属性对象接口
 * @author Administrator
 *
 */
public interface IPSPickupDEField extends IPSLinkDEField 
{
	/**
	 * 获取拾取文本属性辅助对象
	 * @return
	 */
	IPSLinkDEField getPSPickupTextDEField() throws Exception;
	
	
	/**
	 * 获取值拾取范围
	 * @return
	 */
	String getPickupDataRange();
	
	
	/**
	 * 获取1：N关系对象
	 * @return
	 */
	IPSDER1N getPSDER1N()throws Exception;
}
