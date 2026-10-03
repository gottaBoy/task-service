package net.ibizsys.paas.sysmodel;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.ibizsys.paas.api.IServiceAPIAction;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.cache.DEUniStateModel;
import net.ibizsys.paas.cache.IUniState;
import net.ibizsys.paas.cache.IUniStateManager;
import net.ibizsys.paas.cache.IUniStateModel;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DER;
import net.ibizsys.paas.core.DERs;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.IPostConstructable;
import net.ibizsys.paas.core.ISystemSetting;
import net.ibizsys.paas.core.IValueTranslator;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.core.Plugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.core.PluginList;
import net.ibizsys.paas.core.ValueTranslatorGlobal;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.IDBFunction;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.demodel.DEActionWizardModel;
import net.ibizsys.paas.demodel.DEDataSetDEAWModel;
import net.ibizsys.paas.demodel.DEFInputTipSetModel;
import net.ibizsys.paas.demodel.DEFInputTipSetModelGlobal;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.DER11Model;
import net.ibizsys.paas.demodel.DER1NModel;
import net.ibizsys.paas.demodel.DERIndexModel;
import net.ibizsys.paas.demodel.DERInheritModel;
import net.ibizsys.paas.demodel.DERMultiInheritModel;
import net.ibizsys.paas.demodel.IDEActionWizardModel;
import net.ibizsys.paas.demodel.IDEFInputTipSetModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.dts.DTSQueueModel;
import net.ibizsys.paas.dts.IDTSQueueModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.util.IAppCustomizeUtil;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.DEDataSetViewMsgModel;
import net.ibizsys.paas.view.IViewMessage;
import net.ibizsys.paas.view.IViewMsgGroupModel;
import net.ibizsys.paas.view.IViewMsgGroupPlugin;
import net.ibizsys.paas.view.IViewMsgModel;
import net.ibizsys.paas.view.IViewWizard;
import net.ibizsys.paas.view.IViewWizardGroupModel;
import net.ibizsys.paas.view.StaticViewMsgModel;
import net.ibizsys.paas.view.ViewMsgGroupModelGlobal;
import net.ibizsys.paas.view.ViewMsgModelGlobal;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psba.core.BASchemeModelGlobal;
import net.ibizsys.psba.core.IBASchemeModel;
import net.ibizsys.psba.core.IBASchemeRuntime;
import net.ibizsys.psrt.srv.wf.entity.WFDynamicUser;
import net.ibizsys.psrt.srv.wf.entity.WFUserGroup;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFDynamicUserService;
import net.ibizsys.psrt.srv.wf.service.WFUserGroupService;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.ibizsys.pswf.core.IWFModel;
import net.ibizsys.pswf.core.IWFRoleModel;
import net.ibizsys.pswf.core.WFModelGlobal;
import net.sf.json.JSONObject;

/**
 * 系统模型基类
 * 
 * @author lionlau
 * 
 */
public abstract class SystemModelBase extends ModelBase3Impl implements ISystemModel, ISystemRuntime, org.springframework.web.context.ServletContextAware {
	



	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(SystemModelBase.class);
	
	/**
	 * 关系模型
	 */
	private HashMap<String, IDERBase> derBaseMap = new HashMap<String, IDERBase>();

	/**
	 * 实体映射
	 */
	private HashMap<String, IDataEntityModel> dataEntityModelMap = new HashMap<String, IDataEntityModel>();
	
	/**
	 * 实体映射2（只映射ID）
	 */
	private HashMap<String, IDataEntityModel> dataEntityModelMap2 = new HashMap<String, IDataEntityModel>();

	/**
	 * 流程模型映射
	 */
	private HashMap<String, IWFModel> wfModelMap = new HashMap<String, IWFModel>();

	/**
	 * 流程角色映射
	 */
	private HashMap<String, IWFRoleModel> wfRoleModelMap = new HashMap<String, IWFRoleModel>();

	/**
	 * 实体主关系列表映射
	 */
	private HashMap<String, ArrayList<IDERBase>> deMajorDERsMap = new HashMap<String, ArrayList<IDERBase>>();

	/**
	 * 实体从关系列表映射
	 */
	private HashMap<String, ArrayList<IDERBase>> deMinorDERsMap = new HashMap<String, ArrayList<IDERBase>>();

	/**
	 * 大数据架构模型映射
	 */
	private HashMap<String, IBASchemeModel> baSchemeModelMap = new HashMap<String, IBASchemeModel>();

	/**
	 * 系统属性输入提示集合模型映射
	 */
	private HashMap<String, IDEFInputTipSetModel> defInputTipSetModelMap = new HashMap<String, IDEFInputTipSetModel>();
	
	
	/**
	 * 系统视图消息组模型映射
	 */
	private HashMap<String, IViewMsgGroupModel> viewMsgGroupModelMap = new HashMap<String, IViewMsgGroupModel>();

	/**
	 * 系统视图消息模型映射
	 */
	private HashMap<String, IViewMsgModel> viewMsgModelMap = new HashMap<String, IViewMsgModel>();

	/**
	 * 系统统一状态协调对象模型映射
	 */
	private HashMap<String, IUniStateModel> uniStateModelMap = new HashMap<String, IUniStateModel>();
	
	/**
	 * 系统值规则对象模型映射
	 */
	private HashMap<String, ISystemValueRuleModel> sysValueRuleModelMap = new HashMap<String, ISystemValueRuleModel>();
	
	
	/**
	 * 系统逻辑模型映射
	 */
	private HashMap<String, ISystemLogicModel> systemLogicModelMap = new HashMap<String, ISystemLogicModel>();
	
	
	/**
	 * 系统分布事务队列对象模型映射
	 */
	private HashMap<String, IDTSQueueModel> dstQueueModelMap = new HashMap<String, IDTSQueueModel>();
	

	/**
	 * 系统服务接口客户端对象模型映射
	 */
	private HashMap<String, IServiceAPIClientModel> serviceAPIClientModelMap = new HashMap<String, IServiceAPIClientModel>();
	
	
	/**
	 * 系统用户角色对象模型映射
	 */
	private HashMap<String, ISystemUserRoleModel> sysUserRoleModelMap = new HashMap<String, ISystemUserRoleModel>();
	
	/**
	 * 系统实体界面行为模型映射
	 */
	private HashMap<String, IDEUIActionModel> deUIActionModelMap = new HashMap<String, IDEUIActionModel>();
	
	/**
	 * Web程序上下文
	 */
	private ServletContext servletContext = null;

	private static HashMap<String, String> replaceObjectMap = null;

	private ISystemPlugin iSystemPlugin = null;

	private IViewMsgGroupPlugin iViewMsgGroupPlugin = null;

	private SystemViewMsgGroupPlugin nullSystemViewMsgGroupPlugin = new SystemViewMsgGroupPlugin();
	
	private IServiceAPIClientModel iServiceAPIClientModel = null;

	private IDynaSystemSetting iDynaSystemSetting = null;
	
	protected SystemSettingModel systemSettingModel = new SystemSettingModel();
	
	private HashMap<String, ISystemPartModel> systemPartModelMap = new HashMap<String, ISystemPartModel>();
	
	private HashMap<String, ISystemUtil> systemUtilMap = new HashMap<String, ISystemUtil>();
	
	private static String strModuleIId = null;
	
	/**
	 * 初始化注解
	 * 
	 * @param c
	 * @throws Exception
	 */
	protected void initAnnotation(Class c) {
		Annotation[] annotations = c.getAnnotations();
		if (annotations != null) {
			for (Annotation annotation : annotations) {
				if (annotation instanceof DERs) {
					prepareDERs((DERs) annotation);
					continue;
				}
			}
		}
	}

	/**
	 * 准备实体关系
	 * 
	 * @param ders
	 */
	protected void prepareDERs(DERs ders) {
		for (DER der : ders.value()) {
			IDERBase iDERBase = createDERBase(der);
			derBaseMap.put(iDERBase.getId(), iDERBase);
			derBaseMap.put(iDERBase.getName(), iDERBase);

			String strMajorDEId = iDERBase.getMajorDEId();
			String strMinorDEId = iDERBase.getMinorDEId();

			ArrayList<IDERBase> majorDERList = deMajorDERsMap.get(strMajorDEId);
			if (majorDERList == null) {
				majorDERList = new ArrayList<IDERBase>();
				deMajorDERsMap.put(strMajorDEId, majorDERList);
			}
			majorDERList.add(iDERBase);
			ArrayList<IDERBase> minorDERList = deMinorDERsMap.get(strMinorDEId);
			if (minorDERList == null) {
				minorDERList = new ArrayList<IDERBase>();
				deMinorDERsMap.put(strMinorDEId, minorDERList);
			}
			minorDERList.add(iDERBase);
		}
	}

	/**
	 * 建立实体关系模型对象
	 * 
	 * @param der
	 * @return
	 */
	protected IDERBase createDERBase(DER der) {

		if (StringHelper.compare(der.type(), IDERBase.DERTYPE_DER1N, true) == 0) {
			DER1NModel der1nModel = new DER1NModel();
			der1nModel.init(this, der);
			return der1nModel;
		}

		if (StringHelper.compare(der.type(), IDERBase.DERTYPE_DER11, true) == 0) {
			DER11Model der11Model = new DER11Model();
			der11Model.init(this, der);
			return der11Model;
		}

		if (StringHelper.compare(der.type(), IDERBase.DERTYPE_DERINHERIT, true) == 0) {
			DERInheritModel derInheritModel = new DERInheritModel();
			derInheritModel.init(this, der);
			return derInheritModel;
		}

		if (StringHelper.compare(der.type(), IDERBase.DERTYPE_DERINDEX, true) == 0) {
			DERIndexModel derIndexModel = new DERIndexModel();
			derIndexModel.init(this, der);
			return derIndexModel;
		}

		if (StringHelper.compare(der.type(), IDERBase.DERTYPE_DERMULINH, true) == 0) {
			DERMultiInheritModel derMultiInheritModel = new DERMultiInheritModel();
			derMultiInheritModel.init(this, der);
			return derMultiInheritModel;
		}

		return null;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getDataEntityModel(java.lang.String, boolean)
	 */
	@Override
	public IDataEntityModel getDataEntityModel(String strDEName,boolean bIncludeOtherSys) throws Exception {
		IDataEntityModel iDataEntityModel = dataEntityModelMap.get(strDEName);
		if (iDataEntityModel == null){
			if(bIncludeOtherSys)
				return DEModelGlobal.getDEModel(strDEName);
			throw new Exception(StringHelper.format("无法获取指定实体[%1$s]", strDEName));
		}
		return iDataEntityModel;
	}
	
	
	public boolean containsDataEntityModel(String strDEName,boolean bIncludeOtherSys) {
		IDataEntityModel iDataEntityModel = dataEntityModelMap.get(strDEName);
		if (iDataEntityModel == null){
			if(bIncludeOtherSys)
				return DEModelGlobal.containsDEModel(strDEName);
		}
		return iDataEntityModel!=null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getDataEntityModel(java.lang.String)
	 */
	@Override
	public IDataEntityModel getDataEntityModel(String strDEName) throws Exception {
		return getDataEntityModel(strDEName,true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.ISystem#getDataEntity(java.lang.String)
	 */
	@Override
	public IDataEntity getDataEntity(String strDataEntityId) throws Exception {
		return getDataEntityModel(strDataEntityId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.ISystem#getDER(java.lang.String)
	 */
	@Override
	public IDERBase getDER(String strDERId) throws Exception {
		IDERBase iDERBase = derBaseMap.get(strDERId);
		if (iDERBase == null) throw new Exception(StringHelper.format("无法获取指定关系[%1$s]", strDERId));
		return iDERBase;
	}

	
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getDER(java.lang.String, boolean)
	 */
	@Override
	public IDERBase getDER(String strDERId, boolean bTryMode) throws Exception {
		IDERBase iDERBase = derBaseMap.get(strDERId);
		if (iDERBase == null && !bTryMode){
			throw new Exception(StringHelper.format("无法获取指定关系[%1$s]", strDERId));
		}
		return iDERBase;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.ISystem#getCodeList(java.lang.String)
	 */
	@Override
	public ICodeList getCodeList(String strCodeListId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired(required = false)
	@Qualifier("dbDialect")
	private IDBDialect dbDialect;

	/**
	 * 设置数据库代码适配器
	 * 
	 * @param dbDialect
	 */
	public void setDBDialect(IDBDialect dbDialect) {
		this.dbDialect = dbDialect;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect()
	 */
	@Override
	public IDBDialect getDBDialect() {
		return dbDialect;
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * 设置会话工厂
	 * 
	 * @param sessionFactory
	 */

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getWFModel(java.lang.String)
	 */
	@Override
	public IWFModel getWFModel(String strWFModelId) throws Exception {
		return getWFModel(strWFModelId,false);
	}
	
	@Override
	public IWFModel getWFModel(String strWFModelId, boolean bTryMode) throws Exception {
		IWFModel iWFModel = wfModelMap.get(strWFModelId);
		if (iWFModel == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定流程，流程标识[%1$s]", strWFModelId));
		}
		return iWFModel;
	}

	
	

	/**
	 * 获取工作流模型集合
	 * 
	 * @return
	 */
	protected java.util.Iterator<IWFModel> getWFModels() {
		return wfModelMap.values().iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getWFRoleModel(java.lang.String)
	 */
	@Override
	public IWFRoleModel getWFRoleModel(String strWFRoleModelId) throws Exception {
		return getWFRoleModel(strWFRoleModelId,false);
	}
	
	
	@Override
	public IWFRoleModel getWFRoleModel(String strWFRoleModelId, boolean bTryMode) throws Exception {
		IWFRoleModel iWFRoleModel = wfRoleModelMap.get(strWFRoleModelId);
		if (iWFRoleModel == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定流程角色，角色标识[%1$s]", strWFRoleModelId));
		}
		return iWFRoleModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerDataEntityModel(net.ibizsys.paas.demodel.IDataEntityModel)
	 */
	@Override
	public void registerDataEntityModel(IDataEntityModel iDataEntityModel) throws Exception {
		String strId = iDataEntityModel.getId();
		String strName = iDataEntityModel.getName();

		// if (dataEntityModelMap.containsKey(strId))
		// {
		// throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的实体模型", strId));
		// }
		//
		// if (dataEntityModelMap.containsKey(strName))
		// {
		// throw new Exception(StringHelper.format("系统中已经注册了名称为[%1$s]的实体模型", strName));
		// }

		dataEntityModelMap.put(strId, iDataEntityModel);
		dataEntityModelMap.put(strName, iDataEntityModel);
		
		dataEntityModelMap2.put(strId, iDataEntityModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerWFModel(net.ibizsys.pswf.core.IWFModel)
	 */
	@Override
	public void registerWFModel(IWFModel iWFModel) throws Exception {
		String strId = iWFModel.getId();

		if (wfModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的流程模型", strId));
		}
		wfModelMap.put(strId, iWFModel);
		WFModelGlobal.registerWFModel(iWFModel.getClass().getCanonicalName(), iWFModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerWFRoleModel(net.ibizsys.pswf.core.IWFRoleModel)
	 */
	public void registerWFRoleModel(IWFRoleModel iWFRoleModel) throws Exception {
		String strId = iWFRoleModel.getId();

		if (wfRoleModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的流程角色模型", strId));
		}
		wfRoleModelMap.put(strId, iWFRoleModel);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerBASchemeModel(net.ibizsys.psbaScheme.core.IBASchemeModel)
	 */
	@Override
	public void registerBASchemeModel(IBASchemeModel iBASchemeModel) throws Exception {
		String strId = iBASchemeModel.getId();

		if (baSchemeModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的大数据架构模型", strId));
		}
		baSchemeModelMap.put(strId, iBASchemeModel);
		BASchemeModelGlobal.registerBASchemeModel(iBASchemeModel.getClass().getCanonicalName(), iBASchemeModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getBASchemeModel(java.lang.String)
	 */
	@Override
	public IBASchemeModel getBASchemeModel(String strBASchemeModelId) throws Exception {
		IBASchemeModel iBASchemeModel = baSchemeModelMap.get(strBASchemeModelId);
		if (iBASchemeModel == null) {
			throw new Exception(StringHelper.format("无法获取指定大数据架构模型，大数据架构模型标识[%1$s]", strBASchemeModelId));
		}
		return iBASchemeModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#createDEFInputTipSetModel(java.lang.String)
	 */
	@Override
	public IDEFInputTipSetModel createDEFInputTipSetModel( String strUserTag) throws Exception {
		return new DEFInputTipSetModel();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerDEFInputTipSetModel(net.ibizsys.psbaScheme.core.IDEFInputTipSetModel)
	 */
	@Override
	public void registerDEFInputTipSetModel(IDEFInputTipSetModel iDEFInputTipSetModel) throws Exception {
		String strId = iDEFInputTipSetModel.getId();

		if (defInputTipSetModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的属性输入提示集合模型", strId));
		}
		defInputTipSetModelMap.put(strId, iDEFInputTipSetModel);
		DEFInputTipSetModelGlobal.registerDEFInputTipSet(iDEFInputTipSetModel.getClass().getCanonicalName(), iDEFInputTipSetModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getDEFInputTipSetModel(java.lang.String)
	 */
	@Override
	public IDEFInputTipSetModel getDEFInputTipSetModel(String strDEFInputTipSetModelId) throws Exception {
		IDEFInputTipSetModel iDEFInputTipSetModel = defInputTipSetModelMap.get(strDEFInputTipSetModelId);
		if (iDEFInputTipSetModel == null) {
			throw new Exception(StringHelper.format("无法获取指定属性输入提示集合模型，属性输入提示集合标识模型[%1$s]", strDEFInputTipSetModelId));
		}
		return iDEFInputTipSetModel;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerViewMsgGroupModel(net.ibizsys.psbaScheme.core.IViewMsgGroupModel)
	 */
	@Override
	public void registerViewMsgGroupModel(IViewMsgGroupModel iViewMsgGroupModel) throws Exception {
		String strId = iViewMsgGroupModel.getId();

		if (viewMsgGroupModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的视图消息组模型", strId));
		}
		viewMsgGroupModelMap.put(strId, iViewMsgGroupModel);
		ViewMsgGroupModelGlobal.registerViewMsgGroup(iViewMsgGroupModel.getClass().getCanonicalName(), iViewMsgGroupModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getViewMsgGroupModel(java.lang.String)
	 */
	@Override
	public IViewMsgGroupModel getViewMsgGroupModel(String strViewMsgGroupModelId) throws Exception {
		IViewMsgGroupModel iViewMsgGroupModel = viewMsgGroupModelMap.get(strViewMsgGroupModelId);
		if (iViewMsgGroupModel == null) {
			throw new Exception(StringHelper.format("无法获取指定视图消息组模型，视图消息组模型标识[%1$s]", strViewMsgGroupModelId));
		}
		return iViewMsgGroupModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerViewMsgModel(net.ibizsys.psbaScheme.core.IViewMsgModel)
	 */
	@Override
	public void registerViewMsgModel(IViewMsgModel iViewMsgModel) throws Exception {
		String strId = iViewMsgModel.getId();

		if (viewMsgModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的视图消息模型", strId));
		}
		viewMsgModelMap.put(strId, iViewMsgModel);
		ViewMsgModelGlobal.registerViewMsg(iViewMsgModel.getClass().getCanonicalName(), iViewMsgModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getViewMsgModel(java.lang.String)
	 */
	@Override
	public IViewMsgModel getViewMsgModel(String strViewMsgModelId) throws Exception {
		IViewMsgModel iViewMsgModel = viewMsgModelMap.get(strViewMsgModelId);
		if (iViewMsgModel == null) {
			throw new Exception(StringHelper.format("无法获取指定视图消息模型，视图消息模型标识[%1$s]", strViewMsgModelId));
		}
		return iViewMsgModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerUniStateModel(net.ibizsys.psbaScheme.core.IUniStateModel)
	 */
	@Override
	public void registerUniStateModel(IUniStateModel iUniStateModel) throws Exception {
		String strId = iUniStateModel.getId();

		if (uniStateModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的统一状态协同对象", strId));
		}
		
		if (uniStateModelMap.containsKey(iUniStateModel.getUniqueTag())) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的统一状态协同对象", iUniStateModel.getUniqueTag()));
		}
		
		uniStateModelMap.put(strId, iUniStateModel);
		uniStateModelMap.put(iUniStateModel.getUniqueTag(), iUniStateModel);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getUniStateModel(java.lang.String)
	 */
	@Override
	public IUniStateModel getUniStateModel(String strUniStateModelId) throws Exception {
		IUniStateModel iUniStateModel = uniStateModelMap.get(strUniStateModelId);
		if (iUniStateModel == null) {
			throw new Exception(StringHelper.format("无法获取指定统一状态协同对象，统一状态协同对象标识[%1$s]", strUniStateModelId));
		}
		return iUniStateModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#createUniStateModel(java.lang.String, java.lang.String)
	 */
	@Override
	public IUniStateModel createUniStateModel(String strType,String strUserTag) throws Exception {
		if(StringHelper.compare(strType, IUniState.UNISTATETYPE_DE, true)==0){
			return new DEUniStateModel();
		}
		return null;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerDTSQueueModel(net.ibizsys.psbaScheme.core.IDTSQueueModel)
	 */
	@Override
	public void registerDTSQueueModel(IDTSQueueModel iDTSQueueModel) throws Exception {
		String strId = iDTSQueueModel.getId();

		if (dstQueueModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的分布事务队列协同对象", strId));
		}
		
		dstQueueModelMap.put(strId, iDTSQueueModel);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getDTSQueueModel(java.lang.String)
	 */
	@Override
	public IDTSQueueModel getDTSQueueModel(String strDTSQueueModelId) throws Exception {
		IDTSQueueModel iDTSQueueModel = dstQueueModelMap.get(strDTSQueueModelId);
		if (iDTSQueueModel == null) {
			throw new Exception(StringHelper.format("无法获取指定分布事务队列协同对象，分布事务队列协同对象标识[%1$s]", strDTSQueueModelId));
		}
		return iDTSQueueModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#createDTSQueueModel(java.lang.String, java.lang.String)
	 */
	@Override
	public IDTSQueueModel createDTSQueueModel(String strType,String strUserTag) throws Exception {
		return new DTSQueueModel();	
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerSystemValueRuleModel(net.ibizsys.paas.sysmodel.ISystemValueRuleModel)
	 */
	@Override
	public void registerSystemValueRuleModel(ISystemValueRuleModel iSystemValueRuleModel) throws Exception {
		String strId = iSystemValueRuleModel.getId();

		if (sysValueRuleModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的值规则对象", strId));
		}
		
		if(!StringHelper.isNullOrEmpty(iSystemValueRuleModel.getUniqueTag())){
			if (sysValueRuleModelMap.containsKey(iSystemValueRuleModel.getUniqueTag())) {
				throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的值规则对象", iSystemValueRuleModel.getUniqueTag()));
			}
		}
		
		sysValueRuleModelMap.put(strId, iSystemValueRuleModel);
	
		if(!StringHelper.isNullOrEmpty(iSystemValueRuleModel.getUniqueTag())){
			sysValueRuleModelMap.put(iSystemValueRuleModel.getUniqueTag(), iSystemValueRuleModel);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getValueRuleModel(java.lang.String)
	 */
	@Override
	public ISystemValueRuleModel getSystemValueRuleModel(String strValueRuleModelId) throws Exception {
		ISystemValueRuleModel iSystemValueRuleModel = this.sysValueRuleModelMap.get(strValueRuleModelId);
		if (iSystemValueRuleModel == null) {
			throw new Exception(StringHelper.format("无法获取指定系统值规则对象，值规则对象标识[%1$s]", strValueRuleModelId));
		}
		return iSystemValueRuleModel;
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerSystemLogicModel(net.ibizsys.psbaScheme.core.ISystemLogicModel)
	 */
	@Override
	public void registerSystemLogicModel(ISystemLogicModel iSystemLogicModel) throws Exception {
		String strId = iSystemLogicModel.getId();

		if (systemLogicModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的系统逻辑对象", strId));
		}
		
		if(!StringHelper.isNullOrEmpty(iSystemLogicModel.getUniqueTag())){
			if (systemLogicModelMap.containsKey(iSystemLogicModel.getUniqueTag())) {
				throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的系统逻辑对象", iSystemLogicModel.getUniqueTag()));
			}
		}
		
		systemLogicModelMap.put(strId, iSystemLogicModel);
	
		if(!StringHelper.isNullOrEmpty(iSystemLogicModel.getUniqueTag())){
			systemLogicModelMap.put(iSystemLogicModel.getUniqueTag(), iSystemLogicModel);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getSystemLogicModel(java.lang.String)
	 */
	@Override
	public ISystemLogicModel getSystemLogicModel(String strSystemLogicModelId) throws Exception {
		ISystemLogicModel iSystemLogicModel = this.systemLogicModelMap.get(strSystemLogicModelId);
		if (iSystemLogicModel == null) {
			throw new Exception(StringHelper.format("无法获取指定系统逻辑对象，系统逻辑标识[%1$s]", strSystemLogicModelId));
		}
		return iSystemLogicModel;
	}
	
	
	/**
	 * 设置标识
	 * 
	 * @param strId the strId to set
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName the strName to set
	 */
	protected void setName(String strName) {
		this.strName = strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getWFRoleModes()
	 */
	@Override
	public Iterator<IWFRoleModel> getWFRoleModels() {
		return wfRoleModelMap.values().iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect(java.lang.String)
	 */
	@Override
	public IDBDialect getDBDialect(String strDSLink) {
		if (StringHelper.isNullOrEmpty(strDSLink) || StringHelper.compare(strDSLink, IDataEntity.DSLINK_DEFAULT, true) == 0) {
			return this.getDBDialect();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB2, true) == 0) {
			return this.getDBDialect2();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB3, true) == 0) {
			return this.getDBDialect3();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB4, true) == 0) {
			return this.getDBDialect4();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB5, true) == 0) {
			return this.getDBDialect5();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB6, true) == 0) {
			return this.getDBDialect6();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB7, true) == 0) {
			return this.getDBDialect7();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB8, true) == 0) {
			return this.getDBDialect8();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB9, true) == 0) {
			return this.getDBDialect9();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB10, true) == 0) {
			return this.getDBDialect10();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB11, true) == 0) {
			return this.getDBDialect11();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB12, true) == 0) {
			return this.getDBDialect12();
		}

		return this.getDBDialect();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory(java.lang. String)
	 */
	@Override
	public SessionFactory getSessionFactory(String strDSLink) {
		if (StringHelper.isNullOrEmpty(strDSLink) || StringHelper.compare(strDSLink, IDataEntity.DSLINK_DEFAULT, true) == 0) {
			return this.getSessionFactory();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB2, true) == 0) {
			return this.getSessionFactory2();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB3, true) == 0) {
			return this.getSessionFactory3();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB4, true) == 0) {
			return this.getSessionFactory4();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB5, true) == 0) {
			return this.getSessionFactory5();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB6, true) == 0) {
			return this.getSessionFactory6();
		}
		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB7, true) == 0) {
			return this.getSessionFactory7();
		}
		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB8, true) == 0) {
			return this.getSessionFactory8();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB9, true) == 0) {
			return this.getSessionFactory9();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB10, true) == 0) {
			return this.getSessionFactory10();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB11, true) == 0) {
			return this.getSessionFactory11();
		}

		if (StringHelper.compare(strDSLink, IDataEntity.DSLINK_DB12, true) == 0) {
			return this.getSessionFactory12();
		}

		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect2")
	private IDBDialect dbDialect2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect2()
	 */
	@Override
	public IDBDialect getDBDialect2() {
		if (dbDialect2 != null) return dbDialect2;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory2")
	private SessionFactory sessionFactory2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory2()
	 */
	@Override
	public SessionFactory getSessionFactory2() {
		if (sessionFactory2 != null) return sessionFactory2;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect3")
	private IDBDialect dbDialect3;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect3()
	 */
	@Override
	public IDBDialect getDBDialect3() {
		if (dbDialect3 != null) return dbDialect3;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory3")
	private SessionFactory sessionFactory3;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory3()
	 */
	@Override
	public SessionFactory getSessionFactory3() {
		if (sessionFactory3 != null) return sessionFactory3;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect4")
	private IDBDialect dbDialect4;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect4()
	 */
	@Override
	public IDBDialect getDBDialect4() {
		if (dbDialect4 != null) return dbDialect4;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory4")
	private SessionFactory sessionFactory4;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory4()
	 */
	@Override
	public SessionFactory getSessionFactory4() {
		if (sessionFactory4 != null) return sessionFactory4;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect5")
	private IDBDialect dbDialect5;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect5()
	 */
	@Override
	public IDBDialect getDBDialect5() {
		if (dbDialect5 != null) return dbDialect5;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory5")
	private SessionFactory sessionFactory5;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory5()
	 */
	@Override
	public SessionFactory getSessionFactory5() {
		if (sessionFactory5 != null) return sessionFactory5;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect6")
	private IDBDialect dbDialect6;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect6()
	 */
	@Override
	public IDBDialect getDBDialect6() {
		if (dbDialect6 != null) return dbDialect6;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory6")
	private SessionFactory sessionFactory6;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory6()
	 */
	@Override
	public SessionFactory getSessionFactory6() {
		if (sessionFactory6 != null) return sessionFactory6;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect7")
	private IDBDialect dbDialect7;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect7()
	 */
	@Override
	public IDBDialect getDBDialect7() {
		if (dbDialect7 != null) return dbDialect7;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory7")
	private SessionFactory sessionFactory7;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory7()
	 */
	@Override
	public SessionFactory getSessionFactory7() {
		if (sessionFactory7 != null) return sessionFactory7;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect8")
	private IDBDialect dbDialect8;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect8()
	 */
	@Override
	public IDBDialect getDBDialect8() {
		if (dbDialect8 != null) return dbDialect8;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory8")
	private SessionFactory sessionFactory8;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory8()
	 */
	@Override
	public SessionFactory getSessionFactory8() {
		if (sessionFactory8 != null) return sessionFactory8;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect9")
	private IDBDialect dbDialect9;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect9()
	 */
	@Override
	public IDBDialect getDBDialect9() {
		if (dbDialect9 != null) return dbDialect9;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory9")
	private SessionFactory sessionFactory9;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory9()
	 */
	@Override
	public SessionFactory getSessionFactory9() {
		if (sessionFactory9 != null) return sessionFactory9;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect10")
	private IDBDialect dbDialect10;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect10()
	 */
	@Override
	public IDBDialect getDBDialect10() {
		if (dbDialect10 != null) return dbDialect10;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory10")
	private SessionFactory sessionFactory10;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory10()
	 */
	@Override
	public SessionFactory getSessionFactory10() {
		if (sessionFactory10 != null) return sessionFactory10;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect11")
	private IDBDialect dbDialect11;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect11()
	 */
	@Override
	public IDBDialect getDBDialect11() {
		if (dbDialect11 != null) return dbDialect11;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory11")
	private SessionFactory sessionFactory11;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory11()
	 */
	@Override
	public SessionFactory getSessionFactory11() {
		if (sessionFactory11 != null) return sessionFactory11;
		return this.getSessionFactory();
	}

	@Autowired(required = false)
	@Qualifier("dbDialect12")
	private IDBDialect dbDialect12;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getDBDialect12()
	 */
	@Override
	public IDBDialect getDBDialect12() {
		if (dbDialect12 != null) return dbDialect12;
		return this.getDBDialect();
	}

	@Autowired(required = false)
	@Qualifier("sessionFactory12")
	private SessionFactory sessionFactory12;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getSessionFactory12()
	 */
	@Override
	public SessionFactory getSessionFactory12() {
		if (sessionFactory12 != null) return sessionFactory12;
		return this.getSessionFactory();
	}

	/**
	 * 进一步构建系统模型
	 * 
	 * @throws Exception
	 */
	public void postConstruct() throws Exception {
		if (this.dbDialect != null && this.sessionFactory != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory, this.dbDialect);
		}
		if (this.dbDialect2 != null && this.sessionFactory2 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory2, this.dbDialect2);
		}
		if (this.dbDialect3 != null && this.sessionFactory3 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory3, this.dbDialect3);
		}
		if (this.dbDialect4 != null && this.sessionFactory4 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory4, this.dbDialect4);
		}
		if (this.dbDialect5 != null && this.sessionFactory5 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory5, this.dbDialect5);
		}
		if (this.dbDialect6 != null && this.sessionFactory6 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory6, this.dbDialect6);
		}
		if (this.dbDialect7 != null && this.sessionFactory7 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory7, this.dbDialect7);
		}
		if (this.dbDialect8 != null && this.sessionFactory8 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory8, this.dbDialect8);
		}
		if (this.dbDialect9 != null && this.sessionFactory9 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory9, this.dbDialect9);
		}
		if (this.dbDialect10 != null && this.sessionFactory10 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory10, this.dbDialect10);
		}
		if (this.dbDialect11 != null && this.sessionFactory11 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory11, this.dbDialect11);
		}
		if (this.dbDialect12 != null && this.sessionFactory12 != null) {
			DAOGlobal.registerDBDialect(this.sessionFactory12, this.dbDialect12);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#installRTDatas()
	 */
	@Override
	public void installRTDatas() throws Exception {
		installBASchemes();
		installWFRTDatas();
		installAppCustomizedDatas();
		onInstallRTDatas();
		//安装应用配置数据
	}

	/**
	 * 安装运行时数据触发
	 * 
	 * @throws Exception
	 */
	protected void onInstallRTDatas() throws Exception {

	}
	
	/**
	 * 安装应用定制化数据
	 * @throws Exception
	 */
	protected void installAppCustomizedDatas() throws Exception {
		ISystemUtil iSystemUtil = this.getSystemUtil(IAppCustomizeUtil.UTILTYPE_APPCUSTOMIZE, true);
		if(iSystemUtil!=null) {
			((IAppCustomizeUtil)iSystemUtil).installAll();
		}
	}

	/**
	 * 安装工作流运行时数据
	 * 
	 * @throws Exception
	 */
	protected void installWFRTDatas() throws Exception {
		// 准备流程角色
		WFUserGroupService wfUserGroupService = (WFUserGroupService) ServiceGlobal.getService(WFUserGroupService.class);
		WFDynamicUserService wfDynamicUserService = (WFDynamicUserService) ServiceGlobal.getService(WFDynamicUserService.class);
		java.util.Iterator<IWFRoleModel> wfRoleModes = this.getWFRoleModels();
		if (wfRoleModes != null) {
			while (wfRoleModes.hasNext()) {
				IWFRoleModel iWFRoleModel = wfRoleModes.next();
				// 判断是否为用户组
				if (StringHelper.compare(iWFRoleModel.getWFRoleType(), IWFRoleModel.WFROLETYPE_USERGROUP, true) == 0) {
					WFUserGroup wfUserGroup = new WFUserGroup();
					wfUserGroup.setWFUserGroupId(iWFRoleModel.getId());
					wfUserGroup.setWFUserGroupName(iWFRoleModel.getName());
					wfUserGroup.set(IProcParam.TAG_PERSONID, "SYSTEM");
					wfUserGroup.set(IProcParam.TAG_LOGINNAME, "SYSTEM");
					wfUserGroup.set(IProcParam.TAG_PERSONNAME, "系统内建用户");
					wfUserGroupService.save(wfUserGroup);

					ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n", this.getName(), wfUserGroupService.getDEModel().getLogicName(), wfUserGroupService.getDEModel().getDataInfo(wfUserGroup)));
					continue;
				}

				if (StringHelper.compare(iWFRoleModel.getWFRoleType(), IWFRoleModel.WFROLETYPE_CUSTOM, true) == 0) {
					WFDynamicUser wfDynamicUser = new WFDynamicUser();
					wfDynamicUser.setWFDynamicUserId(iWFRoleModel.getId());
					wfDynamicUser.setWFDynamicUserName(iWFRoleModel.getName());
					wfDynamicUser.setUserObject("#");
					wfDynamicUser.set(IProcParam.TAG_PERSONID, "SYSTEM");
					wfDynamicUser.set(IProcParam.TAG_LOGINNAME, "SYSTEM");
					wfDynamicUser.set(IProcParam.TAG_PERSONNAME, "系统内建用户");
					wfDynamicUserService.save(wfDynamicUser);

					ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n", this.getName(), wfDynamicUserService.getDEModel().getLogicName(), wfDynamicUserService.getDEModel().getDataInfo(wfDynamicUser)));
					continue;
				}
			}
		}

		// 准备工作流
		for (IWFModel iWFModel : this.wfModelMap.values()) {
			WFWorkflowService wfWorkflowService = (WFWorkflowService) ServiceGlobal.getService(WFWorkflowService.class);
			WFWorkflow wfWorkflow = new WFWorkflow();
			wfWorkflow.setWFWorkflowId(iWFModel.getId());
			if (wfWorkflowService.checkKey(wfWorkflow) == IService.CHECKKEYSTATE_OK) {
				// 新建数据
				wfWorkflow.setWFWorkflowName(iWFModel.getName());
				wfWorkflow.setWFState(1);
				if (!StringHelper.isNullOrEmpty(iWFModel.getRemindMsgTemplId())) wfWorkflow.setRemindMsgTemplId(iWFModel.getRemindMsgTemplId());
				wfWorkflow.setWFLogicName(iWFModel.getName());
				wfWorkflow.setWFVersion(1);
				wfWorkflow.setWFModel("<?xml version=\"1.0\" encoding=\"utf-8\" ?><SRFEXWFWORKFLOW></SRFEXWFWORKFLOW>");
				wfWorkflow.set(IProcParam.TAG_PERSONID, "SYSTEM");
				wfWorkflow.set(IProcParam.TAG_LOGINNAME, "SYSTEM");
				wfWorkflow.set(IProcParam.TAG_PERSONNAME, "系统内建用户");
				wfWorkflowService.create(wfWorkflow);

				ActionSessionManager.appendActionInfo(StringHelper.format("[%1$s]安装[%2$s][%3$s]\r\n", this.getName(), wfWorkflowService.getDEModel().getLogicName(), wfWorkflowService.getDEModel().getDataInfo(wfWorkflow)));
			}
		}

	}

	/**
	 * 安装大数据架构
	 * 
	 * @throws Exception
	 */
	protected void installBASchemes() throws Exception {
		for (IBASchemeModel iBASchemeModel : baSchemeModelMap.values()) {
			try {
				if (iBASchemeModel instanceof IBASchemeRuntime) {
					((IBASchemeRuntime) iBASchemeModel).install();
				}
			} catch (Exception ex) {
				throw new Exception("安装大数据架构", ex);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getValueTranslator(java.lang.String )
	 */
	@Override
	public IValueTranslator getValueTranslator(String strTranslator) throws Exception {
		return ValueTranslatorGlobal.getValueTranslator(strTranslator);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getLocalization()
	 */
	@Override
	public String getLocalization() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getDERs(java.lang.String, boolean)
	 */
	@Override
	public java.util.Iterator<IDERBase> getDERs(String strDEId, boolean bMajor) {
		ArrayList<IDERBase> list = null;
		if (bMajor) {
			list = this.deMajorDERsMap.get(strDEId);
		} else {
			list = this.deMinorDERsMap.get(strDEId);
		}
		if (list == null) return null;
		return list.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.context.ServletContextAware#setServletContext(javax.servlet.ServletContext)
	 */
	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}



	@Override
	public IDEDataAccMgr createDEDataAccMgr(IDataEntityModel iDEModel) throws Exception {
		DEDataAccMgr iDEDataAccMgr = new DEDataAccMgr();
		iDEDataAccMgr.init(iDEModel);
		return iDEDataAccMgr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#createObject(java.lang.String)
	 */
	@Override
	public Object createObject(String strObjectType) throws Exception {
		if (replaceObjectMap != null) {
			String strNewObject = replaceObjectMap.get(strObjectType);
			if (!StringHelper.isNullOrEmpty(strNewObject)) return ObjectHelper.create(strNewObject);
		}
		return ObjectHelper.create(strObjectType);
	}

	/**
	 * 建立对象，如果对象提供 IPostConstructable 接口，则调用 postConstruct 方法。
	 * 
	 * @param strObjectType
	 * @return
	 * @throws Exception
	 */
	public Object createObject2(String strObjectType) throws Exception {

		Object object = createObject(strObjectType);
		if (object != null && object instanceof IPostConstructable) {
			((IPostConstructable) object).postConstruct();
		}
		return object;
	}

	/**
	 * 替换对象
	 * 
	 * @param strObject
	 * @param strNewObject
	 */
	public static synchronized void replaceObject(String strObject, String strNewObject) {
		if (replaceObjectMap == null) replaceObjectMap = new HashMap<String, String>();
		replaceObjectMap.put(strObject, strNewObject);
	}

	// /*
	// * (non-Javadoc)
	// * @see net.ibizsys.paas.sysmodel.ISystemModel#fillViewMessages(net.ibizsys.paas.view.IViewMsgModel, java.util.ArrayList)
	// */
	// @Override
	// public void fillViewMessages(IViewMsgModel iViewMsgModel, ArrayList<IViewMessage> viewMessageList) throws Exception {
	// iViewMsgModel.fillViewMessages(viewMessageList);
	// }
	//
	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.sysmodel.ISystemModel#fillViewWizards(net.ibizsys.paas.view.IViewWizardModel, java.util.ArrayList)
	// */
	// @Override
	// public void fillViewWizards(IViewWizardModel iViewWizardModel, ArrayList<IViewWizard> viewWizardList) throws Exception {
	// iViewWizardModel.fillViewWizards(strQuery, viewWizardList);
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getViewMessages(net.ibizsys.paas.controller.IViewController, net.ibizsys.paas.view.IViewMsgGroupModel)
	 */
	@Override
	public Iterator<IViewMessage> getViewMessages(IViewController iViewController, IViewMsgGroupModel iViewMsgGroupModel) throws Exception {

		ArrayList<IViewMessage> viewMessageList = null;
		IViewMsgGroupPlugin iViewMsgGroupPlugin = this.getViewMsgGroupPlugin();
		if (iViewMsgGroupPlugin != null) {
			PluginActionResult pluginActionResult = iViewMsgGroupPlugin.doGetViewMessages(iViewController, iViewMsgGroupModel, null, null);
			if (pluginActionResult.getUserObject() != null) {
				viewMessageList = (ArrayList<IViewMessage>) pluginActionResult.getUserObject();
			}
			if (pluginActionResult.getResult() == PluginActionResult.RESULT_REPLACE) {
				if (viewMessageList == null) return null;
				return viewMessageList.iterator();
			}
		}
		if (viewMessageList == null) {
			viewMessageList = new ArrayList<IViewMessage>();
		}
		iViewMsgGroupModel.fillViewMessages(iViewController, viewMessageList);
		return viewMessageList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getViewWizards(net.ibizsys.paas.controller.IViewController, net.ibizsys.paas.view.IViewWizardGroupModel, java.lang.String)
	 */
	@Override
	public Iterator<IViewWizard> getViewWizards(IViewController iViewController, IViewWizardGroupModel iViewWizardGroupModel, String strQuery) throws Exception {
		ArrayList<IViewWizard> viewWizardList = new ArrayList<IViewWizard>();
		iViewWizardGroupModel.fillViewWizards(iViewController, strQuery, viewWizardList);
		return viewWizardList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#setSystemPlugin(net.ibizsys.paas.sysmodel.ISystemPlugin)
	 */
	@Override
	public void setSystemPlugin(ISystemPlugin iSystemPlugin) throws Exception {
		setSystemPlugin(iSystemPlugin, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#setSystemPlugin(net.ibizsys.paas.sysmodel.ISystemPlugin, boolean)
	 */
	@Override
	public void setSystemPlugin(ISystemPlugin iSystemPlugin, boolean bIgnoreOrigin) throws Exception {
		ISystemPlugin lastPlugin = null;
		if (!bIgnoreOrigin) {
			lastPlugin = this.iSystemPlugin;
			if (lastPlugin == null) {
				lastPlugin = SysModelGlobal.getSystemPlugin();
			}
		}

		iSystemPlugin.setPrevPlugin(lastPlugin);
		this.iSystemPlugin = iSystemPlugin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getSystemPlugin()
	 */
	@Override
	public ISystemPlugin getSystemPlugin() {
		return iSystemPlugin;
	}

	/**
	 * 安装插件
	 * 
	 * @param pluginList
	 * @throws Exception
	 */
	protected void installPlugins(PluginList pluginList) throws Exception {
		if (pluginList == null || pluginList.getList() == null) return;

		for (Plugin plugin : pluginList.getList()) {
			if (StringHelper.compare(plugin.getType(), Plugin.PLUGINTYPE_SYSTEM, true) == 0) {
				// 系统插件
				ISystemPlugin iSystemPlugin = (ISystemPlugin) ObjectHelper.create(plugin.getObj());
				if (StringHelper.isNullOrEmpty(plugin.getTarget())) {
					iSystemPlugin.init(null, plugin.getCode());
					SysModelGlobal.setSystemPlugin(iSystemPlugin);
				} else {
					ISystemModel iSystemModel = (ISystemModel) SysModelGlobal.getSystem(plugin.getTarget());
					iSystemPlugin.init(iSystemModel, plugin.getCode());
					iSystemModel.setSystemPlugin(iSystemPlugin);
				}

				continue;
			}

			if (StringHelper.compare(plugin.getType(), Plugin.PLUGINTYPE_SERVICE, true) == 0) {
				// 服务插件
				IServicePlugin iServicePlugin = (IServicePlugin) ObjectHelper.create(plugin.getObj());
				IDataEntityModel dataEntityModel = DEModelGlobal.getDEModel(plugin.getTarget());
				iServicePlugin.init(plugin.getCode());
				dataEntityModel.setServicePlugin(iServicePlugin);
				continue;
			}
		}

	}

	/**
	 * 获取视图消息组插件
	 * 
	 * @return
	 */
	protected IViewMsgGroupPlugin getViewMsgGroupPlugin() {

		if (iViewMsgGroupPlugin == null) {
			if (this.getSystemPlugin() != null && this.getSystemPlugin().getViewMsgGroupPlugin() != null) {
				iViewMsgGroupPlugin = this.getSystemPlugin().getViewMsgGroupPlugin();
			}
			if (iViewMsgGroupPlugin == null) {
				iViewMsgGroupPlugin = nullSystemViewMsgGroupPlugin;
			}
		}
		return (iViewMsgGroupPlugin == nullSystemViewMsgGroupPlugin) ? null : iViewMsgGroupPlugin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getRealSessionFactory(net.ibizsys.paas.demodel.IDataEntityModel, org.hibernate.SessionFactory)
	 */
	@Override
	public SessionFactory getRealSessionFactory(IDataEntityModel iDataEntityModel, SessionFactory sessionFactory) {
		return sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#createDEActionWizardModel(int, java.lang.String)
	 */
	@Override
	public IDEActionWizardModel createDEActionWizardModel(int nMode, String strUserTag) throws Exception {
		switch (nMode) {
		case IDEActionWizard.DYNAMICMODE_STATIC:
			return new DEActionWizardModel();
		case IDEActionWizard.DYNAMICMODE_DEDATASET:
			return new DEDataSetDEAWModel();
		default:
			throw new Exception(StringHelper.format("无法识别的实体操作向导模式[%1$s]", nMode));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#createViewMsgModel(int, java.lang.String)
	 */
	@Override
	public IViewMsgModel createViewMsgModel(int nMode, String strUserTag) throws Exception {
		switch (nMode) {
		case IViewMsgModel.DYNAMICMODE_STATIC:
			return new StaticViewMsgModel();
		case IViewMsgModel.DYNAMICMODE_DEDATASET:
			return new DEDataSetViewMsgModel();
		default:
			throw new Exception(StringHelper.format("无法识别的视图消息模式[%1$s]", nMode));
		}
	}

	
	@Autowired(required = false)
	@Qualifier("uniStateManager")
	private IUniStateManager uniStateManager;
	
	@Override
	public IUniStateManager getUniStateManager() {
		return uniStateManager;
	}

	@Override
	public void fillViewMsgActiveData(IEntity iEntity, IViewMsgModel iViewMsgModel, IViewController iViewController) throws Exception {
		iEntity.set(IViewMsgModel.ACTIVEDATA_VIEWID, iViewController.getId());
		iEntity.set(IViewMsgModel.ACTIVEDATA_VIEWCLS, iViewController.getClass().getCanonicalName());
		
		Object objDEId = null;
		Object objKey = null;
		Object objDERId = null;
		JSONObject jo = WebContext.getActiveData();
		if (jo != null) {
			if (iViewController.getDEModel() != null) {
				objDEId = iViewController.getDEModel().getId();
			} else {
				objDEId = jo.opt("srfdeid");
			}
			objKey = jo.opt("srfkey");
			if (objKey == null){
				objKey = WebContext.getKey(WebContext.getCurrent());
			}
		}
		if (jo == null) {
			jo = WebContext.getParentData();
			if (jo != null) {
				objDEId = jo.opt("srfparentdeid");
				objKey = jo.opt("srfparentkey");
				if (objKey == null) {
					objKey = WebContext.getParentKey(WebContext.getCurrent());
				}

				String strParentType = WebContext.getParentType(WebContext.getCurrent());
				if (!StringHelper.isNullOrEmpty(strParentType)) {
					if (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0) {
						objDERId = WebContext.getDER1NId(WebContext.getCurrent());
					} else if (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0) {
						objDERId = WebContext.getDER1NId(WebContext.getCurrent());
					}
				}
			}
		}

		if (objDEId != null){
			iEntity.set(IViewMsgModel.ACTIVEDATA_DEID, objDEId);
			IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)objDEId,true);
			if(iDataEntityModel!=null)
			{
				iEntity.set(IViewMsgModel.ACTIVEDATA_DENAME, iDataEntityModel.getName());
			}
		}
		if (objKey != null) iEntity.set(IViewMsgModel.ACTIVEDATA_KEY, objKey);
		if (objDERId != null) iEntity.set(IViewMsgModel.ACTIVEDATA_DERID, objDERId);
	}

	@Override
	public IDBFunction getDBFunction(IDBDialect iDBDialect, String strFuncName) throws Exception {
		return iDBDialect.getDBFunction(strFuncName);
	}

	@Autowired(required = false)
	@Qualifier("noViewMode")
	private Boolean noViewMode;
	
	
	@Override
	public boolean isNoViewMode(IDataEntityModel iDataEntityModel) {
		if(noViewMode == null)
			return iDataEntityModel.isNoViewMode();
		return noViewMode;
	}

	@Override
	public String getDEOPPrivTarget(String strDEOPPriv) {
		if(StringHelper.isNullOrEmpty(strDEOPPriv))
			return IDataEntityModel.DEOPPRIVTARGET_UNKNOWN;
		if((StringHelper.compare(strDEOPPriv, DataAccessActions.CREATE,true) == 0)
				||(strDEOPPriv.indexOf(DEDataAccMgr.SYSUNIRES_PREFIX)==0)){
			return IDataEntityModel.DEOPPRIVTARGET_NONE;
		}
		return IDataEntityModel.DEOPPRIVTARGET_DATA;
	}
	
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerServiceAPIClientModel(net.ibizsys.psbaScheme.core.IServiceAPIClientModel)
	 */
	@Override
	public void registerServiceAPIClientModel(IServiceAPIClientModel iServiceAPIClientModel) throws Exception {
		String strId = iServiceAPIClientModel.getId();
		if (serviceAPIClientModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的服务API客户端对象", strId));
		}
		
		serviceAPIClientModelMap.put(strId, iServiceAPIClientModel);
		if(!StringHelper.isNullOrEmpty(iServiceAPIClientModel.getUniqueTag())){
			if(!serviceAPIClientModelMap.containsKey(iServiceAPIClientModel.getUniqueTag())){
				serviceAPIClientModelMap.put(iServiceAPIClientModel.getUniqueTag(),iServiceAPIClientModel);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getServiceAPIClientModel(java.lang.String)
	 */
	@Override
	public IServiceAPIClientModel getServiceAPIClientModel(String strServiceAPIClientModelId) throws Exception {
		IServiceAPIClientModel iServiceAPIClientModel = serviceAPIClientModelMap.get(strServiceAPIClientModelId);
		if (iServiceAPIClientModel == null) {
			throw new Exception(StringHelper.format("无法获取指定服务API客户端对象，服务API客户端标识[%1$s]", strServiceAPIClientModelId));
		}
		return iServiceAPIClientModel;
	}

	@Override
	public boolean isUseServiceAPI() {
		return !StringHelper.isNullOrEmpty(this.getServiceAPIClientId());
	}

	@Override
	public IServiceAPIClientModel getServiceAPIClientModel() throws Exception {
		if(StringHelper.isNullOrEmpty(this.getServiceAPIClientId()))
			return null;
		if(this.iServiceAPIClientModel==null){
			this.iServiceAPIClientModel = this.getServiceAPIClientModel(this.getServiceAPIClientId());
		}
		return this.iServiceAPIClientModel;
	}

	/**
	 * 获取系统的服务API客户端标识
	 * @return
	 */
	public String getServiceAPIClientId(){
		return null;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#isDEUseServiceAPI(net.ibizsys.paas.demodel.IDataEntityModel)
	 */
	@Override
	public boolean isDEUseServiceAPI(IDataEntityModel iDataEntityModel) {
		return isUseServiceAPI();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getServiceAPIPath(net.ibizsys.paas.api.IServiceAPIClientModel, net.ibizsys.paas.api.IServiceAPIAction, java.lang.Object)
	 */
	@Override
	public String getServicePath(IServiceAPIClientModel iServiceAPIClientModel, IServiceAPIAction iServiceAPIAction, Object objParam) throws Exception {
		return iServiceAPIClientModel.getServicePath();
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#createSystemUserRoleModel(java.lang.String, java.lang.String)
	 */
	@Override
	public ISystemUserRoleModel createSystemUserRoleModel(String strType, String strRoleTag) throws Exception {
		
		if(StringHelper.compare(strType, ISystemUserRoleModel.ROLETYPE_DEDATASET, false) == 0){
			return new DEDataSetSystemUserRoleModel();
		}
		
		if(StringHelper.compare(strType, ISystemUserRoleModel.ROLETYPE_CUSTOM, false) == 0){
			return new CustomSystemUserRoleModel();
		}
		
		throw new Exception(StringHelper.format("无法识别的系统角色类型[%1$s]",strType));
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerSystemUserRoleModel(net.ibizsys.paas.sysmodel.ISystemUserRoleModel)
	 */
	@Override
	public void registerSystemUserRoleModel(ISystemUserRoleModel iSystemUserRoleModel) throws Exception {
		String strId = iSystemUserRoleModel.getId();

		if (sysUserRoleModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的用户角色对象", strId));
		}
		
		if(!StringHelper.isNullOrEmpty(iSystemUserRoleModel.getRoleTag())){
			if (sysUserRoleModelMap.containsKey(iSystemUserRoleModel.getRoleTag())) {
				throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的用户角色对象", iSystemUserRoleModel.getRoleTag()));
			}
		}
		sysUserRoleModelMap.put(strId, iSystemUserRoleModel);
		if(!StringHelper.isNullOrEmpty(iSystemUserRoleModel.getRoleTag())){
			sysUserRoleModelMap.put(iSystemUserRoleModel.getRoleTag(), iSystemUserRoleModel);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getUserRoleModel(java.lang.String)
	 */
	@Override
	public ISystemUserRoleModel getSystemUserRoleModel(String strUserRoleModelId) throws Exception {
		ISystemUserRoleModel iSystemUserRoleModel = this.sysUserRoleModelMap.get(strUserRoleModelId);
		if (iSystemUserRoleModel == null) {
			throw new Exception(StringHelper.format("无法获取指定系统用户角色对象，用户角色对象标识[%1$s]", strUserRoleModelId));
		}
		return iSystemUserRoleModel;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getDynaSystemSetting()
	 */
	@Override
	public IDynaSystemSetting getDynaSystemSetting() {
		return this.iDynaSystemSetting;
	}
	
	
	/**
	 * 设置动态系统设置
	 * @param iDynaSystemSetting
	 */
	public void setDynaSystemSetting(IDynaSystemSetting iDynaSystemSetting){
		this.iDynaSystemSetting = iDynaSystemSetting;
	}

	@Override
	public ISystemSetting getSystemSetting() {
		return systemSettingModel;
	}
	
	
	
	@Override
	public void installDBModel(String strVersion,boolean bIgnoreCheck) throws Exception {
		onInstallDBModel(null,strVersion,bIgnoreCheck);
	}

	/**
	 * 安装数据结构
	 * @throws Exception
	 */
	protected void onInstallDBModel(String strCat,String strVersion,boolean bIgnoreCheck)throws Exception{
		if(this.getDBDialect() == null && this.getSessionFactory()!=null)
			return;
		
		if(dataEntityModelMap.size() == 0)
			return ;
		
		IDataEntityModel iDataEntityModel = null;
		for(IDataEntityModel firstDEModel:dataEntityModelMap.values()){
			iDataEntityModel = firstDEModel;
			break;
		}
		
		IService service = iDataEntityModel.getService(this.getSessionFactory());
		
		if(StringHelper.isNullOrEmpty(strCat)){
			strCat = this.getName().toLowerCase();
		}
		if(StringHelper.isNullOrEmpty(strVersion)){
			strVersion = "last";
		}
		
		String strSqlFile = StringHelper.format("db/%1$s.%2$s.%3$s.sql",strCat.toLowerCase(),this.getDBDialect().getDBType().toLowerCase(),strVersion.toLowerCase());
		String strSqlCheckFile = StringHelper.format("db/%1$s.%2$s.%3$s.check.sql",strCat.toLowerCase(),this.getDBDialect().getDBType().toLowerCase(),strVersion.toLowerCase());
				
		InputStream sqlInputStream = this.getClass().getClassLoader().getResourceAsStream(strSqlFile);
		InputStream sqlCheckInputStream = this.getClass().getClassLoader().getResourceAsStream(strSqlCheckFile);
		if(sqlInputStream == null || sqlCheckInputStream == null)
			return;
		
		String strCheckSqlCode = FileHelper.readFile(sqlCheckInputStream);
		if(StringHelper.isNullOrEmpty(strCheckSqlCode))
			return;
		
		log.info(StringHelper.format("开始安装系统[%1$s]数据库[%2$s]模型",this.getName(),this.getDBDialect().getDBType()));
		if(!bIgnoreCheck){
			try{
				DBCallResult dbCallResult = service.executeRaw(strCheckSqlCode, null);
				if(dbCallResult.isOk()){
					return ;
				}
				log.debug(StringHelper.format("执行安装数据库检查脚本发生错误，执行安装数据库"));
			}
			catch(Exception ex){
				log.debug(StringHelper.format("执行安装数据库检查脚本发生错误，执行安装数据库"));
			}
		}
		
		String strSqlCode = FileHelper.readFile(sqlInputStream);
		if(StringHelper.isNullOrEmpty(strSqlCode))
			return;
		
		strSqlCode = strSqlCode.replace("\r\n", "\n");
		String[] sqls = StringHelper.split(strSqlCode, "/**分割线**/");
//		if(sqls.length == 1){
//			sqls = StringHelper.split(strSqlCode, ";");
//		}
		for (String strSql : sqls) {
			strSql = strSql.trim();
			if (StringHelper.isNullOrEmpty(strSql))
				continue;
			
			try{
				DBCallResult dbCallResult = service.executeRaw(strSql, null);
				if(dbCallResult.isOk()){
					log.debug(StringHelper.format("成功执行：%1$s",strSql));
				}
			}
			catch(Exception ex){
				
			}
		}
		
		try{
			DBCallResult dbCallResult = service.executeRaw(strCheckSqlCode, null);
			if(dbCallResult.isOk()){
				log.info(StringHelper.format("安装系统数据库成功！"));
			}
			else{
				log.error(StringHelper.format("安装系统数据库失败！"));
			}
		}
		catch(Exception ex){
			log.error(StringHelper.format("安装系统数据库失败！"));
		}
		
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#registerDEUIActionModel(net.ibizsys.paas.demodel.IDEUIActionModel)
	 */
	@Override
	public void registerDEUIActionModel(IDEUIActionModel iDEUIActionModel) throws Exception {
		String strId = iDEUIActionModel.getId();
		if (this.deUIActionModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的实体界面行为对象", strId));
		}
		
		this.deUIActionModelMap.put(strId, iDEUIActionModel);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getDEUIActionModel(java.lang.String, boolean)
	 */
	@Override
	public IDEUIActionModel getDEUIActionModel(String strDEUIActionId, boolean bTryMode) throws Exception {
		IDEUIActionModel iDEUIActionModel = this.deUIActionModelMap.get(strDEUIActionId);
		if (iDEUIActionModel == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取指定全局实体界面行为对象，实体界面行为对象标识[%1$s]", strDEUIActionId));
		}
		return iDEUIActionModel;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#toJSONObject(net.ibizsys.paas.demodel.IDataEntityModel, net.ibizsys.paas.entity.IEntity, boolean, int)
	 */
	@Override
	public JSONObject toJSONObject(IDataEntityModel iDataEntityModel, IEntity iEntity, boolean bIncludeEmpty,int nOption) throws Exception {
		JSONObject jo = DataObject.toJSONObject(iEntity, bIncludeEmpty);
		if(((nOption & IService.EXPORTMODELMODE_NOOPERATORINFO) == IService.EXPORTMODELMODE_NOOPERATORINFO)&&iDataEntityModel!=null){
			IDEField iDEField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_CREATEMAN, true);
			if(iDEField!=null){
				jo.remove(iDEField.getName().toLowerCase());
			}
			iDEField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_CREATEDATE, true);
			if(iDEField!=null){
				jo.remove(iDEField.getName().toLowerCase());
			}
			iDEField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_UPDATEMAN, true);
			if(iDEField!=null){
				jo.remove(iDEField.getName().toLowerCase());
			}
			iDEField = iDataEntityModel.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_UPDATEDATE, true);
			if(iDEField!=null){
				jo.remove(iDEField.getName().toLowerCase());
			}
		}
		if(((nOption & IService.EXPORTMODELMODE_PHYSICALONLY) == IService.EXPORTMODELMODE_PHYSICALONLY)&&iDataEntityModel!=null){
			java.util.Iterator<IDEField> defields = iDataEntityModel.getDEFields();
			while(defields.hasNext()){
				IDEField iDEField = defields.next();
				if(!iDEField.isPhisicalDEField()){
					jo.remove(iDEField.getName().toLowerCase());
				}
			}
		}
		
		return jo;
	}

	@Override
	public void registerSystemPartModel(ISystemPartModel iSystemPartModel) throws Exception {
		String strId = iSystemPartModel.getId();

		if (systemPartModelMap.containsKey(strId)) {
			throw new Exception(StringHelper.format("系统中已经注册了标识为[%1$s]的系统成员模型", strId));
		}
		
		systemPartModelMap.put(strId, iSystemPartModel);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#logException(java.lang.Object, java.lang.Throwable, java.lang.String, java.lang.Object)
	 */
	@Override
	public void logException(Object logger, Throwable throwable, String strMessage,  Object objUserData) {
		if(getExceptionHandler()==null)
			return ;
		 this.getExceptionHandler().log(this, logger,  throwable,  strMessage,  objUserData);
	}
	
	/**
	 * 获取系统全局异常处理对象，扩展类重写此方法
	 * @return
	 */
	protected IExceptionHandler getExceptionHandler(){
		return null;
	}

	@Override
	public void registerSystemUtil(ISystemUtil iSystemUtil) throws Exception {
		systemUtilMap.put(iSystemUtil.getUtilType(),iSystemUtil);
	}

	/**
	 * Create, initialize and register a system utility by class name.
	 *
	 * @param strUtilType utility type
	 * @param strClassName implementation class name
	 * @throws Exception if the class cannot be created or initialized
	 */
	public void registerSystemUtilObj(String strUtilType, String strClassName) throws Exception {
		Object obj = ObjectHelper.create(strClassName);
		if (!(obj instanceof ISystemUtil)) {
			throw new Exception(StringHelper.format("系统辅助功能类[%1$s]不是ISystemUtil实现", strClassName));
		}
		ISystemUtil iSystemUtil = (ISystemUtil) obj;
		if (iSystemUtil instanceof SystemUtilBase) {
			((SystemUtilBase) iSystemUtil).setUtilType(strUtilType);
		}
		iSystemUtil.init(this);
		this.registerSystemUtil(iSystemUtil);
	}

	/**
	 * Get the SaaS workflow utility registered for this system.
	 *
	 * @return registered utility, or null when it is not available
	 * @throws Exception on an incompatible registration
	 */
	public net.ibizsys.sswf.sysmodel.util.SaaSWFUtilBase getSaaSWFUtil() throws Exception {
		ISystemUtil iSystemUtil = this.getSystemUtil(
				net.ibizsys.saas.sysmodel.util.SaaSSystemUtils.SaaSWF, true);
		if (iSystemUtil == null) {
			return null;
		}
		if (!(iSystemUtil instanceof net.ibizsys.sswf.sysmodel.util.SaaSWFUtilBase)) {
			throw new Exception("系统辅助功能SaaSWF不是SaaSWFUtilBase实现");
		}
		return (net.ibizsys.sswf.sysmodel.util.SaaSWFUtilBase) iSystemUtil;
	}

	/**
	 * Get the SaaS workflow service utility, lazily creating the dynamic
	 * implementation when it is present in the local runtime.
	 *
	 * @return workflow service utility
	 * @throws Exception on an incompatible registration or missing runtime
	 */
	public net.ibizsys.sswf.sysmodel.util.SaaSWFServiceUtilBase getSaaSWFServiceUtil()
			throws Exception {
		ISystemUtil iSystemUtil = this.getSystemUtil(
				net.ibizsys.saas.sysmodel.util.SaaSSystemUtils.SaaSWFService, true);
		if (iSystemUtil == null) {
			this.registerSystemUtilObj(
					net.ibizsys.saas.sysmodel.util.SaaSSystemUtils.SaaSWFService,
					"net.ibizsys.ssdynawf.sysmodel.DefaultDynaWFServiceUtil");
			iSystemUtil = this.getSystemUtil(
					net.ibizsys.saas.sysmodel.util.SaaSSystemUtils.SaaSWFService, true);
		}
		if (!(iSystemUtil instanceof net.ibizsys.sswf.sysmodel.util.SaaSWFServiceUtilBase)) {
			throw new Exception("系统辅助功能SaaSWFService不是SaaSWFServiceUtilBase实现");
		}
		return (net.ibizsys.sswf.sysmodel.util.SaaSWFServiceUtilBase) iSystemUtil;
	}

	@Override
	public ISystemUtil getSystemUtil(String strUtilType, boolean bTry) throws Exception {
		ISystemUtil iSystemUtil = systemUtilMap.get(strUtilType);
		if(iSystemUtil == null && !bTry){
			throw new Exception(StringHelper.format("无法获取指定系统辅助功能[%1$s]",strUtilType));
		}
		return iSystemUtil;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemRuntime#getModuleId()
	 */
	@Override
	public String getModuleId() {
		return SystemModelBase.strModuleIId;
	}
	
	/**
	 * 设置部署系统模块标识 
	 * @param strModuleId
	 */
	protected void setModuleId(String strModuleId) {
		SystemModelBase.strModuleIId = strModuleId;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemModel#getDataEntityModels()
	 */
	@Override
	public Iterator<IDataEntityModel> getDataEntityModels() {
		return this.dataEntityModelMap2.values().iterator();
	}
}
