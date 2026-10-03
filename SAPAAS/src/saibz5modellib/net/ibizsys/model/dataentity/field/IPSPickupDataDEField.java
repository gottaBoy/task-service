package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.der.IPSDER1N;

/**
 * 外键附加数据实体属性对象接口
 * @author Administrator
 *
 */
public interface IPSPickupDataDEField extends IPSLinkDEField 
{
	/**
	 * 获取拾取文本属性辅助对象
	 * @return
	 */
	IPSPickupDEField getPSPickupDEField() throws Exception;
	

	/**
	 * 获取1：N关系对象
	 * @return
	 */
	IPSDER1N getPSDER1N() throws Exception;
	
	
	
	
	/**
	 * 支持回写属性值
	 * @return
	 */
	boolean isEnableWriteBack();
}
