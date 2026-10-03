package net.ibizsys.model.dataentity.field;

import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.core.IDEField;


/**
 * 实体属性对象接口
 * @author Administrator
 * @version 5.1.116.180602
 */
public interface IPSDEField extends IPSModelObject,IDEField
{

	/**
	 * 获取实体
	 * @return
	 */
	IPSDataEntity getPSDataEntity();
	
	
	
	
	
	
//	/**
//	 * 获取指定的数据库列
//	 * @param strDBType
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEFDTColumn getPSDTColumn(String strDBType) throws Exception;
//	
//	
//
//	
//	
//	/**
//	 * 获取属性逻辑名称
//	 * @param strLanguage 语言
//	 * @return
//	 */
//	String getLogicName(String strLanguage);
//	
//	
//	
	/**
	 * 获取属性逻辑名称
	 * @return
	 */
	String getLogicName();
	
	
	
	/**
	 * 获取逻辑名称语言资源标记
	 * @return
	 */
	String getLNLanResTag();
	
	
	/**
	 * 获取逻辑名称语言资源对象
	 * @return
	 */
	IPSLanguageRes getLNPSLanguageRes();
//	
////	/**
////	 * 获取属性代码表
////	 * @return
////	 */
////	String getCodeListId() ;
	
	
	/**
	 * 获取属性是否为链接属性
	 * @return
	 */
	boolean isLinkDEField();
	
	
	/**
	 * 获取属性是否为继承属性
	 * @return
	 */
	boolean isInheritDEField();
	
	
	/**
	 * 获取属性是否为公式属性
	 * @return
	 */
	boolean isFormulaDEField();
//	
//	
//	
//	/**
//	 * 物理化的公式属性
//	 * @return
//	 */
//	boolean isFormulaPhisical();
	
	
	/**
	 * 获取属性是否为物理属性
	 * @return
	 */
	boolean isPhisicalDEField();
	
	
	
	
	/**
	 * 获取属性是否为索引识别属性
	 * @return
	 */
	boolean isIndexTypeDEField();
	
	
	/**
	 * 获取属性是否为表单类型属性
	 * @return
	 */
	boolean isFormTypeDEField();
//	
//	
//	
//	
//	/**
//	 * 获取属性是否忽略继承
//	 * @return
//	 */
//	boolean isIgnoreInherit();
//	
//	
//	
//	/**
//	 * 改属性是否对客户可见
//	 * @return
//	 */
//	boolean isUserVisible();
//	

	
	/**
	 * 是否拷贝重置
	 * @return
	 */
	boolean isPasteReset();

	/**
	 * 是否系统保留字段
	 * @return
	 */
	boolean isSystemReserver();
//	
//	/**
//	 * 获取属性的单位
//	 * @return
//	 */
//	String getUnit();
//	
//	
//	/**
//	 * 获取属性的单位宽度
//	 * @return
//	 */
//	int getUnitWidth();
//	
//	
//	
//	/**
//	 * 获取属性的单位语言资源标识
//	 * @return
//	 */
//	String getUnitLanResTag();
//	
//	/**
//	 * 获取属性的标准数据类型
//	 * @return
//	 */
////	int getStdDataType() throws Exception;
////	
////	/**
////	 * 获取属性的查询辅助对象
////	 * @return
////	 */
////	IDEFQueryHelper getQueryHelper();
////	
////	/**
////	 * 获取值规则
////	 * @return
////	 */
////	String getValueRule();
////	
////	/**
////	 * 获取值规则信息
////	 * @return
////	 */
////	String getValueRuleInfo();
//	
//	
//	/**
//	 * 获取属性值
//	 * @param strValue
//	 * @return
//	 */
//	Object getDEFValue(String strValue);
//	
	
	/**
	 * 启用数据审计
	 * @return
	 */
	boolean isEnableAudit();
	
	
	
	/**
	 * 获取审计格式化 
	 * %1$s 属性逻辑名称  %2$s 旧值  %3$s 新值
	 * @return
	 */
	String getAuditInfoFormat();
	
	
	/**
	 * 获取属性浮点精度
	 * @return
	 */
	int getPrecision();
//
//	
//	/**
//	 * 获取重复检查代码
//	 * @return
//	 */
//	String getDupCheckCode(boolean bInsert);
//	
//	
////	/**
////	 * 获取属性的指定属性值
////	 * @param strPropertyName 属性名称
////	 * @return
////	 */
////	String getProperty(String strPropertyName);
////	
////	
////	/**
////	 * 获取属性的指定属性值
////	 * @param strPropertyName 属性名称
////	 * @param strDefault 默认值
////	 * @return
////	 */
////	String getProperty(String strPropertyName,String strDefault);
	
	
	/**
	 * 是否启用实体属性权限控制
	 * @return
	 */
	boolean isEnablePriv();
	
	
	
	/**
	 * 获取字符串转换模式
	 * @return
	 */
	String getStringCase();
	
	
	
////	/**
////	 * 获取输入辅助模板分组
////	 * @return
////	 */
////	String getCaretTemplGroupId();
////	
////	
////	/**
////	 * 获取输入辅助采集模式
////	 * @return
////	 */
////	String getCaretRetMode();
	
	
	/**
	 * 获取旧值更新模式
	 * @return
	 */
	String getUpdateOVMode();
	
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	
	
//	
//	/**
//	 * 获取密码存储模式
//	 * @return
//	 */
//	//int getPwdStorage();
//	
//	
//	
	
	/**
	 * 字段是否支持插入
	 * @return
	 */
	boolean isEnableUserInsert();
	
	
	/**
	 * 字段是否支持更新
	 * @return
	 */
	boolean isEnableUserUpdate();
//	
//	
//	
//	
//	/**
//	 * 获取代码表参数
//	 * @return
//	 */
//	String getCodeListParam();
//	
//	
//	
//	
////	
////	/**
////	 * 是否为界面辅助属性
////	 * @return
////	 */
////	boolean isUIAssistField();
////	
//	
//	
//	/**
//	 * 获取密码存储方式
//	 * @return
//	 */
//	int getEncryptStorage();
//	
//	
//	
//	
////	/**
////	 * 获取输入提示
////	 * @return
////	 */
////	String getInputTips();
////	
////	
////	
////	/**
////	 * 获取属性是否有效
////	 * @return
////	 */
////	boolean getValidFlag();
	
	
	/**
	 * 获取完整名称
	 * @return
	 */
	String getFullName();
	
	
	/**
	 * 获取指定的属性表单项
	 * @param strPSDEFUIModeId
	 * @return
	 * @throws Exception
	 */
	IPSDEFUIMode getPSDEFUIMode(String strPSDEFUIModeId) throws Exception;
//
//	
//	
//
//	
//	
//	
//	
//	
//	
	/**
	 * 获取指定的属性搜索模式
	 * @param strPSDEFSearchModeId
	 * @return
	 * @throws Exception
	 */
	IPSDEFSearchMode getPSDEFSearchMode(String strPSDEFSearchModeId) throws Exception;
	
	
	
	/**
	 * 获取全部搜索模式
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEFSearchMode> getAllPSDEFSearchModes()throws Exception;
//	
//	
//	
//	
	/**
	 * 允许空输入
	 * @return
	 */
	boolean isAllowEmpty();
	
	
	
	
	
	/**
	 * 获取属性值规则
	 * @param strPSDEFValueRuleId
	 * @return
	 * @throws Exception
	 */
	IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId)throws Exception;
	
	
	
	/**
	 * 获取属性值规则
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEFValueRule> getAllPSDEFValueRules()throws Exception;
	
	
	
	/**
	 * 获取值格式化串
	 * @return
	 */
	String getValueFormat() ;
//	
//		
//	
//	
	/**
	 * 获取允许用户的输入模式
	 * @return
	 */
	int getEnableUserInput();
//	
//	
//	
//	/**
//	 * 获取联合键值模式
//	 * @return
//	 */
//	String getUnionKeyValue();
//	
//	
//	
//	/**
//	 * 获取属性是否为多表单识别属性
//	 * @return
//	 */
//	boolean isMultiFormDEField();
//	
//	
////	/**
////	 * 获取指定的代码表编号
////	 * 
////	 * @return
////	 */
////	String getCodeListId()throws Exception ;
//	
	/**
	 * 获取属性代码表
	 * @return
	 * @throws Exception
	 */
	IPSCodeList getPSCodeList() throws Exception ;
//	
//	
//	
//	
//	/**
//	 * 获取重复检查模式
//	 * @return
//	 */
//	String getDupCheckMode();
//	
//	
//	
//	
//	/**
//	 * 获取重复检查值范围
//	 * @return
//	 */
//	String[] getDupCheckValues();
//	
//	
//	
//	/**
//	 * 获取重复检查范围属性
//	 * @return
//	 */
//	IPSDEField getDupCheckPSDEField()  throws Exception;
//	
//	
	
	/**
	 * 获取长度
	 * @return
	 */
	int getLength();
	
	/**
	 * 获取字符串的长度
	 * @return
	 */
	int getStringLength();
	
	
	
	
	/**
	 * 获取默认值类型
	 * @return
	 */
	String getDefaultValueType();
	
	
	/**
	 * 获取默认值类型
	 * @return
	 */
	String getDefaultValue();
	
	
	
//	/**
//	 * 是否为查询列
//	 * @return
//	 */
//	boolean isQueryColumn();
//	
	
	/**
	 * 获取系统值规则
	 * @return
	 */
	String getPSSysValueRuleId();
//	
//	
//	
//	/**
//	 * 获取约束的属性
//	 * @return
//	 */
//	IPSDEField getRestrictedPSDEField() throws Exception;
//	
//	
//	
	/**
	 * 获取实体主状态属性模式 
	 * @return
	 */
	String getDEMSFieldMode();
//	
//	
//	
//	/**
//	 * 获取所在表名称
//	 * @return
//	 */
//	String getTableName();
//	
//	
//	
//	
//	/**
//	 * 获取数据数据默认值
//	 * @return
//	 */
//	String getTestDataValue();
//	
//	
//	
//	/**
//	 * 获取系统示例数据
//	 * @return
//	 */
//	IPSSysSampleValue getPSSampleValue();
//	
//	
//	/**
//	 * 获取XML标记名称
//	 * @return
//	 */
//	String getXmlTagName();
//	
//	
//	
//	
//	/**
//	 * 是否支持临时数据
//	 * @return
//	 */
//	boolean isEnableTempData();
//	
//	
//	
//	/**
//	 * 获取默认的属性输入提示
//	 * @return
//	 */
//	IPSDEFInputTip getDefaultPSDEFInputTip();
//	
//	
//	/**
//	 * 获取属性输入提示
//	 * @param strPSDEFInputTipId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEFInputTip getPSDEFInputTip(String strPSDEFInputTipId)throws Exception;
//	
//	
//	/**
//	 * 获取属性输入提示
//	 * @param strPSDEFInputTipId
//	 * @param bTryMode 尝试模式
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEFInputTip getPSDEFInputTip(String strPSDEFInputTipId,boolean bTryMode)throws Exception;
//	
//	
//	/**
//	 * 获取属性输入提示
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEFInputTip> getAllPSDEFInputTips()throws Exception;
//	
//	
	/**
	 * 获取属性排序值
	 * @return
	 */
	int getOrderValue();
//	
//	
//	
//	/**
//	 * 获取系统单位对象
//	 * @return
//	 */
//	IPSSysUnit getPSSysUnit();
//	
//	
//	
	/**
	 * 获取属性的建立时间
	 * @return
	 */
	long getCreateTime();
	
	
//	
//	/**
//	 * 获取单位语言资源对象
//	 * @return
//	 */
//	IPSLanguageRes getUnitPSLanguageRes();
//	

	/**
	 * 是否检查引用实体的递归关系
	 * @return
	 */
	boolean isCheckRecursion();
	
//	
//	/**
//	 * 获取属性对应的视图级别
//	 * @return
//	 */
//	int getViewLevel();
//	
//	
//	
//	
//	/**
//	 * 是否为查询列
//	 * @return
//	 */
//	boolean isQueryColumn(int nViewLevel);
//	
//	
//	
//	/**
//	 * 获取指定数据库列对象
//	 * @param strDBType
//	 * @return
//	 * @throws Exception
//	 * @since 5.1.116.180602
//	 */
//	IPSDEFDTColumn getPSDETDTColumn(String strDBType)throws Exception;
//	
//	
//	
//	/**
//	 * 获取属性全部的数据库列对象
//	 * @return
//	 * @throws Exception
//	 * @since 5.1.116.180602
//	 */
//	java.util.Iterator<IPSDEFDTColumn> getAllPSDEFDTColumns() throws Exception;
	
}
