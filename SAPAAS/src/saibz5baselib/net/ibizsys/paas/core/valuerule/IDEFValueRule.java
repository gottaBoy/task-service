package net.ibizsys.paas.core.valuerule;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IModelBase;

/**
 * 属性之规则接口
 * 
 * @author lionlau
 *
 */
public interface IDEFValueRule extends IModelBase {
	/**
	 * 获取实体
	 * 
	 * @return
	 */
	IDataEntity getDataEntity();

	/**
	 * 获取属性
	 * 
	 * @return
	 */
	IDEField getDEField();

}
