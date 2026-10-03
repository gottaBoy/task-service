package net.ibizsys.paas.core;

import java.util.Iterator;

import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;

/**
 * 实体模型接口
 * 
 * @author lionlau
 *
 */
public interface IDataEntity extends IModelBase {
	/**
	 * 默认数据库
	 */
	public final static String DSLINK_DEFAULT = "DEFAULT";

	/**
	 * 数据连接2
	 */
	public final static String DSLINK_DB2 = "DB2";

	/**
	 * 数据连接3
	 */
	public final static String DSLINK_DB3 = "DB3";

	/**
	 * 数据连接4
	 */
	public final static String DSLINK_DB4 = "DB4";
	
	
	/**
	 * 数据连接5
	 */
	public final static String DSLINK_DB5 = "DB5";
	
	
	
	/**
	 * 数据连接6
	 */
	public final static String DSLINK_DB6 = "DB6";
	
	
	/**
	 * 数据连接7
	 */
	public final static String DSLINK_DB7 = "DB7";
	
	
	/**
	 * 数据连接8
	 */
	public final static String DSLINK_DB8 = "DB8";
	
	
	
	/**
	 * 数据连接9
	 */
	public final static String DSLINK_DB9 = "DB9";
	
	
	/**
	 * 数据连接10
	 */
	public final static String DSLINK_DB10 = "DB10";
	
	
	
	/**
	 * 数据连接11
	 */
	public final static String DSLINK_DB11 = "DB11";
	
	
	
	/**
	 * 数据连接12
	 */
	public final static String DSLINK_DB12 = "DB12";
	

	/**
	 * 动态实体（静态）
	 */
	public final static int DYNAMICMODE_STATIC = 0;

	/**
	 * 动态实体（动态）
	 */
	public final static int DYNAMICMODE_DYNAMIC = 1;

	/**
	 * 动态实体（扩展）
	 */
	public final static int DYNAMICMODE_EXTEND = 2;


	
	// 定义数据访问控制方式代码表
	/**
	 * 无控制
	 */
	public final static int DATAACCCTRL_NONE = 0;

	/**
	 * 自控制
	 */
	public final static int DATAACCCTRL_SELF = 1;

	/**
	 * 附属主实体控制
	 */
	public final static int DATAACCCTRL_MASTER = 2;

	/**
	 * 附属主实体控制（未定义时自控制）
	 */
	public final static int DATAACCCTRL_MASTER_SELF = 3;
	
	
	// 定义实体安全访问控制体系
	/**
	 * 实体安全访问控制体系:子系统角色控制
	 */
	public final static int DATAACCCTRLARCH_RTSYSROLE = 1;

	/**
	 * 实体安全访问控制体系:系统角色及实体角色控制
	 */
	public final static int DATAACCCTRLARCH_SYSROLE_DEROLE = 2;

	
		
	/**
	 * 无审计
	 */
	public final static int AUDITMODE_NONE = 0;

	/**
	 * 基本审计
	 */
	public final static int AUDITMODE_STD = 1;

	/**
	 * 详细审计（含变化记录）
	 */
	public final static int AUDITMODE_ADV = 2;

	/**
	 * 索引实体类型（索引）
	 */
	public final static String INDEXDETYPE_INDEX = "INDEX";

	/**
	 * 索引实体类型（继承）
	 */
	public final static String INDEXDETYPE_INHERIT = "INHERIT";

	/**
	 * 数据变更日志，无
	 */
	public final static int DATACHGLOG_NONE = 0;

	/**
	 * 数据变更日志，日志主键，后续展开
	 */
	// public final static int DATACHGLOG_KEY =1;

	/**
	 * 数据变更日志，日志数据（同步）
	 */
	public final static int DATACHGLOG_SINGLEDATA = 2;

	/**
	 * 数据变更日志，日志数据（含关联数据）（同步）
	 */
	public final static int DATACHGLOG_FULLDATA = 3;

	/**
	 * 数据变更日志，日志数据（异步）
	 */
	public final static int DATACHGLOG_SINGLEDATA_ASYNC = 4;

	/**
	 * 数据变更日志，日志数据（含关联数据）（异步）
	 */
	public final static int DATACHGLOG_FULLDATA_ASYNC = 5;

	/**
	 * 无存储
	 */
	public final static int STORAGEMODE_NONE = 0;

	/**
	 * SQL
	 */
	public final static int STORAGEMODE_SQL = 1;

	/**
	 * NoSQL
	 */
	public final static int STORAGEMODE_NoSQL = 2;

	/**
	 * SQL&NoSQL
	 */
	public final static int STORAGEMODE_SQLAndNoSQL = 3;
	
	
	/**
	 * ServiceAPI
	 */
	public final static int STORAGEMODE_SERVICEAPI = 4;
	
	
	/**
	 * 多模式存储
	 */
	public final static int STORAGEMODE_MULTI = 8;
	
	/**
	 * SQL（多模式存储）
	 */
	public final static int STORAGEMODE_SQLAndMore = STORAGEMODE_SQL|STORAGEMODE_MULTI;

	/**
	 * NoSQL（多模式存储）
	 */
	public final static int STORAGEMODE_NoSQLAndMore = STORAGEMODE_NoSQL|STORAGEMODE_MULTI;

	
	/**
	 * ServiceAPI（多模式存储）
	 */
	public final static int STORAGEMODE_SERVICEAPIAndMore = STORAGEMODE_SERVICEAPI|STORAGEMODE_MULTI;
	
	
	/**
	 * 用户自定义
	 */
	public final static int STORAGEMODE_USER = 128;
	
	
	/**
	 * 用户自定义2
	 */
	public final static int STORAGEMODE_USER2 = 256;
	
	
	/**
	 * 视图级别（未知）
	 */
	public final static int VIEWLEVEL_UNKNOWN = -1;
	
	
	/**
	 * 默认视图级别（全部属性）
	 */
	public final static int VIEWLEVEL_DEFAULT = 0;
	

	/**
	 * 视图级别2（表内数据）
	 */
	public final static int VIEWLEVEL_LEVEL2 = 1;
	
	
	/**
	 * 视图级别3（关键属性）
	 */
	public final static int VIEWLEVEL_LEVEL3 = 2;
	
	
	/**
	 * 视图级别4（个别属性）
	 */
	public final static int VIEWLEVEL_LEVEL4 = 3;
	
	
	/**
	*无
	*/
	public final static int DATAIMPEXPFLAG__NONE = 0 ;

	/**
	*导出
	*/
	public final static int DATAIMPEXPFLAG_EXPORT = 1 ;

	/**
	*导入
	*/
	public final static int DATAIMPEXPFLAG_IMPORT = 2 ;

	/**
	*导入及导出
	*/
	public final static int DATAIMPEXPFLAG_ALL = 3 ;
	
	/**
	 * 获取系统
	 * 
	 * @return
	 */
	ISystem getSystem();

	/**
	 * 获取实体属性
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IDEField> getDEFields() throws Exception;

	/**
	 * 查找一个属性
	 * 
	 * @param strDEFieldName
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IDEField getDEField(String strDEFieldName, boolean bTryMode) throws Exception;

	/**
	 * 获取主键属性
	 * 
	 * @return
	 */
	IDEField getKeyDEField();

	
	/**
	 * 获取唯一标识属性
	 * @return
	 */
	IDEField getUniTagDEField();
	
	
	/**
	 * 获取主属性
	 * 
	 * @return
	 */
	IDEField getMajorDEField();

	/**
	 * 获取逻辑属性
	 * 
	 * @return
	 */
	IDEField getLogicValidDEField();

	/**
	 * 获取表名
	 * 
	 * @return
	 */
	String getTableName();

	/**
	 * 获取表名
	 * 
	 * @return
	 */
	String getUserTable();

	/**
	 * 获取视图名称
	 * 
	 * @return
	 */
	String getViewName();

	
	/**
	 * 获取级别2视图名称
	 * 
	 * @return
	 */
	String getView2Name();
	
	
	
	/**
	 * 获取级别3视图名称
	 * 
	 * @return
	 */
	String getView3Name();
	
	
	
	/**
	 * 获取级别4视图名称
	 * 
	 * @return
	 */
	String getView4Name();
	
	
	/**
	 * 获取关系
	 * 
	 * @param bMajor
	 * @param strPSDERId
	 * @return
	 * @throws Exception
	 */
	IDERBase getDER(boolean bMajor, String strDERId) throws Exception;

	/**
	 * 获取实体关系集合
	 * 
	 * @param bMajor 是否为主实体
	 * @return
	 */
	java.util.Iterator<IDERBase> getDERs(boolean bMajor);

	/**
	 * 获取数据结合对象
	 * 
	 * @param strDEDataSetId
	 * @return
	 * @throws Exception
	 */
	IDEDataSet getDEDataSet(String strDEDataSetId) throws Exception;

	/**
	 * 获取逻辑名称
	 * 
	 * @return
	 */
	String getLogicName();

	/**
	 * 获取实体行为
	 * 
	 * @param strDEActionId
	 * @return
	 * @throws Exception
	 */
	IDEAction getDEAction(String strDEActionId) throws Exception;

	/**
	 * 获取实体逻辑
	 * 
	 * @param strDELogicId
	 * @return
	 * @throws Exception
	 */
	IDELogic getDELogic(String strDELogicId) throws Exception;

	/**
	 * 获取实体界面行为
	 * 
	 * @param strDEActionId
	 * @return
	 * @throws Exception
	 */
	IDEUIAction getDEUIAction(String strDEUIActionId) throws Exception;

	/**
	 * 获取实体工作流配置
	 * 
	 * @param strDEWFId
	 * @return
	 * @throws Exception
	 */
	IDEWF getDEWF(String strDEWFId) throws Exception;
	
	
	/**
	 * 获取是否有实体工作流配置
	 * @return
	 */
	boolean hasDEWF();

	/**
	 * 建立数据对象
	 * 
	 * @return
	 * @throws Exception
	 */
	IDataObject createDataObject() throws Exception;

	/**
	 * 获取指定的自填模式
	 * 
	 * @param strACModeName
	 * @return
	 * @throws Exception
	 */
	IDEACMode getDEACMode(String strACModeName) throws Exception;

	/**
	 * 获取默认的自填模式
	 * 
	 * @return
	 * @throws Exception
	 */
	IDEACMode getDefaultDEACMode() throws Exception;

	/**
	 * 获取数据数据
	 * 
	 * @param strDEDataQueryId
	 * @return
	 * @throws Exception
	 */
	IDEDataQuery getDEDataQuery(String strDEDataQueryId) throws Exception;

	/**
	 * 获取数据集合
	 * 
	 * @param strName
	 * @param bTry
	 * @return
	 * @throws Exception
	 */
	IDEDataSet getDEDataSet(String strName, boolean bTry) throws Exception;

	/**
	 * 获取逻辑有效
	 * 
	 * @return
	 */
	boolean isLogicValid();

	/**
	 * 获取逻辑有效值
	 * 
	 * @param bValid
	 * @return
	 */
	Object getLogicValidValue(boolean bValid);

	/**
	 * 获取默认数据源链接
	 * 
	 * @return
	 */
	String getDSLink();

	/**
	 * 是否同时支持多数据源
	 * 
	 * @return
	 */
	boolean isEnableMultiDS();

	/**
	 * 计算实体主状态
	 * 
	 * @param iSimpleDataObject
	 * @return
	 * @throws Exception
	 */
	IDEMainState getDEMainState(ISimpleDataObject iSimpleDataObject) throws Exception;

	/**
	 * 获取数据导入模式
	 * 
	 * @param strDEDataImportId
	 * @return
	 * @throws Exception
	 */
	IDEDataImport getDEDataImport(String strDEDataImportId) throws Exception;

	/**
	 * 获取数据输出模式
	 * 
	 * @param strDEDataExportId
	 * @return
	 * @throws Exception
	 */
	IDEDataExport getDEDataExport(String strDEDataExportId) throws Exception;
	
	/**
	 * 获取实体操作向导组对象
	 * @param strDEActionWizardGroupId
	 * @return
	 * @throws Exception
	 */
	IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception;
	
	/**
	 * 获取实体操作向导组对象
	 * @param strDEActionWizardGroupId
	 * @param  bTryMode 尝试获取
	 * @return
	 * @throws Exception
	 */
	IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId,boolean bTryMode) throws Exception;
	
	
	
	/**
	 * 获取实体操作向导对象
	 * @param strDEActionWizardId
	 * @return
	 * @throws Exception
	 */
	IDEActionWizard getDEActionWizard(String strDEActionWizardId) throws Exception;
	

	/**
	 * 获取数据访问控制模式
	 * 
	 * @return
	 */
	int getDataAccCtrlMode();

	/**
	 * 获取数据审计模式
	 * 
	 * @return
	 */
	int getAuditMode();

	/**
	 * 获取指定索引关系
	 * 
	 * @param bMajor
	 * @param strIndexValue
	 * @return
	 * @throws Exception
	 */
	IDERIndex getDERIndex(boolean bMajor, String strIndexValue) throws Exception;

	/**
	 * 获取继承的数据实体
	 * 
	 * @return
	 */
	IDataEntity getInheritDataEntity() throws Exception;

	/**
	 * 获取实体动态模式
	 * 
	 * @return
	 */
	int getDynamicMode();

	/**
	 * 获取映射的权限操作标识
	 * 
	 * @param strDEOPPrivTag
	 * @param strDERName
	 * @return
	 */
	String getMapDEOPPrivTag(String strDEOPPrivTag, String strDERName);

	/**
	 * 获取数据变化日志模式
	 * 
	 * @return
	 */
	int getDataChangeLogMode();

	/**
	 * 获取实体数据同步配置
	 * 
	 * @param bIn 是否为输入配置
	 * @return
	 */
	java.util.Iterator<IDEDataSync> getDEDataSyncs(boolean bIn);

	/**
	 * 是否为无视图模式
	 * 
	 * @return
	 */
	boolean isNoViewMode();

	/**
	 * 获取默认的实体数据查询，用于完成无视图模式查询
	 * 
	 * @return
	 */
	IDEDataQuery getDefaultDEDataQuery();
	
	
	/**
	 * 获取视图的实体数据查询，用于完成无视图模式查询
	 * @nViewLevel 视图级别
	 * @return
	 */
	IDEDataQuery getViewDEDataQuery(int nViewLevel);
	
	

	/**
	 * 获取实体存储模式
	 * 
	 * @return
	 */
	int getStorageMode();
	
	
	/**
	 * 获取实体大数据表
	 * 
	 * @param strDEBATableId
	 * @return
	 * @throws Exception
	 */
	IDEBATable getDEBATable(String strDEBATableId) throws Exception;
	
	
	
	/**
	 * 获取实体相关的大数据表
	 * @return
	 */
	java.util.Iterator<IDEBATable> getDEBATables();
	
	
	
	
	/**
	 * 获取实体统一状态对象
	 * 
	 * @param strDEUniStateId
	 * @return
	 * @throws Exception
	 */
	IDEUniState getDEUniState(String strDEUniStateId) throws Exception;
	
	
	
	/**
	 * 获取实体统一状态对象集合
	 * @return
	 */
	java.util.Iterator<IDEUniState> getDEUniStates();
	
	
	
	/**
	 * 获取实体默认统一状态对象
	 * @return
	 */
	IDEUniState getDefaultDEUniState();
	
	
	
	 /**
	  * 获取数据导入导出模式
	 * @return
	 */
	int getDataImpExpMode();
	
	
	
	
	/**
	 * 获取服务接口客户端标识
	 * @return
	 */
	String getServiceAPIClientId();
	
	
	
	/**
	 * 获取实体分布事务处理队列标识
	 * @return
	 */
	String getDefaultDEDTSQueueId();
	
	
	
	/**
	 * 获取访问控制体系，值参考 net.ibizsys.paas.core.IDataEntity.DATAACCCTRLARCH_XXX 定义
	 * @return
	 */
	int getDataAccCtrlArch();
	
	
	
	/**
	 * 获取指定用户角色对象
	 * @param strDEUserRoleId
	 * @return
	 * @throws Exception
	 */
	IDEUserRole getDEUserRole(String strDEUserRoleId) throws Exception;

	/**
	 * 获取实体的全部用户角色对象
	 * @return
	 */
	Iterator<IDEUserRole> getDEUserRoles();
	
	
	/**
	 * 获取实体操作标识绑定的角色对象集合
	 * @param strDEOPrivTag
	 * @return
	 */
	java.util.Iterator<IDEOPPrivRole> getDEOPPrivRoles(String strDEOPrivTag);
	
	
	
	
	/**
	 * 获取实体数据库配置模型
	 * @param strDBType
	 * @return
	 */
	IDEDBConfig getDEDBConfig(String strDBType) throws Exception;
	
	
	
	/**
	 * 获取实体默认的数据导入处理
	 * @return
	 */
	IDEDataImport getDefaultDEDataImport();
	

}
