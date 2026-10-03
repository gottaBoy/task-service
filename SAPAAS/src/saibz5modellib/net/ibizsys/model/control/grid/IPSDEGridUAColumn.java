package net.ibizsys.model.control.grid;

import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;

/**
 * 实体表格操作列对象接口
 * @author lionlau
 *
 */
public interface IPSDEGridUAColumn extends IPSDEGridColumn
{
	/**
	 * 获取对应的操作界面组
	 * @return
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup();
}
