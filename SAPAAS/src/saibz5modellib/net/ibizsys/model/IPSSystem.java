package net.ibizsys.model;

import net.ibizsys.model.app.IPSApplication;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIAction;
import net.ibizsys.model.dataentity.uiaction.IPSDEUIActionGroup;
import net.ibizsys.model.der.IPSDERBase;
import net.ibizsys.model.dynasys.IPSDynaInst;
import net.ibizsys.model.res.IPSLanguageItem;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysDBValueFunc;
import net.ibizsys.model.res.IPSSysEditorStyle;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.IPSSysLan;
import net.ibizsys.model.res.IPSSysPDTView;
import net.ibizsys.model.res.IPSSysPortlet;
import net.ibizsys.model.security.IPSSysUniRes;
import net.ibizsys.model.valuerule.IPSSysValueRule;
import net.ibizsys.model.wf.IPSWFRole;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.core.ISystem;

/**
 * 系统模型对象
 * @author Administrator
 *
 */
public interface IPSSystem extends IPSModelObject,ISystem {

	/**
	 * 获取实体数据对象
	 * 
	 * @param strDEName
	 * @return
	 * @throws Exception
	 */
	IPSDataEntity getPSDataEntity(String strDEName) throws Exception;

	/**
	 * 获取实体数据对象
	 * 
	 * @param strDEName
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSDataEntity getPSDataEntity(String strDEName, boolean bCache) throws Exception;
	
	
	/**
	 * 获取系统应用对象
	 * @param strPSSysAppId
	 * @return
	 * @throws Exception
	 */
	IPSApplication getPSApplication(String strPSSysAppId)throws Exception;
	
	
	/**
	 * 获取统一资源
	 * 
	 * @param strSysUniResId
	 * @return
	 * @throws Exception
	 */
	IPSSysUniRes getPSSysUniRes(String strSysUniResId) throws Exception;
	
	
	/**
	 * 获取图片资源
	 * 
	 * @param strSysImageId
	 * @return
	 * @throws Exception
	 */
	IPSSysImage getPSSysImage(String strSysImageId) throws Exception;
	
	
	
	
	/**
	 * 获取样式表
	 * 
	 * @param strSysCssId
	 * @return
	 * @throws Exception
	 */
	IPSSysCss getPSSysCss(String strSysCssId) throws Exception;
	
	
	
	/**
	 * 获取系统系统计数器
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSSysCounter getPSSysCounter(String strPSSysCounterId, boolean bTryMode) throws Exception;
	

	
	/**
	 * 获取代码表
	 * 
	 * @param strCodeListId
	 * @return
	 * @throws Exception
	 */
	IPSCodeList getPSCodeList(String strCodeListId) throws Exception;
	
	
	
	/**
	 * 获取系统编辑器样式
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSSysEditorStyle getPSSysEditorStyle(String strPSSysEditorStyleId) throws Exception;
	
	
	
	/**
	 * 获取指定编辑器的默认系统编辑器样式
	 * @param strPSEditorTypeId
	 * @return
	 */
	IPSSysEditorStyle getDefaultPSSysEditorStyle(String strPSEditorTypeId);
	
	
	
	/**
	 * 获取系统数据库值操作
	 * @param strPSSysDBValueFuncId
	 * @return
	 * @throws Exception
	 */
	IPSSysDBValueFunc getPSSysDBValueFunc(String strPSSysDBValueFuncId)throws Exception; 
	
	
	
	/**
	 * 获取门户部件
	 * 
	 * @param strSysPortletId
	 * @return
	 * @throws Exception
	 */
	IPSSysPortlet getPSSysPortlet(String strSysPortletId) throws Exception;
	
	
	/**
	 * 获取语言资源
	 * 
	 * @param strLanguageResId
	 * @return
	 * @throws Exception
	 */
	IPSLanguageRes getPSLanguageRes(String strLanguageResId) throws Exception;
	
	
	/**
	 * 获取系统模型版本
	 * @return
	 */
	int getVersion();
	
	
	
	/**
	 * 获取实体界面行为组
	 * 
	 * @param strSystemDEUIActionGroupId
	 * @return
	 * @throws Exception
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception;
	
	
	
	/**
	 * 获取实体数据操作标识
	 * 
	 * @param strPSDEOPPrivId
	 * @return
	 * @throws Exception
	 */
	IPSDEOPPriv getPSDEOPPriv(String strPSDEOPPrivId) throws Exception;
	
	
	
	
	/**
	 * 获取全局实体界面行为
	 * 
	 * @param strDEUIActionId
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSDEUIAction getPSDEUIAction(String strDEUIActionId, boolean bTryMode) throws Exception;
	
	
	/**
	 * 是否使用无视图模式
	 * @return
	 */
	boolean isNoViewMode();
	
	
	/**
	 * 获取指定系统工作流
	 * 
	 * @param strWorkflowId
	 * @return
	 * @throws Exception
	 */
	IPSWorkflow getPSWorkflow(String strWorkflowId) throws Exception;
	
	/**
	 * 获取指定系统工作流
	 * 
	 * @param strWorkflowId
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IPSWorkflow getPSWorkflow(String strWorkflowId,boolean bTryMode) throws Exception;
	
	
	/**
	 * 获取预置视图
	 * 
	 * @param strSysPDTViewId
	 * @return
	 * @throws Exception
	 */
	IPSSysPDTView getPSSysPDTView(String strSysPDTViewId) throws Exception;
	
	
	/**
	 * 查找指定实体关系
	 * 
	 * @param strPSDERId
	 * @return
	 * @throws Exception
	 */
	IPSDERBase getPSDER(String strPSDERId) throws Exception;
	
	
	
	/**
	 * 获取值规则
	 * 
	 * @param strSysValueRuleId
	 * @return
	 * @throws Exception
	 */
	IPSSysValueRule getPSSysValueRule(String strSysValueRuleId) throws Exception;
	
	
	/**
	 * 获取后台服务体系
	 * 
	 * @return
	 */
	String getSFType();
	
	
	/**
	 * 获取代码表
	 * 
	 * @param strCodeListId
	 * @return
	 * @throws Exception
	 */
	IPSCodeList getPSCodeListByTempl(String strCodeListTemplId) throws Exception;

	
	
	/**
	 * 获取语言资源项
	 * 
	 * @param strLanguageItemId
	 * @return
	 * @throws Exception
	 */
	IPSLanguageItem getPSLanguageItem(String strLanguageItemId, boolean bTryMode) throws Exception;
	
	

	/**
	 * 获取逻辑名称
	 * 
	 * @return
	 */
	String getLogicName();
	
	
	
	/**
	 * 获取系统工作流角色
	 * 
	 * @param strWFRoleId
	 * @return
	 * @throws Exception
	 */
	IPSWFRole getPSWFRole(String strWFRoleId) throws Exception;
	
	
	
	
	
	
	
	
	/**
	 * 获取后台服务框架标示
	 * 
	 * @return
	 */
	String getPSSFId();

	/**
	 * 获取后台服务框架名称
	 * 
	 * @return
	 */
	String getPSSFName();
	
	

	/**
	 * 获取全部系统语言
	 * 
	 * @return
	 */
	java.util.Iterator<IPSSysLan> getAllPSSysLans() throws Exception;
	
	
	/**
	 * 获取默认语言
	 * 
	 * @return
	 */
	String getDefaultLanguage();

	/**
	 * 获取系统是否支持多语言
	 * 
	 * @return
	 */
	boolean isEnableMultiLan();

	
	/**
	 * 判断是否具备指定流程引擎
	 * @param strEngineType
	 * @return
	 */
	boolean hasPSWFEngineType(String strEngineType)  throws Exception;
	
	
	/**
	 * 获取全部流程
	 * 
	 * @return
	 */
	java.util.Iterator<IPSWorkflow> getAllPSWorkflows() throws Exception;

	/**
	 * 获取全部流程角色
	 * 
	 * @return
	 */
	java.util.Iterator<IPSWFRole> getAllPSWFRoles() throws Exception;
	
	
	/**
	 * 获取系统数据库结构版本
	 * @return
	 */
	int getDBVersion();
	
	
	/**
	 * 是否支持动态系统
	 * @return
	 */
	boolean isEnableDynaSys();
	
	
	/**
	 * 获取模型库实例标识
	 * @return
	 */
	String getPSSysModelInstId();

	
	/**
	 * 获取全部应用程序
	 * 
	 * @return
	 */
	java.util.Iterator<IPSApplication> getAllPSApps() throws Exception;
	
	
	
	
	/**
	 * 获取指定动态实例
	 * 
	 * @param strPSDynaInstId
	 * @return
	 * @throws Exception
	 */
	IPSDynaInst getPSDynaInst(String strPSDynaInstId) throws Exception;
	
	
	/**
	 * 重置全部动态实例
	 */
	void resetAllPSDynaInsts();
	
	
	/**
	 * 重置指定动态实例
	 * @param strPSDynaInstId
	 * @throws Exception
	 */
	void resetPSDynaInst(String strPSDynaInstId);
}
