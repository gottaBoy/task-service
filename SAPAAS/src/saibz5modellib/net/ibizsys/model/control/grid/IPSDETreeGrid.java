package net.ibizsys.model.control.grid;

import net.ibizsys.model.dataentity.field.IPSDEField;

/**
 * 实体树表格对象接口
 * @author Administrator
 *
 */
public interface IPSDETreeGrid extends IPSDEGrid
{
	/**
	 * 获取树父数据属性
	 * @return
	 */
	IPSDEField getTreePPSDEF();
}
