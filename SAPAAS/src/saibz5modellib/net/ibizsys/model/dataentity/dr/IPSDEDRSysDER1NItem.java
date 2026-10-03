package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.der.IPSDER1N;


/**
 * 实体关系项(系统DER1N)接口
 * @author Administrator
 *
 */
public interface IPSDEDRSysDER1NItem extends IPSDEDRItem
{
	/**
	 * 获取关系名称
	 * @return
	 */
	String getPSDER1NName();
	
	
	/**
	 * 获取1:N关系对象
	 * @return
	 */
	IPSDER1N getPSDER1N();
	
}
