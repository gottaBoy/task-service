package net.ibizsys.model.control.drctrl;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;
import net.ibizsys.model.res.IPSLanguageRes;


/**
 * 实体数据关系栏分组对象接口
 * @author Administrator
 *
 */
public interface IPSDEDRBarGroup extends IPSModelObject
{

	
	
	/**
	 * 实体数据关系栏对象
	 * @return
	 */
	IPSDEDRBar getPSDEDRBar();
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption();

	
	
	
	/**
	 * 获取分组项
	 * @return
	 */
	java.util.Iterator<IPSDEDRBarItem> getPSDEDRBarItems();
	
	
	
	
	
	/**
	 * 获取实体关系分组对象
	 * @return
	 */
	IPSDEDRGroup getPSDEDRGroup();
	
	
	
	/**
	 * 是否为隐藏分组
	 * @return
	 */
	boolean isHidden();
	
	
	/**
	 * 获取标题语言资源
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();
}
