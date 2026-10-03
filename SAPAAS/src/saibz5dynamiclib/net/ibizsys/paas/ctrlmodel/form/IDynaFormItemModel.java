package net.ibizsys.paas.ctrlmodel.form;

import net.ibizsys.paas.ctrlmodel.IFormItemModel;

/**
 * 动态表单项对象接口
 * 
 * @author Administrator
 *
 */
public interface IDynaFormItemModel extends IDynaFormDetailModel, IFormItemModel {

	/**
	 * 模型属性：编辑器高度
	 */
	final static String ATTR_EDITORHEIGHT = "editorheight";
	
	/**
	 * 模型属性：编辑器宽度
	 */
	final static String ATTR_EDITORWIDTH = "editorwidth";
	
	/**
	 * 模型属性：编辑器样式
	 */
	final static String ATTR_EDITORSTYLE = "editorstyle";
	
	
	/**
	 * 模型属性：编辑器类型
	 */
	final static String ATTR_EDITORTYPE = "editortype";
	
	/**
	 * 模型属性：标签位置
	 */
	final static String ATTR_LABELPOS = "labelpos";
	
	/**
	 * 模型属性：标签宽度
	 */
	final static String ATTR_LABELWIDTH = "labelwidth";
	
	/**
	 * 模型属性：占位提示
	 */
	final static String ATTR_PLACEHOLDER = "placeholder";
	
	/**
	 * 模型属性：允许空输入
	 */
	final static String ATTR_ALLOWEMPTY = "allowempty";
	
	/**
	 * 模型属性：支持编辑
	 */
	final static String ATTR_EDITABLE = "editable";
	
	/**
	 * 模型属性：使用空白标题
	 */
	final static String ATTR_EMPTYCAPTION = "emptycaption";
	
	
	/**
	 * 模型属性：隐藏项
	 */
	final static String ATTR_HIDDEN = "hidden";
	
	
	/**
	 * 标签位置：左边
	 */
	public final static String LABELPOS_LEFT = "LEFT";

	/**
	 * 标签位置：上方
	 */
	public final static String LABELPOS_TOP = "TOP";

	/**
	 * 标签位置：右边
	 */
	public final static String LABELPOS_RIGHT = "RIGHT";

	/**
	 * 标签位置：下方
	 */
	public final static String LABELPOS_BOTTOM = "BOTTOM";

	/**
	 * 标签位置：不显示
	 */
	public final static String LABELPOS_NONE = "NONE";

	/**
	 * 是否为空白标签
	 * 
	 * @return
	 */
	boolean isEmptyCaption();

	/**
	 * 获取编辑器宽度
	 * 
	 * @return
	 */
	double getEditorWidth();

	/**
	 * 获取编辑器高度
	 * 
	 * @return
	 */
	double getEditorHeight();

	/**
	 * 获取是否允许输入
	 * 
	 * @return
	 */
	boolean isAllowEmpty();

	/**
	 * 获取标签位置
	 * 
	 * @return
	 */
	String getLabelPos();

	/**
	 * 获取标签宽度
	 * 
	 * @return
	 */
	int getLabelWidth();

	/**
	 * 是否为隐藏项
	 * 
	 * @return
	 */
	boolean isHidden();

	/**
	 * 获取编辑器类型
	 * 
	 * @return
	 */
	String getEditorType();

	/**
	 * 是否支持编辑
	 * 
	 * @return
	 */
	boolean isEditable();

	/**
	 * 获取编辑器演示
	 * 
	 * @return
	 */
	String getEditorStyle();
	
	
	
	/**
	 * 获取输入提示信息
	 * @return
	 */
	String getPlaceHolder();
}
