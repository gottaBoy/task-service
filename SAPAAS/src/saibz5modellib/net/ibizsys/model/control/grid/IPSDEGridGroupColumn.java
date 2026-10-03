package net.ibizsys.model.control.grid;


/**
 * 实体表格组合列对象接口
 * @author lionlau
 *
 */
public interface IPSDEGridGroupColumn extends IPSDEGridColumn
{
	/**
	 * 获取组合列中列集合
	 * @return
	 */
	java.util.Iterator<IPSDEGridColumn> getPSDEGridColumns();

}
