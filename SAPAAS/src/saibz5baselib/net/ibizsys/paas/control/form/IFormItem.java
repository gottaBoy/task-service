package net.ibizsys.paas.control.form;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

/**
 * 表单项接口
 * 
 * @author lionlau
 *
 */
public interface IFormItem extends IModelBase {
	/**
	 * 主键标记
	 */
	static String KEY = "srfkey";

	/**
	 * 更新标志
	 */
	static String UF = "srfuf";

	/**
	 * 临时数据模式
	 */
	static String TEMPMODE = "srftempmode";

	/**
	 * 实体编号
	 */
	static String DEID = "srfdeid";

	/**
	 * 源数据键标记
	 */
	static String SOURCEKEY = "srfsourcekey";

	/**
	 * 最后更新时间
	 */
	static String LASTUPDATEDATE = "srfupdatedate";

	/**
	 * 项权限控制标识
	 */
	static String ITEMPRIV_PREFIX = "srfip_";

	/**
	 * 启用条件（无）
	 */
	final static int ENABLECOND_NONE = 0;

	/**
	 * 启用条件（建立）
	 */
	final static int ENABLECOND_CREATE = 1;

	/**
	 * 启用条件（更新）
	 */
	final static int ENABLECOND_UPDATE = 2;

	/**
	 * 输入忽略条件（无）
	 */
	final static int IGNOREINPUT_NONE = 0;

	/**
	 * 输入忽略条件（建立）
	 */
	final static int IGNOREINPUT_CREATE = 1;

	/**
	 * 输入忽略条件（更新）
	 */
	final static int IGNOREINPUT_UPDATE = 2;

	/**
	 * 启用条件（建立及更新）
	 */
	final static int ENABLECOND_ALL = ENABLECOND_CREATE | ENABLECOND_UPDATE;

	/**
	 * 输入忽略条件（建立及更新）
	 */
	final static int IGNOREINPUT_ALL = IGNOREINPUT_CREATE | IGNOREINPUT_UPDATE;
	
	
	/**
	 * 输入忽略条件（禁用时忽略）
	 */
	final static int IGNOREINPUT_DISABLE = 4;
	
	
	
	/**
	 * 输入忽略条件（禁用时忽略且不设置值输出到前端）4|8
	 */
	final static int IGNOREINPUT_DISABLE_AND_NOTSETOUTPUT = 12;
	
	
	
	/**
	 * 输入忽略条件（更新及设置原值） 2|16
	 */
	final static int IGNOREINPUT_UPDATE_AND_SETORIGIN = 18;
	
	
	

	// 定义回写属性值模式代码表

	/**
	 * 回写属性值模式：无
	 */
	final static int WRITEBACKDEFMODE_NONE = 0;

	/**
	 * 回写属性值模式：始终回写
	 */
	final static int WRITEBACKDEFMODE_ALWAYS = 1;

	/**
	 * 回写属性值模式：部件有效
	 */
	final static int WRITEBACKDEFMODE_ENABLED = 2;


	/**
	 * 获取数据项
	 * 
	 * @return
	 */
	IDataItem getDataItem();

	/**
	 * 获取表单项输入的值
	 * 
	 * @param iWebContext
	 * @return
	 */
	Object getInputValue(IWebContext iWebContext) throws Exception;

	/**
	 * 输出到客户端的值
	 * 
	 * @param iWebContext
	 * @param iDataObject
	 * @param bString 以字符串形式输出
	 * @return
	 * @throws Exception
	 */
	Object getOutputValue(IWebContext iWebContext, IDataObject iDataObject, boolean bString) throws Exception;

	/**
	 * 获取表单项默认值
	 * 
	 * @param iWebContext
	 * @param bUpdate 是否为更新模式，默认为新建
	 * @return
	 */
	Object getDefaultValue(IWebContext iWebContext, boolean bUpdate) throws Exception;

	/**
	 * 获取动态表单项配置
	 * 
	 * @param iWebContext
	 * @param iDataObject
	 * @param bUpdate
	 * @return
	 * @throws Exception
	 */
	JSONObject getConfig(IWebContext iWebContext, IDataObject iDataObject, boolean bUpdate) throws Exception;

	/**
	 * 获取权限标识
	 * 
	 * @return
	 */
	String getPrivilegeId();

	/**
	 * 获取值项名称
	 * 
	 * @return
	 */
	String getValueItemName();

	/**
	 * 获取表单项的属性值规则
	 * 
	 * @return
	 */
	java.util.Iterator<IFIDEFValueRule> getFIDEFValueRules();

	/**
	 * 获取属性 名称
	 * 
	 * @return
	 */
	String getDEFName();

	/**
	 * 获取表单对象
	 * 
	 * @return
	 */
	IForm getForm();

	/**
	 * 获取实体属性
	 * 
	 * @return
	 */
	IDEField getDEField();

	/**
	 * 获取表单自填模式接口
	 * 
	 * @return
	 */
	IFIDEACMode getFIDEACMode();

	/**
	 * 获取启用的条件
	 * 
	 * @return
	 */
	int getEnableCond();

	/**
	 * 获取建立时默认值类型
	 * 
	 * @return
	 */
	String getCreateDVT();

	/**
	 * 获取建立时默认值
	 * 
	 * @return
	 */
	String getCreateDV();

	/**
	 * 获取更新时默认值类型
	 * 
	 * @return
	 */
	String getUpdateDVT();

	/**
	 * 获取更新时默认值
	 * 
	 * @return
	 */
	String getUpdateDV();

	/**
	 * 获取对应的代码表
	 * 
	 * @return
	 */
	ICodeList getCodeList() throws Exception;

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption();

	/**
	 * 是否允许为空
	 * 
	 * @return
	 */
	boolean isAllowEmpty();

	/**
	 * 获取标题语言标识
	 * 
	 * @return
	 */
	// @Deprecated
	String getCapLanId();

	/**
	 * 获取标题语言标识
	 * 
	 * @return
	 */
	String getCapLanResTag();

	/**
	 * 获取代码表标识
	 * 
	 * @return
	 */
	String getCodeListId();

	/**
	 * 获取值规则标识
	 * 
	 * @return
	 */
	String getValueRuleId();

	/**
	 * 获取输入忽略
	 * 
	 * @return
	 */
	int getIgnoreInput();

	/**
	 * 获取值处理器
	 * 
	 * @return
	 */
	String getValueTranslator();

	/**
	 * 获取用户词条分类
	 * 
	 * @return
	 */
	String getUserDictCatId();

	/**
	 * 获取权限标识的属性名称
	 * 
	 * @return
	 */
	String getPrivFieldName();

	/**
	 * 获取输入提示
	 * 
	 * @return
	 */
	String getInputTip();

	/**
	 * 获取输入提示语言资源标识
	 * 
	 * @return
	 */
	String getInputTipLanResTag();

	/**
	 * 获取输入提示进一步链接
	 * 
	 * @return
	 */
	String getInputTipUrl();

	/**
	 * 获取输入提示集合标识
	 * 
	 * @return
	 */
	String getInputTipSetId();

	/**
	 * 获取输入提示唯一标识
	 * 
	 * @return
	 */
	String getInputTipUniqueTag();

	/**
	 * 获取输入提示是否支持关闭
	 * 
	 * @return
	 */
	boolean isInputTipClosable();
	
	
	
	/**
	 * 获取回写属性模式，值参考 net.ibizsys.paas.control.form.IFormItem.WRITEBACKDEFMODE_XXX 定义
	 * @return
	 */
	int getWriteBackDEFMode();
}
