package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.entity.IEntity;

/**
 * 动态系统代码表模型对象接口
 * @author Administrator
 *
 */
public interface IDynaCodeListModel extends ICodeListModel,IDynaModelJsonLoader {

	/**
	 * 初始化
	 * @param iDynaCodeListModelContainer
	 * @param iEntity
	 * @throws Exception
	 */
	void init(IDynaCodeListModelContainer iDynaCodeListModelContainer,IEntity iEntity)throws Exception;
	
	
	
	/**
	 * 获取动态实例标识
	 * @return
	 */
	String getDynaInstId();
	
	
}
