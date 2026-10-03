package net.ibizsys.paas.demodel;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetGroupParam;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.ibizsys.psrt.srv.web.WebContext;

/**
 * 实体数据集合模型
 * 
 * @author lionlau
 *
 */
public abstract class DEDataSetModelBase extends ModelBase3Impl implements IDEDataSetModel {
	private IDataEntity iDataEntity = null;
	private DEDataSet deDataSetAnno = null;
	private boolean bEnableGroup = false;
	private int nGroupTopCount = -1;
	/**
	 * 启用组织机构数据范围
	 */
	private boolean bEnableOrgDR = false;

	/**
	 * 启用组织部门数据范围
	 */
	private boolean bEnableSecDR = false;

	/**
	 * 启用组织部门业务条线代码
	 */
	private boolean bEnableSecBC = false;

	private long nOrgDR = 0;

	private long nSecDR = 0;

	private String strSecBC = "";

	private boolean bEnableUserDR = false;

	private String strUserDRAction = DataAccessActions.READ;


	private String strCustomDRMode = null;

	private String strCustomDRMode2 = null;

	private String strCustomDRModeParam = null;

	private String strCustomDRMode2Param = null;
	
	private boolean bEnableCache = false;
		
	private String strCacheScope = null;

	private int nCacheTimeout = -1;
	
	private String strMajorSortField = null;

	private String strMajorSortDir = null;

	private String strMinorSortField = null;

	private String strMinorSortDir= null;

	private int nPageSize = -1;
	
	private String strCacheUniStateId = null;
	
	private String strCacheUniStateDELogicId = null;
	
	private String strCacheHookState = null;
	
	private String strActiveDataDELogicId = null;
	
	protected ArrayList<IDEDataSetGroupParam> deDataSetGroupParamList = new ArrayList<IDEDataSetGroupParam>();

	protected ArrayList<IDEDataSetQuery> deDataSetQueryList = new ArrayList<IDEDataSetQuery>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSet#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.prepareDEDataSetGroupParams();
		this.onInit();
	}

	/**
	 * 初始化触发
	 * 
	 * @throws Exception
	 */
	protected void onInit() throws Exception {

		if (deDataSetAnno != null) {
			for (DEDataSetQuery deDataSetQuery : deDataSetAnno.queries()) {
				deDataSetQueryList.add(new DEDataSetQueryModel(deDataSetQuery));
			}
		}
	}

	/**
	 * 准备分组参数
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDataSetGroupParams() throws Exception {

	}

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
				if (annotation instanceof DEDataSet) {
					setDEDataSetAnno((DEDataSet) annotation);
					continue;
				}
			}
		}
	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return the iDataEntity
	 */
	public IDataEntity getDataEntity() {
		return iDataEntity;
	}

	
	/**
	 * 设置实体模型对象
	 * 
	 * @param iDataEntity the iDataEntity to set
	 */
	protected void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
	}
	
	
	/**
	 * 获取实体模型对象
	 * @return
	 */
	public IDataEntityModel getDEModel(){
		return (IDataEntityModel) this.getDataEntity();
	}
	

	/**
	 * 获取结果集对象注解
	 * 
	 * @return the deDataSet
	 */
	public DEDataSet getDEDataSetAnno() {
		return deDataSetAnno;
	}

	/**
	 * 设置结果集对象注解
	 * 
	 * @param deDataSet the deDataSet to set
	 */
	protected void setDEDataSetAnno(DEDataSet deDataSetAnno) {
		this.deDataSetAnno = deDataSetAnno;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return getDEDataSetAnno().id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return getDEDataSetAnno().name();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataSetModel#getDEDataSetQuerys()
	 */
	@Override
	public Iterator<IDEDataSetQuery> getDEDataSetQueries() {
		return this.deDataSetQueryList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSet#getDEDataQueries()
	 */
	@Override
	public Iterator<IDEDataQuery> getDEDataQueries() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataSetModel#isCustomDS()
	 */
	@Override
	public boolean isCustomDS() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEDataSetModel#fetchDEDataSet(net.ibizsys.paas.core.IDEDataSetFetchContext)
	 */
	@Override
	public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
		throw new Exception("没有实现");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSet#isEnableGroup()
	 */
	@Override
	public boolean isEnableGroup() {
		return this.bEnableGroup;
	}

	/**
	 * 设置是否启用分组
	 * 
	 * @param bEnableGroup
	 */
	protected void setEnableGroup(boolean bEnableGroup) {
		this.bEnableGroup = bEnableGroup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSet#getDEDataSetGroupParams()
	 */
	@Override
	public Iterator<IDEDataSetGroupParam> getDEDataSetGroupParams() {
		return this.deDataSetGroupParamList.iterator();
	}

	/**
	 * 注册分组参数
	 * 
	 * @param iDEDataSetGroupParam
	 */
	protected void registerDEDataSetGroupParam(IDEDataSetGroupParam iDEDataSetGroupParam) {
		this.deDataSetGroupParamList.add(iDEDataSetGroupParam);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataSet#getGroupTopCount()
	 */
	@Override
	public int getGroupTopCount() {
		return this.nGroupTopCount;
	}

	/**
	 * 设置分组Top记录数
	 * 
	 * @param nGroupTopCount
	 */
	protected void setGroupTopCount(int nGroupTopCount) {
		this.nGroupTopCount = nGroupTopCount;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#isEnableOrgDR()
	 */
	@Override
	public boolean isEnableOrgDR() {
		return this.bEnableOrgDR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#isEnableSecDR()
	 */
	@Override
	public boolean isEnableSecDR() {
		return this.bEnableSecDR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#isEnableSecBC()
	 */
	@Override
	public boolean isEnableSecBC() {
		return this.bEnableSecBC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#getOrgDR()
	 */
	@Override
	public long getOrgDR() {
		return this.nOrgDR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#getSecDR()
	 */
	@Override
	public long getSecDR() {
		return this.nSecDR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#getSecBC()
	 */
	@Override
	public String getSecBC() {
		return this.strSecBC;
	}

	/**
	 * 设置是否启用组织数据范围
	 * 
	 * @param bEnableOrgDR the bEnableOrgDR to set
	 */
	protected void setEnableOrgDR(boolean bEnableOrgDR) {
		this.bEnableOrgDR = bEnableOrgDR;
	}

	/**
	 * 设置是否启用部门数据范围
	 * 
	 * @param bEnableSecDR the bEnableSecDR to set
	 */
	protected void setEnableSecDR(boolean bEnableSecDR) {
		this.bEnableSecDR = bEnableSecDR;
	}

	/**
	 * 设置是否启用部门业务代码
	 * 
	 * @param bEnableSecBC the bEnableSecBC to set
	 */
	protected void setEnableSecBC(boolean bEnableSecBC) {
		this.bEnableSecBC = bEnableSecBC;
	}

	/**
	 * 设置组织数据范围
	 * 
	 * @param nOrgDR the nOrgDR to set
	 */
	protected void setOrgDR(long nOrgDR) {
		this.nOrgDR = nOrgDR;
	}

	/**
	 * 设置部门数据范围
	 * 
	 * @param nSecDR the nSecDR to set
	 */
	protected void setSecDR(long nSecDR) {
		this.nSecDR = nSecDR;
	}

	/**
	 * 设置部门业务代码
	 * 
	 * @param strSecBC the strSecBC to set
	 */
	protected void setSecBC(String strSecBC) {
		this.strSecBC = strSecBC;
	}

	/**
	 * 是否启用用户数据范围
	 * 
	 * @return
	 */
	@Override
	public boolean isEnableUserDR() {
		return this.bEnableUserDR;
	}

	/**
	 * 设置是否启用用户数据范围
	 * 
	 * @param bEnableUserDR
	 */
	protected void setEnableUserDR(boolean bEnableUserDR) {
		this.bEnableUserDR = bEnableUserDR;
	}

	/**
	 * 获取用户数据范围对应的操作
	 * 
	 * @return
	 */
	@Override
	public String getUserDRAction() {
		return this.strUserDRAction;
	}


	/**
	 * 填充获取的数据范围
	 * @param iService
	 * @param iWebContext
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	public void fillDEDataSetFetchDataRange(IService iService,IWebContext iWebContext,IDEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		
		// 启用用户权限
		if (this.isEnableUserDR() || this.isEnableOrgDR() || this.isEnableSecDR() || this.isEnableSecBC() || !StringHelper.isNullOrEmpty(this.getCustomDRMode()) || !StringHelper.isNullOrEmpty(this.getCustomDRMode2())) {
			
			ArrayList<String> condList = new ArrayList<String>();
			if(iService == null){
				iService = this.getDEModel().getService();
			}
			if(iWebContext == null){
				iWebContext = deDataSetFetchContextImpl.getWebContext();
				if(iWebContext == null){
					iWebContext = WebContext.getCurrent();
				}
			}
			
			if (StringHelper.isNullOrEmpty(iWebContext.getCurUserId())) {
				throw new ErrorException(Errors.ACCESSDENY, "用户还未登录");
			}
			IUserRoleMgr iUserRoleMgr = iWebContext.getUserRoleMgr();
			if (iWebContext.isSuperUser()) {
				condList.add("1=1");
			} else {
				if (this.isEnableUserDR()) {
					ArrayList<UserRoleData> list = iUserRoleMgr.getUserRoleDatas(this.getDEModel().getId(), this.getUserDRAction());
					if (list != null) {
						for (UserRoleData userRoleData : list) {
							String strCode = iUserRoleMgr.getUserRoleDataCond(iService, userRoleData, deDataSetFetchContextImpl);
							if (!StringHelper.isNullOrEmpty(strCode)) {
								condList.add(strCode);
							}
						}
					}
				}

				if (!this.isEnableUserDR() || condList.size() > 0 || iWebContext.isOrgAdmin()) {
					String strCode = iUserRoleMgr.getDEDataRangeCond(iService, this, deDataSetFetchContextImpl);
					if (!StringHelper.isNullOrEmpty(strCode)) {
						condList.add(strCode);
					}
				}
			}

			// 获取实体的组织维度
			IDEField orgIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
			IDEField secIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);
			DEDataSetFetchContext.enableOrgDRCond(deDataSetFetchContextImpl, orgIdDEField, secIdDEField, condList);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataRange#getCustomDRMode()
	 */
	@Override
	public String getCustomDRMode() {
		return this.strCustomDRMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataRange#getCustomDRMode2()
	 */
	@Override
	public String getCustomDRMode2() {
		return this.strCustomDRMode2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataRange#getCustomDRModeParam()
	 */
	@Override
	public String getCustomDRModeParam() {
		return this.strCustomDRModeParam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataRange#getCustomDRMode2Param()
	 */
	@Override
	public String getCustomDRMode2Param() {
		return this.strCustomDRMode2Param;
	}

	/**
	 * 设置自定义数据范围模式
	 * 
	 * @param strCustomDRMode
	 */
	protected void setCustomDRMode(String strCustomDRMode) {
		this.strCustomDRMode = strCustomDRMode;
	}

	/**
	 * 设置自定义数据范围模式2
	 * 
	 * @param strCustomDRMode2
	 */
	protected void setCustomDRMode2(String strCustomDRMode2) {
		this.strCustomDRMode2 = strCustomDRMode2;
	}

	/**
	 * 设置自定义数据范围模式参数
	 * 
	 * @param strCustomDRModeParam
	 */
	protected void setCustomDRModeParam(String strCustomDRModeParam) {
		this.strCustomDRModeParam = strCustomDRModeParam;
	}

	/**
	 * 设置自定义数据范围模式2参数
	 * 
	 * @param strCustomDRMode2Param
	 */
	protected void setCustomDRMode2Param(String strCustomDRMode2Param) {
		this.strCustomDRMode2Param = strCustomDRMode2Param;
	}

	@Override
	public boolean isEnableDEDataRange() {
		return this.isEnableUserDR() || this.isEnableOrgDR() || this.isEnableSecDR() || this.isEnableSecBC() || !StringHelper.isNullOrEmpty(this.getCustomDRMode()) || !StringHelper.isNullOrEmpty(this.getCustomDRMode2()) ;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSet#isEnableCache()
	 */
	@Override
	public boolean isEnableCache() {
		return this.bEnableCache;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSet#getCacheScope()
	 */
	@Override
	public String getCacheScope() {
		return this.strCacheScope;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSet#getCacheTimeout()
	 */
	@Override
	public int getCacheTimeout() {
		return this.nCacheTimeout;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSet#getMajorSortField()
	 */
	@Override
	public String getMajorSortField() {
		return this.strMajorSortField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSet#getMajorSortDir()
	 */
	@Override
	public String getMajorSortDir() {
		return this.strMajorSortDir;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSet#getMinorSortField()
	 */
	@Override
	public String getMinorSortField() {
		return this.strMinorSortField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSet#getMinorSortDir()
	 */
	@Override
	public String getMinorSortDir() {
		return this.strMinorSortDir;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSet#getPageSize()
	 */
	@Override
	public int getPageSize() {
		return this.nPageSize;
	}

	/**
	 * 设置是否启用缓存
	 * @param bEnableCache
	 */
	protected void setEnableCache(boolean bEnableCache) {
		this.bEnableCache = bEnableCache;
	}

	/**
	 * 设置缓存范围
	 * @param strCacheScope
	 */
	protected void setCacheScope(String strCacheScope) {
		this.strCacheScope = strCacheScope;
	}


	/**
	 * 设置缓存超时时长
	 * @param nCacheTimeout
	 */
	protected void setCacheTimeout(int nCacheTimeout) {
		this.nCacheTimeout = nCacheTimeout;
	}

	/**
	 * 设置一级排序属性
	 * @param strMajorSortField
	 */
	protected void setMajorSortField(String strMajorSortField) {
		this.strMajorSortField = strMajorSortField;
	}

	/**
	 * 设置一级排序方向
	 * @param strMajorSortDir
	 */
	protected void setMajorSortDir(String strMajorSortDir) {
		this.strMajorSortDir = strMajorSortDir;
	}

	/**
	 * 设置二级排序属性
	 * @param strMinorSortField
	 */
	protected void setMinorSortField(String strMinorSortField) {
		this.strMinorSortField = strMinorSortField;
	}

	/**
	 * 设置二级排序方向
	 * @param strMinorSortDir
	 */
	protected void setMinorSortDir(String strMinorSortDir) {
		this.strMinorSortDir = strMinorSortDir;
	}

	/**
	 * 设置默认分页大小
	 * @param nPageSize
	 */
	protected void setPageSize(int nPageSize) {
		this.nPageSize = nPageSize;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IDataCacheSupporter#getCacheUniStateId()
	 */
	@Override
	public String getCacheUniStateId() {
		return this.strCacheUniStateId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IDataCacheSupporter#getCacheUniStateDELogicId()
	 */
	@Override
	public String getCacheUniStateDELogicId() {
		return this.strCacheUniStateDELogicId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IDataCacheSupporter#getCacheHookState()
	 */
	@Override
	public String getCacheHookState() {
		return this.strCacheHookState;
	}

	/**
	 * 设置缓存使用的统一状态协同对象标识
	 * @param strCacheUniStateId
	 */
	protected void setCacheUniStateId(String strCacheUniStateId) {
		this.strCacheUniStateId = strCacheUniStateId;
	}

	/**
	 * 设置缓存使用统一状态计算逻辑
	 * @param strCacheUniStateDELogicId
	 */
	protected void setCacheUniStateDELogicId(String strCacheUniStateDELogicId) {
		this.strCacheUniStateDELogicId = strCacheUniStateDELogicId;
	}

	/**
	 * 设置缓存监控的状态
	 * @param strCacheHookState
	 */
	protected void setCacheHookState(String strCacheHookState) {
		this.strCacheHookState = strCacheHookState;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSet#getActiveDataDELogicId()
	 */
	@Override
	public String getActiveDataDELogicId() {
		return this.strActiveDataDELogicId;
	}
	
	
	/**
	 * 设置当前上下文数据实体逻辑标识
	 * @param strActiveDataDELogicId
	 */
	protected void setActiveDataDELogicId(String strActiveDataDELogicId){
		this.strActiveDataDELogicId = strActiveDataDELogicId;
	}
	
	
}
