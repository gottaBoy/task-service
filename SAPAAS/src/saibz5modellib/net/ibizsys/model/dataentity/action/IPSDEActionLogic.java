package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.logic.IPSDELogic;


/**
 * 实体行为附加逻辑对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDEActionLogic extends IPSModelObject {
	/**
	 * 附加位置：执行之前
	 */
	public final static String ATTACHMODE_BEFORE = "BEFORE";

	/**
	 * 附加位置：执行之后
	 */
	public final static String ATTACHMODE_AFTER = "AFTER";

	
	
	/**
	 * 获取实体行为
	 * @return
	 */
	IPSDEAction getPSDEAction();
	
	/**
	 * 获取附加模式
	 * 
	 * @return
	 */
	String getAttachMode();

	/**
	 * 获取实体逻辑表标识
	 * 
	 * @return
	 */
	String getPSDELogicId();

	/**
	 * 获取实体逻辑表名称
	 * 
	 * @return
	 */
	String getPSDELogicName();

	/**
	 * 获取实体逻辑对象
	 * 
	 * @return
	 */
	IPSDELogic getPSDELogic() throws Exception;

	/**
	 * 是否为内部逻辑
	 * 
	 * @return
	 */
	boolean isInternalLogic();

	/**
	 * 获取附加实体
	 * 
	 * @return
	 */
	IPSDataEntity getDstPSDE() throws Exception;

	/**
	 * 获取附加实体行为
	 * 
	 * @return
	 */
	IPSDEAction getDstPSDEAction() throws Exception;

	/**
	 * 是否启用
	 * 
	 * @return
	 */
	boolean isValid();
	
	
	
	/**
	 * 是否克隆传入参数
	 * @return
	 */
	boolean isCloneParam();
	
	
	
	/**
	 * 是否忽略处理异常
	 * @return
	 */
	boolean isIgnoreException();
}
