package net.ibizsys.paas.sysmodel;

import net.ibizsys.paas.api.IServiceAPIAction;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.cache.IUniStateManager;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IModelBase3;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ISystemSetting;
import net.ibizsys.paas.core.IValueTranslator;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.dts.IDTSQueueModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.sf.json.JSONObject;

/**
 * 系统模型接口
 * 
 * @author lionlau
 *
 */
public interface ISystemModel extends ISystem,IModelBase3 {
	
	/**
	 * 获取模式，默认，不存在则报异常
	 */
	final static int GETMODE_EXCEPTIONIF = 0;
	
	/**
	 * 获取模式，尝试，不存在则返回null
	 */
	final static int GETMODE_TRY = 1;
	
	
	/**
	 * 获取模式，不存在则建立
	 */
	final static int GETMODE_CREATEIF = 2;
	
	
	/**
	 * 用户词典分类
	 */
	final static String USERDICTCAT = "USERDICTCAT";

	/**
	 * 用户词典分类（全局）
	 */
	final static String USERDICTCAT_GLOBAL = "GLOBAL";

	/**
	 * 用户词典分类（用户）
	 */
	final static String USERDICTCAT_USER = "USER";

	/**
	 * 获取指定实体模型（先当前系统，不存在则查找全局）
	 * 
	 * @param strDEName
	 * @return
	 * @throws Exception
	 */
	IDataEntityModel getDataEntityModel(String strDEName) throws Exception;

	
	/**
	 * 获取实体模型
	 * @param strDEName
	 * @param bIncludeOtherSys 是否包括其它子系统
	 * @return
	 * @throws Exception
	 */
	IDataEntityModel getDataEntityModel(String strDEName,boolean bIncludeOtherSys) throws Exception ;
	
	/**
	 * 获取系统流程模型
	 * 
	 * @param strWFModelId
	 * @return
	 * @throws Exception
	 */
	IWFModel getWFModel(String strWFModelId) throws Exception;

	/**
	 * 获取流程角色模型
	 * 
	 * @param strWFRoleModelId
	 * @return
	 * @throws Exception
	 */
	IWFRoleModel getWFRoleModel(String strWFRoleModelId) throws Exception;

	
	/**
	 * 获取系统流程模型
	 * 
	 * @param strWFModelId
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IWFModel getWFModel(String strWFModelId,boolean bTryMode) throws Exception;

	/**
	 * 获取流程角色模型
	 * 
	 * @param strWFRoleModelId
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IWFRoleModel getWFRoleModel(String strWFRoleModelId,boolean bTryMode) throws Exception;
	
	
	/**
	 * 获取流程角色集合
	 * 
	 * @return
	 */
	java.util.Iterator<IWFRoleModel> getWFRoleModels();

	/**
	 * 值转换器
	 * 
	 * @param strTranslator
	 * @return
	 * @throws Exception
	 */
	IValueTranslator getValueTranslator(String strTranslator) throws Exception;

	/**
	 * 安装运行时数据
	 */
	void installRTDatas() throws Exception;

	/**
	 * 获取实体相关关系
	 * 
	 * @param strDEId
	 * @param bMajor 主关系或从关系
	 * @return
	 */
	java.util.Iterator<IDERBase> getDERs(String strDEId, boolean bMajor);
	
	
	/**
	 * 获取指定关系
	 * 
	 * @param strDERId
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IDERBase getDER(String strDERId,boolean bTryMode) throws Exception;
	

//	/**
//	 * 获取系统动态模型存储对象
//	 * 
//	 * @return
//	 */
//	IDynamicModelStorage getDynamicModelStorage() throws Exception;

	/**
	 * 建立实体数据访问对象
	 * 
	 * @param iDEModel
	 * @return
	 * @throws Exception
	 */
	IDEDataAccMgr createDEDataAccMgr(IDataEntityModel iDEModel) throws Exception;

	/**
	 * 注册系统实体模型
	 * 
	 * @param iDataEntityModel
	 * @throws Exception
	 */
	void registerDataEntityModel(IDataEntityModel iDataEntityModel) throws Exception;

	/**
	 * 注册系统流程模型
	 * 
	 * @param iWFModel
	 * @throws Exception
	 */
	void registerWFModel(IWFModel iWFModel) throws Exception;

	/**
	 * 注册系统流程角色模型
	 * 
	 * @param iWFRoleModel
	 * @throws Exception
	 */
	void registerWFRoleModel(IWFRoleModel iWFRoleModel) throws Exception;

	
	
	/**
	 * 注册系统成员模型
	 * @param iSystemPartModel
	 * @throws Exception
	 */
	void registerSystemPartModel(ISystemPartModel iSystemPartModel) throws Exception;
	
	
	/**
	 * 注册系统大数据架构模型
	 * 
	 * @param iBASchemeModel
	 * @throws Exception
	 */
	void registerBASchemeModel(IBASchemeModel iBASchemeModel) throws Exception;

	/**
	 * 获取系统大数据架构模型
	 * 
	 * @param strBASchemeModelId
	 * @return
	 * @throws Exception
	 */
	IBASchemeModel getBASchemeModel(String strBASchemeModelId) throws Exception;
	
	
	
	/**
	 * 注册系统视图消息组
	 * 
	 * @param iViewMsgGroupModel
	 * @throws Exception
	 */
	void registerViewMsgGroupModel(IViewMsgGroupModel iViewMsgGroupModel) throws Exception;

	/**
	 * 获取系统视图消息组
	 * 
	 * @param strViewMsgGroupId
	 * @return
	 * @throws Exception
	 */
	IViewMsgGroupModel getViewMsgGroupModel(String strViewMsgGroupId) throws Exception;
	
	

	/**
	 * 注册系统视图消息
	 * 
	 * @param iViewMsgModel
	 * @throws Exception
	 */
	void registerViewMsgModel(IViewMsgModel iViewMsgModel) throws Exception;

	/**
	 * 获取系统视图消息
	 * 
	 * @param strViewMsgId
	 * @return
	 * @throws Exception
	 */
	IViewMsgModel getViewMsgModel(String strViewMsgId) throws Exception;

	/**
	 * 获取视图消息集合
	 * @param iViewController 视图控制器
	 * @param iViewMsgGroupModel
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IViewMessage> getViewMessages(IViewController iViewController,IViewMsgGroupModel iViewMsgGroupModel) throws Exception;


	/**
	 * 获取视图向导集合
	 * @param iViewController 视图控制器
	 * @param iViewMsgGroupModel
	 * @param strQuery
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IViewWizard> getViewWizards(IViewController iViewController,IViewWizardGroupModel iViewWizardGroupModel,String strQuery) throws Exception;

	
	/**
	 * 设置System插件，继承原功能
	 * @param iSystemPlugin
	 * @throws Exception
	 */
	void setSystemPlugin(ISystemPlugin iSystemPlugin) throws Exception;
	
	
	/**
	 * 设置System插件，
	 * @param iSystemPlugin
	 * @param bResetOrigin 是否重置原插件功能 
	 * @throws Exception
	 */
	void setSystemPlugin(ISystemPlugin iSystemPlugin,boolean bIgnoreOrigin) throws Exception;
	
	
	
	/**
	 * 获取System插件
	 * @return
	 */
	ISystemPlugin getSystemPlugin();
	
	

	/**
	 * 建立实体操作向导模型
	 * @param nMode 模式
	 * @param strUserTag 用户标记
	 * @return
	 * @throws Exception
	 */
	IDEActionWizardModel createDEActionWizardModel(int nMode,String strUserTag)throws Exception;
	
	
	
	/**
	 * 建立视图消息模型
	 * @param nMode 模式
	 * @param strUserTag 用户标记
	 * @return
	 * @throws Exception
	 */
	IViewMsgModel createViewMsgModel(int nMode,String strUserTag)throws Exception;
	
	
	
	/**
	 * 注册统一状态协同对象模型
	 * @param iUniStateModel
	 * @throws Exception
	 */
	void registerUniStateModel(IUniStateModel iUniStateModel) throws Exception ;

	/**
	 * 获取统一状态协同对象模型
	 * @param strUniStateModelId
	 * @return
	 * @throws Exception
	 */
	IUniStateModel getUniStateModel(String strUniStateModelId) throws Exception ;
	

	/**
	 * 建立统一状态协同对象模型
	 * @param strType 对象类型
	 * @param strUserTag
	 * @return
	 * @throws Exception
	 */
	IUniStateModel createUniStateModel(String strType,String strUserTag)throws Exception;
	
	 /**
	  * 获取统一状态管理器
	 * @return
	 */
	IUniStateManager getUniStateManager();
	
	
	

	/**
	 * 填充视图消息的当前数据
	 * @param iViewMsgModel
	 * @param iViewController
	 * @param iEntity
	 * @throws Exception
	 */
	void fillViewMsgActiveData(IEntity iEntity,IViewMsgModel iViewMsgModel,IViewController iViewController)throws Exception;
	
	
	
	/**
	 * 建立属性输入提示集合模型
	 * @param strUserTag 用户标记
	 * @return
	 * @throws Exception
	 */
	IDEFInputTipSetModel createDEFInputTipSetModel(String strUserTag)throws Exception;
	
	
	
	/**
	 * 注册系统属性输入提示集合
	 * 
	 * @param iDEFInputTipSetModel
	 * @throws Exception
	 */
	void registerDEFInputTipSetModel(IDEFInputTipSetModel iDEFInputTipSetModel) throws Exception;

	/**
	 * 获取系统属性输入提示集合
	 * 
	 * @param strDEFInputTipSetId
	 * @return
	 * @throws Exception
	 */
	IDEFInputTipSetModel getDEFInputTipSetModel(String strDEFInputTipSetId) throws Exception;
	
	
	
	/**
	 * 获取指定数据库函数对象
	 * @param iDBDialect
	 * @param strFuncName
	 * @return
	 * @throws Exception
	 */
	IDBFunction getDBFunction(IDBDialect iDBDialect, String strFuncName) throws Exception;
	
	
	
	/**
	 * 注册系统值规则对象模型
	 * @param iSystemValueRuleModel
	 * @throws Exception
	 */
	void registerSystemValueRuleModel(ISystemValueRuleModel iSystemValueRuleModel) throws Exception ;

	/**
	 * 获取系统值规则对象模型
	 * @param strSystemValueRuleModelId
	 * @return
	 * @throws Exception
	 */
	ISystemValueRuleModel getSystemValueRuleModel(String strSystemValueRuleModelId) throws Exception ;
	
	
	
	/**
	 * 注册系统逻辑对象模型
	 * @param iSystemLogicModel
	 * @throws Exception
	 */
	void registerSystemLogicModel(ISystemLogicModel iSystemLogicModel) throws Exception ;

	/**
	 * 获取系统逻辑对象模型
	 * @param strSystemLogicModelId
	 * @return
	 * @throws Exception
	 */
	ISystemLogicModel getSystemLogicModel(String strSystemLogicModelId) throws Exception ;
	
	
	
	
	/**
	 * 获取实体是否启用无视图模式
	 * @param iDataEntityModel
	 * @return
	 */
	boolean isNoViewMode(IDataEntityModel iDataEntityModel);
	
	
	
	/**
	 * 获取实体操作标识所针对的目标
	 * @param strDEOPPriv
	 * @return
	 */
	String getDEOPPrivTarget(String strDEOPPriv);
	
	
	

	/**
	 * 注册分布事务队列协同对象模型
	 * @param iDTSQueueModel
	 * @throws Exception
	 */
	void registerDTSQueueModel(IDTSQueueModel iDTSQueueModel) throws Exception ;

	/**
	 * 获取分布事务队列协同对象模型
	 * @param strDTSQueueModelId
	 * @return
	 * @throws Exception
	 */
	IDTSQueueModel getDTSQueueModel(String strDTSQueueModelId) throws Exception ;
	

	/**
	 * 建立分布事务队列协同对象模型
	 * @param strType 对象类型
	 * @param strUserTag
	 * @return
	 * @throws Exception
	 */
	IDTSQueueModel createDTSQueueModel(String strType,String strUserTag)throws Exception;
	
	
	
	
	/**
	 * 注册服务接口客户端模型
	 * @param iServiceAPIClientModel
	 * @throws Exception
	 */
	void registerServiceAPIClientModel(IServiceAPIClientModel iServiceAPIClientModel) throws Exception ;

	/**
	 * 获取服务接口客户端模型
	 * @param strServiceAPIClientModelId
	 * @return
	 * @throws Exception
	 */
	IServiceAPIClientModel getServiceAPIClientModel(String strServiceAPIClientModelId) throws Exception ;
	
	
	
	/**
	 * 获取服务接口路径
	 * @param iServiceAPIClientModel
	 * @param iServiceAPIAction
	 * @param objParam
	 * @return
	 * @throws Exception
	 */
	String getServicePath(IServiceAPIClientModel iServiceAPIClientModel,IServiceAPIAction iServiceAPIAction,Object objParam) throws Exception ;

	
	/**
	 * 建立系统用户角色模型
	 * @param strType 对象类型
	 * @param strRoleTag
	 * @return
	 * @throws Exception
	 */
	ISystemUserRoleModel createSystemUserRoleModel(String strType,String strRoleTag)throws Exception;
	
	
	/**
	 * 注册系统用户角色对象模型
	 * @param iSystemUserRoleModel
	 * @throws Exception
	 */
	void registerSystemUserRoleModel(ISystemUserRoleModel iSystemUserRoleModel) throws Exception ;

	/**
	 * 获取系统用户角色对象模型
	 * @param strSystemUserRoleModelId
	 * @return
	 * @throws Exception
	 */
	ISystemUserRoleModel getSystemUserRoleModel(String strSystemUserRoleModelId) throws Exception ;
	
	
	/**
	 * 获取动态系统设置
	 * @return
	 */
	IDynaSystemSetting getDynaSystemSetting();
	
	
	
	
	/**
	 * 获取系统设置对象
	 * @return
	 */
	ISystemSetting getSystemSetting();
	
	
	/**
	 *  安装系统的数据库模型
	 * @param strVersion
	 * @param bIgnoreCheck
	 * @throws Exception
	 */
	void installDBModel(String strVersion,boolean bIgnoreCheck) throws Exception;
	
	
	
	
	/**
	 * 注册系统全局实体界面行为对象模型
	 * @param iDEUIActionModel
	 * @throws Exception
	 */
	void registerDEUIActionModel(IDEUIActionModel iDEUIActionModel) throws Exception;
	
	
	
	
	/**
	 * 获取系统全局实体界面行为对象模型
	 * @param strDEUIActionId
	 * @param bTryMode
	 * @return
	 * @throws Exception
	 */
	IDEUIActionModel getDEUIActionModel(String strDEUIActionId,boolean bTryMode)throws Exception;
	
	
	
	
	/**
	 * 导出实体的数据对象Json对象
	 * @param iDataEntityModel
	 * @param et
	 * @param bIncludeEmpty
	 * @param nOption 导出模式
	 * @return
	 * @throws Exception
	 */
	JSONObject toJSONObject(IDataEntityModel iDataEntityModel, IEntity iEntity, boolean bIncludeEmpty,int nOption) throws Exception;
	
	
	
	
	/**
	 * 登记系统异常
	 * @param logger
	 * @param throwable
	 * @param strMessage 额外异常消息
	 * @param objUserData 用户标记数据
	 */
	void logException(Object logger,Throwable throwable,String strMessage,Object objUserData);
	
	
	
	
	/**
	 * 注册系统辅助功能
	 * @param iSystemUtil
	 * @throws Exception
	 */
	void registerSystemUtil(ISystemUtil iSystemUtil)throws Exception;
	
	
	
	/**
	 * 获取系统辅助功能
	 * @param strUtilType
	 * @param bTry
	 * @return
	 * @throws Exception
	 */
	ISystemUtil getSystemUtil(String strUtilType,boolean bTry)throws Exception;
	
	
	
	
	
	/**
	 * 获取实体模型集合
	 * @return
	 */
	java.util.Iterator<IDataEntityModel> getDataEntityModels();
	
	
	
}
