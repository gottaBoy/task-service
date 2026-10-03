package net.ibizsys.paas.view;

import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psmsg.core.MsgTypes;
import net.ibizsys.psmsg.util.MsgTemplateGlobal;
import net.ibizsys.psmsg.util.MsgTemplateHelper;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;

/**
 * 实体数据集合视图消息模型
 * @author Administrator
 *
 */
public class DEDataSetViewMsgModel extends StaticViewMsgModel  implements IDEDataSetViewMsgModel{

	protected class ViewMsgCache{
		public ArrayList<IViewMsgModel> viewMsgModelList = new ArrayList<IViewMsgModel>();
		public String strCacheTag = null;
		public long nLastCacheTime = 0l;
	}
	
	/**
	 * 实体名称
	 */
	private String strDEName;

	/**
	 * 实体数据集合名称
	 */
	private String strDEDataSetName;

	
	/**
	 * 获取标题属性
	 * 
	 * @return
	 */
	private String strTitleField;

	/**
	 * 获取标题语言资源标记
	 * 
	 * @return
	 */
	private String strTitleLanResTagField;
	
	
	/**
	 * 消息类型属性
	 */
	private String  strMsgTypeField;
	
	
	
	/**
	 * 消息位置属性
	 */
	private String  strMsgPosField;
	
	
	
	/**
	 * 获可删除标记属性
	 */
	private String strRemoveFlagField;
	
	
	/**
	 * 内容属性
	 */
	private String strContentField;
	
	
	/**
	 * 排序值属性
	 */
	private String strOrderValueField ;
	/**
	 * 是否支持缓存
	 */
	private boolean bEnableCache = false;
	
	private int nCacheTimeout = -1;
	
	private String strCacheScope = null;
	
	private String strCacheTagField = null;
	
	private String strCacheTag2Field = null;
	
	private String strDSLink = null;
	
	private String strActiveDataDELogicId = null;
	
//	private ArrayList<IViewMsgModel> viewMsgModelList = new ArrayList<IViewMsgModel>();
//	private Boolean bPrepareViewMsgs = false;
	
	protected HashMap<String, ViewMsgCache> viewMsgCacheMap = new HashMap<String, ViewMsgCache>();
	
	protected IDataEntityModel iDEModel = null;

	
	@Override
	protected void onInit() throws Exception {
		iDEModel = DEModelGlobal.getDEModel(this.getDEName());
		super.onInit();
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsgModel#getDEName()
	 */
	@Override
	public String getDEName() {
		return this.strDEName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsgModel#getDEDataSetName()
	 */
	@Override
	public String getDEDataSetName() {
		return this.strDEDataSetName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsgModel#getTitleField()
	 */
	@Override
	public String getTitleField() {
		return this.strTitleField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsgModel#getTitleLanResTagField()
	 */
	@Override
	public String getTitleLanResTagField() {
		return this.strTitleLanResTagField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsgModel#getMsgTypeField()
	 */
	@Override
	public String getMsgTypeField() {
		return this.strMsgTypeField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsgModel#getMsgPosField()
	 */
	@Override
	public String getMsgPosField() {
		return this.strMsgPosField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsgModel#getRemoveFlagField()
	 */
	@Override
	public String getRemoveFlagField() {
		return this.strRemoveFlagField;
	}

	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsgModel#getContentField()
	 */
	@Override
	public String getContentField() {
		return this.strContentField;
	}

	
	
	/**
	 * 设置实体名称
	 * @param strDEName
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}

	/**
	 * 设置实体数据集合名称
	 * @param strDEDataSetName
	 */
	public void setDEDataSetName(String strDEDataSetName) {
		this.strDEDataSetName = strDEDataSetName;
	}

	/**
	 * 设置存放消息标题的属性名称
	 * @param strTitleField
	 */
	public void setTitleField(String strTitleField) {
		this.strTitleField = strTitleField;
	}

	/**
	 * 设置存放消息标题语言资源标识的属性名称
	 * @param strMsgPosField
	 */
	public void setTitleLanResTagField(String strTitleLanResTagField) {
		this.strTitleLanResTagField = strTitleLanResTagField;
	}

	/**
	 * 设置存放消息类型的属性名称
	 * @param strMsgPosField
	 */
	public void setMsgTypeField(String strMsgTypeField) {
		this.strMsgTypeField = strMsgTypeField;
	}

	/**
	 * 设置存放消息位置的属性名称
	 * @param strMsgPosField
	 */
	public void setMsgPosField(String strMsgPosField) {
		this.strMsgPosField = strMsgPosField;
	}

	/**
	 * 设置存放删除标志的属性名称
	 * @param strRemoveFlagField
	 */
	public void setRemoveFlagField(String strRemoveFlagField) {
		this.strRemoveFlagField = strRemoveFlagField;
	}

	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsg#getOrderValueField()
	 */
	@Override
	public String getOrderValueField() {
		return this.strOrderValueField;
	}

	
	/**
	 * 设置排序值属性
	 * @param strOrderValueField
	 */
	public void setOrderValueField(String strOrderValueField){
		this.strOrderValueField =strOrderValueField;
	}
	
	/**
	 * 设置存放内容的属性名称
	 * @param strContentField
	 */
	public void setContentField(String strContentField) {
		this.strContentField = strContentField;
	}

	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.StaticViewMsgModel#fillViewMessages(net.ibizsys.paas.controller.IViewController, java.util.ArrayList)
	 */
	@Override
	public int fillViewMessages(IViewController iViewController,ArrayList<IViewMsgModel> viewMessageList) throws Exception {
		ArrayList<IViewMsgModel> viewMsgModelList = prepareViewMsgs(iViewController);
		int nTotal = 0;
		for(IViewMsgModel iViewMsgModel: viewMsgModelList){
			nTotal+=	iViewMsgModel.fillViewMessages(iViewController, viewMessageList);
		}
		return nTotal;
	}
	
	
	
	
	/**
	 * 准备视图消息数据
	 * @throws Exception
	 */
	protected ArrayList<IViewMsgModel> prepareViewMsgs(IViewController iViewController) throws Exception {
		
		IEntity simpleEntity  = this.iDEModel.createEntity();
		this.getSystemModel().fillViewMsgActiveData(simpleEntity, this, iViewController);
		if(!StringHelper.isNullOrEmpty(this.getActiveDataDELogicId())){
			IService iService = this.getService(iViewController.getSessionFactory());
			iService.executeLogic(this.getActiveDataDELogicId(), simpleEntity);
		}
		String strCacheTag = null;
		if(this.isEnableCache()){
			strCacheTag = getCacheTag(simpleEntity);
			ViewMsgCache viewMsgCache = viewMsgCacheMap.get(strCacheTag);
			if(viewMsgCache!=null && (this.nCacheTimeout <= 0 || (viewMsgCache.nLastCacheTime + this.nCacheTimeout )>System.currentTimeMillis())){
				return viewMsgCache.viewMsgModelList;
			}
		}
		
		ArrayList<IViewMsgModel> viewMsgModelList = onPrepareViewMsgs(iViewController,simpleEntity);
		if(strCacheTag!=null){
			ViewMsgCache viewMsgCache = new ViewMsgCache();
			viewMsgCache.nLastCacheTime = System.currentTimeMillis();
			viewMsgCache.viewMsgModelList = viewMsgModelList;
			viewMsgCacheMap.put(strCacheTag, viewMsgCache);
			
		}
		return viewMsgModelList;
	}
	
	/**
	 * 准备视图消息
	 * @throws Exception
	 */
	protected ArrayList<IViewMsgModel> onPrepareViewMsgs(IViewController iViewController,IEntity simpleEntity) throws Exception {
		DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
		deDataSetFetchContextImpl.setActiveDataObject(simpleEntity);
		deDataSetFetchContextImpl.setFetchTotalRow(false);
		deDataSetFetchContextImpl.setPaging(false);
		fillDEDataSetFetchContext(deDataSetFetchContextImpl);
		DBFetchResult dbFetchResult = fetchDEDataSet(deDataSetFetchContextImpl,iViewController.getSessionFactory());
		if(dbFetchResult.isError()){
			throw new Exception(StringHelper.format("获取数据集发生错误，%1$s",dbFetchResult.getErrorInfo()));
		}
		ArrayList<IViewMsgModel> viewMsgModelList = new ArrayList<IViewMsgModel>();
		try{
			
			IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
			int nCacheRowCount = iDataTable.getCachedRowCount();
			if(nCacheRowCount ==-1){
				int nBatchSize = 50;
				while(true){
					int nRowCount = iDataTable.cacheRows(nBatchSize);
					for(int i = 0;i<nRowCount;i++){
						IDataRow iDataRow = iDataTable.getCachedRow(i);
						IViewMsgModel iViewMsg = createViewMsg(iDataRow);
						if(iViewMsg != null){
							viewMsgModelList.add(iViewMsg);
						}
					}
					if(nRowCount<nBatchSize)
						break;
				}
			}
			else{
				for(int i = 0 ;i<nCacheRowCount;i++){
					IDataRow iDataRow = iDataTable.getCachedRow(i);
					IViewMsgModel iViewMsg = createViewMsg(iDataRow);
					if(iViewMsg != null){
						viewMsgModelList.add(iViewMsg);
					}
				}
			}
		}
		catch(Exception ex){
			throw new Exception(StringHelper.format("获取数据集发生错误，%1$s",ex.getMessage()),ex);
		}
		finally{
			dbFetchResult.getDataSet().close();
		}	
		return viewMsgModelList;
	}
	
	/**
	 * 建立视图消息对象
	 * @param iDataRow
	 * @return
	 * @throws Exception
	 */
	protected IViewMsgModel createViewMsg(IDataRow iDataRow)throws Exception{
		
		StaticViewMsgModel viewMsgModel = new StaticViewMsgModel();
		
		if(StringHelper.isNullOrEmpty(this.getMsgTemplateId())){
			if(!StringHelper.isNullOrEmpty(this.getContentField())){
				viewMsgModel.setMessage(DataObject.getStringValue(iDataRow.get(this.getContentField()),null));
			}
		}
		else{
			IEntity iEntity = this.iDEModel.createEntity();
			DataObject.fromDataRow(iEntity, iDataRow);
			MsgTemplate msgTemplate = MsgTemplateGlobal.getMsgTemplate(this.getMsgTemplateId());
			MsgSendQueue msgSendQueue = MsgTemplateHelper.getMsgSendQueue(MsgTypes.INTERNAL, msgTemplate, iDEModel, iEntity, null,null,null,null,null);
			viewMsgModel.setMessage(msgSendQueue.getContent());
			viewMsgModel.setTitle(msgSendQueue.getSubject());
		}
		
		if(StringHelper.isNullOrEmpty(viewMsgModel.getTitle())){
			if(!StringHelper.isNullOrEmpty(this.getTitleField())){
				viewMsgModel.setTitle(DataObject.getStringValue(iDataRow.get(this.getTitleField()),null));
			}
		}
		
		if(!StringHelper.isNullOrEmpty(this.getMsgPosField())){
			viewMsgModel.setPosition(DataObject.getStringValue(iDataRow.get(this.getMsgPosField()),null));
		}
		else{
			viewMsgModel.setPosition(this.getPosition());
		}
		if(!StringHelper.isNullOrEmpty(this.getMsgTypeField())){
			viewMsgModel.setMessageType(DataObject.getStringValue(iDataRow.get(this.getMsgTypeField()),null));
		}
		else{
			viewMsgModel.setMessageType(this.getMessageType());
		}
		if(!StringHelper.isNullOrEmpty(this.getRemoveFlagField())){
			viewMsgModel.setEnableRemove(DataObject.getIntegerValue(iDataRow.get(this.getRemoveFlagField()),0)==1);
		}
		else{
			viewMsgModel.setEnableRemove(this.isEnableRemove());
		}
		if(!StringHelper.isNullOrEmpty(this.getOrderValueField())){
			viewMsgModel.setOrderValue(DataObject.getIntegerValue(iDataRow.get(this.getOrderValueField()),this.getOrderValue()));
		}
		
		if(StringHelper.isNullOrEmpty(viewMsgModel.getMessage()))
			return null;
		
		return viewMsgModel;
	}
	

	/**
	 * 填充获取数据上下文对象
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		onFillDEDataSetFetchContext(deDataSetFetchContextImpl);
	}

	/**
	 * 填充获取数据上下文对象
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {

	}
	
	/**
	 * 获取实体数据集合结果
	 * 
	 * @param deDataSetFetchContextImpl
	 * @return
	 * @throws Exception
	 */
	protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl,SessionFactory sessionFactory) throws Exception {
		IService iService = getService(sessionFactory);	
		
		return iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);
	}
	
	protected IService getService(SessionFactory sessionFactory)throws Exception {
		if(StringHelper.isNullOrEmpty(this.getDSLink())){
			return iDEModel.getService(sessionFactory);
		}
		else{
			return iDEModel.getService(((ISystemRuntime)this.getSystemModel()).getSessionFactory(this.getDSLink()));
		}
	}

	@Override
	public boolean isEnableCache() {
		return this.bEnableCache;
	}

	@Override
	public String getCacheScope() {
		return this.strCacheScope;
	}

	@Override
	public int getCacheTimeout() {
		return nCacheTimeout;
	}

	@Override
	public String getCacheTagField() {
		return this.strCacheTagField;
	}

	@Override
	public String getCacheTag2Field() {
		return this.strCacheTag2Field;
	}

	/**
	 * 设置是否支持缓存
	 * @param bEnableCache
	 */
	public void setEnableCache(boolean bEnableCache) {
		this.bEnableCache = bEnableCache;
	}

	/**
	 * 设置缓存超时
	 * @param nCacheTimeout
	 */
	public void setCacheTimeout(int nCacheTimeout) {
		this.nCacheTimeout = nCacheTimeout;
	}

	/**
	 * 设置缓存范围
	 * @param strCacheScope
	 */
	public void setCacheScope(String strCacheScope) {
		this.strCacheScope = strCacheScope;
	}

	/**
	 * 设置缓存标识属性
	 * @param strCacheTagField
	 */
	public void setCacheTagField(String strCacheTagField) {
		this.strCacheTagField = strCacheTagField;
	}

	/**
	 * 设置缓存标识2属性
	 * @param strCacheTag2Field
	 */
	public void setCacheTag2Field(String strCacheTag2Field) {
		this.strCacheTag2Field = strCacheTag2Field;
	}

	@Override
	public void resetCache() {
		viewMsgCacheMap.clear();
	}
	
	/**
	 * 获取数据源链接
	 * 
	 * @return
	 */
	@Override
	public String getDSLink() {
		return this.strDSLink;
	}

	/**
	 * 设置实体数据连接
	 * 
	 * @param strDSLink
	 */
	public void setDSLink(String strDSLink) {
		this.strDSLink = strDSLink;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IDEDataSetViewMsg#getActiveDataDELogicId()
	 */
	@Override
	public String getActiveDataDELogicId() {
		return this.strActiveDataDELogicId;
	}
	
	/**
	 * 设置上下文数据计算逻辑
	 * @param strActiveDataDELogicId
	 */
	public void setActiveDataDELogicId(String strActiveDataDELogicId){
		this.strActiveDataDELogicId = strActiveDataDELogicId;
	}
	
	protected String getCacheTag(IEntity iEntity) throws Exception{
		if(StringHelper.isNullOrEmpty(this.getCacheTag2Field())){
			
			return StringHelper.format("%1$s_null",iEntity.get(this.getCacheTagField()));
		}
		else
			return StringHelper.format("%1$s_%2$s",iEntity.get(this.getCacheTagField()),iEntity.get(this.getCacheTag2Field()));
	}
	
	
	
}
