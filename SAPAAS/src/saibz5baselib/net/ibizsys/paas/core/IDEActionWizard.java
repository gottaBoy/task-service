package net.ibizsys.paas.core;

import net.ibizsys.paas.view.IViewWizard;

/**
 * 实体操作向导接口
 * @author Administrator
 *
 */
public interface IDEActionWizard extends IViewWizard,IDataEntityObject{
	
	/**
	 * 动态模式（静态）
	 */
	final static int DYNAMICMODE_STATIC = 0;

	/**
	 * 动态模式（实体数据集合）
	 */
	final static int DYNAMICMODE_DEDATASET = 1;
	
	/**
	 * 获取实体操作向导项集合
	 * @return
	 */
	java.util.Iterator<IDEActionWizardItem> getDEActionWizardItems();
	
	
	/**
	 * 关键字
	 * @return
	 */
	String getKeywords();
}
