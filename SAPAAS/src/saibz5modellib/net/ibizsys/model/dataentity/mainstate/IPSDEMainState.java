package net.ibizsys.model.dataentity.mainstate;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.paas.core.IDEMainState;


/**
 * 实体主状态对象接口
 * @author lionlau
 *
 */
public interface IPSDEMainState extends IPSDataEntityObject,IDEMainState,IPSModelObject
{

	
	
	/**
	 * 获取主状态相关实体行为集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEMainStateAction> getPSDEMainStateActions();
	
	
	/**
	 * 获取主状态相关实体操作标识集合
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEMainStateOPPriv> getPSDEMainStateOPPrivs();
	
	
	
	/**
	 * 获取实体数据查询
	 * @return
	 */
	IPSDEDataQuery getPSDEDataQuery();
	
	/**
	 * 获取实体数据查询标示
	 * @return
	 */
	String getPSDEDataQueryId();
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	
	
	
	/**
	 * 是否启用视图操作控制
	 * @return
	 */
	boolean isEnableViewActions();
	
	
	
	/**
	 * 获取视图操作控制
	 * @return
	 */
	long getViewActions();
}
