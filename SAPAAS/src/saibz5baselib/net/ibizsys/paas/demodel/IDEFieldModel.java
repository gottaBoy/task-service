package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEFDTColumn;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IModelBase3;

/**
 * 实体属性模型接口
 * 
 * @author Administrator
 *
 */
public interface IDEFieldModel extends IDEField,IModelBase3 {
	/**
	 * 获取链接的属性
	 * 
	 * @return
	 * @throws Exception
	 */
	IDEFieldModel getLinkDEField() throws Exception;

	/**
	 * 获取实际的的属性
	 * 
	 * @return
	 * @throws Exception
	 */
	IDEFieldModel getRealDEField() throws Exception;

	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	IDataEntityModel getDEModel();
	
	
	
	/**
	 * 注册实体属性数据列对象
	 * @param iDEFDTColumn
	 */
	void registerDEFDTColumn(IDEFDTColumn iDEFDTColumn);

	
}
