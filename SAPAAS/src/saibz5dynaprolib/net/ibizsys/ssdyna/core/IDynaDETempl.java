package net.ibizsys.ssdyna.core;

import net.ibizsys.paas.core.IModelBase2;

/**
 * 动态实体模板
 * @author Administrator
 *
 */
public interface IDynaDETempl extends IModelBase2{

	/**
	 *  获取模板实体标识
	 * @return
	 */
	String getTemplDEId();
	
	
	/**
	 *  获取模板实体名称
	 * @return
	 */
	String getTemplDEName();
}
