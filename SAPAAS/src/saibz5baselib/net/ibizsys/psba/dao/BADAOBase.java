package net.ibizsys.psba.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.psba.core.IBACallContext;
import net.ibizsys.psba.core.IBAColumn;
import net.ibizsys.psba.core.IBADialect;
import net.ibizsys.psba.core.IBASchemeRuntime;
import net.ibizsys.psba.core.IBATable;
import net.ibizsys.psba.entity.IBAEntity;
import net.ibizsys.psba.entity.IBAEntityActionHelper;
import net.ibizsys.psrt.srv.web.WebContext;

/**
 * 大数据体系数据访问对象
 * 
 * @author Administrator
 *
 * @param <ET>
 */
public abstract class BADAOBase<ET extends IBAEntity> implements IBADAO<ET>, IBACallContext {

	private static final Log log = LogFactory.getLog(BADAOBase.class);

	private ThreadPoolExecutor threadPoolExecutor = null;
	
	
	protected class DBCallResultProxy {
		private DBCallResult dbCallResult = null;

		public DBCallResult getDBCallResult() {
			return this.dbCallResult;
		}

		public void setDBCallResult(DBCallResult dbCallResult) {
			this.dbCallResult = dbCallResult;
		}
	}

	
	
	/**
	 * 获取DAO对象的标识
	 * 
	 * @return
	 */
	protected String getBADAOId() {
		return null;
	}



	@Override
	public IWebContext getWebContext() {
		return WebContext.getCurrent();
	}

	private IBAEntityActionHelper iBAEntityActionHelper= null;
	
	
	protected ThreadPoolExecutor createThreadPoolExecutor() {
		return new ThreadPoolExecutor(0, 10, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100),
		          new ThreadPoolExecutor.AbortPolicy());
	}
	
	/**
	 * 获取查询线程池
	 * @return
	 * @throws Exception
	 */
	protected synchronized ThreadPoolExecutor getSelectThreadPoolExecutor(){
		if(threadPoolExecutor == null)
			threadPoolExecutor = createThreadPoolExecutor();
		return threadPoolExecutor;
	}
	
	/**
	 * 获取工作线程池
	 * @return
	 * @throws Exception
	 */
	protected synchronized ThreadPoolExecutor getWorkThreadPoolExecutor(){
		if(threadPoolExecutor == null)
			threadPoolExecutor = createThreadPoolExecutor();
		return threadPoolExecutor;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.dao.IBADAO#getBAEntityActionHelper()
	 */
	public IBAEntityActionHelper getBAEntityActionHelper()throws Exception{
		if(iBAEntityActionHelper != null)
			return iBAEntityActionHelper;
		BAEntityActionHelperImpl iBAEntityActionHelper = new BAEntityActionHelperImpl();
		iBAEntityActionHelper.init(this);
		this.iBAEntityActionHelper = iBAEntityActionHelper;
		return this.iBAEntityActionHelper;
	}
	
	@Override
	public void executeGetCmd(IBAEntity et, String[] families) throws Exception {
		et.setActionHelper(this.getBAEntityActionHelper());
		final IBAEntity et2 = et;
		final IBACallContext iBACallContext = this;
		final String[] families2 = families;
		
		// 执行作业
		this.doWork(new IBADAOWork() {
			@Override
			public void execute(Object connection) throws Exception {
				getRealBADialect().executeGetCmd(iBACallContext, connection, et2, families2);
				
			}
		});
	}
	


	
	@Override
	public void executeCreateCmd(IBAEntity et, String[] families) throws Exception {
		final IBAEntity et2 = et;
		final IBACallContext iBACallContext = this;
		final String[] families2 = families;

		// 执行作业
		this.doWork(new IBADAOWork() {
			@Override
			public void execute(Object connection) throws Exception {
				HashMap<IBAColumn, Object> insertColumnsMap = new HashMap<IBAColumn, Object>();
				if(!fillInsertColumnMap(insertColumnsMap, et2, families2))
					return;
				onBeforeCreate(iBACallContext, connection, insertColumnsMap, et2, families2);
				getRealBADialect().executeCreateCmd(iBACallContext, connection, insertColumnsMap, et2, families2);
				onAfterCreate(iBACallContext, connection, insertColumnsMap, et2, families2);
			}
		});
	}
	
	
	
	@Override
	public void executeBatchCreateCmd(IBAEntity[] ets, String[] families) throws Exception {
		final IBAEntity[] ets2 = ets;
		final IBACallContext iBACallContext = this;
		final String[] families2 = families;

		// 执行作业
		this.doWork(new IBADAOWork() {
			@Override
			public void execute(Object connection) throws Exception {
				
				HashMap<IBAEntity,HashMap<IBAColumn, Object>> baEntityMap = new HashMap<IBAEntity,HashMap<IBAColumn, Object>>();
				List<Map<IBAColumn, Object>> list = new ArrayList<Map<IBAColumn, Object>>();
				List<IBAEntity> etlist = new ArrayList<IBAEntity>();
				for(IBAEntity et2:ets2){
					HashMap<IBAColumn, Object> insertColumnsMap = new HashMap<IBAColumn, Object>();
					if(!fillInsertColumnMap(insertColumnsMap, et2, families2))
						continue;
					baEntityMap.put(et2, insertColumnsMap);
					etlist.add(et2);
					onBeforeCreate(iBACallContext, connection, insertColumnsMap, et2, families2);
					list.add(insertColumnsMap);
				}
				
				getRealBADialect().executeBatchCreateCmd(iBACallContext, connection, list, etlist.toArray(new IBAEntity[etlist.size()]), families2);
				
				for(IBAEntity et2:ets2){
					HashMap<IBAColumn, Object> insertColumnsMap = baEntityMap.get(et2);
					if(insertColumnsMap == null)
						continue;
					onAfterCreate(iBACallContext, connection, insertColumnsMap, et2, families2);
				}
			}
		});
	}
	
	/**
	 * 数据建立之前调用
	 * @param iBACallContext
	 * @param connection
	 * @param columnsMap
	 * @param et
	 * @param bTempMode
	 * @throws Exception
	 */
	protected void onBeforeCreate(IBACallContext iBACallContext, Object connection, java.util.Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception{
		
	}
	
	
	/**
	 * 数据建立之后调用
	 * @param iBACallContext
	 * @param connection
	 * @param columnsMap
	 * @param et
	 * @param bTempMode
	 * @throws Exception
	 */
	protected void onAfterCreate(IBACallContext iBACallContext, Object connection, java.util.Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception{
		
	}

	
	
	@Override
	public void executeUpdateCmd(IBAEntity et, String[] families) throws Exception {
		final IBAEntity et2 = et;
		final IBACallContext iBACallContext = this;
		final String[] families2 = families;

		// 执行作业
		this.doWork(new IBADAOWork() {
			@Override
			public void execute(Object connection) throws Exception {
				HashMap<IBAColumn, Object> updateColumnsMap = new HashMap<IBAColumn, Object>();
				if(!fillUpdateColumnMap(updateColumnsMap, et2, families2, false))
					return;
				onBeforeUpdate(iBACallContext, connection, updateColumnsMap, et2, families2);
				getRealBADialect().executeUpdateCmd(iBACallContext, connection, updateColumnsMap, et2, families2);
				onAfterUpdate(iBACallContext, connection, updateColumnsMap, et2, families2);
			}
		});
	}
	

	/**
	 * 更新之前调用
	 * @param iBACallContext
	 * @param connection
	 * @param columnsMap
	 * @param et
	 * @param families
	 * @throws Exception
	 */
	protected void onBeforeUpdate(IBACallContext iBACallContext, Object connection, java.util.Map<IBAColumn, Object> columnsMap, IBAEntity et,String[] families) throws Exception{
		
	}

	/**
	 * 更新之后调用
	 * @param iBACallContext
	 * @param connection
	 * @param columnsMap
	 * @param et
	 * @param bTempMode
	 * @throws Exception
	 */
	protected void onAfterUpdate(IBACallContext iBACallContext, Object connection, java.util.Map<IBAColumn, Object> columnsMap, IBAEntity et,String[] families) throws Exception{
		
	}

	
	/**
	 * 系统更新之前调用
	 * @param iBACallContext
	 * @param connection
	 * @param columnsMap
	 * @param et
	 * @param families
	 * @throws Exception
	 */
	protected void onBeforeSysUpdate(IBACallContext iBACallContext, Object connection, java.util.Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception{
		
	}

	/**
	 * 系统更新之后调用
	 * @param iBACallContext
	 * @param connection
	 * @param columnsMap
	 * @param et
	 * @param bTempMode
	 * @throws Exception
	 */
	protected void onAfterSysUpdate(IBACallContext iBACallContext, Object connection, java.util.Map<IBAColumn, Object> columnsMap, IBAEntity et, String[] families) throws Exception{
		
	}
	
	
	@Override
	public void executeRemoveCmd(IBAEntity et) throws Exception {

		final IBAEntity et2 = et;
		final IBACallContext iBACallContext = this;

		// 执行作业
		this.doWork(new IBADAOWork() {
			@Override
			public void execute(Object connection) throws Exception {
				onBeforeRemove(iBACallContext, connection, et2);
				getRealBADialect().executeRemoveCmd(iBACallContext, connection, et2);
				onAfterRemove(iBACallContext, connection, et2);
			}
		});
	}

	
	
	/**
	 * 删除数据之前
	 * @param iBACallContext
	 * @param connection
	 * @param et
	 * @throws Exception
	 */
	protected void onBeforeRemove(IBACallContext iBACallContext, Object connection, IBAEntity et) throws Exception{
		
	}
	
	/**
	 * 删除数据之后
	 * @param iBACallContext
	 * @param connection
	 * @param et
	 * @throws Exception
	 */
	protected void onAfterRemove(IBACallContext iBACallContext, Object connection, IBAEntity et) throws Exception{
		
	}
	
	@Override
	public ArrayList<IBAEntity> executeSelectCmd(IBASelectContext iBASelectContext) throws Exception {
		final IBASelectContext iBASelectContext2 = iBASelectContext;
		final IBACallContext iBACallContext = this;
		final CallResult callResult = new  CallResult();
		// 执行作业
		this.doWork(new IBADAOWork() {
			@Override
			public void execute(Object connection) throws Exception {
				 ArrayList<IBAEntity> list2 =   getRealBADialect().executeSelectCmd(iBACallContext, connection, iBASelectContext2,null);
				 for(IBAEntity ibaEntity:list2){
					 ibaEntity.setActionHelper(getBAEntityActionHelper());
				 }
				 callResult.setUserObject(list2);
			}
		});
		
		return (ArrayList<IBAEntity>)callResult.getUserObject();
	}
	
	
	
	
	
	
//	@Override
//	public DBFetchResult fetchDEDataSet(IDEDataSetFetchContext iDEDataSetFetchContext, String strDEDataSetName, boolean bTempMode) throws Exception {
//		if(bTempMode)
//			throw new Exception("大数据不支持临时数据");
//		
//		final IBACallContext iBACallContext = this;
//		final IDEDataSetFetchContext iDEDataSetFetchContext2 = iDEDataSetFetchContext;
//		final String strDEDataSetName2 = strDEDataSetName;
//		final DBCallResultProxy dbCallResultProxy = new DBCallResultProxy();
//		// 执行作业
//		this.doWork(new IBADAOWork() {
//			@Override
//			public void execute(Object connection) throws Exception {
//				DBFetchResult dbFetchResult = getRealBADialect().fetchDEDataSet(iBACallContext, connection, iDEDataSetFetchContext2, strDEDataSetName2, null);
//				dbCallResultProxy.setDBCallResult(dbFetchResult);
//			}
//		});
//		return (DBFetchResult) dbCallResultProxy.getDBCallResult();
//	}

	

	/* (non-Javadoc)
	 * @see net.ibizsys.psba.dao.IBADAO#executeSelectCmdAsync(net.ibizsys.psba.dao.IBASelectContext)
	 */
	@Override
	public void executeSelectCmdAsync(IBASelectContext iBASelectContext,IBAAsyncSelectHandler iBAAsyncSelectHandler) throws Exception {
		if(iBAAsyncSelectHandler== null){
			throw new Exception("没有指定异步处理对象");
		}
		final IBASelectContext iBASelectContext2 = iBASelectContext;
		final IBAAsyncSelectHandler iBAAsyncSelectHandler2 = iBAAsyncSelectHandler;
		this.getSelectThreadPoolExecutor().execute( new Runnable() {
			@Override
			public void run() {
				try {
					executeSelectCmd(iBASelectContext2,new IBAAsyncSelectHandler(){

						@Override
						public void exception(Exception exception) {
							iBAAsyncSelectHandler2.exception(exception);
						}

						@Override
						public void processBAEntity(IBAEntity iBAEntity) {
							try{
								iBAEntity.setActionHelper(getBAEntityActionHelper());
								iBAAsyncSelectHandler2.processBAEntity(iBAEntity);
							}
							catch(Exception ex){
								log.error(ex);
							}
							
						}}
					);
				} catch (Exception e) {
					iBAAsyncSelectHandler2.exception(e);
					return;
				}
			}
		});
	}

	
	
	
	
	@Override
	public void executeSelectCmd(IBASelectContext iBASelectContext, IBAAsyncSelectHandler iBAAsyncSelectHandler) throws Exception {
		
		if(iBAAsyncSelectHandler== null){
			throw new Exception("没有指定异步处理对象");
		}
		
		final IBASelectContext iBASelectContext2 = iBASelectContext;
		final IBACallContext iBACallContext = this;
		final IBAAsyncSelectHandler iBAAsyncSelectHandler2 = iBAAsyncSelectHandler;
		// 执行作业
		this.doWork(new IBADAOWork() {
			@Override
			public void execute(Object connection) throws Exception {
				getRealBADialect().executeSelectCmd(iBACallContext, connection, iBASelectContext2,new IBAAsyncSelectHandler(){

					@Override
					public void exception(Exception exception) {
						iBAAsyncSelectHandler2.exception(exception);
					}

					@Override
					public void processBAEntity(IBAEntity iBAEntity) {
						try{
							iBAEntity.setActionHelper(getBAEntityActionHelper());
							iBAAsyncSelectHandler2.processBAEntity(iBAEntity);
						}
						catch(Exception ex){
							log.error(ex);
						}
						
					}});
			}
		});
	}



	/**
	 * 增加异步查询数据对象作业
	 * @param iBAEntity
	 * @param iBAAsyncSelectHandler
	 */
	protected void addAsyncSelectBAEntityWork(IBAEntity iBAEntity,IBAAsyncSelectHandler iBAAsyncSelectHandler){
		final IBAAsyncSelectHandler iBAAsyncSelectHandler2  = iBAAsyncSelectHandler;
		final IBAEntity iBAEntity2 = iBAEntity;
		this.getWorkThreadPoolExecutor().execute(new Runnable() {
			
			@Override
			public void run() {
				iBAAsyncSelectHandler2.processBAEntity(iBAEntity2);
			}
		});
	}


	@Override
	public IBADialect getRealBADialect() {
		return ((IBASchemeRuntime) this.getBASchemeModel()).getBADialect();
	}

	
	protected Object getParamValue(String strParamName, ISimpleDataObject iEntity) throws Exception {
		return getParamValue(strParamName, iEntity, WebContext.getCurrent(), null, null);
	}
	
	protected Object getParamValue(String strParamName, ISimpleDataObject iEntity,IDataEntity iDataEntity) throws Exception {
		return getParamValue(strParamName, iEntity, WebContext.getCurrent(), iDataEntity, null);
	}

	/**
	 * 获取参数值
	 * 
	 * @param strParamName
	 * @param iEntity
	 * @param objDefaultValue
	 * @return
	 * @throws Exception
	 */
	protected Object getParamValue(String strParamName, IEntity iEntity, Object objDefaultValue,IDataEntity iDataEntity) throws Exception {
		return getParamValue(strParamName, iEntity, WebContext.getCurrent(), iDataEntity, objDefaultValue);
	}

	/**
	 * 填充插入的列数据
	 * 
	 * @param insertColumnsMap
	 * @param et 数据对象
	 * @param bTempMode
	 * @throws Exception
	 */
	protected boolean fillInsertColumnMap(HashMap<IBAColumn, Object> insertColumnsMap, IBAEntity et2,String[] families) throws Exception {

		Object objKeyValue = et2.getRowKey();// et2.get(this.getDEModel().getKeyDEField().getName());
		
		if(this.getBATableModel().getBATableType() == IBATable.BATABLETYPE_RELATED){
			
			throw new Exception("暂时不支持");
//			java.util.Iterator<IBATableDE> baTableDEs = this.getBATableModel().getBATableDEs();
//			while(baTableDEs.hasNext()){
//				IBATableDE iBATableDE = baTableDEs.next();
//				if(iBATableDE.getBATableDEType() == IBATableDE.BATABLEDETYPE_MINOR){
//					//从关系放入
//					entityMap.put(iBATableDE.getId(), et2);
//					break;
//				}
//			}
//			
//			//关系表
//			int nCount = this.getBATableModel().getBATableDERCount();
//			IEntity last = et2;
//			Object objLastKey = null;
//			
//			for(int i =0;i<nCount;i++){
//				IBATableDER iBATableDER = this.getBATableModel().getBATableDERAt(i);
//				Object obj = last.get(iBATableDER.getDERFieldName());
//				if(obj == null)
//					return false;
//				
//				IDataEntityModel iDEModel = DEModelGlobal.getDEModel(iBATableDER.getMajorDEName());
//				IService iService = iDEModel.getService(et2.getSessionFactory());
//				IEntity iEntity = iDEModel.createEntity();
//				iEntity.set(iDEModel.getKeyDEField().getName(),obj);
//				if(!iService.get(iEntity,true)){
//					return false;
//				}
//				
//				last = iEntity;
//				objLastKey = obj;
//			}
//			baTableDEs = this.getBATableModel().getBATableDEs();
//			while(baTableDEs.hasNext()){
//				IBATableDE iBATableDE = baTableDEs.next();
//				if(iBATableDE.getBATableDEType() == IBATableDE.BATABLEDETYPE_MAJOR){
//					//主关系放入
//					entityMap.put(iBATableDE.getId(), last);
//					break;
//				}
//			}
//			
//			String strKey = StringHelper.format("%1$s|%2$s",objKeyValue,objLastKey);
//			et2.set(WebContextBase.PARAM_KEY,strKey);
			
		}
		else{
			
			if(et2.getCreateDate()!=null){
				//放入系统列
				IBAColumn iBAColumn = this.getBATableModel().getBAColumn(IBATable.COLSET_CREATEINFO, IBATable.COL_CREATEINFO_CREATEDATE);
				insertColumnsMap.put(iBAColumn, et2.getCreateDate());
			}
			if(et2.getUpdateDate()!=null){
				IBAColumn iBAColumn = this.getBATableModel().getBAColumn(IBATable.COLSET_UPDATEINFO, IBATable.COL_UPDATEINFO_UPDATEDATE);
				insertColumnsMap.put(iBAColumn, et2.getUpdateDate());
			}
			
			HashMap<String,ISimpleDataObject> entityMap = new HashMap<String,ISimpleDataObject>();
			if(families == null){
				java.util.Iterator<String> names = et2.getFamilyNames();
				while(names.hasNext()){
					String strFamily = names.next();
					entityMap.put(strFamily,et2.getFamily(strFamily,true));
				}
			}
			else {
				for(String strFamily:families){
					entityMap.put(strFamily,et2.getFamily(strFamily,true));
				}
			}
			
			for(String strFamily:entityMap.keySet()){
				ISimpleDataObject et = entityMap.get(strFamily);
				java.util.Iterator<IBAColumn> baColumns = this.getBATableModel().getBAColSet(strFamily).getBAColumns();
				while (baColumns.hasNext()) {
					IBAColumn iBAColumn = baColumns.next();
					IDEField iDEField = iBAColumn.getDEField();
					//if (StringHelper.isNullOrEmpty(iBAColumn.getPreDefinedType()) ) {
					if(true){
						if (!StringHelper.isNullOrEmpty(iBAColumn.getDBValueFunc())) {
							Object objValue = this.getRealBADialect().getFuncValue(iBAColumn.getDBValueFunc(), true, new String[] { iBAColumn.getName() });
							insertColumnsMap.put(iBAColumn, objValue);
							continue;
						}

						insertColumnsMap.put(iBAColumn, this.getParamValue(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()), et,iDEField.getDataEntity()));
					} else {
						if ((StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_CREATEDATE, true) == 0) || (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEDATE, true) == 0)) {
							insertColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_CURTIME, et,null));
							continue;
						}

						if ((StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_CREATEMAN, true) == 0) || (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEMAN, true) == 0)) {
							insertColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_PERSONID, et,null));
							continue;
						}

						if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_LOGICVALID, true) == 0) {
							Object objValidValue = iDEField.getDataEntity().getLogicValidValue(true);
							insertColumnsMap.put(iBAColumn, objValidValue);
							continue;
						}

						if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGID, true) == 0) {
							insertColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_ORGID, et));
							continue;
						}

						if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGNAME, true) == 0) {
							insertColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_ORGNAME, et));
							continue;
						}

						if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGSECTORID, true) == 0) {
							insertColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_ORGSECTORID, et));
							continue;
						}

						if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGSECTORNAME, true) == 0) {
							insertColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_ORGSECTORNAME, et));
							continue;
						}
					}
				}
			}

		}
		

		return true;

	}

	/**
	 * 填充要更新的列集合
	 * 
	 * @param updateColumnsMap
	 * @param et
	 * @param bTempMode
	 * @param bSysUpdateMode
	 * @throws Exception
	 */
	protected boolean fillUpdateColumnMap(HashMap<IBAColumn, Object> updateColumnsMap, IBAEntity et, String[] families,boolean bSysUpdateMode) throws Exception {

		return fillInsertColumnMap(updateColumnsMap, et, families);
		
//		java.util.Iterator<IBAColumn> baColumns = this.getBATableModel().getBAColumns();
//		while (baColumns.hasNext()) {
//			IBAColumn iBAColumn = baColumns.next();
//			IDEField iDEField = iBAColumn.getDEField();
//			if (StringHelper.isNullOrEmpty(iBAColumn.getPreDefinedType()) ) {
//				if (!et.contains(iDEField.getName())) {
//					if (!StringHelper.isNullOrEmpty(iDEField.getDBValueFunc())) {
//						// Object objValue = this.getRealBADialect().getFuncValue(iBAColumn.getDBValueFunc(),false,new String[]{ iBAColumn.getName()});
//						// updateColumnsMap.put(iBAColumn, objValue);
//					}
//					continue;
//				}
//
//				if (et.get(iDEField.getName()) == null) {
//					updateColumnsMap.put(iBAColumn, null);
//				} else {
//					updateColumnsMap.put(iBAColumn, this.getParamValue(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()), et));
//				}
//			} else {
//				if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEDATE, true) == 0) {
//					if (!bSysUpdateMode) updateColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_CURTIME, et));
//					continue;
//				}
//
//				if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEMAN, true) == 0) {
//					if (!bSysUpdateMode) updateColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_PERSONID, et));
//					continue;
//				}
//
//				if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGID, true) == 0) {
//					if (et.get(IProcParam.TAG_ORGID) != null || et.get(iDEField.getName()) != null) updateColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_ORGID, et));
//					continue;
//				}
//
//				if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGNAME, true) == 0) {
//					if (et.get(IProcParam.TAG_ORGNAME) != null || et.get(iDEField.getName()) != null) updateColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_ORGNAME, et));
//					continue;
//				}
//
//				if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGSECTORID, true) == 0) {
//					if (et.get(IProcParam.TAG_ORGSECTORID) != null || et.get(iDEField.getName()) != null) updateColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_ORGSECTORID, et));
//					continue;
//				}
//
//				if (StringHelper.compare(iBAColumn.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGSECTORNAME, true) == 0) {
//					if (et.get(IProcParam.TAG_ORGSECTORNAME) != null || et.get(iDEField.getName()) != null) updateColumnsMap.put(iBAColumn, this.getParamValue(IProcParam.TAG_ORGSECTORNAME, et));
//					continue;
//				}
//			}
//		}

		//		return true;
	}

	/**
	 * 获取参数值
	 * 
	 * @param strParamName
	 * @param iEntity
	 * @param iWebContext
	 * @param iDataEntity
	 * @return
	 * @throws Exception
	 */
	protected static Object getParamValue(String strParamName, ISimpleDataObject iEntity, IWebContext iWebContext, IDataEntity iDataEntity, Object objDefaultValue) throws Exception {
		strParamName = strParamName.toUpperCase();
		if (strParamName.indexOf(IProcParam.TAG_VAR) == 0) {
			// 变量
			strParamName = strParamName.substring(4);
			Object objValue = (iEntity == null) ? null : iEntity.get(strParamName);
			if (objValue != null && objValue instanceof String) {
				if (StringHelper.isNullOrEmpty((String) objValue)) {
					objValue = null;
				}
			}
			return objValue;
		}

		if (strParamName.indexOf(IProcParam.TAG_VF) == 0) {
			// 变量
			strParamName = strParamName.substring(3);
			if (iEntity != null && iEntity.contains(strParamName))
				return 1;
			else
				return 0;
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_CURTIME, true) == 0) {
			if (iEntity != null) {
				// java.sql.Timestamp curTime = DataTypeHelper.getTimestampValue(iEntity, IProcParam.TAG_CURTIME, DateHelper.getCurTime());
				java.sql.Timestamp curTime = DataTypeHelper.getTimestampValue(iEntity, IProcParam.TAG_CURTIME, null);
				if (curTime == null) curTime = DateHelper.getCurTime();
				return curTime;
			} else {
				return DateHelper.getCurTime();
			}
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_PERSONID, true) == 0) {
			if (iEntity != null) {
				String strTempOpPersonId = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_PERSONID, (iWebContext == null) ? null : iWebContext.getCurUserId());
				return strTempOpPersonId;
			} else {
				return (iWebContext == null) ? null : iWebContext.getCurUserId();
			}
		}
		
		if (StringHelper.compare(strParamName, IProcParam.TAG_PERSONNAME, true) == 0) {
			if (iEntity != null) {
				String strTempOpPersonName = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_PERSONNAME, (iWebContext == null) ? null : iWebContext.getCurUserName());
				return strTempOpPersonName;
			} else {
				return (iWebContext == null) ? null : iWebContext.getCurUserName();
			}
		}
		

		if (StringHelper.compare(strParamName, IProcParam.TAG_ORGID, true) == 0) {
			if (iEntity != null) {
				String strOrgId = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_ORGID, null);
				if (StringHelper.isNullOrEmpty(strOrgId) && iDataEntity != null) {
					IDEField ideField = ((IDataEntityModel) iDataEntity).getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
					if (ideField != null) strOrgId = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
				}
				if (StringHelper.isNullOrEmpty(strOrgId) && (iWebContext != null)) {
					strOrgId = iWebContext.getCurOrgId();
				}
				return strOrgId;
			} else {
				return (iWebContext == null) ? null : iWebContext.getCurOrgId();
			}
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_ORGNAME, true) == 0) {
			if (iEntity != null) {
				String strOrgName = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_ORGNAME, null);
				if (StringHelper.isNullOrEmpty(strOrgName) && iDataEntity != null) {
					IDEField ideField = ((IDataEntityModel) iDataEntity).getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGNAME, true);
					if (ideField != null) strOrgName = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
				}
				if (StringHelper.isNullOrEmpty(strOrgName) && (iWebContext != null)) {
					strOrgName = iWebContext.getCurOrgName();
				}
				return strOrgName;
			} else {
				return (iWebContext == null) ? null : iWebContext.getCurOrgName();
			}
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_ORGSECTORID, true) == 0) {
			if (iEntity != null) {
				String strOrgSectorId = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_ORGSECTORID, null);
				if (StringHelper.isNullOrEmpty(strOrgSectorId) && iDataEntity != null) {
					IDEField ideField = ((IDataEntityModel) iDataEntity).getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);
					if (ideField != null) strOrgSectorId = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
				}
				if (StringHelper.isNullOrEmpty(strOrgSectorId) && (iWebContext != null)) {
					strOrgSectorId = iWebContext.getCurOrgSectorId();
				}
				return strOrgSectorId;
			} else {
				return (iWebContext == null) ? null : iWebContext.getCurOrgSectorId();
			}
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_ORGSECTORNAME, true) == 0) {
			if (iEntity != null) {
				String strOrgSectorName = DataTypeHelper.getStringValue(iEntity, IProcParam.TAG_ORGSECTORNAME, null);
				if (StringHelper.isNullOrEmpty(strOrgSectorName) && iDataEntity != null) {
					IDEField ideField = ((IDataEntityModel) iDataEntity).getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORNAME, true);
					if (ideField != null) strOrgSectorName = DataTypeHelper.getStringValue(iEntity, ideField.getName(), null);
				}
				if (StringHelper.isNullOrEmpty(strOrgSectorName) && (iWebContext != null)) {
					strOrgSectorName = iWebContext.getCurOrgSectorName();
				}
				return strOrgSectorName;
			} else {
				return (iWebContext == null) ? null : iWebContext.getCurOrgSectorName();
			}
		}

		// if (StringHelper.compare(strParamName, IProcParam.TAG_ACTIONMODE, true) == 0)
		// {
		// return strActionMode);
		// callParam.setDataType(DataTypes.VARCHAR);
		// return callParam;
		// }

		if (StringHelper.compare(strParamName, IProcParam.TAG_ACTIONARG, true) == 0) {
			throw new Exception(StringHelper.format("不支持默认参数[%1$s]", strParamName));
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_RD, true) == 0) {
			throw new Exception(StringHelper.format("不支持默认参数[%1$s]", strParamName));
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_RETCODE, true) == 0) {
			throw new Exception(StringHelper.format("不支持默认参数[%1$s]", strParamName));
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_RETINFO, true) == 0) {
			throw new Exception(StringHelper.format("不支持默认参数[%1$s]", strParamName));
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_RETINFORES, true) == 0) {
			throw new Exception(StringHelper.format("不支持默认参数[%1$s]", strParamName));
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_RETINFORESARG, true) == 0) {
			throw new Exception(StringHelper.format("不支持默认参数[%1$s]", strParamName));
		}

		// 检查DALOG
		if (StringHelper.compare(strParamName, IProcParam.TAG_DALOG, true) == 0) {
			if (iEntity != null) {
				return DataTypeHelper.getIntegerValue(iEntity, IProcParam.TAG_DALOG, 1);
			} else
				return 1;
		}

		// 检查传入的键值
		if (StringHelper.compare(strParamName, IProcParam.TAG_CHECKKEY, true) == 0) {
			if (iEntity != null) {
				return DataTypeHelper.getIntegerValue(iEntity, IProcParam.TAG_CHECKKEY, 1);
			} else
				return 1;
		}

		// 返回结果集
		if (StringHelper.compare(strParamName, IProcParam.TAG_RETDATA, true) == 0) {
			if (iEntity != null) {
				return DataTypeHelper.getIntegerValue(iEntity, IProcParam.TAG_RETDATA, 1);
			} else
				return 1;
		}

		if (StringHelper.compare(strParamName, IProcParam.TAG_TAG, true) == 0) {
			throw new Exception(StringHelper.format("不支持默认参数[%1$s]", strParamName));
		}

//		if (StringHelper.compare(strParamName, IProcParam.TAG_DRAFTFLAG, true) == 0) {
//			if (EntityBase.hasDraftFlag(iEntity)) {
//				return EntityBase.isDraft(iEntity) ? 1 : 0;
//			} else {
//				int nDefaultValue = 1;
//				if (nDefaultValue == 1) {
//					// 进一步判断是否与原始键值
//					Object objValue = (iEntity == null) ? null : iEntity.get(ServiceBase.ORIGINKEY);
//					if (objValue != null) {
//						return 0;
//					}
//				}
//			}
//		}

		if (objDefaultValue == null) throw new Exception(StringHelper.format("不支持参数名称[%1$s]", strParamName));
		return objDefaultValue;
	}

	/**
	 * 执行服务作业,默认启用事物
	 * 
	 * @param iBADAOWork
	 * @throws Exception
	 */
	protected void doWork(IBADAOWork iBADAOWork) throws Exception {
		doWork(-1, iBADAOWork, true);
	}

	/**
	 * 执行服务作业
	 * 
	 * @param iBADAOWork
	 * @param bTransaction 是否启用事物
	 * @throws Exception
	 */
	protected void doWork(IBADAOWork iBADAOWork, boolean bTransaction) throws Exception {
		doWork(-1, iBADAOWork, false);
	}

	/**
	 * 执行服务作业
	 * 
	 * @param nMode
	 * @param iBADAOWork
	 * @param bTransaction
	 * @throws Exception
	 */
	protected void doWork(int nMode, IBADAOWork iBADAOWork, boolean bTransaction) throws Exception {
		long nBeginTime = java.lang.System.currentTimeMillis();

		Object connection = getConnection();
		try {
			if (bTransaction) {
				iBADAOWork.execute(connection);
			} else {
				iBADAOWork.execute(connection);
			}

			closeConnection(connection);
		} catch (Exception ex) {
			if (connection != null) {
				closeConnection(connection);
				connection = null;
			}

			String strMessage = ex.getMessage();
			if (ex.getCause() != null && ex.getCause() instanceof Exception) {
				Exception exception = (Exception) ex.getCause();
				strMessage = exception.getMessage();
			}
			log.error(StringHelper.format("大数据表[%1$s]doWork发生异常，%2$s", this.getBATableModel().getName(), strMessage), ex);

			throw ex;
		}

		long nTime = java.lang.System.currentTimeMillis() - nBeginTime;
		log.debug(StringHelper.format("作业 耗时[%1$s]", nTime));
	}

	/**
	 * 获取大数据连接
	 * 
	 * @return
	 */
	protected Object getConnection() throws Exception {
		return ((IBASchemeRuntime) this.getBASchemeModel()).getBADataSource().getConnection();
	}

	/**
	 * 关闭大数据连接
	 * 
	 * @param objConn
	 * @throws Exception
	 */
	protected void closeConnection(Object objConn) throws Exception {
		((IBASchemeRuntime) this.getBASchemeModel()).getBADataSource().closeConnection(objConn);
	}




	
	
	
}
