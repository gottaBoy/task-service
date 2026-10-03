package net.ibizsys.paas.core;

import net.ibizsys.paas.entity.IEntity;

/**
 * 实体工作流接口
 * 
 * @author lionlau
 *
 */
public interface IDEWF extends IDataEntityObject {
	/**
	 * 初始化
	 * 
	 * @param iDataEntity
	 * @throws Exception
	 */
	void init(IDataEntity iDataEntity) throws Exception;

	/**
	 * 获取流程表标识
	 * 
	 * @return
	 */
	String getWorkflowId();

	/**
	 * 获取流程步骤实体属性
	 * 
	 * @return
	 */
	String getWFStepField();

	/**
	 * 获取流程状态实体属性
	 * 
	 * @return
	 */
	String getWFStateField();

	/**
	 * 获取用户状态实体属性
	 * 
	 * @return
	 */
	String getUDStateField();

	/**
	 * 获取流程实例名称
	 * 
	 * @return
	 */
	String getWFInstField();

	/**
	 * 获取用户数据流程状态值
	 * 
	 * @return
	 */
	String getEntityWFState();

	/**
	 * 获取流程操作者属性
	 * 
	 * @return
	 */
	String getWFActorsField();

	/**
	 * 获取流程返回值属性
	 * 
	 * @return
	 */
	String getWFRetField();

	/**
	 * 判断数据是否在流程中
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	boolean testDataInWF(IEntity iEntity) throws Exception;

	/**
	 * 获取指定数据的流程数据界面预置参数
	 * 
	 * @param iEntity
	 * @param bWorkMode
	 * @return
	 * @throws Exception
	 */
	String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode) throws Exception;
	
	
	/**
	 * 获取指定数据的流程数据界面预置参数
	 * 
	 * @param iEntity
	 * @param bWorkMode
	 * @param nAppType 应用类型
	 * @return
	 * @throws Exception
	 */
	String getWFEditViewPDTParam(IEntity iEntity, boolean bWorkMode, int nAppType) throws Exception;
	

	/**
	 * 获取启动流程名称
	 * 
	 * @return
	 */
	String getWFStartName();

	/**
	 * 获取流程版本属性
	 * 
	 * @return
	 */
	String getWFVerField();

	/**
	 * 获取流程标识存储属性
	 * 
	 * @return
	 */
	String getWorkflowField();

	/**
	 * 获取流程模式
	 * 
	 * @return
	 */
	String getWFMode();
}
