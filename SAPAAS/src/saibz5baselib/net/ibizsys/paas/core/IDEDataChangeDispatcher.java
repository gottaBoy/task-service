package net.ibizsys.paas.core;

import net.ibizsys.psrt.srv.common.entity.DEDataChgDisp;

/**
 * 实体数据变化派送者
 * 
 * @author Administrator
 *
 */
public interface IDEDataChangeDispatcher {

	/**
	 * 初始化
	 * 
	 * @param deDataChgDisp
	 * @throws Exception
	 */
	void init(DEDataChgDisp deDataChgDisp) throws Exception;

	/**
	 * 获取引擎的名称
	 * 
	 * @return
	 */
	String getName();

	/**
	 * 派发数据
	 * 
	 * @param iDEDataChangeDispatchParam
	 * @throws Exception
	 */
	void dispatch(IDEDataChangeDispatchParam iDEDataChangeDispatchParam) throws Exception;
}
