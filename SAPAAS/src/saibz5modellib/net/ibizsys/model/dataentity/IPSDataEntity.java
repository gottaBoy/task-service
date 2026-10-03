package net.ibizsys.model.dataentity;

import java.util.Iterator;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.dataexport.IPSDEDataExport;
import net.ibizsys.model.dataentity.dr.IPSDEDRGroup;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.dataentity.dr.IPSDEDataRelation;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.field.IPSPickupDEField;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.mainstate.IPSDEMainState;
import net.ibizsys.model.dataentity.print.IPSDEPrint;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.dataentity.util.IPSDEUtil;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.der.IPSDER11;
import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.der.IPSDERIndex;
import net.ibizsys.model.der.IPSDERInherit;
import net.ibizsys.model.der.IPSDERMultiInherit;
import net.ibizsys.model.der.IPSDERNN;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.core.IDataEntity;


/**
 * 系统实体对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSDataEntity extends IDataEntity,IPSSystemObject {

	/**
	 * 实体类型：主实体
	 */
	public final static int DETYPE_MAJOR = 1;

	/**
	 * 实体类型：附属实体
	 */
	public final static int DETYPE_ATTACHED = 2;

	/**
	 * 实体类型：关系实体
	 */
	public final static int DETYPE_RELATED = 3;

	/**
	 * 实体扩展模式：无扩展
	 */
	public final static int EXTENDMODE_NONE = 0;

	/**
	 * 实体扩展模式：子系统扩展
	 */
	public final static int EXTENDMODE_SUBSYS = 2;

	
	/**
	 * 默认支持的界面行为：建立
	 */
	public final static int ENABLEUIACTION_CREATE = 1;
	
	/**
	 * 默认支持的界面行为：更新
	 */
	public final static int ENABLEUIACTION_UPDATE = 2;
	
	/**
	 * 默认支持的界面行为：移除
	 */
	public final static int ENABLEUIACTION_REMOVE = 4;
	
	/**
	 * 默认支持的界面行为：查看
	 */
	public final static int ENABLEUIACTION_VIEW = 8;
	
	
	/**
	 * 虚拟实体模式，无
	 */
	public final static int VIRTUALMODE_NONE = 0;
	
	
	/**
	 * 虚拟实体模式，常规，多实体剪裁组合
	 */
	public final static int VIRTUALMODE_MINHERIT = 1;
	
	
	/**
	 * 虚拟实体模式，高级，单一继承扩展
	 */
	public final static int VIRTUALMODE_INHERIT = 2;
	
	
	
	/**
	 * 获取属性集合
	 * 
	 * @return
	 */
	
	Iterator<IPSDEField> getPSDEFields() throws Exception;
	
	
	/**
	 * 获取属性集合，功能与getPSDEFields相同
	 * 
	 * @return
	 */
	Iterator<IPSDEField> getAllPSDEFields() throws Exception;
	
	

	/**
	 * 查找指定属性
	 * 
	 * @param strDEFieldName
	 * @return
	 * @throws Exception
	 */
	IPSDEField getPSDEField(String strDEFieldName) throws Exception;

	/**
	 * 查找指定属性
	 * 
	 * @param strDEFieldName
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSDEField getPSDEField(String strDEFieldName, boolean bTryMode) throws Exception;

	/**
	 * 获取实体对象的完整名称，格式为 系统名称|实体名称
	 * 
	 * @return
	 */
	String getFullName();

	/**
	 * 获取实体是否启用逻辑有效控制
	 * 
	 * @return
	 */
	boolean isLogicValid();

	/**
	 * 获取逻辑有效控制值
	 * 
	 * @param bValid
	 *            是否有效
	 * @return
	 */
	Object getLogicValidValue(boolean bValid);

	/**
	 * 获取逻辑有效值字符值
	 * 
	 * @param bValid
	 * @return
	 */
	String getLogicValidStringValue(boolean bValid);

	
//	/**
//	 * 获取实体全部数据库配置集合 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEDBConfig> getAllPSDEDBConfigs()throws Exception;
//	
//	/**
//	 * 获取实体的指定数据库配置
//	 * 
//	 * @param strDBType
//	 *            数据库类型
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDBConfig getPSDEDBConfig(String strDBType) throws Exception;
//
//	/**
//	 * 获取实体的指定数据库配置
//	 * 
//	 * @param strDBType   数据库类型
//	 * @param bTryMode 尝试模式
//	 *
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDBConfig getPSDEDBConfig(String strDBType,boolean bTryMode) throws Exception;
//	
	
	/**
	 * 获取实体模型版本
	 * @return
	 */
	int getVersion();
	
	/**
	 * 获取主键属性
	 * 
	 * @return
	 */
	IPSDEField getKeyPSDEField();

	/**
	 * 获取主属性
	 * 
	 * @return
	 */
	IPSDEField getMajorPSDEField();

	/**
	 * 获取逻辑属性
	 * 
	 * @return
	 */
	IPSDEField getLogicValidPSDEField() throws Exception;

	/**
	 * 通过关系获取外键属性
	 * 
	 * @param strPSDERId
	 * @return
	 * @throws Exception
	 */
	IPSPickupDEField getPSPickupDEField(String strPSDERId) throws Exception;

	/**
	 * 获取继承的数据实体
	 * 
	 * @return
	 */
	IPSDataEntity getInheritPSDataEntity() throws Exception;

	/**
	 * 获取继承关系
	 * 
	 * @return
	 */
	IPSDERInherit getPSDERInherit() throws Exception;

	/**
	 * @param strPreDefinedType
	 * @return
	 */
	IPSDEField getPSDEFieldByPDT(String strPreDefinedType, boolean bTryMode) throws Exception;

	/**
	 * 通过关系获取属性列表
	 * 
	 * @param strDERId
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEField> getPSDEFieldsByDER(String strDERId) throws Exception;
//
//	/**
//	 * @param bMain
//	 * @param strDERType
//	 * @param strPSDERName
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDERBase getPSDER(boolean bMain, String strDERType, String strPSDERName) throws Exception;
//
//	/**
//	 * 获取全部实体界面行为
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEUIAction> getAllPSDEUIActions() throws Exception;
//
	/**
	 * 获取实体界面行为
	 * 
	 * @param strDEUIActionId
	 * @return
	 * @throws Exception
	 */
	IPSDEUIAction getPSDEUIAction(String strDEUIActionId) throws Exception;
	
	/**
	 * 获取实体界面行为
	 * 
	 * @param strDEUIActionId
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IPSDEUIAction getPSDEUIAction(String strDEUIActionId,boolean bTryMode) throws Exception;
//	
//	
//
//	
//
	/**
	 * 获取实体界面行为组
	 * 
	 * @param strDEUIActionGroupId
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId) throws Exception;
	
	/**
	 * 获取实体界面行为组
	 * 
	 * @param strDEUIActionGroupId
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId,boolean bTryMode) throws Exception;
	

	

	/**
	 * 获取关系
	 * 
	 * @param bMajor
	 * @param strPSDERId
	 * @return
	 * @throws Exception
	 */
	IPSDERBase getPSDER(boolean bMajor, String strPSDERId) throws Exception;

	/**
	 * 获取关系
	 * 
	 * @param bMajor
	 * @param strPSDERId
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSDERBase getPSDER(boolean bMajor, String strPSDERId, boolean bTryMode) throws Exception;

	/**
	 * 获取实体关系集合
	 * @param bMajor 是否主关系 
	 * @return
	 */
	java.util.Iterator<IPSDERBase> getPSDERs(boolean bMajor);

	
	/**
	 * 获取实体主关系集合
	 * @return
	 */
	java.util.Iterator<IPSDERBase> getMajorPSDERs();
	
	/**
	 * 获取实体从关系集合
	 * @return
	 */
	java.util.Iterator<IPSDERBase> getMinorPSDERs();
//	
//	
//	String getDBSchema();
//
	/**
	 * 获取实体数据查询
	 * 
	 * @param strSystemDEDataQueryId
	 * @return
	 * @throws Exception
	 */
	IPSDEDataQuery getPSDEDataQuery(String strDEDataQueryId) throws Exception;

	

	/**
	 * 获取实体数据集合
	 * 
	 * @param strSystemDEDataSetId
	 * @return
	 * @throws Exception
	 */
	IPSDEDataSet getPSDEDataSet(String strDEDataSetId) throws Exception;

	

	/**
	 * 获取全部结果集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEDataSet> getAllPSDEDataSets() throws Exception;

	

	/**
	 * 获取全部的主实体
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDataEntity> getAllMasterPSDataEntities() throws Exception;

//	
//
//	/**
//	 * 获取全部实体行为
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEAction> getAllPSDEActions() throws Exception;
//
	/**
	 * 获取实体行为
	 * 
	 * @param strDEActionId
	 *            实体行为ID 或 标识（大写）
	 * @return
	 * @throws Exception
	 */
	IPSDEAction getPSDEAction(String strDEActionId) throws Exception;

	/**
	 * 获取实体行为
	 * 
	 * @param strDEActionId
	 *            实体行为ID 或 标识（大写）
	 * @param bTryMode
	 *            参数模式
	 * @return
	 * @throws Exception
	 */
	IPSDEAction getPSDEAction(String strDEActionId, boolean bTryMode) throws Exception;

	

	/**
	 * 获取索引类型属性
	 * 
	 * @return
	 */
	IPSDEField getIndexTypePSDEField();

	/**
	 * 获取全部实体自填模式
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEACMode> getAllPSDEACModes() throws Exception;

	/**
	 * 获取实体自填模式
	 * 
	 * @param strSystemDEACModeId
	 * @return
	 * @throws Exception
	 */
	IPSDEACMode getPSDEACMode(String strDEACModeId) throws Exception;
//
//	
//
//	/**
//	 * 获取全部实体界面关系组
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEDataRelation> getAllPSDEDataRelations()throws Exception;
	/**
	 * 获取实体数据关系
	 * 
	 * @param strSystemDEDataRelationId
	 * @return
	 * @throws Exception
	 */
	IPSDEDataRelation getPSDEDataRelation(String strDEDataRelationId) throws Exception;
//
//	
//
//	/**
//	 * 获取实体全部实体关系分组对象
//	 * @return
//	 */
//	java.util.Iterator<IPSDEDRGroup> getAllPSDEDRGroups()throws Exception;
//	
	
	/**
	 * 获取实体数据关系分组
	 * 
	 * @param strSystemDEDRGroupId
	 * @return
	 * @throws Exception
	 */
	IPSDEDRGroup getPSDEDRGroup(String strDEDRGroupId) throws Exception;
//
//	
//
//	/**
//	 * 获取实体全部关系界面对象
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEDRItem> getAllPSDEDRItems()throws Exception;
//	
//	
	/**
	 * 获取实体数据关系界面
	 * 
	 * @param strSystemDEDRItemId
	 * @return
	 * @throws Exception
	 */
	IPSDEDRItem getPSDEDRItem(String strDEDRItemId) throws Exception;

	

	/**
	 * 获取全部数据查询
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEDataQuery> getAllPSDEDataQueries() throws Exception;
//
//	/**
//	 * 获取系统模块
//	 * 
//	 * @return
//	 */
//	IPSSystemModule getPSSystemModule();
//
	/**
	 * 获取代码名称
	 * 
	 * @return
	 */
	String getCodeName();

	/**
	 * 获取联合键值属性集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEField> getUnionKeyValuePSDEFields();

	/**
	 * 获取1:N关系集合
	 * 
	 * @param bMajor
	 * @param bRemoveOrder
	 * @return
	 */
	Iterator<IPSDER1N> getPSDER1Ns(boolean bMajor, boolean bRemoveOrder);

	/**
	 * 获取1:N关系集合
	 * 
	 * @param bMajor
	 * @return
	 */
	Iterator<IPSDER1N> getPSDER1Ns(boolean bMajor);

	/**
	 * 获取删除1:N关系集合
	 * 
	 * @return
	 */
	Iterator<IPSDER1N> getRemovePSDER1Ns();

	/**
	 * 获取 克隆1:N关系集合
	 * 
	 * @return
	 */
	Iterator<IPSDER1N> getClonePSDER1Ns();
//
//	/**
//	 * 获取导出1:N关系集合
//	 * 
//	 * @return
//	 */
//	Iterator<IPSDER1N> getExportPSDER1Ns();
//
//	/**
//	 * 获取临时数据1:N关系集合
//	 * 
//	 * @return
//	 */
//	Iterator<IPSDER1N> getTempDataPSDER1Ns(boolean bMajor);
//
	/**
	 * 获取实体索引关系集合
	 * 
	 * @param bMajor
	 * @return
	 */
	Iterator<IPSDERIndex> getPSDERIndexs(boolean bMajor);

	/**
	 * 获取索引实体类型
	 * 
	 * @return
	 */
	String getIndexDEType();

	/**
	 * 获取逻辑名称
	 * 
	 * @return
	 */
	String getLogicName(String strLanguage);

	/**
	 * 获取逻辑名称语言资源标记
	 * 
	 * @return
	 */
	String getLNLanResTag();

	/**
	 * 获取逻辑名称语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getLNPSLanguageRes();
//
//	/**
//	 * 获取全部实体逻辑
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDELogic> getAllPSDELogics() throws Exception;
//
	/**
	 * 获取实体逻辑
	 * 
	 * @param strSystemDELogicId
	 * @return
	 * @throws Exception
	 */
	IPSDELogic getPSDELogic(String strDELogicId) throws Exception;

	

	/**
	 * 是否支持临时数据
	 * 
	 * @return
	 */
	boolean isEnableTempData();
//
	/**
	 * 是否支持多表单
	 * 
	 * @return
	 */
	boolean isEnableMultiForm();

	/**
	 * 获取表单类型属性
	 * 
	 * @return
	 */
	IPSDEField getFormTypePSDEField();

	

	/**
	 * 获取实体类型
	 * 
	 * @return
	 */
	int getDEType();

	/**
	 * 获取关系实体的N：N关系对象，
	 * 
	 * @return
	 */
	IPSDERNN getPSDERNN() throws Exception;

	

	

	/**
	 * 获取全部实体流程配置
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEWF> getAllPSDEWFs() throws Exception;

	/**
	 * 获取实体流程配置
	 * 
	 * @param strWFDEId
	 * @return
	 * @throws Exception
	 */
	IPSDEWF getPSDEWF(String strDEWFId) throws Exception;
//	
//	
//	/**
//	 * 获取实体工作流配置数量
//	 * @return
//	 */
//	int getPSDEWFCount() throws Exception;
//
//	
//
	/**
	 * 是否存储实体流程配置
	 * 
	 * @return
	 * @throws Exception
	 */
	boolean hasPSDEWF() throws Exception;

	/**
	 * 获取实体默认流程配置
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSDEWF getDefaultPSDEWF() throws Exception;
//
//	
//
//	/**
//	 * 获取数据表空间标识
//	 * 
//	 * @return
//	 */
//	String getTableSpaceId();
//
//	/**
//	 * 是否同时支持多数据源
//	 * 
//	 * @return
//	 */
//	boolean isEnableMultiDS();
//
	/**
	 * 获取全部实体数据操作标识
	 * 
	 * @return
	 * @throws Exception
	 */
	// java.util.Iterator<IPSDEOPPriv> getAllPSDEOPPrivs() throws Exception;

	/**
	 * 获取实体数据操作标识
	 * 
	 * @param strSystemDEOPPrivId
	 * @return
	 * @throws Exception
	 */
	IPSDEOPPriv getPSDEOPPriv(String strDEOPPrivId) throws Exception;

	/**
	 * 获取全部实体主状态
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEMainState> getAllPSDEMainStates() throws Exception;

	/**
	 * 获取实体主状态
	 * 
	 * @param strDEMainStateId
	 * @return
	 * @throws Exception
	 */
	IPSDEMainState getPSDEMainState(String strDEMainStateId) throws Exception;
	
	/**
	 * 获取实体主状态
	 * 
	 * @param strDEMainStateId
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IPSDEMainState getPSDEMainState(String strDEMainStateId,boolean bTryMode) throws Exception;
//	
//
//	
//
	/**
	 * 是否支持实体主状态
	 * 
	 * @return
	 */
	boolean isEnableDEMainState();
//
//	/**
//	 * 获取为现有模型
//	 * 
//	 * @return
//	 */
//	boolean isExistingModel();

	/**
	 * 是否支持系统组织模型
	 * 
	 * @return
	 */
	boolean isEnableOrgModel();
//
	/**
	 * 获取实体主状态属性集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEField> getDEMainStateDEFields();
//
//	/**
//	 * 是否为子系统实体
//	 * 
//	 * @return
//	 */
//	boolean isSubSysDE();
//
	/**
	 * 获取属性值规则
	 * 
	 * @param strPSDEFValueRuleId
	 * @return
	 * @throws Exception
	 */
	IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId) throws Exception;

	/**
	 * 获取属性值规则
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception;

	/**
	 * 获取实体系统图片资源
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();
//
//	


	/**
	 * 获取指定预定义视图标识
	 * 
	 * @param strPDTName
	 * @return
	 */
	String getPSDEViewIdByPDT(String strPDTName) throws Exception;
//
//	
//
//	/**
//	 * 获取全部实体数据库索引
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEDBIndex> getAllPSDEDBIndexs() throws Exception;
//
//	/**
//	 * 获取实体数据库索引
//	 * 
//	 * @param strSystemDEDBIndexId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDBIndex getPSDEDBIndex(String strDEDBIndexId) throws Exception;
//	
//	/**
//	 * 获取实体数据库索引
//	 * 
//	 * @param strSystemDEDBIndexId
//	 * @param bTryMode 尝试模式
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDBIndex getPSDEDBIndex(String strDEDBIndexId,boolean bTryMode) throws Exception;
//	
//
//	
//
//	/**
//	 * 获取全部实体报表
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEReport> getAllPSDEReports() throws Exception;
//
//	/**
//	 * 获取实体报表
//	 * 
//	 * @param strDEReportId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEReport getPSDEReport(String strDEReportId) throws Exception;
//
//	
//
//	

	/**
	 * 获取全部实体打印
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEPrint> getAllPSDEPrints() throws Exception;

	/**
	 * 获取实体打印
	 * 
	 * @param strDEPrintId
	 * @return
	 * @throws Exception
	 */
	IPSDEPrint getPSDEPrint(String strDEPrintId) throws Exception;
	
	
	/**
	 * 获取实体打印
	 * 
	 * @param strDEPrintId
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSDEPrint getPSDEPrint(String strDEPrintId,boolean bTryMode) throws Exception;
	

	

	/**
	 * 获取默认实体打印
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSDEPrint getDefaultPSDEPrint() throws Exception;

	/**
	 * 是否有实体打印
	 * 
	 * @return
	 * @throws Exception
	 */
	boolean hasPSDEPrint() throws Exception;
//
//	/**
//	 * 获取全部实体视图逻辑
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEViewLogic> getAllPSDEViewLogics() throws Exception;
//
//	/**
//	 * 获取实体视图逻辑
//	 * 
//	 * @param strSystemDEViewLogicId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEViewLogic getPSDEViewLogic(String strDEViewLogicId) throws Exception;
//
//	
//
//	/**
//	 * 是否有默认的实体行为测试单元
//	 * 
//	 * @return
//	 */
//	boolean hasDefaultDEActionTestUnit();
//
//	/**
//	 * 获取XML标记名称
//	 * 
//	 * @return
//	 */
//	String getXmlTagName();
//
//	/**
//	 * 获取全部实体向导
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEWizard> getAllPSDEWizards() throws Exception;
//
//	/**
//	 * 获取实体向导
//	 * 
//	 * @param strDEWizardId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEWizard getPSDEWizard(String strDEWizardId) throws Exception;
//	
//	/**
//	 * 获取实体向导
//	 * 
//	 * @param strDEWizardId
//	 * @param bTryMode 尝试模式
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEWizard getPSDEWizard(String strDEWizardId,boolean bTryMode) throws Exception;
//	
//
//	
//
//	/**
//	 * 获取全部实体数据同步
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEDataSync> getAllPSDEDataSyncs() throws Exception;
//
//	/**
//	 * 获取实体数据同步
//	 * 
//	 * @param strDEDataSyncId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDataSync getPSDEDataSync(String strDEDataSyncId) throws Exception;
//
//	

	/**
	 * 获取1:1关系
	 * 
	 * @return
	 */
	IPSDER11 getPSDER11() throws Exception;

	/**
	 * 获取1:1关系集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDER11> getPSDER11s() throws Exception;

	/**
	 * 是否为虚拟实体，虚拟实体自身并不具备数据持久化能力
	 * 
	 * @return
	 */
	boolean isVirtual();

	/**
	 * 获取实体多继承关系
	 * 
	 * @param bMajor
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDERMultiInherit> getPSDERMultiInherits(boolean bMajor) throws Exception;
//
//	/**
//	 * 获取全部实体大数据表配置
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEBDTable> getAllPSDEBDTables() throws Exception;
//
//	/**
//	 * 获取实体大数据表
//	 * 
//	 * @param strDEBDTableId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEBDTable getPSDEBDTable(String strDEBDTableId) throws Exception;
//
//	
//
//	/**
//	 * 获取实体存储模式
//	 * 
//	 * @return
//	 */
//	int getStorageMode();
//
	/**
	 * 获取全部实体数据导出
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSDEDataExport> getAllPSDEDataExports() throws Exception;

	/**
	 * 获取实体数据导出
	 * 
	 * @param strDEDataExportId
	 * @return
	 * @throws Exception
	 */
	IPSDEDataExport getPSDEDataExport(String strDEDataExportId) throws Exception;

	
	/**
	 * 获取实体数据导出
	 * 
	 * @param strDEDataExportId
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IPSDEDataExport getPSDEDataExport(String strDEDataExportId,boolean bTryMode) throws Exception;
//	
//	
//	
//	/**
//	 * 获取全部实体数据导入
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEDataImport> getAllPSDEDataImports() throws Exception;
//
//	/**
//	 * 获取实体数据导入
//	 * 
//	 * @param strDEDataImportId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDataImport getPSDEDataImport(String strDEDataImportId) throws Exception;
//	
//	/**
//	 *  获取实体数据导入
//	 * @param strDEDataImportId
//	 * @param bTryMode
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDataImport getPSDEDataImport(String strDEDataImportId,boolean bTryMode) throws Exception;
//	
//
//	
//	
//
//	/**
//	 * 获取全部实体操作向导
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEActionWizard> getAllPSDEActionWizards() throws Exception;
//
//	/**
//	 * 获取实体操作向导
//	 * 
//	 * @param strDEActionWizardId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEActionWizard getPSDEActionWizard(String strDEActionWizardId) throws Exception;
//
//	
//
//	/**
//	 * 获取全部实体操作向导组
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEActionWizardGroup> getAllPSDEActionWizardGroups() throws Exception;
//
//	/**
//	 * 获取实体操作向导组
//	 * 
//	 * @param strDEActionWizardGroupId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEActionWizardGroup getPSDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception;
//
//	
//
//	/**
//	 * 获取实体的默认帮助模块标识
//	 * 
//	 * @return
//	 */
//	String getPSHelpModuleId();
//
//	/**
//	 * 获取虚拟键值分隔符
//	 * 
//	 * @return
//	 */
//	String getVKeySeparator();
//
//	/**
//	 * 是否支持指定视图级别
//	 * 
//	 * @param nViewLevel
//	 * @return
//	 */
//	boolean isEnableViewLevel(int nViewLevel);
//
//	/**
//	 * 获取支持的视图级别
//	 * 
//	 * @return
//	 */
//	int getEnableViewLevel();
//
//	/**
//	 * 根据视图级别获取视图名称
//	 * 
//	 * @param nViewLevel
//	 * @return
//	 */
//	String getViewName(int nViewLevel);
//	
//	
//	
//	/**
//	 * 是否启用数据对象缓存
//	 * @return
//	 */
//	boolean isEnableEntityCache();
//
//	
//	/**
//	 * 获取数据对象缓存超时
//	 * @return
//	 */
//	int getEntityCacheTimeout();
//	
//	
//	
//	/**
//	 * 获取最大数据对象缓存数量，超过这个数量，
//	 * @return
//	 */
//	int getMaxEntityCacheCount();
//	
//	
//	
//	/**
//	 * 获取全部实体统一状态配置
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEUniState> getAllPSDEUniStates() throws Exception;
//
//	/**
//	 * 获取实体统一状态配置
//	 * 
//	 * @param strDEUniStateId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEUniState getPSDEUniState(String strDEUniStateId) throws Exception;
//	
//	
//	/**
//	 * 获取实体统一状态配置
//	 * 
//	 * @param strDEUniStateId
//	 * @param bTryMode 尝试模式 
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEUniState getPSDEUniState(String strDEUniStateId,boolean bTryMode) throws Exception;
//	
//
//	
//
//	/**
//	 * 是否存储实体统一状态配置
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	boolean hasPSDEUniState() throws Exception;
//
//	/**
//	 * 获取实体默认统一状态配置
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEUniState getDefaultPSDEUniState() throws Exception;
//	
//	
//	/**
//	 * 获取模型的导入导出模式
//	 * @return
//	 */
//	int getModelImpExpMode();
//	
//	
//	/**
//	 * 获取服务API提供模式，值参考 SA.SRFDA.PS.Core.IPSSystemSetting.SERVICEAPI_XXX 定义
//	 * 
//	 * @return
//	 */
//	int getServiceAPIMode();
//	
//	
//	
//	
//	/**
//	 * 获取全部实体服务API
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEServiceAPI> getAllPSDEServiceAPIs() throws Exception;
//
//	/**
//	 * 获取实体服务API
//	 * 
//	 * @param strDEServiceAPIId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEServiceAPI getPSDEServiceAPI(String strDEServiceAPIId) throws Exception;
//
//	
//	
//	
//	/**
//	 * 获取全部实体分布事务队列配置
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEDTSQueue> getAllPSDEDTSQueues() throws Exception;
//
//	/**
//	 * 获取实体分布事务队列配置
//	 * 
//	 * @param strWFDEId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEDTSQueue getPSDEDTSQueue(String strDEDTSQueueId) throws Exception;
//
//	
//
//	/**
//	 * 是否存储实体分布事务队列配置
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	boolean hasPSDEDTSQueue() throws Exception;
//	
//	
	
	/**
	 * 获取服务代码名称
	 * @return
	 */
	String getServiceCodeName();
//	
//	
//	/**
//	 * 是否默认支持实体行为
//	 * @return
//	 */
//	boolean isEnableSADEAction();
//	
//	
//	
//	/**
//	 * 是否默认支持基本查询操作
//	 * @return
//	 */
//	boolean isEnableSASelect();
//	
//	
//	/**
//	 * 是否默认支持获取实体数据集
//	 * @return
//	 */
//	boolean isEnableSADEDataSet();
//	
//	
//	
	/**
	 * 获取默认支持用户界面行为
	 * @return
	 */
	int getEnableUIActions();
//
//	
//	
//	
//	/**
//	 * 获取全部实体用户角色
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEUserRole> getAllPSDEUserRoles() throws Exception;
//
//	/**
//	 * 获取实体用户角色
//	 * 
//	 * @param strDEUserRoleId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEUserRole getPSDEUserRole(String strDEUserRoleId) throws Exception;
//	
//	/**
//	 * 获取实体用户角色
//	 * 
//	 * @param strDEUserRoleId
//	 * @param bTryMode 尝试模式
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEUserRole getPSDEUserRole(String strDEUserRoleId,boolean bTryMode) throws Exception;
//	
//
//	
//
//	/**
//	 * 获取全部实体用户操作标识角色
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEOPPrivRole> getAllPSDEOPPrivRoles() throws Exception;
//
//	/**
//	 * 获取实体用户操作标识角色
//	 * 
//	 * @param strDEOPPrivRoleId
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDEOPPrivRole getPSDEOPPrivRole(String strDEOPPrivRoleId) throws Exception;
//
//	
//	
//	
//	
//	/**
//	 * 获取全部实体辅助功能
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	java.util.Iterator<IPSDEUtil> getAllPSDEUtils() throws Exception;
//
	/**
	 * 获取实体辅助功能
	 * 
	 * @param strDEUtilId
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IPSDEUtil getPSDEUtil(String strDEUtilId,boolean bTryMode) throws Exception;

	
//	
//	/**
//	 * 获取默认的实体分布处理队列
//	 * @return
//	 */
//	IPSDEDTSQueue getDefaultPSDEDTSQueue() throws Exception;
//	
//	
//	
//	
//	
//	
//	
//	/**
//	 * 获取实体示例数据集合
//	 * @return
//	 * @throws Exception
//	 */
//	Iterator<IPSDESampleData> getAllPSDESampleDatas() throws Exception;
//	
//	
//	
//	/**
//	 * 获取实体示例数据
//	 * 
//	 * @param strDESampleDataId
//	 * @param bTryMode 尝试模式
//	 * @return
//	 * @throws Exception
//	 */
//	IPSDESampleData getPSDESampleData(String strDESampleDataId,boolean bTryMode) throws Exception;
	
	
	
	
	/**
	 * 获取是否支持动态存储
	 * @return
	 */
	boolean isEnableDynaStorage() ;
	
	
	
	/**
	 * 获取虚拟模式,值参考 SA.SRFDA.PS.Core.DataEntity.IPSDataEntity.VIRTUALMODE_XXX 定义
	 * @return
	 */
	int getVirtualMode();
	
	
	
	/**
	 * 获取动态实体模板标识
	 * @return
	 */
	String getPSDynaDETemplId();
	
	
	/**
	 * 获取预定义视图名称集合
	 * 
	 * @return
	 */
	java.util.Iterator<String> getPDTViewNames();


}
