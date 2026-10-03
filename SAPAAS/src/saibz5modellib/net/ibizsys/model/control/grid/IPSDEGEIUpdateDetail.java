package net.ibizsys.model.control.grid;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 实体表格编辑项值更新处理成员对象接口
 * @author Administrator
 *
 */
public interface IPSDEGEIUpdateDetail extends IPSModelObject
{
	
	
	/**
	 * 获取表格编辑项更新对象
	 * @return
	 */
	IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate();
	
	/**
	 *  获取表格编辑项名称
	 * @return
	 */
	String getPSDEGridColumnName();
	
	
	/**
	 * 获取表格编辑项标识
	 * @return
	 */
	String getPSDEGridColumnId();
	
	
	
}
