package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IDEFDTColumn;

/**
 * 实体属性数据列模型对象
 * @author Administrator
 *
 */
public interface IDEFDTColumnModel extends IDEFDTColumn{

	/**
	 * 获取数据库类型
	 * @return
	 */
	String getDBType();
}
