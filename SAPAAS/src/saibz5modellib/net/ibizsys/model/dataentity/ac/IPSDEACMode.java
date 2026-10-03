package net.ibizsys.model.dataentity.ac;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.core.IDEACMode;


/**
 * 实体自动填充模型对象接口
 * @author Administrator
 *
 */
public interface IPSDEACMode extends IPSDataEntityObject,IDEACMode
{
	/**
	 * 是否为默认模式
	 * @return
	 */
	boolean isDefaultMode();
//	
//	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();

	/**
	 * 是否支持分页工具栏
	 * @return
	 */
	boolean isEnablePagingBar();
	
	
	
	/**
	 * 获取分页大小
	 * @return
	 */
	int getPagingSize();
	
	
	
	/**
	 * 获取二级排序属性
	 * @return
	 */
	IPSDEField getMinorSortPSDEF();
	

	
	/**
	 * 获取二级排序方向
	 * @return
	 */
	String getMinorSortDir();
	
	
	/**
	 * 获取值属性
	 * @return
	 */
	IPSDEField getValuePSDEF();
	
	
	/**
	 * 获取文本属性
	 * @return
	 */
	IPSDEField getTextPSDEF();
	
	/**
	 * 获取逻辑名称
	 * @return
	 */
	String getLogicName();
	
	
	/**
	 * 获取无值显示内容语言资源对象
	 * @return
	 */
	IPSLanguageRes getEmptyTextPSLanguageRes();
	
	
	/**
	 * 获取无值显示内容
	 * @return
	 */
	String getEmptyText();
	
	
}
