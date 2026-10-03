package net.ibizsys.model.dataentity.priv;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.paas.core.IDEOPPriv;


/**
 * 实体操作标识对象接口
 * @author Administrator
 *
 */
public interface IPSDEOPPriv extends IPSSystemObject,IDEOPPriv
{
	
	/**
	 * 获取实体对象
	 * @return
	 */
	IPSDataEntity getPSDataEntity();
	
	  
	/**
	 * 获取逻辑名称
	 * @return
	 */
	String getLogicName();
	
	
	
	/**
	 * 获取关系名称
	 * @return
	 */
	String getPSDERName();
	

	
	/**
	 * 获取映射关系对象
	 * @return
	 */
	IPSDERBase getPSDER();

	/**
	 * 获取映射实体操作标识
	 * @return
	 */
	String getMapPSDEOPPrivName();
}
