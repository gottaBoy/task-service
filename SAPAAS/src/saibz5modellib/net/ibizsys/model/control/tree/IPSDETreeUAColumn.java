package net.ibizsys.model.control.tree;

import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;

/**
 * 实体树视图操作列对象接口
 * @author lionlau
 *
 */
public interface IPSDETreeUAColumn extends IPSDETreeColumn
{
	/**
	 * 获取对应的操作界面组
	 * @return
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup();
}
