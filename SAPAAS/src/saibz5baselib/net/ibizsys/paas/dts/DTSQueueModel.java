package net.ibizsys.paas.dts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.db.SelectGroupFilter;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.StringHelper;

/**
 * 系统分布事务队列对象模型
 * @author Administrator
 *
 */
public class DTSQueueModel extends SystemModelObjectBase implements IDTSQueueModel {

	private static final Log log = LogFactory.getLog(DTSQueueModel.class);
	
	private IService iService = null;

	private IDataEntityModel iDEModel = null;
	
	private IService historyService = null;

	private IDataEntityModel historyDEModel = null;
	
	
	/**
	 * 相关的实体名称
	 */
	private String strDEName = null;
	
	
	/**
	 * 历史队列实体名称
	 */
	private String strHistoryDEName = null;
	
	
	
	/**
	 * 错误属性
	 */
	private String strErrorField = null;
	
	
	/**
	 * 时间属性
	 */
	private String strTimeField = null;
	
	
	
	/**
	 * 状态属性
	 * 
	 */
	private String strStateField = null;
	
	
	/**
	 * 事务确认完成调用的实体行为的名称
	 */
	private String strConfirmDEActionName = null;

	/**
	 * 事务取消调用的实体行为的名称
	 */
	private String strCancelDEActionName = null;
	
	private int nCancelTimeout = 600000;//600秒
	
	private int nRefreshTimer = 2000;//2秒
	
	private int nQueryCancelTimeout =  900000;//900秒
	
	private String strPushDEActionName = null;
	
	private String strRefreshDEActionName = null;
	
	private HashMap<String, DTSQueueEntity> dtsQueueEntityMap = new HashMap<String, DTSQueueEntity>();
	private ArrayList<DTSQueueEntity> dtsQueueEntityList = new ArrayList<DTSQueueEntity>();
	private Object objLock = new Object();
	
	private int nMaximumPoolSize = 10;
	
	private int nBlockingQueueSize = 500;
	
	private ThreadPoolExecutor workThreadPoolExecutor = null;
	
	private ScheduledExecutorService mainThreadPoolExecutor = null;
	
	private ScheduledExecutorService queryThreadPoolExecutor = null;
	
	
	private class DTSQueueEntity {
		private IEntity iEntity = null;
		private long nStartTime = 0l;
		private long nLastRefreshTime = 0l;
		private int nState = IDTSQueue.STATE_CREATED;
		private String strKey = null;
		public DTSQueueEntity(IEntity iEntity,String strKey){
			this.iEntity = iEntity;
			this.strKey = strKey;
			this.nStartTime = System.currentTimeMillis();
			updateRefreshTime();
		}

		/**
		 * 获取数据对象
		 * @return
		 */
		public IEntity getEntity(){
			return this.iEntity;
		}
		
		public int getState(){
			return nState;
		}
	
		
		public void setState(int nState){
			this.nState = nState;
		}
		
		
		public String getKey(){
			return this.strKey;
		}
		
		
		/**
		 * 更新刷新时间
		 */
		public void updateRefreshTime(){
			this.nLastRefreshTime = System.currentTimeMillis();
		}
		
		
		/**
		 * 获取开始时间
		 * @return
		 */
		public long getStartTime(){
			return this.nStartTime;
		}
		
		/**
		 * 获取最后刷新时间
		 * @return
		 */
		public long getLastRefreshTime(){
			return this.nLastRefreshTime;
		}
	}
	
	
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.setSystemModel(iSystemModel);
		
		this.onInit();

	}
	
	@Override
	protected void onInit() throws Exception {
		this.iDEModel = this.getSystemModel().getDataEntityModel(this.getDEName());
		//this.iService = this.iDEModel.getService();
		if(!StringHelper.isNullOrEmpty(this.getHistoryDEName())){
			this.historyDEModel = this.getSystemModel().getDataEntityModel(this.getHistoryDEName());
			//this.historyService  = this.historyDEModel.getService();
		}
		
		super.onInit();
		
		start();
	}
	
	
	protected void start()throws Exception{
		
		/**
		 * 开始计时程序，完成2个功能
		 * （1）数据库中超过时长的数据的取消
		 * （2）对于当前内存中的数据的再处理
		 */
		
		this.mainThreadPoolExecutor =createMainThreadPoolExecutor();
		this.workThreadPoolExecutor =createWorkThreadPoolExecutor();
		this.queryThreadPoolExecutor = createScheduleThreadPoolExecutor();
		
		this.mainThreadPoolExecutor.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				try{
					ServiceWorkHelper.getInstance().execute(new IServiceWork(){
						@Override
						public void execute(ITransaction iTransaction) throws Exception {
							processDTSQueueEntityList();
						}
					});
				}
				catch(Exception ex){
					log.error(ex);
				}
	
			}},this.getRefreshTimer(),this.getRefreshTimer(),TimeUnit.MILLISECONDS);
		
		this.queryThreadPoolExecutor.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				processTimeoutDTSQueueEntities();
				
			}},30,30,TimeUnit.SECONDS);
	}
	
	
	/**
	 * 设置标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	/**
	 * 设置名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IDSTQueue#getDEName()
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
	 * @see net.ibizsys.paas.cache.IDSTQueue#getHistoryDEName()
	 */
	@Override
	public String getHistoryDEName() {
		return strHistoryDEName;
	}

	/**
	 * 设置历史队列实体名称
	 * @param strDEName
	 */
	public void setHistoryDEName(String strHistoryDEName) {
		this.strHistoryDEName = strHistoryDEName;
	}
	

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IDSTQueue#getErrorField()
	 */
	@Override
	public String getErrorField() {
		return strErrorField;
	}

	/**
	 * 设置错误属性
	 * @param strErrorField
	 */
	public void setErrorField(String strErrorField) {
		this.strErrorField = strErrorField;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IDSTQueue#getTimeField()
	 */
	@Override
	public String getTimeField() {
		return strTimeField;
	}

	
	/**
	 * 设置时间属性
	 * @param strTimeField
	 */
	public void setTimeField(String strTimeField) {
		this.strTimeField = strTimeField;
	}

	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.cache.IDSTQueue#getStateField()
	 */
	@Override
	public String getStateField() {
		return strStateField;
	}

	/**
	 * 设置状态属性
	 * @param strStateField
	 */
	public void setStateField(String strStateField) {
		this.strStateField = strStateField;
	}

	


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.dts.IDTSQueue#getConfirmDEActionName()
	 */
	@Override
	public String getConfirmDEActionName() {
		return this.strConfirmDEActionName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.dts.IDTSQueue#getCancelDEActionName()
	 */
	@Override
	public String getCancelDEActionName() {
		return this.strCancelDEActionName;
	}

	/**
	 * 设置事务确认完成调用的实体行为的名称
	 * @param strConfirmDEActionName
	 */
	public void setConfirmDEActionName(String strConfirmDEActionName) {
		this.strConfirmDEActionName = strConfirmDEActionName;
	}

	/**
	 * 设置事务取消调用的实体行为的名称
	 * @param strCancelDEActionName
	 */
	public void setCancelDEActionName(String strCancelDEActionName) {
		this.strCancelDEActionName = strCancelDEActionName;
	}

	@Override
	public int getCancelTimeout() {
		return this.nCancelTimeout;
	}

	@Override
	public int getRefreshTimer() {
		return this.nRefreshTimer;
	}

	@Override
	public String getPushDEActionName() {
		return this.strPushDEActionName;
	}

	@Override
	public String getRefreshDEActionName() {
		return this.strRefreshDEActionName;
	}

	/**
	 * 获取取消的超时时长
	 * @param nCancelTimeout
	 */
	public void setCancelTimeout(int nCancelTimeout) {
		this.nCancelTimeout = nCancelTimeout;
	}

	/**
	 * 设置刷新队列状态时长
	 * @param nRefreshTimer
	 */
	public void setRefreshTimer(int nRefreshTimer) {
		this.nRefreshTimer = nRefreshTimer;
	}

	/**
	 * 设置推送队列实体行为名称
	 * @param strPushDEActionName
	 */
	public void setPushDEActionName(String strPushDEActionName) {
		this.strPushDEActionName = strPushDEActionName;
	}

	/**
	 * 设置刷新队列实体行为名称
	 * @param strRefreshDEActionName
	 */
	public void setRefreshDEActionName(String strRefreshDEActionName) {
		this.strRefreshDEActionName = strRefreshDEActionName;
	}
	
	
	
	
	@Override
	public int getQueryCancelTimeout() {
		return this.nQueryCancelTimeout;
	}
	
	/**
	 * 设置查询超时时长
	 * @param nQueryCancelTimeout
	 */
	public void setQueryCancelTimeout(int nQueryCancelTimeout){
		this.nQueryCancelTimeout = nQueryCancelTimeout;
	}

	@Override
	public IDataEntityModel getDEModel() {
		return this.iDEModel;
	}
	
	/**
	 * 获取实体服务对象
	 * @return
	 */
	protected IService getService(){
		if(this.iService==null){
			this.iService = this.getDEModel().getService();
		}
		return this.iService;
	}
	
	
	/**
	 * 获取历史实体服务对象
	 * @return
	 */
	protected IDataEntityModel getHistoryDEModel() {
		return this.historyDEModel;
	}
	
	/**
	 * 获取历史实体服务对象
	 * @return
	 */
	protected IService getHistoryService(){
		if(this.historyService==null){
			this.historyService = this.getHistoryDEModel().getService();
		}
		return this.historyService;
	}
	

	@Override
	public void push(IEntity iEntity) throws Exception {
		String strKey = DataObject.getStringValue(iEntity.get(this.getDEModel().getKeyDEField().getName()),null);
		if(StringHelper.isNullOrEmpty(strKey)){
			throw new ErrorException(Errors.INVALIDDATAKEYS, this.getDEModel());
		}
		
		DTSQueueEntity dtsQueueEntity = null;
		synchronized (objLock) {
			if(!dtsQueueEntityMap.containsKey(strKey)){
				dtsQueueEntity = new DTSQueueEntity(iEntity,strKey);
				dtsQueueEntityMap.put(strKey, dtsQueueEntity);
				this.dtsQueueEntityList.add(dtsQueueEntity);
			}
		}
		
		if(dtsQueueEntity == null)
			return;
		
		push(dtsQueueEntity);
	}

	
	/**
	 * 推送队列数据
	 * @param dtsQueueEntity
	 */
	protected void push(final DTSQueueEntity dtsQueueEntity){
		this.workThreadPoolExecutor.execute(new Runnable(){
			@Override
			public void run() {
				executeQueueAction(dtsQueueEntity,getPushDEActionName(),IDTSQueue.STATE_PROCESSING);
			}
		});
	}
	
	/**
	 * 刷新队列数据
	 * @param dtsQueueEntity
	 */
	protected void refresh(final DTSQueueEntity dtsQueueEntity){
		this.workThreadPoolExecutor.execute(new Runnable(){
			@Override
			public void run() {
				executeQueueAction(dtsQueueEntity,getRefreshDEActionName(),IDTSQueue.STATE_PROCESSING);
			}
		});
	}
	
	/**
	 * 执行队列操作
	 * @param dtsQueueEntity
	 * @param strAction
	 */
	protected void executeQueueAction(final DTSQueueEntity dtsQueueEntity,final String strAction,final int nQueueState){
		
		try{
			ServiceWorkHelper.getInstance().execute(new IServiceWork(){
				@Override
				public void execute(ITransaction iTransaction) throws Exception {
					IEntity et = getDEModel().createEntity();
					dtsQueueEntity.getEntity().copyTo(et, false);
					getService().executeAction(strAction, et);
					int nCurState =DataObject.getIntegerValue(et,getStateField(),nQueueState);
					DTSQueueEntity moveDTSQueueEntity = null;
					synchronized (objLock) {
						DTSQueueEntity dtsQueueEntity2 = dtsQueueEntityMap.get(dtsQueueEntity.getKey());
						if(dtsQueueEntity2!=null){
							if(nCurState==IDTSQueue.STATE_FINISHED || nCurState==IDTSQueue.STATE_FAILED || nCurState==IDTSQueue.STATE_CANCELLED){
								dtsQueueEntityMap.remove(dtsQueueEntity2.getKey());
								dtsQueueEntityList.remove(dtsQueueEntity2);
								moveDTSQueueEntity = dtsQueueEntity2;
							}
							else{
								dtsQueueEntity2.setState(nCurState);
							}
						}
					}
					//如果有确认行为，则调用
					try{
						if(nCurState==IDTSQueue.STATE_FINISHED){
							if(!StringHelper.isNullOrEmpty(getConfirmDEActionName())){
								getService().executeAction(getConfirmDEActionName(), et);
							}
						}
						
					}
					catch(Exception ex){
						//可能需要日志错误信息
						log.error(ex);
					}
					
					//判断是否需要移除
					if(moveDTSQueueEntity!=null){
						moveToHistory(moveDTSQueueEntity);
					}
					
				}
			});
		}
		catch(Exception ex){
			log.error(ex);
		}
	}
	
	/**
	 * 移动数据到历史队列中
	 * @param dtsQueueEntity
	 */
	protected void moveToHistory(final DTSQueueEntity dtsQueueEntity){
		if(this.getHistoryDEModel()==null)
			return;
		
		try{
			ServiceWorkHelper.getInstance().execute(new IServiceWork(){
				@Override
				public void execute(ITransaction iTransaction) throws Exception {
					IEntity et = getDEModel().createEntity();
					et.set(getDEModel().getKeyDEField().getName(),dtsQueueEntity.getKey());
					getService().get(et);
					IEntity historyET = getHistoryDEModel().createEntity();
					et.copyTo(historyET, false);
					historyET.set(getHistoryDEModel().getKeyDEField().getName(), dtsQueueEntity.getKey());
					if(getHistoryDEModel().getMajorDEField()!=null && getDEModel().getMajorDEField()!=null){
						historyET.set(getHistoryDEModel().getMajorDEField().getName(),et.get(getDEModel().getMajorDEField().getName()));
					}
					getHistoryService().save(historyET,false);
					getService().remove(et);
				}
			});
		}
		catch(Exception ex){
			log.error(ex);
		}
	}
	
	
	protected ScheduledExecutorService createScheduleThreadPoolExecutor(){
		return Executors.newScheduledThreadPool(1);
	}
	
	protected ScheduledExecutorService createMainThreadPoolExecutor(){
		return Executors.newScheduledThreadPool(1);
	}
	
	protected ThreadPoolExecutor createWorkThreadPoolExecutor(){
		return  new ThreadPoolExecutor(0, getMaximumPoolSize(), 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(getBlockingQueueSize()), new ThreadPoolExecutor.AbortPolicy());
	}
	
	protected int getMaximumPoolSize(){
		return this.nMaximumPoolSize;
	}
	
	protected int getBlockingQueueSize(){
		return this.nBlockingQueueSize;
	}
	
	/**
	 * 处理内存中的数据
	 */
	protected void processDTSQueueEntityList(){
		DTSQueueEntity[] list = null;
		synchronized(this.objLock){
			int nSize= this.dtsQueueEntityMap.size();
			if(nSize>0){
				list = this.dtsQueueEntityMap.values().toArray(new DTSQueueEntity[nSize]);
			}
		}
		if(list!=null){
			long nCurTime = System.currentTimeMillis();
			for(DTSQueueEntity dtsQueueEntity:list){
				if(nCurTime - dtsQueueEntity.getStartTime() > this.getCancelTimeout()){
					executeQueueAction(dtsQueueEntity,getCancelDEActionName(),IDTSQueue.STATE_CANCELLED);
					continue;
				}
				
				if(nCurTime - dtsQueueEntity.getLastRefreshTime() > this.getRefreshTimer()){
					executeQueueAction(dtsQueueEntity,getRefreshDEActionName(),IDTSQueue.STATE_PROCESSING);
					continue;
				}
			}
		}
		
		
	}
	
	
	/**
	 * 处理数据库中的超时数据
	 */
	protected void processTimeoutDTSQueueEntities(){
		
		try{
			ServiceWorkHelper.getInstance().execute(new IServiceWork(){
				@Override
				public void execute(ITransaction iTransaction) throws Exception {
					if(getService()==null)
						return;
					
					SelectContext selectContext = new SelectContext();
					SelectGroupFilter selectGroupFilter = new SelectGroupFilter();
					//放入状态
					if(true){
						SelectGroupFilter selectStateGroupFilter = new SelectGroupFilter();
						selectStateGroupFilter.setCondOp(ICondition.CONDOP_OR);
						if(true){
							SelectFieldFilter selectFieldFilter = new SelectFieldFilter();
							selectFieldFilter.setDEFName(getStateField());
							selectFieldFilter.setCondOp(ICondition.CONDOP_EQ);
							selectFieldFilter.setCondObjectValue(IDTSQueue.STATE_CREATED);
							selectStateGroupFilter.getSelectFilterList(true).add(selectFieldFilter);
						}
						if(true){
							SelectFieldFilter selectFieldFilter = new SelectFieldFilter();
							selectFieldFilter.setDEFName(getStateField());
							selectFieldFilter.setCondOp(ICondition.CONDOP_EQ);
							selectFieldFilter.setCondObjectValue(IDTSQueue.STATE_PROCESSING);
							selectStateGroupFilter.getSelectFilterList(true).add(selectFieldFilter);
						}
						selectGroupFilter.getSelectFilterList(true).add(selectStateGroupFilter);
					}
					//放入时间
					if(true){
						SelectFieldFilter timeFilter = new SelectFieldFilter();
						timeFilter.setDEFName(getTimeField());
						timeFilter.setCondOp(ICondition.CONDOP_LT);
						timeFilter.setCondObjectValue(new java.sql.Timestamp((System.currentTimeMillis() - getQueryCancelTimeout())));
						selectGroupFilter.getSelectFilterList(true).add(timeFilter);
					}
					
					selectContext.setSelectFilter(selectGroupFilter);
					selectContext.setMaxRowCount(1000);
					
					ArrayList<IEntity> list = getService().select(selectContext);
					for(IEntity iEntity:list){
						DTSQueueEntity dtsQueueEntity = new DTSQueueEntity(iEntity,DataObject.getStringValue(iEntity.get(getDEModel().getKeyDEField().getName()))); 
						executeQueueAction(dtsQueueEntity,getCancelDEActionName(),IDTSQueue.STATE_CANCELLED);
						moveToHistory(dtsQueueEntity);
					}
				}
			});
		}
		catch(Exception ex){
			log.error(ex);
		}	
		
		
		
		
	}
}
