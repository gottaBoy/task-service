package net.ibizsys.paas.core;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.psrt.srv.common.entity.DEDataChg;

/**
 * 实体数据变更派发参数
 * 
 * @author LionLau
 *
 */
public interface IDEDataChangeDispatchParam {
	/**
	 * 获取实体数据变更
	 * 
	 * @return
	 */
	DEDataChg getDEDataChg();

	// /**
	// * 获取XML导出节点
	// * @return
	// */
	// XMLNode getExportNode();
	//

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 */
	IDataEntity getDataEntity();

	/**
	 * 获取当前数据对象
	 * 
	 * @return
	 */
	IEntity getEntity();

	/**
	 * 获取关联数据对象集合
	 * 
	 * @return
	 */
	java.util.Iterator<IEntity> getRelatedEntities();
}
