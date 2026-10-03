package net.ibizsys.paas.core;

/**
 * 实体操作向导项接口
 * @author Administrator
 *
 */
public interface IDEActionWizardItem extends IModelBase{
	
	/**
	 * 获取实体操作向导
	 * @return
	 */
	IDEActionWizard getDEActionWizard();
	
	/**
	 * 获取提示内容
	 * @return
	 */
	String getContent();
	
	
	
	/**
	 * 获取更多提示的链接
	 * @return
	 */
	String getMoreUrl();
	
	
	/**
	 * 获取操作值
	 * @return
	 */
	String getActionValue();
}
