package net.ibizsys.pswf.core;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.entity.IEntity;


/**
 * 流程实体模型接口
 * @author lionlau
 *
 */
public interface IWFDEModel
{
	/**
	 * 获取标识
	 * @return
	 */
	String getId();
	
	
	/**
	 * 获取名称
	 * @return
	 */
	String getName();
	
	
	/**
	 * 获取工作流模型对象
	 * @return
	 */
	IWFModel getWFModel();
	
	
	/**
	 * 获取流程步骤实体属性
	 * @return
	 */
	String getWFStepField();
	
	
	
	/**
	 * 获取流程状态实体属性
	 * @return
	 */
	String getWFStateField();
	
	
	
	/**
	 * 获取用户状态实体属性
	 * @return
	 */
	String getUDStateField();
	
	
	
	/**
	 * 获取流程结果属性
	 * @return
	 */
	String getWFRetField();
	
	
	
	/**
	 * 获取流程编号
	 * @return
	 */
	String getWorkflowId();
	
	
	/**
	 * 获取流程标识属性
	 * @return
	 */
	String getWorkflowField();
	
	
	/**
	 * 获取流程实例属性
	 * @return
	 */
	String getWFInstField();
	
	
	/**
	 * 获取用户数据流程状态值
	 * @return
	 */
	String getEntityWFState();
	
	
	
	/**
	 * 获取流程操作者属性
	 * @return
	 */
	String getWFActorsField();
	
	
	
	/**
	 * 判断数据是否在流程中
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	boolean testDataInWF(IEntity iEntity) throws Exception;
	
	
	
	/**
	 * 获取流程数据界面预定义视图参数
	 * @param iEntity
	 * @param bWorkMode
	 * @return
	 * @throws Exception
	 */
	String getWFEditViewPDTParam(IEntity iEntity,boolean bWorkMode) throws Exception;
	
	

	/**
	 * 判断当前用户是否具备流程提交能力
	 * @param iEntity
	 * @param strCurUserId
	 * @param sessionFactory
	 * @return
	 * @throws Exception
	 */
	boolean testUserWFSubmit(IEntity iEntity,String strCurUserId,SessionFactory sessionFactory) throws Exception;

	
	
	/**
	 * 获取流程启动名称
	 * @return
	 */
	String getWFStartName();
	
	
	
	/**
	 * 获取流程版本属性
	 * @return
	 */
	String getWFVerField();
	
	
	
	/**
	 * 获取流程模式
	 * @return
	 */
	String getWFMode();
}
