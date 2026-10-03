package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.entity.IEntity;


/**
 * 动态代码表模型容器
 * @author Administrator
 *
 */
public interface IDynaCodeListModelContainer extends ICodeListModel {

	/**
	 * 注册动态代码表模型
	 * @param iDynaCodeListModel
	 * @throws Exception
	 */
	void registerDynaCodeListModel(IDynaCodeListModel iDynaCodeListModel)throws Exception;
	
	
	
	/**
	 * 重置当前动态系统实例
	 */
	void resetCurrentDynaSysInst();
	
	
	/**
	 * 重置全部动态系统实例
	 */
	void resetAllDynaSysInst();
	
	
	
	/**
	 * 建立动态代码表模型对象
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	IDynaCodeListModel createDynaCodeListModel(IEntity iEntity)throws Exception;
}
