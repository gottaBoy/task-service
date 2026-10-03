package net.ibizsys.model.dataentity.mainstate;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;


/**
 * 实体主数据状态相关操作标识
 * @author lionlau
 *
 */
public interface IPSDEMainStateOPPriv extends IPSModelObject
{
	
	
	/**
	 * 获取实体主状态
	 * @return
	 */
	IPSDEMainState getPSDEMainState();
	
	/**
	 * 获取实体操作标识
	 * @return
	 */
	String getPSDEOPPrivId();
	
	
	
	/**
	 * 获取实体操作标识对象
	 * @return
	 */
	IPSDEOPPriv getPSDEOPPriv();
}
