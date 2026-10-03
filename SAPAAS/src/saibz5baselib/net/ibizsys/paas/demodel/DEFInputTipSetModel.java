package net.ibizsys.paas.demodel;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEFInputTip;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

/**
 * 实体属性输入提示集合模型对象接口实现
 * @author Administrator
 *
 */
public class DEFInputTipSetModel extends SystemModelObjectBase implements IDEFInputTipSetModel {

	private static final Log log = LogFactory.getLog(DEFInputTipSetModel.class);
	
	/**
	 * 实体名称
	 * 
	 */
	String strDEName;

	/**
	 * 实体数据集合名称
	 * 
	 */
	String strDEDataSetName;

	
	/**
	 * 可关闭标记属性
	 
	 */
	String strEnableCloseField;
	
	
	
	/**
	 * 内容属性
	 */
	String strContentField;
	
	
	
	/**
	 * 唯一标识属性
	 */
	String strUniqueTagField;
	
	
	
	/**
	 * 链接属性
	 */
	String strLinkField;

	
	protected Boolean bPrepareDEFInputTips = false;
	
	private Object objPrepareDEFInputTips = new Object();
	
	protected HashMap<String ,IDEFInputTip> defInputTipMap = new HashMap<String ,IDEFInputTip>();
	
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.setSystemModel(iSystemModel);
		this.onInit();
	}
	
	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTipSet#getDEName()
	 */
	@Override
	public String getDEName() {
		return strDEName;
	}



	/**
	 * 设置实体名称
	 * @param strDEName
	 */
	public void setDEName(String strDEName) {
		this.strDEName = strDEName;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTipSet#getDEDataSetName()
	 */
	@Override
	public String getDEDataSetName() {
		return strDEDataSetName;
	}



	/**
	 * 设置实体数据集合名称
	 * @param strDEDataSetName
	 */
	public void setDEDataSetName(String strDEDataSetName) {
		this.strDEDataSetName = strDEDataSetName;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTipSet#getEnableCloseField()
	 */
	@Override
	public String getEnableCloseField() {
		return strEnableCloseField;
	}



	/**
	 * 设置允许关闭值属性
	 * @param strEnableCloseField
	 */
	public void setEnableCloseField(String strEnableCloseField) {
		this.strEnableCloseField = strEnableCloseField;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTipSet#getContentField()
	 */
	@Override
	public String getContentField() {
		return strContentField;
	}



	/**
	 * 设置内容值属性
	 * @param strContentField
	 */
	public void setContentField(String strContentField) {
		this.strContentField = strContentField;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTipSet#getUniqueTagField()
	 */
	@Override
	public String getUniqueTagField() {
		return strUniqueTagField;
	}



	/**
	 * 设置唯一标识值属性
	 * @param strUniqueTagField
	 */
	public void setUniqueTagField(String strUniqueTagField) {
		this.strUniqueTagField = strUniqueTagField;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEFInputTipSet#getLinkField()
	 */
	@Override
	public String getLinkField() {
		return strLinkField;
	}



	/**
	 * 设置链接值属性
	 * @param strLinkField
	 */
	public void setLinkField(String strLinkField) {
		this.strLinkField = strLinkField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDEFInputTipSetModel#getDEFInputTip(java.lang.String)
	 */
	@Override
	public IDEFInputTip getDEFInputTip(String strUniqueTag) throws Exception {
		return getDEFInputTip(strUniqueTag,false);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDEFInputTipSetModel#getDEFInputTip(java.lang.String, boolean)
	 */
	@Override
	public IDEFInputTip getDEFInputTip(String strUniqueTag, boolean bTryMode) throws Exception {
		prepareDEFInputTips();
		IDEFInputTip iDEFInputTip = defInputTipMap.get(strUniqueTag);
		if(iDEFInputTip == null){
			if(!bTryMode){
				throw new Exception(StringHelper.format("无法获取输入提示标识[%1$s]",strUniqueTag));
			}
			log.warn(StringHelper.format("无法获取输入提示标识[%1$s]",strUniqueTag));
		}
		return iDEFInputTip;
	}



	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDEFInputTipSetModel#prepareDEFInputTips()
	 */
	@Override
	public void prepareDEFInputTips() throws Exception {
		synchronized (objPrepareDEFInputTips) {
			if(bPrepareDEFInputTips)
				return;
			onPrepareDEFInputTips();			
			bPrepareDEFInputTips = true;
		}
	}
	
	/**
	 * 准备属性输入提示
	 * @throws Exception
	 */
	protected void onPrepareDEFInputTips() throws Exception {
		
		DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
		deDataSetFetchContextImpl.setFetchTotalRow(false);
		deDataSetFetchContextImpl.setPaging(false);
		fillDEDataSetFetchContext(deDataSetFetchContextImpl);
		DBFetchResult dbFetchResult = fetchDEDataSet(deDataSetFetchContextImpl);
		if(dbFetchResult.isError()){
			throw new Exception(StringHelper.format("获取数据集发生错误，%1$s",dbFetchResult.getErrorInfo()));
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
						IDEFInputTip iDEFInputTip = createDEFInputTip(iDataRow);
						if(iDEFInputTip != null){
							if(StringHelper.isNullOrEmpty(iDEFInputTip.getUniqueTag())){
								throw new Exception("没有指定属性输入提示唯一标识");
							}
							
							defInputTipMap.put(iDEFInputTip.getUniqueTag(), iDEFInputTip);
						}
					}
					if(nRowCount<nBatchSize)
						break;
				}
			}
			else{
				for(int i = 0 ;i<nCacheRowCount;i++){
					IDataRow iDataRow = iDataTable.getCachedRow(i);
					IDEFInputTip iDEFInputTip = createDEFInputTip(iDataRow);
					if(iDEFInputTip != null){
						if(StringHelper.isNullOrEmpty(iDEFInputTip.getUniqueTag())){
							throw new Exception("没有指定属性输入提示唯一标识");
						}
						
						defInputTipMap.put(iDEFInputTip.getUniqueTag(), iDEFInputTip);
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
	
	/**
	 * 建立属性输入提示对象
	 * @param iDataRow
	 * @return
	 * @throws Exception
	 */
	protected IDEFInputTip createDEFInputTip(IDataRow iDataRow)throws Exception{
		
		DEFInputTipModel defInputTipModel = new DEFInputTipModel();
		if(!StringHelper.isNullOrEmpty(this.getContentField())){
			defInputTipModel.setContent(DataObject.getStringValue(iDataRow.get(this.getContentField()),null));
		}
		if(!StringHelper.isNullOrEmpty(this.getEnableCloseField())){
			defInputTipModel.setEnableClose(DataTypeHelper.getIntegerValue(iDataRow,this.getEnableCloseField(),1) == 1);
		}
		if(!StringHelper.isNullOrEmpty(this.getLinkField())){
			defInputTipModel.setMoreUrl(DataTypeHelper.getStringValue(iDataRow,this.getLinkField(),null));
		}
		if(!StringHelper.isNullOrEmpty(this.getUniqueTagField())){
			defInputTipModel.setUniqueTag(DataTypeHelper.getStringValue(iDataRow,this.getUniqueTagField(),null));
		}
		return defInputTipModel;
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
	protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(this.getDEName());
		IService iService = iDataEntityModel.getService();
		return iService.fetchDataSet(this.getDEDataSetName(), deDataSetFetchContextImpl);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDEFInputTipSetModel#resetAll()
	 */
	@Override
	public void resetAll() {
		synchronized (objPrepareDEFInputTips) {
			if(!bPrepareDEFInputTips)
				return;
			defInputTipMap.clear();
			bPrepareDEFInputTips = false;
		}
	}
	
	
	
}
