package net.ibizsys.model.control.form;

import java.util.Iterator;

import net.ibizsys.model.dataentity.field.IPSDEFUIItem;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 实体属性预定义表单项对象接口
 * @author Administrator
 *
 */
public interface IPSDEFFormItem extends IPSDEFUIItem
{
	/**
	 * 获取编辑器默认宽度
	 * @return
	 */
	int getEditorWidth();
	
	
	/**
	 * 获取编辑器默认高度
	 * @return
	 */
	int getEditorHeight();
	
	
	
	/**
	 * 获取表单项值值名称
	 * @param iPSDEFormItem
	 * @return
	 */
	String getValueItemName(IPSDEFormItem iPSDEFormItem);
	
	

	/**
	 * 获取表单项值规则集合
	 * @return
	 */
	Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules();
	

	
	
	/**
	 * 获取后台处理对象类型，值参考 SA.SRFDA.PS.Core.Control.IPSControlItem.HandlerType_XXX 定义
	 * @param strType
	 * @return
	 */
	String getItemHandlerType(IPSDEFormItem iPSDEFormItem);
	
	
	/**
	 * 获取启用编辑的条件，值参考 net.ibizsys.paas.control.form.IFormItem.ENABLECOND_XXX 定义
	 * @return
	 */
	int getEnableCond();
	
	
	
	
	/**
	 * 获取扩展的参数对象
	 * @return
	 */
	ObjectNode getItemParam(IPSDEFormItem iPSDEFormItem)  throws Exception;
	
	


}
