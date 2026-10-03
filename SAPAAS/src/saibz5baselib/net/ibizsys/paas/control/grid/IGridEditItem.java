package net.ibizsys.paas.control.grid;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.data.IDataItem;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.web.IWebContext;
import net.sf.json.JSONObject;

/**
 * 表格编辑项接口
 * 
 * @author lionlau
 *
 */
public interface IGridEditItem extends IModelBase {
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
	 * 最后更新时间
	 */
	static String LASTUPDATEDATE = "srfupdatedate";

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
	 * 获取数据项
	 * 
	 * @return
	 */
	IDataItem getDataItem();

	/**
	 * 获取表格编辑项输入的值
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
	 * 获取表格编辑项默认值
	 * 
	 * @param iWebContext
	 * @param bUpdate 是否为更新模式，默认为新建
	 * @return
	 */
	Object getDefaultValue(IWebContext iWebContext, boolean bUpdate) throws Exception;

	/**
	 * 获取动态表格编辑项配置
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
	 * 获取表格编辑项的属性值规则
	 * 
	 * @return
	 */
	java.util.Iterator<IGEIDEFValueRule> getGEIDEFValueRules();

	/**
	 * 获取属性 名称
	 * 
	 * @return
	 */
	String getDEFName();

	/**
	 * 获取表格对象
	 * 
	 * @return
	 */
	IGrid getGrid();

	/**
	 * 获取实体属性
	 * 
	 * @return
	 */
	IDEField getDEField();

	/**
	 * 获取表格编辑项自填模式接口
	 * 
	 * @return
	 */
	IGEIDEACMode getGEIDEACMode();

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
	String getCapLanId();

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

}
