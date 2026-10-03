package net.ibizsys.model.control.grid;

import java.util.Properties;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.paas.control.grid.IGridEditItem;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 实体表格编辑项对象接口，相关功能可参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem 定义
 * @author Administrator
 *
 */
public interface IPSDEGridEditItem extends IGridEditItem,IPSModelObject{
	
	/**
	 * 获取实体表格对象
	 * @return
	 */
	IPSDEGrid getPSDEGrid();
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	/**
	 * 获取表格列
	 * @return
	 */
	IPSDEGridColumn getPSDEGridColumn();
	
	
	/**
	 * 获取属性对象
	 * @return
	 */
	IPSDEField getPSDEField();
	
	
	
	
	/**
	 * 获取编辑器类型
	 * @return
	 */
	String getEditorType();
	
	
	
	/**
	 * 编辑器类型
	 * @return
	 */
	IPSEditorType getPSEditorType();
	
	
	
	
	/**
	 * 获取系统编辑器样式
	 * @return
	 */
	IPSSysEditorStyle getPSSysEditorStyle();
	
	
	/**
	 * 获取编辑器样式
	 * @return
	 */
	String getEditorStyle();
	
	
	
	/**
	 * 是否允许输入
	 * @return
	 */
	boolean isAllowEmpty();
	
	
	/**
	 * 获取代码表对象标识
	 * @return
	 */
	String getPSCodeListId();
	
	
	
	/**
	 * 获取属性值规则集合
	 * @return
	 */
	java.util.Iterator<IPSGEIDEFValueRule> getPSGEIDEFValueRules();
	
	
	
	/**
	 * 获取属性表格列
	 * @return
	 */
	IPSDEFGridColumn getPSDEFGridColumn();
	
	/**
	 * 获取引用的链接应用视图对象
	 * @return
	 * @throws Exception
	 */
	IPSAppView getRefLinkPSAppView() throws Exception;
	
	
	/**
	 * 获取引用的选择应用视图对象
	 * @return
	 * @throws Exception
	 */
	IPSAppView getRefPickupPSAppView() throws Exception;
	
	
	/**
	 * 获取引用的数据集合
	 * @return
	 * @throws Exception
	 */
	IPSDEDataSet getRefPSDEDataSet() throws Exception;
	
	
	
	/**
	 * 获取引用的自动填充模式
	 * @return
	 * @throws Exception
	 */
	IPSDEACMode getRefPSDEACMode() throws Exception;
	
	
	
	
	/**
	 * 获取部件的处理器类型
	 * @return
	 */
	String getItemHandlerType();
	
	
	
	/**
	 * 获取代码表对象
	 * @return
	 */
	IPSCodeList getPSCodeList();
	
	
	/**
	 * 是否支持编辑
	 * @return
	 */
	boolean isEditable();
	
	
	
	/**
	 * 获取扩展的参数对象
	 * @return
	 */
	ObjectNode getItemParam()  throws Exception;
	
	
	/**
	 * 获取对应的表格编辑项更新标识
	 * @return
	 */
	String getPSDEGEIUpdateId();
	
	
	
	/**
	 * 获取表格编辑项更新对象
	 * @return
	 * @throws Exception
	 */
	IPSDEGridEditItemUpdate getPSDEGridEditItemUpdate() throws Exception;
	
	
	
	
	/**
	 * 获取编辑器参数
	 * @param strEditorParam
	 * @param nDefault
	 * @return
	 */
	int getEditorParam(String strEditorParam,int nDefault);
	
	
	
	/**
	 * 获取编辑器参数
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	String getEditorParam(String strEditorParam,String strDefault);
	
	
	
	/**
	 * 获取编辑器参数
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	double getEditorParam(String strEditorParam,double fDefault);
	
	
	
	
	/**
	 * 获取编辑器参数
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	boolean getEditorParam(String strEditorParam,boolean bDefault);
	
	
	/**
	 * 获取编辑器参数
	 * @return
	 */
	Properties getEditorParams();
	
	
	
	/**
	 * 获取系统值规则标识
	 * @return
	 */
	String getPSSysValueRuleId();
	
	
	/**
	 * 是否转换为代码项文本
	 * @return
	 */
	boolean isConvertToCodeItemText();
	
	
	
	/**
	 * 是否需要代码表配置
	 * @return
	 */
	boolean isNeedCodeListConfig();
	
	
	/**
	 * 获取输出代码表模型
	 * @return
	 */
	int getOutputCodeListConfigMode();
	
	/**
	 * 获取编辑器样式
	 * @return
	 */
	String getEditorCssStyle();


	/**
	 * 获取约束的表格编辑项
	 * @return
	 */
	String getResetItemName();
	
	
	/**
	 * 获取重置的表格编辑项名称集合
	 * @return
	 */
	java.util.Iterator<String> getResetItemNames();
	

	
	
	/**
	 * 获取空白占位内容
	 * @return
	 */
	String getPlaceHolder();
	

	
	/**
	 * 获取异步处理对象
	 * @return
	 */
	IPSAjaxHandler getItemPSAjaxHandler();
}
