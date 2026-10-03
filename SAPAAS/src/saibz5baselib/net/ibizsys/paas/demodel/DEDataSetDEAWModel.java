package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.HashMap;

import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IViewWizard;

/**
 * 
 * 实体操作向导（数据集合模式）对象接口实现
 * @author Administrator
 *
 */
public class DEDataSetDEAWModel extends DEActionWizardModel implements IDEDataSetDEAWModel {

	protected ArrayList<IDEActionWizardModel> deActionWizardList = new ArrayList<IDEActionWizardModel>();
	protected HashMap<String, IDEActionWizardModel> deActionWizardMap = new HashMap<String, IDEActionWizardModel>();
	
	private Boolean bPrepareDEActionWizards = false;
	
	private Object objPrepareDEActionWizardsLock = new Object();
	
	/**
	 * 获取操作向导实体名称
	 * @return
	 */
	String strAWDEName;
	
	
	/**
	 * 获取操作向导实体数据集合名称
	 * @return
	 */
	String strAWDEDataSetName;
	
	
	
	/**
	 * 获取操作向导名称属性
	 * @return
	 */
	String strAWNameField;
	
	
	/**
	 * 获取操作向导关键字属性
	 * @return
	 */
	String strAWKeywordField;
	
	
	
	
	/**
	 * 获取操作向导排序属性
	 * @return
	 */
	String strAWSortField;
	

	
	
	/**
	 * 获取操作向导项实体名称
	 * @return
	 */
	String strAWIDEName;
	
	
	
	/**
	 * 获取操作向导项实体数据集合名称
	 * @return
	 */
	String strAWIDEDataSetName;
	
	
	

	/**
	 * 获取操作向导项名称属性
	 * @return
	 */
	String strAWINameField;
	
	
	
	/**
	 * 获取操作向导项值属性
	 * @return
	 */
	String strAWIValueField;
	
	
	
	/**
	 * 获取操作向导项外键属性
	 * @return
	 */
	String strAWIFKeyField;
	
	
	
	/**
	 * 获取操作向导项内容属性
	 * @return
	 */
	String strAWIContentField;
	
	
	/**
	 * 获取操作向导项Url属性
	 * @return
	 */
	String strAWIUrlField;
	
	
	
	/**
	 * 获取操作向导项排序属性
	 * @return
	 */
	String strAWISortField;
	
	
	/**
	 *  操作向导实体主键
	 */
	String strAWKeyField ;
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWDEName()
	 */
	@Override
	public String getAWDEName() {
		return strAWDEName;
	}



	/**
	 * 设置操作向导实体名称
	 * @param strAWDEName
	 */
	public void setAWDEName(String strAWDEName) {
		this.strAWDEName = strAWDEName;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWDEDataSetName()
	 */
	@Override
	public String getAWDEDataSetName() {
		return strAWDEDataSetName;
	}



	/**
	 * 设置操作向导数据集合名称
	 * @param strAWDEDataSetName
	 */
	public void setAWDEDataSetName(String strAWDEDataSetName) {
		this.strAWDEDataSetName = strAWDEDataSetName;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWNameField()
	 */
	@Override
	public String getAWNameField() {
		return strAWNameField;
	}



	/**
	 * 设置操作向导名称值属性
	 * @param strAWNameField
	 */
	public void setAWNameField(String strAWNameField) {
		this.strAWNameField = strAWNameField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWKeywordField()
	 */
	@Override
	public String getAWKeywordField() {
		return strAWKeywordField;
	}


	
	/**
	 * 设置操作向导关键字值属性
	 * @param strAWKeywordField
	 */
	public void setAWKeywordField(String strAWKeywordField) {
		this.strAWKeywordField = strAWKeywordField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWSortField()
	 */
	@Override
	public String getAWSortField() {
		return strAWSortField;
	}



	/**
	 * 设置操作向导排序值属性
	 * @param strAWSortField
	 */
	public void setAWSortField(String strAWSortField) {
		this.strAWSortField = strAWSortField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWIDEName()
	 */
	@Override
	public String getAWIDEName() {
		return strAWIDEName;
	}



	/**
	 * 设置操作项实体名称
	 * @param strAWIDEName
	 */
	public void setAWIDEName(String strAWIDEName) {
		this.strAWIDEName = strAWIDEName;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWIDEDataSetName()
	 */
	@Override
	public String getAWIDEDataSetName() {
		return strAWIDEDataSetName;
	}



	/**
	 * 设置操作项数据集合名称
	 * @param strAWIDEDataSetName
	 */
	public void setAWIDEDataSetName(String strAWIDEDataSetName) {
		this.strAWIDEDataSetName = strAWIDEDataSetName;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWINameField()
	 */
	@Override
	public String getAWINameField() {
		return strAWINameField;
	}



	/**
	 * 设置操作项名称值属性
	 * @param strAWINameField
	 */
	public void setAWINameField(String strAWINameField) {
		this.strAWINameField = strAWINameField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWIValueField()
	 */
	@Override
	public String getAWIValueField() {
		return strAWIValueField;
	}



	/**
	 * 设置操作项操作值值属性
	 * @param strAWIValueField
	 */
	public void setAWIValueField(String strAWIValueField) {
		this.strAWIValueField = strAWIValueField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWIFKeyField()
	 */
	@Override
	public String getAWIFKeyField() {
		return strAWIFKeyField;
	}



	/**
	 * 设置操作项外键值属性
	 * @param strAWIFKeyField
	 */
	public void setAWIFKeyField(String strAWIFKeyField) {
		this.strAWIFKeyField = strAWIFKeyField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWIContentField()
	 */
	@Override
	public String getAWIContentField() {
		return strAWIContentField;
	}



	/**
	 * 设置操作项内容值属性
	 * @param strAWIContentField
	 */
	public void setAWIContentField(String strAWIContentField) {
		this.strAWIContentField = strAWIContentField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWIUrlField()
	 */
	@Override
	public String getAWIUrlField() {
		return strAWIUrlField;
	}



	/**
	 * 设置操作项链接值属性
	 * @param strAWIUrlField
	 */
	public void setAWIUrlField(String strAWIUrlField) {
		this.strAWIUrlField = strAWIUrlField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataSetDEAW#getAWISortField()
	 */
	@Override
	public String getAWISortField() {
		return strAWISortField;
	}



	/**
	 * 设置操作项排序值属性
	 * @param strAWISortField
	 */
	public void setAWISortField(String strAWISortField) {
		this.strAWISortField = strAWISortField;
	}
	
	
	@Override
	public int fillViewWizards(IViewController iViewController, String strQuery, ArrayList<IViewWizard> viewWizardList) throws Exception {
		int nTotal = 0;
		this.prepareDEActionWizards();
		for(IDEActionWizard iDEActionWizard:deActionWizardList){
			nTotal += ((IDEActionWizardModel)iDEActionWizard).fillViewWizards(iViewController,strQuery, viewWizardList);
		}
		return nTotal;
	}




	/**
	 * 准备实体操作向导数据
	 * @throws Exception
	 */
	protected void prepareDEActionWizards() throws Exception {
		synchronized (objPrepareDEActionWizardsLock) {
			if(bPrepareDEActionWizards)
				return;
			onPrepareDEActionWizards();			
			bPrepareDEActionWizards = true;
		}
	}
	
	/**
	 * 准备实体操作向导
	 * @throws Exception
	 */
	protected void onPrepareDEActionWizards() throws Exception {
		
		this.deActionWizardMap.clear();
		this.deActionWizardList.clear();
		
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getAWDEName());
		this.strAWKeyField = iDataEntityModel.getKeyDEField().getName();
		if(true){
			DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
			fillAWDEDataSetFetchContext(deDataSetFetchContextImpl);
			DBFetchResult dbFetchResult = fetchAWDEDataSet(deDataSetFetchContextImpl);
			if(dbFetchResult.isError()){
				throw new Exception(StringHelper.format("获取操作向导数据集发生错误，%1$s",dbFetchResult.getErrorInfo()));
			}
			try{
				IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
				int nCacheRowCount = iDataTable.getCachedRowCount();
				if(nCacheRowCount ==-1){
					int nBatchSize = 50;
					while(true){
						int nRowCount = iDataTable.cacheRows(nBatchSize);
						for(int i = 0;i<nRowCount;i++){
							IDataRow iDataRow = iDataTable.getCachedRow(i);
							IDEActionWizardModel iDEActionWizardModel = createDEActionWizardModel(iDataRow);
							if(iDEActionWizardModel != null){
								if(StringHelper.isNullOrEmpty(iDEActionWizardModel.getId())){
									throw new Exception("没有指定实体操作向导唯一标识");
								}
								deActionWizardMap.put(iDEActionWizardModel.getId(), iDEActionWizardModel);
								deActionWizardList.add(iDEActionWizardModel);
							}
						}
						if(nRowCount<nBatchSize)
							break;
					}
				}
				else{
					for(int i = 0 ;i<nCacheRowCount;i++){
						IDataRow iDataRow = iDataTable.getCachedRow(i);
						IDEActionWizardModel iDEActionWizardModel = createDEActionWizardModel(iDataRow);
						if(iDEActionWizardModel != null){
							if(StringHelper.isNullOrEmpty(iDEActionWizardModel.getId())){
								throw new Exception("没有指定实体操作向导唯一标识");
							}
							deActionWizardMap.put(iDEActionWizardModel.getId(), iDEActionWizardModel);
							deActionWizardList.add(iDEActionWizardModel);
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
		}
		
		if(true){
			DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
			fillAWIDEDataSetFetchContext(deDataSetFetchContextImpl);
			DBFetchResult dbFetchResult = fetchAWIDEDataSet(deDataSetFetchContextImpl);
			if(dbFetchResult.isError()){
				throw new Exception(StringHelper.format("获取操作向导项数据集发生错误，%1$s",dbFetchResult.getErrorInfo()));
			}
			try{
				IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
				int nCacheRowCount = iDataTable.getCachedRowCount();
				if(nCacheRowCount ==-1){
					int nBatchSize = 50;
					while(true){
						int nRowCount = iDataTable.cacheRows(nBatchSize);
						for(int i = 0;i<nRowCount;i++){
							IDataRow iDataRow = iDataTable.getCachedRow(i);
							IDEActionWizardItemModel iDEActionWizardItemModel = createDEActionWizardItemModel(iDataRow);
							String strDEActionWizardId = DataObject.getStringValue(iDataRow.get(this.getAWIFKeyField()),null);
							if(iDEActionWizardItemModel == null)
								continue;
							
							if(StringHelper.isNullOrEmpty(strDEActionWizardId)){
								throw new Exception("没有指定实体操作向导唯一标识");
							}
							
							IDEActionWizardModel iDEActionWizardModel = deActionWizardMap.get(strDEActionWizardId);
							if(iDEActionWizardModel == null){
								throw new Exception(StringHelper.format("无法获取实体操作向导[%1$s]",strDEActionWizardId));
							}
							iDEActionWizardModel.registerDEActionWizardItemModel(iDEActionWizardItemModel);
						}
						if(nRowCount<nBatchSize)
							break;
					}
				}
				else{
					for(int i = 0 ;i<nCacheRowCount;i++){
						IDataRow iDataRow = iDataTable.getCachedRow(i);
						IDEActionWizardItemModel iDEActionWizardItemModel = createDEActionWizardItemModel(iDataRow);
						String strDEActionWizardId = DataObject.getStringValue(iDataRow.get(this.getAWIFKeyField()),null);
						if(iDEActionWizardItemModel == null)
							continue;
						
						if(StringHelper.isNullOrEmpty(strDEActionWizardId)){
							throw new Exception("没有指定实体操作向导唯一标识");
						}
						
						IDEActionWizardModel iDEActionWizardModel = deActionWizardMap.get(strDEActionWizardId);
						if(iDEActionWizardModel == null){
							throw new Exception(StringHelper.format("无法获取实体操作向导[%1$s]",strDEActionWizardId));
						}
						iDEActionWizardModel.registerDEActionWizardItemModel(iDEActionWizardItemModel);
					}
				}
			}
			catch(Exception ex){
				throw new Exception(StringHelper.format("获取数据集发生错误，%1$s",ex.getMessage()),ex);
			}
			finally{
				dbFetchResult.getDataSet().close();
			}	
		}
		
	}
	
	/**
	 * 建立实体操作向导对象
	 * @param iDataRow
	 * @return
	 * @throws Exception
	 */
	protected IDEActionWizardModel createDEActionWizardModel(IDataRow iDataRow)throws Exception{
		
		DEActionWizardModel deActionWizardModel = new DEActionWizardModel();
		String strKey = DataObject.getStringValue(iDataRow.get(this.strAWKeyField),null);
		deActionWizardModel.setId(strKey);
		if(!StringHelper.isNullOrEmpty(this.getAWNameField())){
			deActionWizardModel.setName(DataTypeHelper.getStringValue(iDataRow,this.getAWNameField(),null));
		}
		return deActionWizardModel;
	}

	/**
	 * 建立实体操作向导项对象
	 * @param iDataRow
	 * @return
	 * @throws Exception
	 */
	protected IDEActionWizardItemModel createDEActionWizardItemModel(IDataRow iDataRow)throws Exception{
		
		DEActionWizardItemModel deActionWizardItemModel = new DEActionWizardItemModel();
		if(!StringHelper.isNullOrEmpty(this.getAWINameField())){
			deActionWizardItemModel.setName(DataTypeHelper.getStringValue(iDataRow,this.getAWINameField(),null));
		}
		
		if(!StringHelper.isNullOrEmpty(this.getAWIContentField())){
			deActionWizardItemModel.setContent(DataTypeHelper.getStringValue(iDataRow,this.getAWIContentField(),null));
		}

		if(!StringHelper.isNullOrEmpty(this.getAWIUrlField())){
			deActionWizardItemModel.setMoreUrl(DataTypeHelper.getStringValue(iDataRow,this.getAWIUrlField(),null));
		}
		
		if(!StringHelper.isNullOrEmpty(this.getAWIValueField())){
			deActionWizardItemModel.setActionValue(DataTypeHelper.getStringValue(iDataRow,this.getAWIValueField(),null));
		}
		
//		if(!StringHelper.isNullOrEmpty(this.getAWSortField())){
//			deActionWizardModel.set(DataTypeHelper.getIntegerValue(iDataRow,this.getEnableCloseField(),1) == 1);
//		}
//		if(!StringHelper.isNullOrEmpty(this.getaw())){
//			deActionWizardModel.setMoreUrl(DataTypeHelper.getStringValue(iDataRow,this.getLinkField(),null));
//		}
//		if(!StringHelper.isNullOrEmpty(this.getUniqueTagField())){
//			deActionWizardModel.setUniqueTag(DataTypeHelper.getStringValue(iDataRow,this.getUniqueTagField(),null));
//		}
		return deActionWizardItemModel;
	}
	
	

	/**
	 * 填充获取数据上下文对象（AW数据集合）
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void fillAWDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		if(!StringHelper.isNullOrEmpty(this.getAWSortField())){
			deDataSetFetchContextImpl.setSort(this.getAWSortField());
		}
		onFillAWDEDataSetFetchContext(deDataSetFetchContextImpl);
	}

	/**
	 * 填充获取数据上下文对象（AW数据集合）
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void onFillAWDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {

	}
	
	/**
	 * 填充获取数据上下文对象（AWI数据集合）
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void fillAWIDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		if(!StringHelper.isNullOrEmpty(this.getAWISortField())){
			deDataSetFetchContextImpl.setSort(this.getAWISortField());
		}
		onFillAWIDEDataSetFetchContext(deDataSetFetchContextImpl);
	}

	/**
	 * 填充获取数据上下文对象（AWI数据集合）
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void onFillAWIDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {

	}
	
	/**
	 * 获取操作向导实体数据集合结果
	 * @param deDataSetFetchContextImpl
	 * @return
	 * @throws Exception
	 */
	protected DBFetchResult fetchAWDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getAWDEName());
		IService iService = iDataEntityModel.getService();
		return iService.fetchDataSet(this.getAWDEDataSetName(), deDataSetFetchContextImpl);
	}
	
	/**
	 * 获取操作向导项实体数据集合结果
	 * @param deDataSetFetchContextImpl
	 * @return
	 * @throws Exception
	 */
	protected DBFetchResult fetchAWIDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getAWIDEName());
		IService iService = iDataEntityModel.getService();
		return iService.fetchDataSet(this.getAWIDEDataSetName(), deDataSetFetchContextImpl);
	}
}
