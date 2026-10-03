package net.ibizsys.model.control;

import java.util.Properties;

import net.ibizsys.model.core.IPSModelObject;

/**
 * 编辑器类型对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSEditorType extends IPSModelObject {

	// 定义编辑器类型代码表

	/**
	 * 文本框
	 */
	final static String EDITORTYPE_TEXTBOX = "TEXTBOX";

	/**
	 * 用户自定义
	 */
	final static String EDITORTYPE_USERCONTROL = "USERCONTROL";

	/**
	 * 隐藏表单项
	 */
	final static String EDITORTYPE_HIDDEN = "HIDDEN";

	/**
	 * IP地址输入框
	 */
	final static String EDITORTYPE_IPADDRESSTEXTBOX = "IPADDRESSTEXTBOX";

	/**
	 * 标签
	 */
	final static String EDITORTYPE_SPAN = "SPAN";

	/**
	 * 多行输入框
	 */
	final static String EDITORTYPE_TEXTAREA = "TEXTAREA";

	/**
	 * 数据选择
	 */
	final static String EDITORTYPE_PICKER = "PICKER";

	/**
	 * 下拉列表框
	 */
	final static String EDITORTYPE_DROPDOWNLIST = "DROPDOWNLIST";

	/**
	 * HTML编辑框
	 */
	final static String EDITORTYPE_HTMLEDITOR = "HTMLEDITOR";

	/**
	 * 直接内容
	 */
	final static String EDITORTYPE_RAW = "RAW";

	/**
	 * 时间选择器
	 */
	final static String EDITORTYPE_DATEPICKER = "DATEPICKER";

	/**
	 * 列表框
	 */
	final static String EDITORTYPE_LISTBOX = "LISTBOX";

	/**
	 * 选项框列表
	 */
	final static String EDITORTYPE_CHECKBOXLIST = "CHECKBOXLIST";

	/**
	 * 选项框
	 */
	final static String EDITORTYPE_CHECKBOX = "CHECKBOX";

	/**
	 * 单选项列表
	 */
	final static String EDITORTYPE_RADIOBUTTONLIST = "RADIOBUTTONLIST";

	/**
	 * 文件上传控件
	 */
	final static String EDITORTYPE_FILEUPLOADER = "FILEUPLOADER";

	/**
	 * 数据选择（下拉）
	 */
	final static String EDITORTYPE_PICKEREX_TRIGGER = "PICKEREX_TRIGGER";

	/**
	 * 多行输入框（10行）
	 */
	final static String EDITORTYPE_TEXTAREA_10 = "TEXTAREA_10";

	/**
	 * 自动填充
	 */
	final static String EDITORTYPE_AC = "AC";

	/**
	 * 自动填充（只能选择）
	 */
	final static String EDITORTYPE_AC_FS = "AC_FS";

	// 定义移动端编辑器类型代码表

	/**
	 * 移动端二维码阅读器
	 */
	final static String MBEDITORTYPE_MOB2DBARCODEREADER = "MOB2DBARCODEREADER";

	/**
	 * 移动端条码阅读器
	 */
	final static String MBEDITORTYPE_MOBBARCODEREADER = "MOBBARCODEREADER";

	/**
	 * 移动端选项框列表
	 */
	final static String MBEDITORTYPE_MOBCHECKLIST = "MOBCHECKLIST";

	/**
	 * 移动端时间选择器
	 */
	final static String MBEDITORTYPE_MOBDATE = "MOBDATE";

	/**
	 * 移动端下拉列表框
	 */
	final static String MBEDITORTYPE_MOBDROPDOWNLIST = "MOBDROPDOWNLIST";

	/**
	 * 移动端数据选择
	 */
	final static String MBEDITORTYPE_MOBPICKER = "MOBPICKER";

	/**
	 * 移动端图片控件
	 */
	final static String MBEDITORTYPE_MOBPICTURE = "MOBPICTURE";

	/**
	 * 移动端图片列表控件
	 */
	final static String MBEDITORTYPE_MOBPICTURELIST = "MOBPICTURELIST";

	/**
	 * 移动端单选项列表
	 */
	final static String MBEDITORTYPE_MOBRADIOLIST = "MOBRADIOLIST";

	/**
	 * 移动端开关部件
	 */
	final static String MBEDITORTYPE_MOBSWITCH = "MOBSWITCH";

	/**
	 * 移动端文本框
	 */
	final static String MBEDITORTYPE_MOBTEXT = "MOBTEXT";

	/**
	 * 移动端多行文本
	 */
	final static String MBEDITORTYPE_MOBTEXTAREA = "MOBTEXTAREA";

	/**
	 * 编辑器参数：选择视图
	 */
	final static String EDITORPARAM_PICKUPVIEW = "PICKUPVIEW";

	/**
	 * 编辑器参数：链接视图
	 */
	final static String EDITORPARAM_LINKVIEW = "LINKVIEW";

	/**
	 * 编辑器参数：用户自定义控件
	 */
	final static String EDITORPARAM_USERCONTROL = "USERCONTROL";

	/**
	 * 输出代码表配置模式：无
	 */
	final static int OUTPUTCODELISTCONFIGMODE_NONE = 0;

	/**
	 * 输出代码表配置模式：只输出选择项
	 */
	final static int OUTPUTCODELISTCONFIGMODE_SELECTEDONLY = 1;

	/**
	 * 输出代码表配置模式：输出子项
	 */
	final static int OUTPUTCODELISTCONFIGMODE_INCLUDECHILD = 2;

	/**
	 * 引用视图显示模式：常规
	 */
	final static String REFVIEWSHOWMODE_NORMAL = "NORMAL";

	/**
	 * 引用视图显示模式：模态
	 */
	final static String REFVIEWSHOWMODE_MODAL = "MODAL";

	/**
	 * 引用视图显示模式：嵌入
	 */
	final static String REFVIEWSHOWMODE_EMBEDDED = "EMBEDDED";

	/**
	 * 链接视图显示模式：常规
	 */
	final static String LINKVIEWSHOWMODE_NORMAL = "NORMAL";

	/**
	 * 链接视图显示模式：模态
	 */
	final static String LINKVIEWSHOWMODE_MODAL = "MODAL";

	/**
	 * 链接视图显示模式：嵌入
	 */
	final static String LINKVIEWSHOWMODE_EMBEDDED = "EMBEDDED";

	/**
	 * 是否为标准编辑器
	 * 
	 * @return
	 */
	boolean isStandardEditor();

	/**
	 * 获取标准的编辑类型
	 * 
	 * @return
	 */
	String getStandardPSEditorType();

	/**
	 * 获取是否支持编辑
	 * 
	 * @return
	 */
	boolean isEditable();

	/**
	 * 获取编辑器参数
	 * 
	 * @return
	 */
	Properties getEditorParams();

	/**
	 * @param strEditorParam
	 * @param nDefault
	 * @return
	 */
	int getEditorParam(String strEditorParam, int nDefault);

	/**
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	String getEditorParam(String strEditorParam, String strDefault);

	/**
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	double getEditorParam(String strEditorParam, double fDefault);

	/**
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	boolean getEditorParam(String strEditorParam, boolean bDefault);

	/**
	 * 是否需要转换为代码项文本
	 * 
	 * @return
	 */
	boolean isConvertToCodeItemText();

	/**
	 * 是否需要代码表配置
	 * 
	 * @return
	 */
	boolean isNeedCodeListConfig();

	/**
	 * 获取输出的代码表配置模式
	 * 
	 * @return
	 */
	int getOutputCodeListConfigMode();

	/**
	 * 获取值处理器
	 * 
	 * @return
	 */
	String getValueProcessor();

	/**
	 * 获取宽度
	 * 
	 * @return
	 */
	int getWidth();

	/**
	 * 获取高度
	 * 
	 * @return
	 */
	int getHeight();

	/**
	 * 获取宽度
	 * 
	 * @return
	 */
	int getWidth(String strPSPFId);

	/**
	 * 获取高度
	 * 
	 * @return
	 */
	int getHeight(String strPSPFId);

	/**
	 * 是否为用户自定义部件
	 * 
	 * @return
	 */
	boolean isUserControl();

	/**
	 * 是否有数据选择视图
	 * 
	 * @return
	 */
	boolean hasPickupView();

	/**
	 * 是否有数据链接视图
	 * 
	 * @return
	 */
	boolean hasLinkView();

	/**
	 * 获取后台处理对象类型
	 * 
	 * @return
	 */
	String getAjaxHandlerType();

	/**
	 * 获取引用视图显示模式，值参考 SA.SRFDA.PS.Core.Control.IPSEditorType.REFVIEWSHOWMODE_XXX
	 * 定义
	 * 
	 * @return
	 */
	String getRefViewShowMode();

	/**
	 * 获取引用视图显示模式，值参考
	 * SA.SRFDA.PS.Core.Control.IPSEditorType.LINKVIEWSHOWMODE_XXX 定义
	 * 
	 * @return
	 */
	String getLinkViewShowMode();
}
