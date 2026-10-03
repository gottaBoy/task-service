package net.ibizsys.paas.core;

import net.ibizsys.paas.data.DataObjectList;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDBTransaction;

/**
 * 实体行为调用上下文对象
 * 
 * @author Administrator
 *
 */
public interface IDEActionCallContext extends IActionContext, IDBTransaction {

	/**
	 * 获取Action模式
	 * 
	 * @return
	 */
	String getActionMode();

	/**
	 * 获取对象清单
	 * 
	 * @return
	 */
	DataObjectList getDataObjects();

	/**
	 * 获取数据对象
	 * 
	 * @return
	 */
	IDataObject getDataObject();

}
