package net.ibizsys.paas.ctrlmodel;

import net.ibizsys.paas.control.form.IForm;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

/**
 * 表单模型接口
 * 
 * @author lionlau
 *
 */
public interface IFormModel extends ICtrlModel, IForm {

	/**
	 * 通过数据对象填充表单
	 * 
	 * @param iDataObject 当前数据对象
	 * @param bUpdate 更新模式
	 * @param outputData 输出数据对象
	 * @param outputState 输出状态对象
	 * @param outputConfig 输出配置对象
	 * @throws Exception
	 */
	void fillOutputDatas(IDataObject iDataObject, boolean bUpdate, JSONObject outputData, JSONObject outputState, JSONObject outputConfig) throws Exception;

	/**
	 * 填充数据实体对象
	 * 
	 * @param iDataObject 数据实体s对象
	 * @param bIgnoreEmpty 是否忽略空检查
	 * @param formItemErrors 表单项错误集合
	 * @return
	 */
	void fillInputValues(IDataObject iDataObject, boolean bUpdate, boolean bIgnoreEmpty) throws Exception;

	/**
	 * 获取表单项输入的值
	 * 
	 * @param strFormItem 表单项
	 * @param iWebContext
	 * @return
	 */
	Object getItemInputValue(String strFormItem, IWebContext iWebContext) throws Exception;

	/**
	 * 填充数据实体对象默认值
	 * 
	 * @param iDataObject 数据实体s对象
	 * @param bIgnoreEmpty 是否忽略空检查
	 * @return
	 */
	void fillDefaultValues(IDataObject iDataObject, boolean bUpdate) throws Exception;

}
