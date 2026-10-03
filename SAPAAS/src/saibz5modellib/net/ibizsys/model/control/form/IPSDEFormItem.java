package net.ibizsys.model.control.form;

import java.util.Properties;

import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSEditorType;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.control.form.IFormItem;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 实体表单项对象接口
 * @author lionlau
 *
 */
public interface IPSDEFormItem extends IPSDEFormDetail,IFormItem
{
	//定义标签位置代码表

	/**
	*标签位置：左边
	*/
	final String LABELPOS_LEFT = "LEFT" ;

	/**
	*标签位置：上方
	*/
	final String LABELPOS_TOP = "TOP" ;

	/**
	*标签位置：右边
	*/
	final String LABELPOS_RIGHT = "RIGHT" ;

	/**
	*标签位置：下方
	*/
	final String LABELPOS_BOTTOM = "BOTTOM" ;

	/**
	*标签位置：不显示
	*/
	final String LABELPOS_NONE = "NONE" ;
		
	/**
	 * 获取实体属性对象
	 * @return
	 */
	IPSDEField getPSDEField();
	
	
	/**
	 * 获取标签位置，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem.LABELPOS_XXX 定义
	 * @return
	 */
	String getLabelPos();
	
	
	/**
	 * 获取标签宽度
	 * @return
	 */
	int getLabelWidth();
	
	
	
	/**
	 * 是否为隐藏项
	 * @return
	 */
	boolean isHidden();
	
	
	
	
	/**
	 * 获取编辑器类型
	 * @return
	 */
	String getEditorType();
	
	
	
	/**
	 * 获取编辑器类型对象
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
	 * 获取编辑器宽度
	 * @return
	 */
	double getEditorWidth();
	
	
	
	/**
	 * 获取编辑器高度
	 * @return
	 */
	double getEditorHeight();
	
	
	
	
	/**
	 * 获取是否允许输入
	 * @return
	 */
	boolean isAllowEmpty();
	
	
	
	/**
	 * 获取表单项宽度
	 * @return
	 */
	double getItemWidth();
	
	
	
	
	/**
	 * 获取表单项高度
	 * @return
	 */
	double getItemHeight();
	
	
	
	/**
	 * 获取代码表对象标识
	 * @return
	 */
	String getPSCodeListId();
	
	
	
	/**
	 * 获取属性值规则
	 * @return
	 */
	java.util.Iterator<IPSFIDEFValueRule> getPSFIDEFValueRules();
	
	
	
	/**
	 * 获取属性表单项
	 * @return
	 */
	IPSDEFFormItem getPSDEFFormItem();
	
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
	 * 获取引用的数据集合上下文逻辑
	 * @return
	 * @throws Exception
	 */
	IPSDELogic getRefActiveDataPSDELogic() throws Exception;
	
	/**
	 * 获取引用的自动填充模式
	 * @return
	 * @throws Exception
	 */
	IPSDEACMode getRefPSDEACMode() throws Exception;
	
	
	
	
	/**
	 * 获取部件的处理器类型，值参考 SA.SRFDA.PS.Core.Control.IPSControlItem.HandlerType_XXX 定义
	 * @return
	 */
	String getItemHandlerType();
	
	
	
	/**
	 * 获取代码表对象
	 * @return
	 */
	IPSCodeList getPSCodeList();
	
	
	/**
	 * 获取是否支持编辑
	 * @return
	 */
	boolean isEditable();
	
	
	
	/**
	 * 获取扩展的参数对象
	 * @return
	 */
	ObjectNode getItemParam()  throws Exception;
	
	
	/**
	 * 获取对应的表单项更新标识
	 * @return
	 */
	String getPSDEFIUpdateId();
	
	
	
	/**
	 * 获取表单更新对象
	 * @return
	 * @throws Exception
	 */
	IPSDEFormItemUpdate getPSDEFormItemUpdate() throws Exception;
	
	
	
	
	/**
	 * 获取编辑器参数（整形）
	 * @param strEditorParam
	 * @param nDefault
	 * @return
	 */
	int getEditorParam(String strEditorParam,int nDefault);
	
	
	
	/**
	 * 获取编辑器参数（字符形）
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	String getEditorParam(String strEditorParam,String strDefault);
	
	
	
	/**
	 * 获取编辑器参数（双精度）
	 * @param strEditorParam
	 * @param fDefault
	 * @return
	 */
	double getEditorParam(String strEditorParam,double fDefault);
	
	
	
	
	/**
	 * 获取编辑器参数（布尔形）
	 * @param strEditorParam
	 * @param bDefault
	 * @return
	 */
	boolean getEditorParam(String strEditorParam,boolean bDefault);
	
	
	/**
	 * 获取编辑器参数集合
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
	 * 获取默认的标签单元格合并数量
	 * @return
	 */
	int getLabelColSpan();
	
	
	
	/**
	 * 获取默认的控件单元格合并数量
	 * @return
	 */
	int getCtrlColSpan();
	
	
	
	/**
	 * 获取默认的标签单元格合并数量
	 * @return
	 */
	int getLabelRealColSpan();
	
	
	
	/**
	 * 获取默认的控件单元格合并数量
	 * @return
	 */
	int getCtrlRealColSpan();

	
	
	/**
	 * 获取标题列样式
	 * @return
	 */
	String getLabelColCssClass();
	
	
	/**
	 * 获取控件列样式
	 * @return
	 */
	String getCtrlColCssClass();

	
	/**
	 * 是否需要代码表配置
	 * @return
	 */
	boolean isNeedCodeListConfig();
	
	
	
	/**
	 * 获取输出代码表模型模式
	 * @return
	 */
	int getOutputCodeListConfigMode();
	
	/**
	 * 获取标题样式
	 * @return
	 */
	String getLabelCssStyle();
	
	
	/**
	 * 获取控件区样式
	 * @return
	 */
	String getCtrlCssStyle();
	
	
	/**
	 * 获取编辑器样式
	 * @return
	 */
	String getEditorCssStyle();


	/**
	 * 获取约束的表单项
	 * @return
	 */
	String getResetItemName();
	
	
	/**
	 * 获取重置的表单项名称集合
	 * @return
	 */
	java.util.Iterator<String> getResetItemNames();
	
	
	/**
	 * 是否为空白标签
	 * @return
	 */
	boolean isEmptyCaption();
	
	
	
	/**
	 * 获取空白占位内容
	 * @return
	 */
	String getPlaceHolder();
	
	
	
	/**
	 * 获取界面项图片资源
	 * @return
	 */
	IPSSysImage getPSSysImage();
	
	
	/**
	 * 是否启用项权限控制
	 * @return
	 */
	boolean isEnableItemPriv();
	

	/**
	 * 是否启用单位名称
	 * @return
	 */
	boolean isEnableUnitName();
	
	
	
	/**
	 * 获取单位名称
	 * @return
	 */
	String getUnitName();
	
	
	/**
	 * 获取单位名称宽度
	 * @return
	 */
	int getUnitNameWidth();
	
	
//	/**
//	 * 获取属性输入提示
//	 * @return
//	 */
//	IPSDEFInputTip getPSDEFInputTip();
//	
//	
//	
//	/**
//	 * 获取输入提示语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getPHPSLanguageRes();
	
	
	
	
	/**
	 * 获取输入提示语言资源标识
	 * @return
	 */
	String getPHLanResTag();
	
	
	/**
	 * 获取异步处理对象
	 * @return
	 */
	IPSAjaxHandler getItemPSAjaxHandler();

}
