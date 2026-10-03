package net.ibizsys.model.control.form;

/**
 * 实体表单分页部件对象接口
 * @author Administrator
 *
 */
public interface IPSDEFormTabPanel extends IPSDEFormDetail
{
	/**
	 * 获取所有分页对象
	 * @return
	 */
	java.util.Iterator<IPSDEFormTabPage> getPSDEFormTabPages();
}
