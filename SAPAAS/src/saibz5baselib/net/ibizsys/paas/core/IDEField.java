package net.ibizsys.paas.core;

import net.ibizsys.paas.core.valuerule.IDEFValueRule;

/**
 * 实体属性接口
 * 
 * @author lionlau
 *
 */
public interface IDEField extends IModelBase {

	// 定义允许用户输入代码表

	/**
	 * 无
	 */
	final static int ENABLEUSERINPUT_NONE = 0;

	/**
	 * 新建
	 */
	final static int ENABLEUSERINPUT_INSERT = 1;

	/**
	 * 更新
	 */
	final static int ENABLEUSERINPUT_UPDATE = 2;
	
	/**
	 * 不可见
	 */
	final static int ENABLEUSERINPUT_INVISIBLE = 4;
	

	/**
	 * 新建及更新
	 */
	final static int ENABLEUSERINPUT_ALL = 3;

	// 定义字符转换代码表

	/**
	 * 转换为大写
	 */
	final static String STRINGCASE_UCASE = "UCASE";

	/**
	 * 转换为小写
	 */
	final static String STRINGCASE_LCASE = "LCASE";

	// 属性类型
	/**
	 * 文本，可指定长度
	 */
	final static String DATATYPE_TEXT = "TEXT";

	/**
	 * 全局唯一标识，文本类型，用户不可见
	 */
	final static String DATATYPE_GUID = "GUID";

	/**
	 * 自增标识，大整数类型，用户不可见
	 */
	final static String DATATYPE_ACID = "ACID";

	/**
	 * 长文本，长度1000
	 */
	final static String DATATYPE_LONGTEXT_1000 = "LONGTEXT_1000";

	/**
	 * 长文本，没有长度限制
	 */
	final static String DATATYPE_LONGTEXT = "LONGTEXT";

	/**
	 * HTML文本，没有长度限制
	 */
	final static String DATATYPE_HTMLTEXT = "HTMLTEXT";

	/**
	 * 整型
	 */
	final static String DATATYPE_INT = "INT";

	/**
	 * 大整型
	 */
	final static String DATATYPE_BIGINT = "BIGINT";

	/**
	 * 字符串业务标识，文本类型，用户可见
	 */
	final static String DATATYPE_SBID = "SBID";

	/**
	 * 数字串业务标识，数字类型，用户可见
	 */
	final static String DATATYPE_NBID = "NBID";

	/**
	 * 浮点
	 */
	final static String DATATYPE_FLOAT = "FLOAT";

	/**
	 * 数值
	 */
	final static String DATATYPE_DECIMAL = "DECIMAL";
	
	/**
	 * 大数值
	 */
	final static String DATATYPE_BIGDECIMAL = "BIGDECIMAL";
	

	/**
	 * 日期型
	 */
	final static String DATATYPE_DATE = "DATE";

	/**
	 * 时间型
	 */
	final static String DATATYPE_TIME = "TIME";

	/**
	 * 日期时间型
	 */
	final static String DATATYPE_DATETIME = "DATETIME";

	/**
	 * 单项选择(文本值)
	 */
	final static String DATATYPE_SSCODELIST = "SSCODELIST";

	/**
	 * 多项选择(文本值)
	 */
	final static String DATATYPE_SMCODELIST = "SMCODELIST";

	/**
	 * 单项选择(数值)
	 */
	final static String DATATYPE_NSCODELIST = "NSCODELIST";

	/**
	 * 多项选择(数值)
	 */
	final static String DATATYPE_NMCODELIST = "NMCODELIST";

	/**
	 * 外键值
	 */
	final static String DATATYPE_PICKUP = "PICKUP";

	/**
	 * 外键值文本
	 */
	final static String DATATYPE_PICKUPTEXT = "PICKUPTEXT";

	/**
	 * 外键值附加数据
	 */
	final static String DATATYPE_PICKUPDATA = "PICKUPDATA";

	/**
	 * 继承属性
	 */
	final static String DATATYPE_INHERIT = "INHERIT";

	/**
	 * 是否逻辑
	 */
	final static String DATATYPE_YESNO = "YESNO";

	/**
	 * 真假逻辑
	 */
	final static String DATATYPE_TRUEFALSE = "TRUEFALSE";

	/**
	 * 货币
	 */
	final static String DATATYPE_CURRENCY = "CURRENCY";

	/**
	 * 货币单位
	 */
	final static String DATATYPE_CURRENCYUNIT = "CURRENCYUNIT";

	/**
	 * 工作流处理状态
	 */
	final static String DATATYPE_WFSTATE = "WFSTATE";

	/**
	 * 出生日期
	 */
	final static String DATATYPE_DATETIME_BIRTHDAY = "DATETIME_BIRTHDAY";

	/**
	 * 电子邮件
	 */
	final static String DATATYPE_TEXT_EMAIL = "TEXT_EMAIL";

	/**
	 * 二进制流，没有长度限制
	 */
	final static String DATATYPE_BINARY = "BINARY";

	// 定义更新旧值回填代码表

	/**
	 * 始终回填
	 */
	final static String UPDATEOVMODE_ALWAYS = "ALWAYS";

	/**
	 * 无值时回填
	 */
	final static String UPDATEOVMODE_NOTEXISTS = "NOTEXISTS";

	// 定义预定义类型代码表

	/**
	 * 逻辑有效标识
	 */
	final static String PREDEFINEDTYPE_LOGICVALID = "LOGICVALID";

	/**
	 * 建立人标识
	 */
	final static String PREDEFINEDTYPE_CREATEMAN = "CREATEMAN";

	/**
	 * 建立人名称
	 */
	final static String PREDEFINEDTYPE_CREATEMANNAME = "CREATEMANNAME";

	/**
	 * 建立时间
	 */
	final static String PREDEFINEDTYPE_CREATEDATE = "CREATEDATE";

	/**
	 * 更新人标识
	 */
	final static String PREDEFINEDTYPE_UPDATEMAN = "UPDATEMAN";

	/**
	 * 更新人名称
	 */
	final static String PREDEFINEDTYPE_UPDATEMANNAME = "UPDATEMANNAME";

	/**
	 * 更新时间
	 */
	final static String PREDEFINEDTYPE_UPDATEDATE = "UPDATEDATE";

	/**
	 * 组织机构标识
	 */
	final static String PREDEFINEDTYPE_ORGID = "ORGID";

	/**
	 * 组织部门标识
	 */
	final static String PREDEFINEDTYPE_ORGSECTORID = "ORGSECTORID";

	/**
	 * 组织机构名称
	 */
	final static String PREDEFINEDTYPE_ORGNAME = "ORGNAME";

	/**
	 * 组织部门名称
	 */
	final static String PREDEFINEDTYPE_ORGSECTORNAME = "ORGSECTORNAME";
	
	
	/**
	 * 排序值
	 */
	final static String PREDEFINEDTYPE_ORDERVALUE = "ORDERVALUE";
	

	/**
	 * 联合键值1
	 */
	public final static String UNIONKEYVALUE_KEY1 = "KEY1";

	/**
	 * 联合键值2
	 */
	public final static String UNIONKEYVALUE_KEY2 = "KEY2";

	/**
	 * 联合键值3
	 */
	public final static String UNIONKEYVALUE_KEY3 = "KEY3";

	/**
	 * 联合键值4
	 */
	public final static String UNIONKEYVALUE_KEY4 = "KEY4";

	/**
	 * 联合键值5
	 */
	public final static String UNIONKEYVALUE_KEY5 = "KEY5";

	/**
	 * 联合键值6
	 */
	public final static String UNIONKEYVALUE_KEY6 = "KEY6";

	/**
	 * 联合键值7
	 */
	public final static String UNIONKEYVALUE_KEY7 = "KEY7";

	/**
	 * 联合键值8
	 */
	public final static String UNIONKEYVALUE_KEY8 = "KEY8";

	
	/**
	 * 实体属性类型:未知(0)
	 */
	final static int DEFTYPE_UNKNOWN = 0;
	

	/**
	 * 实体属性类型:物理(1)
	 */
	final static int DEFTYPE_PHISICAL = 1;

	/**
	 * 实体属性类型:公式(2)
	 */
	final static int DEFTYPE_FORMULA = 2;

	/**
	 * 实体属性类型:关系实体的属性(3)
	 */
	final static int DEFTYPE_LINK = 3;
	
	/**
	 * 实体属性类型:扩展存储物理属性(4)
	 */
	final static int DEFTYPE_DYNASTORAGE = 4;
	
	
	/**
	 * 实体属性类型:应用界面属性(5)
	 */
	final static int DEFTYPE_UI = 5;
	
	

	/**
	 * 数据库值模式：版本叠加
	 */
	public final static String DBVALUEMODE_VERSION = "VERSION";

	/**
	 * 数据库值模式：当前日期时间
	 */
	public final static String DBVALUEMODE_CURDATETIME = "CURDATETIME";

	/**
	 * 数据库值模式：当前日期
	 */
	public final static String DBVALUEMODE_CURDATE = "CURDATE";

	/**
	 * 数据库值模式：值函数
	 */
	public final static String DBVALUEMODE_VALUEFUNC = "VALUEFUNC";
	
	
	/**
	 * 数据库值模式：忽略插入或是更新
	 */
	public final static String DBVALUEMODE_IGNORE = "IGNORE";

	/**
	 * 获取实体
	 * 
	 * @return
	 */
	IDataEntity getDataEntity();

	/**
	 * 获取属性逻辑名称
	 * 
	 * @return
	 */
	String getLogicName();

	/**
	 * 获取属性逻辑名称
	 * 
	 * @return
	 */
	String getLogicName(String strLanguange);

	/**
	 * 是否为主键属性
	 * 
	 * @return
	 */
	boolean isKeyDEField();

	/**
	 * 是否为唯一标识属性
	 * 
	 * @return
	 */
	boolean isUniTagField();

	/**
	 * 是否主属性
	 * 
	 * @return
	 */
	boolean isMajorDEField();

	/**
	 * 是否为链接属性
	 * 
	 * @return
	 */
	boolean isLinkDEField();

	/**
	 * 获取数据类型
	 * 
	 * @return
	 */
	String getDataType();

	/**
	 * 获取标准数据类型
	 * 
	 * @return
	 */
	int getStdDataType();

	/**
	 * 是否支持快速搜索
	 * 
	 * @return
	 */
	boolean isEnableQuickSearch();

	/**
	 * 获取属性搜索项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IDEFSearchMode> getDEFSearchModes();

	/**
	 * 是否启用属性权限控制
	 * 
	 * @return
	 */
	boolean isEnablePrivilege();

	/**
	 * 获取指定的代码表编号
	 * 
	 * @return
	 */
	String getCodeListId();

	/**
	 * 获取制定的属性
	 * 
	 * @param strDVRId
	 * @return
	 * @throws Exception
	 */
	IDEFValueRule getDEFValueRule(String strDVRId) throws Exception;

	/**
	 * 获取预定义模式
	 * 
	 * @return
	 */
	String getPreDefinedType();

	/**
	 * 是否为公式属性
	 * 
	 * @return
	 */
	boolean isFormulaDEField();

	/**
	 * 是否为物理属性
	 * 
	 * @return
	 */
	boolean isPhisicalDEField();

	/**
	 * 是否为继承属性
	 * 
	 * @return
	 */
	boolean isInheritDEField();

	/**
	 * 获取数据库值函数，参看 获取数据库值更新模式 getDBValueUpdateMode
	 * 
	 * @return
	 */
	@Deprecated
	String getDBValueFunc();

	/**
	 * 获取数据库值插入模式，值参考 net.ibizsys.paas.core.IDEField.DBVALUEMODE_XXX 定义
	 * 
	 * @return
	 */
	String getDBValueInsertMode();

	/**
	 * 获取数据库值更新模式，值参考 net.ibizsys.paas.core.IDEField.DBVALUEMODE_XXX 定义
	 * 
	 * @return
	 */
	String getDBValueUpdateMode();

	
	/**
	 * 是否启用数据库值插入更新模式，默认为不启用，使用值函数模式
	 * @return
	 */
	boolean isEnableDBValueInsertUpdateMode();
	
	/**
	 * 数据导入次序
	 * 
	 * @return
	 */
	int getImportOrder();

	/**
	 * 获取导入数据标识
	 * 
	 * @return
	 */
	String getImportTag();

	// /**
	// * 导入联合键值
	// * @return
	// */
	// boolean isImportKey();

	/**
	 * 获取备注
	 * 
	 * @return
	 */
	String getMemo();

	/**
	 * 获取关系
	 * 
	 * @return
	 */
	String getDERName();

	/**
	 * 获取连接的属性名称
	 * 
	 * @return
	 */
	String getLinkDEFName();

	/**
	 * 获取值格式化串
	 * 
	 * @return
	 */
	String getValueFormat();

	/**
	 * 是否支持审计
	 * 
	 * @return
	 */
	boolean isEnableAudit();

	/**
	 * 获取审计信息格式
	 * 
	 * @return
	 */
	String getAuditInfoFormat();

	/**
	 * 是否为多表单识别属性
	 * 
	 * @return
	 */
	boolean isMultiFormDEField();

	/**
	 * 是否为实体索引识别属性
	 * 
	 * @return
	 */
	boolean isIndexTypeDEField();

	/**
	 * 是否支持临时数据
	 * 
	 * @return
	 */
	boolean isEnableTempData();

	/**
	 * 获取联合键值模式
	 * 
	 * @return
	 */
	String getUnionKeyValue();

	/**
	 * 是否支持数据库自动值（如自增）
	 * 
	 * @return
	 */
	boolean isEnableDBAutoValue();
	
	/**
	 * 获取数据库值函数代码
	 * @param strDBType
	 * @param bInsert
	 * @return
	 * @throws Exception
	 */
	IDEFDBValueFunc getDEFDBValueFunc(String strDBType,boolean bInsert)throws Exception;
	
	
	
	
	/**
	 * 获取实体属性数据列配置
	 * @param strDBType
	 * @return
	 * @throws Exception
	 */
	IDEFDTColumn getDEFDTColumn(String strDBType)throws Exception;
	
	
	/**
	 * 获取属性类型，值参考 net.ibizsys.paas.core.IDEField.DEFTYPE_XXX 定义
	 * @return
	 */
	int getDEFType();
	
	
	
	/**
	 * 是否为动态存储属性
	 * @return
	 */
	boolean isDynaStorageDEField();
}
