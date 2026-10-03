package net.ibizsys.pswf.core;

import java.util.HashMap;

import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.util.StringHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 动态流程实例模型对象
 * @author Administrator
 *
 */
public class DynaWFInstModel {

	private static final Log log = LogFactory.getLog(DynaWFInstModel.class);
	
	private HashMap<Integer, IWFVersionModel> wfVersionModelMap = new HashMap<Integer, IWFVersionModel>();
	private HashMap<String,IWFVersionModel> lastWFVersionModelMap = new HashMap<String,IWFVersionModel>();
	private HashMap<String,IWFVersionModel> wfVersionModelMap2 = new HashMap<String,IWFVersionModel>();
	private String strDynaSysInstId = null;

	private IWFVersionModel lastWFVersionModel = null;
	private ICodeList wfStepCodeList = null;
	private ICodeList entityStateCodeList = null;
	private String strEntityWFState = "";
	private String strRemindMsgTemplId = "";
	private String strWXAccountId = "";
	private String strWXEntAppId = "";
	
	public DynaWFInstModel(IDynaWFModel iDynaWFModel, String strDynaSysInstId){
		this.strDynaSysInstId = strDynaSysInstId;
	}
	

	
	

//	/* (non-Javadoc)
//	 * @see net.ibizsys.pswf.core.IWFModel#getWFStepCodeList()
//	 */
//	//@Override
//	public ICodeList getWFStepCodeList()
//	{
//		return this.wfStepCodeList;
//	}
//
//	/* (non-Javadoc)
//	 * @see net.ibizsys.pswf.core.IWFModel#getEntityStateCodeList()
//	 */
//	public ICodeList getEntityStateCodeList()
//	{
//		return this.entityStateCodeList;
//	}
	
	
	public IWFVersionModel getLastWFVersionModel()
	{
		return lastWFVersionModel;
	}
	
	

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
	public void registerWFVersionModel(IWFVersionModel iWFVersionModel)throws Exception
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
	public void setWFStepCodeList(ICodeList wfStepCodeList)
	{
		this.wfStepCodeList = wfStepCodeList;
	}

	/**
	 * 设置用户状态代码表对象
	 * @param entityStateCodeList the entityStateCodeList to set
	 */
	public void setEntityStateCodeList(ICodeList entityStateCodeList)
	{
		this.entityStateCodeList = entityStateCodeList;
	}
	
//	
//
//	public  java.util.Iterator<String> getEntityWFStates()
//	{
//		return this.entityWFStateMap.keySet().iterator();
//	}
//	
//	/**
//	 * 判断指定状态是否为用户数据中在流程中
//	 * @param strWFState
//	 */
//	public boolean isEntityWFState(String strWFState)
//	{
//		return entityWFStateMap.containsKey(strWFState);
//	}

//	
//	/**
//	 * 注册业务状态中的流程状态
//	 * @param strWFState
//	 */
//	public void registerEntityWFState(String strWFState)
//	{
//		entityWFStateMap.put(strWFState,"");
//		if(StringHelper.isNullOrEmpty(this.strEntityWFState))
//		{
//			this.strEntityWFState = strWFState;
//		}
//	}



	public String getRemindMsgTemplId()
	{
		return strRemindMsgTemplId;
	}
	
	/**
	 * 设置催办流程模板标识
	 * @param strRemindMsgTemplId
	 */
	public void setRemindMsgTemplId(String strRemindMsgTemplId)
	{
		this.strRemindMsgTemplId = strRemindMsgTemplId;
	}

	public String getWXAccountId() {
		return this.strWXAccountId;
	}


	public String getWXEntAppId() {
		return this.strWXEntAppId;
	}

	/**
	 * 设置微信公众号标识
	 * @param strWXAccountId
	 */
	public void setWXAccountId(String strWXAccountId) {
		this.strWXAccountId = strWXAccountId;
	}

	/**
	 * 设置微信企业应用标识
	 * @param strWXEntAppId
	 */
	public void setWXEntAppId(String strWXEntAppId) {
		this.strWXEntAppId = strWXEntAppId;
	}
	
	
	public IWFVersionModel getWFVersionModel(String strWFVersionId) throws Exception {
		IWFVersionModel iWFVersionModel =  wfVersionModelMap2.get(strWFVersionId);
		if(iWFVersionModel == null)
		{
			throw new Exception(StringHelper.format("无法获取指定流程模型，标识为[%1$s]",strWFVersionId));
		}
		return iWFVersionModel;
	}


	public String getDynaSysInstId(){
		return this.strDynaSysInstId;
	}
	
}
