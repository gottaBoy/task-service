package net.ibizsys.model.control.form;

/**
 * 实体表单分页对象接口
 * @author Administrator
 *
 */
public interface IPSDEFormPage extends IPSDEFormGroupPanel
{
	/**
	 * 获取首列标签列合并数量
	 * @return
	 */
	int getFirstLabelColSpan();
	
	
	
	/**
	 * 获取分页次序
	 * @return
	 */
	int getPageIndex();
}
