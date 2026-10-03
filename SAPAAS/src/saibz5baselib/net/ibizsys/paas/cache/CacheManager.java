package net.ibizsys.paas.cache;

import java.util.concurrent.ConcurrentHashMap;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;



/**
 * 缓存管理对象
 * @author Administrator
 *
 */
public class CacheManager implements ICacheManager {

	/**
	 * 放入用户Session中的缓存管理器对象参数名称
	 */
	public final static String PARAM_USERCACHEMANAGER = "SRFUSERCACHEMANAGER";
	
	
	protected class CacheItem implements ICacheItem{

		private Object objData = null;
		private long nExpiredTime = -1;
		private String strUniqueTag = null;
		private Object objState = null;
		
		@Override
		public Object getData() {
			return this.objData;
		}

		@Override
		public long getExpiredTime() {
			return this.nExpiredTime;
		}

		@Override
		public String getUniqueTag() {
			return this.strUniqueTag;
		}

		@Override
		public Object getState() {
			return this.objState;
		}

		public void setData(Object objData) {
			this.objData = objData;
		}

		public void setExpiredTime(long nExpiredTime) {
			this.nExpiredTime = nExpiredTime;
		}

		public void setUniqueTag(String strUniqueTag) {
			this.strUniqueTag = strUniqueTag;
		}

		public void setState(Object objState) {
			this.objState = objState;
		}
		
		
	}
	
	private ConcurrentHashMap<String, CacheItem> cacheItemMap = new ConcurrentHashMap<String, CacheItem>();
	private int nMaxItemCount = 20000;
	private int nDefaultTimeout = -1;
	
	private final static CacheManager globalCacheManager = new CacheManager();
	private final static ConcurrentHashMap<String, CacheManager> orgCacheManagerMap = new ConcurrentHashMap<String, CacheManager>();
	
	
	/**
	 * 获取实例对象
	 * @param strCacheScope
	 * @return
	 * @throws Exception
	 */
	public static ICacheManager  getInstance(int nCacheScope)throws Exception{
		switch(nCacheScope){
		case CACHESCOPE_GLOBAL:
			return globalCacheManager;
		case CACHESCOPE_ORG:{
			String strOrgId = null;
			if(WebContext.getCurrent() != null){
				strOrgId = WebContext.getCurrent().getCurOrgId();
			}
			if(!StringHelper.isNullOrEmpty(strOrgId)){
				CacheManager orgCacheManager = orgCacheManagerMap.get(strOrgId);
				if(orgCacheManager==null){
					orgCacheManager = new CacheManager();
					orgCacheManagerMap.put(strOrgId, orgCacheManager);
				}
				return orgCacheManager;
			}
			throw new Exception("无法计算当前组织机构标识");
		}
		case CACHESCOPE_USER:{
			IWebContext iWebContext = WebContext.getCurrent();
			if(iWebContext != null){
				return getUserCacheManager(iWebContext);
			}
			
			throw new Exception("无法获取当前用户上下文访问对象");
		}
		}
		throw new Exception(StringHelper.format("无法识别的缓存范围值[%1$s]",nCacheScope));
	}

	
	/**
	 * 获取当前用户的缓存管理器对象
	 * @param iWebContext
	 * @return
	 * @throws Exception
	 */
	public static ICacheManager getUserCacheManager(IWebContext iWebContext)throws Exception{
		Object objCacheManager = iWebContext.getSessionValue(PARAM_USERCACHEMANAGER, false);
		if(objCacheManager == null){
			objCacheManager = new  CacheManager();
			iWebContext.setSessionValue(PARAM_USERCACHEMANAGER, objCacheManager,false);
		}
		return (ICacheManager)objCacheManager;
	}
	
	
	/**
	 * 重置缓存管理对象
	 * @param nCacheScope
	 */
	public static void reset(int nCacheScope)throws Exception{
		reset(nCacheScope,null);
	}

	/**
	 * 重置缓存管理对象
	 * @param nCacheScope
	 * @param strCacheScopeTag 进一步指定缓存范围中的具体标记，如组织机构标识
	 */
	public static void reset(int nCacheScope,String strCacheScopeTag)throws Exception{
		switch(nCacheScope){
		case CACHESCOPE_GLOBAL:
			globalCacheManager.removeAll();
			return ;
		case CACHESCOPE_ORG:{
			if(!StringHelper.isNullOrEmpty(strCacheScopeTag)){
				orgCacheManagerMap.remove(strCacheScopeTag);
			}
			else {
				orgCacheManagerMap.clear();
			}
		}
		case CACHESCOPE_USER:{
			IWebContext iWebContext = WebContext.getCurrent();
			if(iWebContext != null){
				getUserCacheManager(iWebContext).removeAll();
			}
			
			throw new Exception("无法获取当前用户上下文访问对象");
		}
		}
		throw new Exception(StringHelper.format("无法识别的缓存范围值[%1$s]",nCacheScope));
	}

	@Override
	public Object getData(String strCacheTag, Object objState) throws Exception {
		CacheItem cacheItem =  cacheItemMap.get(strCacheTag);
		if(cacheItem!=null)
		{
			if((cacheItem.getExpiredTime() == -1 || cacheItem.getExpiredTime()>=System.currentTimeMillis())  &&testState(cacheItem.getState(),objState))
				return cacheItem.getData();
			return null;
		}
		return null;
	}


	@Override
	public ICacheItem updateData(String strCacheTag, Object objState,Object objData) throws Exception {
		return updateData(strCacheTag, objState, objData,this.getDefaultTimeout());
	}


	@Override
	public ICacheItem updateData(String strCacheTag, Object objState,Object objData, long nTimeout) throws Exception {
		CacheItem cacheItem =  cacheItemMap.get(strCacheTag);
		boolean bNew = false;
		if(cacheItem == null){
			cacheItem = new CacheItem();
			cacheItem.setUniqueTag(strCacheTag);
			bNew = true;
		}
		cacheItem.setData(objData);
		cacheItem.setState(objState);
		if(nTimeout >0){
			cacheItem.setExpiredTime(System.currentTimeMillis()+nTimeout);
		}
		else{
			cacheItem.setExpiredTime(-1);
		}
		if(bNew){
			if(cacheItemMap.size()>nMaxItemCount){
				cacheItemMap.clear();
			}
			cacheItemMap.put(strCacheTag, cacheItem);
		}
		return cacheItem;
	}


	@Override
	public ICacheItem removeData(String strCacheTag) throws Exception {
		return cacheItemMap.remove(strCacheTag);
	}


	@Override
	public ICacheItem getCacheItem(String strCacheTag) {
		return cacheItemMap.get(strCacheTag);
	}
	
	protected boolean testState(Object objState,Object objState2){
		if(objState == null && objState2 == null)
			return true;
		
		if(objState == null || objState2 == null)
			return false;
		
		return objState.equals(objState2);
	}
	
	/**
	 * 设置最大的缓存项数量
	 * @param nMaxItemCount
	 */
	public void setMaxItemCount(int nMaxItemCount){
		this.nMaxItemCount = nMaxItemCount;
	}
	
	
	/**
	 * 设置默认的超时时长
	 * @param nDefaultTimeout
	 */
	public void setDefaultTimeout(int nDefaultTimeout){
		this.nDefaultTimeout = nDefaultTimeout;
	}
	
	
	/**
	 * 获取最大的缓存数量
	 * @return
	 */
	public int getMaxItemCount(){
		return this.nMaxItemCount;
	}
	
	
	/**
	 * 获取默认的超时时长
	 * @return
	 */
	public int getDefaultTimeout(){
		return this.nDefaultTimeout;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.ICacheManager#removeAll()
	 */
	@Override
	public void removeAll(){
		cacheItemMap.clear();
	}
	
//	
//	protected class DEDataSetCache{
//		public Object objLastState = null;
//		public IUniStateModel iUniStateModel = null;
//		public DBFetchResult dbFetchResult = null;
//		public long nLastCacheTime = 0l;
//	}
//	
//	
//	protected HashMap<String, DEDataSetCache> deDataSetCacheMap = new HashMap<String, DEDataSetCache>();
//	
//	protected SessionFactory sessionFactory = null;
//	
//	public SFScopeDataCacher(SessionFactory sessionFactory){
//		this.sessionFactory = sessionFactory;
//	}
//	
//	/**
//	 * 获取数据缓存标记
//	 * @param iDataCacheSupporter
//	 * @return
//	 * @throws Exception
//	 */
//	public String getDEDataSetCacheTag(IDEDataSet iDEDataSet,IEntity iEntity)throws Exception{
//		StringBuilderEx sBuilderEx = new StringBuilderEx();
//		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(iDEDataSet.getDataEntity().getName());
//		IService iService = iDataEntityModel.getService(this.sessionFactory);
//		iService.executeLogic(iDEDataSet.getCacheUniStateDELogicId(), iEntity);
//		if(iDataEntityModel.getSystemModel().getSystemDataCacher()!=null){
//			iDataEntityModel.getSystemModel().getSystemDataCacher().fillDEDataSetCacheTagEntity(iDEDataSet, iEntity, sessionFactory);
//		}
//		LinkedHashMap<String,Object> params = new LinkedHashMap<String,Object>();
//		iEntity.fillMap(params);
//		for(String strKey:params.keySet()){
//			sBuilderEx.append("%1$s=%2$s;",strKey,params.get(strKey));
//		}
//		return sBuilderEx.toString();
//	}
//
//
//
//	@Override
//	public DBFetchResult getDEDataSet(IDEDataSet iDEDataSet,SessionFactory sessionFactory) throws Exception {
//		
//		//获取数据的标识
//		SimpleEntity simpleEntity = new SimpleEntity();
//		String strDEDataSetCacheTag = getDEDataSetCacheTag(iDEDataSet,simpleEntity);
//		if(StringHelper.isNullOrEmpty(strDEDataSetCacheTag))
//			return null;
//		
//		DEDataSetCache deDataSetCache = deDataSetCacheMap.get(strDEDataSetCacheTag);
//		if(deDataSetCache == null){
//			return null;
//		}
//		
//		if((iDEDataSet.getCacheTimeout() <=0) || (deDataSetCache.nLastCacheTime+iDEDataSet.getCacheTimeout() <System.currentTimeMillis())){
//			//判断数据发生发生变化
//			if(deDataSetCache.iUniStateModel!=null){
//				Object objLastState = deDataSetCache.iUniStateModel.getLastState(simpleEntity, iDEDataSet.getCacheHookState());
//				if((deDataSetCache.objLastState == null && objLastState==null)||( deDataSetCache.objLastState != null && objLastState!=null &&deDataSetCache.objLastState.equals(objLastState))){
//					//克隆
//					DBFetchResult dbFetchResult2 = new DBFetchResult();
//					dbFetchResult2.from(deDataSetCache.dbFetchResult);
//					IDataSet iDataSet = deDataSetCache.dbFetchResult.getDataSet();
//					if(iDataSet!=null)
//					{
//						SimpleDataSetImpl dataSet = new SimpleDataSetImpl();
//						for(int i = 0;i<iDataSet.getDataTableCount();i++){
//							IDataTable iDataTable = iDataSet.getDataTable(i);
//							dataSet.addDataTable(iDataTable);
//						}
//						dbFetchResult2.setDataSet(dataSet);
//					}
//					return dbFetchResult2;
//				}
//			}
//		}	
//		//移除缓存
//		deDataSetCacheMap.remove(strDEDataSetCacheTag);
//		return null;
//	}
//
//
//
//	@Override
//	public void updateDEDataSet(IDEDataSet iDEDataSet, DBFetchResult dbFetchResult,SessionFactory sessionFactory) throws Exception {
//		//获取数据的标识
//		SimpleEntity simpleEntity = new SimpleEntity();
//		String strDEDataSetCacheTag = getDEDataSetCacheTag(iDEDataSet,simpleEntity);
//		if(StringHelper.isNullOrEmpty(strDEDataSetCacheTag))
//			return;
//		
//		DEDataSetCache deDataSetCache = new DEDataSetCache();
//		if(!StringHelper.isNullOrEmpty(iDEDataSet.getCacheUniStateId())){
//			IUniStateModel iUniStateModel = UniStateModelGlobal.getUniState(iDEDataSet.getCacheUniStateId());
//			deDataSetCache.iUniStateModel = iUniStateModel;
//		}
//		if(deDataSetCache.iUniStateModel!=null){
//			deDataSetCache.objLastState = deDataSetCache.iUniStateModel.getLastState(simpleEntity, iDEDataSet.getCacheHookState());
//		}
//		//克隆
//		DBFetchResult dbFetchResult2 = new DBFetchResult();
//		dbFetchResult2.from(dbFetchResult);
//		
//		IDataSet iDataSet = dbFetchResult2.getDataSet();
//		if(iDataSet!=null)
//		{
//			SimpleDataSetImpl dataSet = new SimpleDataSetImpl();
//			for(int i = 0;i<iDataSet.getDataTableCount();i++){
//				IDataTable iDataTable = iDataSet.getDataTable(i);
//				if(iDataTable.getCachedRowCount()==-1){
//					iDataTable.cacheAllRows();					
//				}
//				dataSet.addDataTable(iDataTable);
//			}
//			dbFetchResult2.setDataSet(dataSet);
//		}
//		deDataSetCache.dbFetchResult = dbFetchResult2;
//		deDataSetCache.nLastCacheTime = System.currentTimeMillis();
//		deDataSetCacheMap.put(strDEDataSetCacheTag, deDataSetCache);		
//	}
//
//
//
//	@Override
//	public void removeDEDataSet(IDEDataSet iDEDataSet,SessionFactory sessionFactory)throws Exception {
//		//获取数据的标识
//		SimpleEntity simpleEntity = new SimpleEntity();
//		String strDEDataSetCacheTag = getDEDataSetCacheTag(iDEDataSet,simpleEntity);
//		if(StringHelper.isNullOrEmpty(strDEDataSetCacheTag))
//			return;
//		deDataSetCacheMap.remove(strDEDataSetCacheTag);
//	}
}
