package net.ibizsys.paas.core;

import net.ibizsys.paas.view.IViewWizardGroup;

/**
 * 实体操作向导组接口
 * @author Administrator
 *
 */
public interface IDEActionWizardGroup extends IViewWizardGroup,IDataEntityObject{
	
	/**
	 * 获取实体操作向导组成员集合
	 * @return
	 */
	java.util.Iterator<IDEActionWizard> getDEActionWizards();
 }
