package net.ibizsys.pswf.core;

import java.util.HashMap;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 工作流模型基类
 * @author lionlau
 *
 */
public abstract class WFModelBase extends ModelBaseImpl implements IWFModel
{	
	private static final Log log = LogFactory.getLog(WFModelBase.class);
	
	private HashMap<Integer, IWFVersionModel> wfVersionModelMap = new HashMap<Integer, IWFVersionModel>();
	private HashMap<String,IWFVersionModel> lastWFVersionModelMap = new HashMap<String,IWFVersionModel>();
	private HashMap<String,IWFVersionModel> wfVersionModelMap2 = new HashMap<String,IWFVersionModel>();
	
//	private ArrayList<IWFSubWFModel> wfSubWFModelList = new ArrayList<IWFSubWFModel>();
	private IWFVersionModel lastWFVersionModel = null;
	private ICodeList wfStepCodeList = null;
	private ICodeList entityStateCodeList = null;
	private HashMap<String,String> entityWFStateMap = new HashMap<String,String>();
	private IWFService iWFService = null;
	private String strEntityWFState = "";
	private String strRemindMsgTemplId = "";
	private String strWXAccountId = "";
	private String strWXEntAppId = "";
	private Object objRuntimeId = null;
	private String strWFEngineType = IWFModel.WFENGINETYPE_EMBEDDED;
	private String strNameLanResTag = null;
	private String strWFEngineCat = null;
	private String strDefaultDEName = null;
	
	/**
	 * 设置流程模型标识
	 * @param strId the strId to set
	 */
	protected void setId(String strId)
	{
		this.strId = strId;
	}

	/**
	 * 设置流程模型名称
	 * @param strName the strName to set
	 */
	protected void setName(String strName)
	{
		this.strName = strName;
	}
	
	/**
	 * 获取系统模型对象
	 * @return
	 */
	public abstract ISystemModel getSystemModel();
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#createEntity(java.lang.String)
	 */
	@Override
	public IEntity createEntity(String strDEName) throws Exception
	{
		return this.getSystemModel().getDataEntityModel(strDEName).createEntity();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getWFStepCodeList()
	 */
	@Override
	public ICodeList getWFStepCodeList()
	{
		return this.wfStepCodeList;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getEntityStateCodeList()
	 */
	@Override
	public ICodeList getEntityStateCodeList()
	{
		return this.entityStateCodeList;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getLastWFVersionModel()
	 */
	@Override
	public IWFVersionModel getLastWFVersionModel()
	{
		return lastWFVersionModel;
	}
	
	

//	/* (non-Javadoc)
//	 * @see net.ibizsys.pswf.core.IWFModel#getWFSubWFModels()
//	 */
//	@Override
//	public Iterator<IWFSubWFModel> getWFSubWFModels()
//	{
//		return null;
//	}

	@Override
	public IWFVersionModel getLastWFVersionModel(String strWFMode)throws Exception {
		if(StringHelper.isNullOrEmpty(strWFMode))
			return this.getLastWFVersionModel();
		
		IWFVersionModel iWFVersionModel = lastWFVersionModelMap.get(strWFMode);
		if(iWFVersionModel == null)
		{
			log.warn(StringHelper.format("无法获取指定流程模式的最新版本模型，模式为[%1$s]",strWFMode));
			return this.getLastWFVersionModel();
		}
		return iWFVersionModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getWFVersionModelByWFVersion(int)
	 */
	@Override
	public IWFVersionModel getWFVersionModelByWFVersion(int nVersion)throws Exception
	{
		if(nVersion == -1)
			return getLastWFVersionModel();
		
		IWFVersionModel iWFVersionModel =  wfVersionModelMap.get(nVersion);
		if(iWFVersionModel == null)
		{
			throw new Exception(StringHelper.format("无法获取指定流程模型，版本为[%1$s]",nVersion));
		}
		return iWFVersionModel;
	}
	
	/**
	 * 注册流程版本模型
	 * @param iWFVersionModel
	 * @throws Exception
	 */
	protected void registerWFVersionModel(IWFVersionModel iWFVersionModel)throws Exception
	{
		if(lastWFVersionModel==null||lastWFVersionModel.getWFVersion()<iWFVersionModel.getWFVersion())
		{
			lastWFVersionModel = iWFVersionModel;
		}
		
		wfVersionModelMap2.put(iWFVersionModel.getId(), iWFVersionModel);
		wfVersionModelMap.put(iWFVersionModel.getWFVersion(), iWFVersionModel);
		if(!StringHelper.isNullOrEmpty(iWFVersionModel.getWFMode())){
			IWFVersionModel lastWFVersionModel = lastWFVersionModelMap.get(iWFVersionModel.getWFMode());
			if(lastWFVersionModel == null || iWFVersionModel.getWFVersion()>lastWFVersionModel.getWFVersion()){
				lastWFVersionModelMap.put(iWFVersionModel.getWFMode(), iWFVersionModel);
			}
		}
	}

	/**
	 * 设置流程步骤代码表对象
	 * @param wfStepCodeList the wfStepCodeList to set
	 */
	protected void setWFStepCodeList(ICodeList wfStepCodeList)
	{
		this.wfStepCodeList = wfStepCodeList;
	}

	/**
	 * 设置用户状态代码表对象
	 * @param entityStateCodeList the entityStateCodeList to set
	 */
	protected void setEntityStateCodeList(ICodeList entityStateCodeList)
	{
		this.entityStateCodeList = entityStateCodeList;
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getEntityWFStates()
	 */
	@Override
	public  java.util.Iterator<String> getEntityWFStates()
	{
		return this.entityWFStateMap.keySet().iterator();
	}
	
	/**
	 * 判断指定状态是否为用户数据中在流程中
	 * @param strWFState
	 */
	public boolean isEntityWFState(String strWFState)
	{
		return entityWFStateMap.containsKey(strWFState);
	}

	
	/**
	 * 注册业务状态中的流程状态
	 * @param strWFState
	 */
	protected void registerEntityWFState(String strWFState)
	{
		entityWFStateMap.put(strWFState,"");
		if(StringHelper.isNullOrEmpty(this.strEntityWFState))
		{
			this.strEntityWFState = strWFState;
		}
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getWFService()
	 */
	@Override
	public IWFService getWFService()
	{
		return iWFService;
	}

	/**
	 * 设置流程处理服务对象
	 * @param iWFService the iWFService to set
	 */
	protected void setWFService(IWFService iWFService)
	{
		this.iWFService = iWFService;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getEntityWFState()
	 */
	@Override
	public String getEntityWFState()
	{
		return this.strEntityWFState;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getRemindMsgTemplId()
	 */
	@Override
	public String getRemindMsgTemplId()
	{
		return strRemindMsgTemplId;
	}
	
	/**
	 * 设置催办流程模板标识
	 * @param strRemindMsgTemplId
	 */
	protected void setRemindMsgTemplId(String strRemindMsgTemplId)
	{
		this.strRemindMsgTemplId = strRemindMsgTemplId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getWXAccountId()
	 */
	@Override
	public String getWXAccountId() {
		return this.strWXAccountId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getWXEntAppId()
	 */
	@Override
	public String getWXEntAppId() {
		return this.strWXEntAppId;
	}

	/**
	 * 设置微信公众号标识
	 * @param strWXAccountId
	 */
	protected void setWXAccountId(String strWXAccountId) {
		this.strWXAccountId = strWXAccountId;
	}

	/**
	 * 设置微信企业应用标识
	 * @param strWXEntAppId
	 */
	protected void setWXEntAppId(String strWXEntAppId) {
		this.strWXEntAppId = strWXEntAppId;
	}
	
	
	@Override
	public Object getRuntimeId() {
		if(objRuntimeId == null)
			return this.getId();
		return objRuntimeId;
	}

	@Override
	public void setRuntimeId(Object objRuntimeId) {
		this.objRuntimeId = objRuntimeId;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getWFVersionModel(java.lang.String)
	 */
	@Override
	public IWFVersionModel getWFVersionModel(String strWFVersionId) throws Exception {
		IWFVersionModel iWFVersionModel =  wfVersionModelMap2.get(strWFVersionId);
		if(iWFVersionModel == null)
		{
			throw new Exception(StringHelper.format("无法获取指定流程模型，标识为[%1$s]",strWFVersionId));
		}
		return iWFVersionModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFModel#getWFEngineType()
	 */
	@Override
	public String getWFEngineType() {
		return strWFEngineType;
	}

	
	
	/**
	 * 设置工作流引擎类型
	 * @param strWFEngineType
	 */
	protected void setWFEngineType(String strWFEngineType){
		this.strWFEngineType = strWFEngineType;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.pswf.core.IWFProcessModel#getNameLanResTag()
	 */
	@Override
	public String getNameLanResTag() {
		return strNameLanResTag;
	}



	/**
	 * 设置处理名称的语言资源标记
	 * @param strNameLanResTag
	 */
	protected void setNameLanResTag(String strNameLanResTag) {
		this.strNameLanResTag = strNameLanResTag;
	}

	@Override
	public String getWFEngineCat() {
		if(StringHelper.isNullOrEmpty(this.strWFEngineCat))
			return this.getWFEngineType();
		return this.strWFEngineCat;
	}
	
	
	protected void setWFEngineCat(String strWFEngineCat){
		this.strWFEngineCat = strWFEngineCat;
	}
	
	
	@Override
	public String getDefaultDEName() {
		return this.strDefaultDEName;
	}
	
	/**
	 * 设置默认流程实体名称
	 * @param strDefaultDEName
	 */
	protected void setDefaultDEName(String strDefaultDEName) {
		this.strDefaultDEName = strDefaultDEName;
	}
	
	
}
