package net.ibizsys.model.data;

import net.ibizsys.model.core.IPSModelObject;


/**
 * 数据库值操作符号对象接口
 * @author lionlau
 *
 */
public interface IPSDBValueOP extends IPSModelObject
{
	
	
	
	/**
	 * 获取标题
	 * @param bSimpleMode
	 * @param strLanguage
	 * @return
	 */
	String getCaption(boolean bSimpleMode,String strLanguage);
	
	
	
	/**
	 * 获取简单名称
	 * @return
	 */
	String getSimpleName();

}
