package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

/**
 * 表单项模型对象接口
 * 
 * @author lionlau
 *
 */
public interface IFormItemModel extends IFormItem {
	
	/**
	 * 输出代码表配置模式：无
	 */
	final static Integer OUTPUTCODELISTCONFIGMODE_NONE = 0;
	
	
	/**
	 * 输出代码表配置模式：只输出选择项
	 */
	final static Integer OUTPUTCODELISTCONFIGMODE_SELECTEDONLY = 1;
	
	
	/**
	 * 输出代码表配置模式：包括子项
	 */
	final static Integer OUTPUTCODELISTCONFIGMODE_INCLUDECHILD = 2;
	
	
	
	/**
	 * 获取表单模型对象
	 * 
	 * @return
	 */
	IFormModel getFormModel();

	/**
	 * 是否输出代码表配置
	 * 
	 * @return
	 */
	boolean isOutputCodeListConfig();
	
	
	/**
	 * 获取输出的代码表配置模式
	 * @return
	 */
	int getOutputCodeListConfigMode();
	

	/**
	 * 获取表单项输入的值（WEB请求）
	 * 
	 * @param iWebContext
	 * @return
	 */
	Object getInputValue(IWebContext iWebContext) throws Exception;

	/**
	 * 获取表单项输入的值（JSON对象）
	 * 
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	Object getInputValue(JSONObject jsonObject) throws Exception;

	/**
	 * 获取表单项默认值
	 * 
	 * @param iWebContext
	 * @param bUpdate 是否为更新模式
	 * @return
	 */
	Object getDefaultValue(IWebContext iWebContext, boolean bUpdate) throws Exception;

}
