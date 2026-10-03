package net.ibizsys.model.view;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 云平台视图类型对象接口
 * @author Administrator
 *
 */
public interface IPSViewType extends IPSModelObject
{

	/**
	 * 是否为实体视图类型
	 * @return
	 */
	boolean isDEViewType();
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	
	/**
	 * 是否为嵌入视图
	 * @return
	 */
	boolean isEmbeddedView();

}
