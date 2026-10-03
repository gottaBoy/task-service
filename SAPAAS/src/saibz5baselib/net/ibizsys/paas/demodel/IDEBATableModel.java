package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEBATable;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.data.ISimpleDataObject;

/**
 * 实体大数据相关模型
 * @author Administrator
 *
 */
public interface IDEBATableModel extends IDEBATable,IModelBase3 {

	
	
	
	/**
	 * 获取传入数据对象的行键值
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	String getRowKey(ISimpleDataObject iEntity)throws Exception;
}
