package net.ibizsys.model.dataentity.logic;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;


/**
 * 实体逻辑参数对象接口
 * @author lionlau
 *
 */
public interface IPSDELogicParam extends IPSModelObject
{
	
	
	/**
	 * 获取实体逻辑对象
	 * @return
	 */
	IPSDELogic getPSDELogic();
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	
	
	
	/**
	 * 获取参数对应的实体
	 * @return
	 */
	IPSDataEntity getParamPSDataEntity() throws Exception;
	
	
	
	/**
	 * 是否为默认参数
	 * @return
	 */
	boolean isDefault();
	
	
	
	/**
	 * 是否为当前操作会话参数
	 * @return
	 */
	boolean isSessionParam();
	
	
	
	
	
	
	
	/**
	 * 获取为当前操作环境变量
	 * @return
	 */
	boolean isEnvParam();
}
