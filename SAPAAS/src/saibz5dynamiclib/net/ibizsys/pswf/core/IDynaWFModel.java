package net.ibizsys.pswf.core;

import net.ibizsys.paas.entity.IEntity;

/**
 * 动态工作流模型对象接口
 * @author Administrator
 *
 */
public interface IDynaWFModel extends IWFModel {

	/**
	 * 注册动态工作流版本模型
	 * @param iDynaWFVersionModel
	 * @throws Exception
	 */
	void registerDynaWFVersionModel(IDynaWFVersionModel iDynaWFVersionModel)throws Exception;
	
	
	
	/**
	 * 重置当前动态系统实例
	 */
	void resetCurrentDynaSysInst();
	
	
	/**
	 * 重置全部动态系统实例
	 */
	void resetAllDynaSysInst();
	
	
	/**
	 * 建立动态流程版本模型对象
	 * @param iEntity 数据对象
	 * @return
	 * @throws Exception
	 */
	IDynaWFVersionModel createDynaWFVersionModel(IEntity iEntity)throws Exception;
}
