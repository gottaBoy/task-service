/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.dts;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.db.SelectGroupFilter;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.dts.IDTSQueueModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DTSQueueModel
extends SystemModelObjectBase
implements IDTSQueueModel {
    private static final Log log = LogFactory.getLog(DTSQueueModel.class);
    private IService iService = null;
    private IDataEntityModel iDEModel = null;
    private IService historyService = null;
    private IDataEntityModel historyDEModel = null;
    private String strDEName = null;
    private String strHistoryDEName = null;
    private String strErrorField = null;
    private String strTimeField = null;
    private String strStateField = null;
    private String strConfirmDEActionName = null;
    private String strCancelDEActionName = null;
    private int nCancelTimeout = 600000;
    private int nRefreshTimer = 2000;
    private int nQueryCancelTimeout = 900000;
    private String strPushDEActionName = null;
    private String strRefreshDEActionName = null;
    private HashMap<String, DTSQueueEntity> dtsQueueEntityMap = new HashMap();
    private ArrayList<DTSQueueEntity> dtsQueueEntityList = new ArrayList();
    private Object objLock = new Object();
    private int nMaximumPoolSize = 10;
    private int nBlockingQueueSize = 500;
    private ThreadPoolExecutor workThreadPoolExecutor = null;
    private ScheduledExecutorService mainThreadPoolExecutor = null;
    private ScheduledExecutorService queryThreadPoolExecutor = null;

    @Override
    public void init(ISystemModel iSystemModel) throws Exception {
        this.setSystemModel(iSystemModel);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.iDEModel = this.getSystemModel().getDataEntityModel(this.getDEName());
        if (!StringHelper.isNullOrEmpty(this.getHistoryDEName())) {
            this.historyDEModel = this.getSystemModel().getDataEntityModel(this.getHistoryDEName());
        }
        super.onInit();
        this.start();
    }

    protected void start() throws Exception {
        this.mainThreadPoolExecutor = this.createMainThreadPoolExecutor();
        this.workThreadPoolExecutor = this.createWorkThreadPoolExecutor();
        this.queryThreadPoolExecutor = this.createScheduleThreadPoolExecutor();
        this.mainThreadPoolExecutor.scheduleAtFixedRate(new Runnable(){

            @Override
            public void run() {
                try {
                    ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                        @Override
                        public void execute(ITransaction iTransaction) throws Exception {
                            DTSQueueModel.this.processDTSQueueEntityList();
                        }
                    });
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }
        }, this.getRefreshTimer(), this.getRefreshTimer(), TimeUnit.MILLISECONDS);
        this.queryThreadPoolExecutor.scheduleAtFixedRate(new Runnable(){

            @Override
            public void run() {
                DTSQueueModel.this.processTimeoutDTSQueueEntities();
            }
        }, 30L, 30L, TimeUnit.SECONDS);
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    @Override
    public String getDEName() {
        return this.strDEName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    @Override
    public String getHistoryDEName() {
        return this.strHistoryDEName;
    }

    public void setHistoryDEName(String strHistoryDEName) {
        this.strHistoryDEName = strHistoryDEName;
    }

    @Override
    public String getErrorField() {
        return this.strErrorField;
    }

    public void setErrorField(String strErrorField) {
        this.strErrorField = strErrorField;
    }

    @Override
    public String getTimeField() {
        return this.strTimeField;
    }

    public void setTimeField(String strTimeField) {
        this.strTimeField = strTimeField;
    }

    @Override
    public String getStateField() {
        return this.strStateField;
    }

    public void setStateField(String strStateField) {
        this.strStateField = strStateField;
    }

    @Override
    public String getConfirmDEActionName() {
        return this.strConfirmDEActionName;
    }

    @Override
    public String getCancelDEActionName() {
        return this.strCancelDEActionName;
    }

    public void setConfirmDEActionName(String strConfirmDEActionName) {
        this.strConfirmDEActionName = strConfirmDEActionName;
    }

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

    public void setCancelTimeout(int nCancelTimeout) {
        this.nCancelTimeout = nCancelTimeout;
    }

    public void setRefreshTimer(int nRefreshTimer) {
        this.nRefreshTimer = nRefreshTimer;
    }

    public void setPushDEActionName(String strPushDEActionName) {
        this.strPushDEActionName = strPushDEActionName;
    }

    public void setRefreshDEActionName(String strRefreshDEActionName) {
        this.strRefreshDEActionName = strRefreshDEActionName;
    }

    @Override
    public int getQueryCancelTimeout() {
        return this.nQueryCancelTimeout;
    }

    public void setQueryCancelTimeout(int nQueryCancelTimeout) {
        this.nQueryCancelTimeout = nQueryCancelTimeout;
    }

    @Override
    public IDataEntityModel getDEModel() {
        return this.iDEModel;
    }

    protected IService getService() {
        if (this.iService == null) {
            this.iService = this.getDEModel().getService();
        }
        return this.iService;
    }

    protected IDataEntityModel getHistoryDEModel() {
        return this.historyDEModel;
    }

    protected IService getHistoryService() {
        if (this.historyService == null) {
            this.historyService = this.getHistoryDEModel().getService();
        }
        return this.historyService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void push(IEntity iEntity) throws Exception {
        String strKey = DataObject.getStringValue(iEntity.get(this.getDEModel().getKeyDEField().getName()), null);
        if (StringHelper.isNullOrEmpty(strKey)) {
            throw new ErrorException(4, this.getDEModel());
        }
        DTSQueueEntity dtsQueueEntity = null;
        Object object = this.objLock;
        synchronized (object) {
            if (!this.dtsQueueEntityMap.containsKey(strKey)) {
                dtsQueueEntity = new DTSQueueEntity(iEntity, strKey);
                this.dtsQueueEntityMap.put(strKey, dtsQueueEntity);
                this.dtsQueueEntityList.add(dtsQueueEntity);
            }
        }
        if (dtsQueueEntity == null) {
            return;
        }
        this.push(dtsQueueEntity);
    }

    protected void push(final DTSQueueEntity dtsQueueEntity) {
        this.workThreadPoolExecutor.execute(new Runnable(){

            @Override
            public void run() {
                DTSQueueModel.this.executeQueueAction(dtsQueueEntity, DTSQueueModel.this.getPushDEActionName(), 20);
            }
        });
    }

    protected void refresh(final DTSQueueEntity dtsQueueEntity) {
        this.workThreadPoolExecutor.execute(new Runnable(){

            @Override
            public void run() {
                DTSQueueModel.this.executeQueueAction(dtsQueueEntity, DTSQueueModel.this.getRefreshDEActionName(), 20);
            }
        });
    }

    protected void executeQueueAction(final DTSQueueEntity dtsQueueEntity, final String strAction, final int nQueueState) {
        try {
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                @Override
                public void execute(ITransaction iTransaction) throws Exception {
                    Object et = DTSQueueModel.this.getDEModel().createEntity();
                    dtsQueueEntity.getEntity().copyTo((IDataObject)et, false);
                    DTSQueueModel.this.getService().executeAction(strAction, (IEntity)et);
                    int nCurState = DataObject.getIntegerValue(et, DTSQueueModel.this.getStateField(), nQueueState);
                    DTSQueueEntity moveDTSQueueEntity = null;
                    Object object = DTSQueueModel.this.objLock;
                    synchronized (object) {
                        DTSQueueEntity dtsQueueEntity2 = (DTSQueueEntity)DTSQueueModel.this.dtsQueueEntityMap.get(dtsQueueEntity.getKey());
                        if (dtsQueueEntity2 != null) {
                            if (nCurState == 30 || nCurState == 40 || nCurState == 41) {
                                DTSQueueModel.this.dtsQueueEntityMap.remove(dtsQueueEntity2.getKey());
                                DTSQueueModel.this.dtsQueueEntityList.remove(dtsQueueEntity2);
                                moveDTSQueueEntity = dtsQueueEntity2;
                            } else {
                                dtsQueueEntity2.setState(nCurState);
                            }
                        }
                    }
                    try {
                        if (nCurState == 30 && !StringHelper.isNullOrEmpty(DTSQueueModel.this.getConfirmDEActionName())) {
                            DTSQueueModel.this.getService().executeAction(DTSQueueModel.this.getConfirmDEActionName(), (IEntity)et);
                        }
                    }
                    catch (Exception ex) {
                        log.error((Object)ex);
                    }
                    if (moveDTSQueueEntity != null) {
                        DTSQueueModel.this.moveToHistory(moveDTSQueueEntity);
                    }
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected void moveToHistory(final DTSQueueEntity dtsQueueEntity) {
        if (this.getHistoryDEModel() == null) {
            return;
        }
        try {
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                @Override
                public void execute(ITransaction iTransaction) throws Exception {
                    Object et = DTSQueueModel.this.getDEModel().createEntity();
                    et.set(DTSQueueModel.this.getDEModel().getKeyDEField().getName(), dtsQueueEntity.getKey());
                    DTSQueueModel.this.getService().get(et);
                    Object historyET = DTSQueueModel.this.getHistoryDEModel().createEntity();
                    et.copyTo((IDataObject)historyET, false);
                    historyET.set(DTSQueueModel.this.getHistoryDEModel().getKeyDEField().getName(), dtsQueueEntity.getKey());
                    if (DTSQueueModel.this.getHistoryDEModel().getMajorDEField() != null && DTSQueueModel.this.getDEModel().getMajorDEField() != null) {
                        historyET.set(DTSQueueModel.this.getHistoryDEModel().getMajorDEField().getName(), et.get(DTSQueueModel.this.getDEModel().getMajorDEField().getName()));
                    }
                    DTSQueueModel.this.getHistoryService().save(historyET, false);
                    DTSQueueModel.this.getService().remove(et);
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected ScheduledExecutorService createScheduleThreadPoolExecutor() {
        return Executors.newScheduledThreadPool(1);
    }

    protected ScheduledExecutorService createMainThreadPoolExecutor() {
        return Executors.newScheduledThreadPool(1);
    }

    protected ThreadPoolExecutor createWorkThreadPoolExecutor() {
        return new ThreadPoolExecutor(0, this.getMaximumPoolSize(), 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(this.getBlockingQueueSize()), new ThreadPoolExecutor.AbortPolicy());
    }

    protected int getMaximumPoolSize() {
        return this.nMaximumPoolSize;
    }

    protected int getBlockingQueueSize() {
        return this.nBlockingQueueSize;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void processDTSQueueEntityList() {
        DTSQueueEntity[] list = null;
        Object object = this.objLock;
        synchronized (object) {
            int nSize = this.dtsQueueEntityMap.size();
            if (nSize > 0) {
                list = this.dtsQueueEntityMap.values().toArray(new DTSQueueEntity[nSize]);
            }
        }
        if (list != null) {
            long nCurTime = System.currentTimeMillis();
            DTSQueueEntity[] dTSQueueEntityArray = list;
            int n = list.length;
            int n2 = 0;
            while (n2 < n) {
                DTSQueueEntity dtsQueueEntity = dTSQueueEntityArray[n2];
                if (nCurTime - dtsQueueEntity.getStartTime() > (long)this.getCancelTimeout()) {
                    this.executeQueueAction(dtsQueueEntity, this.getCancelDEActionName(), 41);
                } else if (nCurTime - dtsQueueEntity.getLastRefreshTime() > (long)this.getRefreshTimer()) {
                    this.executeQueueAction(dtsQueueEntity, this.getRefreshDEActionName(), 20);
                }
                ++n2;
            }
        }
    }

    protected void processTimeoutDTSQueueEntities() {
        try {
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                @Override
                public void execute(ITransaction iTransaction) throws Exception {
                    if (DTSQueueModel.this.getService() == null) {
                        return;
                    }
                    SelectContext selectContext = new SelectContext();
                    SelectGroupFilter selectGroupFilter = new SelectGroupFilter();
                    SelectGroupFilter selectStateGroupFilter = new SelectGroupFilter();
                    selectStateGroupFilter.setCondOp("OR");
                    SelectFieldFilter selectFieldFilter = new SelectFieldFilter();
                    selectFieldFilter.setDEFName(DTSQueueModel.this.getStateField());
                    selectFieldFilter.setCondOp("EQ");
                    selectFieldFilter.setCondObjectValue(10);
                    selectStateGroupFilter.getSelectFilterList(true).add(selectFieldFilter);
                    selectFieldFilter = new SelectFieldFilter();
                    selectFieldFilter.setDEFName(DTSQueueModel.this.getStateField());
                    selectFieldFilter.setCondOp("EQ");
                    selectFieldFilter.setCondObjectValue(20);
                    selectStateGroupFilter.getSelectFilterList(true).add(selectFieldFilter);
                    selectGroupFilter.getSelectFilterList(true).add(selectStateGroupFilter);
                    SelectFieldFilter timeFilter = new SelectFieldFilter();
                    timeFilter.setDEFName(DTSQueueModel.this.getTimeField());
                    timeFilter.setCondOp("LT");
                    timeFilter.setCondObjectValue(new Timestamp(System.currentTimeMillis() - (long)DTSQueueModel.this.getQueryCancelTimeout()));
                    selectGroupFilter.getSelectFilterList(true).add(timeFilter);
                    selectContext.setSelectFilter(selectGroupFilter);
                    selectContext.setMaxRowCount(1000);
                    ArrayList list = DTSQueueModel.this.getService().select(selectContext);
                    for (IEntity iEntity : list) {
                        DTSQueueEntity dtsQueueEntity = new DTSQueueEntity(iEntity, DataObject.getStringValue(iEntity.get(DTSQueueModel.this.getDEModel().getKeyDEField().getName())));
                        DTSQueueModel.this.executeQueueAction(dtsQueueEntity, DTSQueueModel.this.getCancelDEActionName(), 41);
                        DTSQueueModel.this.moveToHistory(dtsQueueEntity);
                    }
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    private class DTSQueueEntity {
        private IEntity iEntity = null;
        private long nStartTime = 0L;
        private long nLastRefreshTime = 0L;
        private int nState = 10;
        private String strKey = null;

        public DTSQueueEntity(IEntity iEntity, String strKey) {
            this.iEntity = iEntity;
            this.strKey = strKey;
            this.nStartTime = System.currentTimeMillis();
            this.updateRefreshTime();
        }

        public IEntity getEntity() {
            return this.iEntity;
        }

        public int getState() {
            return this.nState;
        }

        public void setState(int nState) {
            this.nState = nState;
        }

        public String getKey() {
            return this.strKey;
        }

        public void updateRefreshTime() {
            this.nLastRefreshTime = System.currentTimeMillis();
        }

        public long getStartTime() {
            return this.nStartTime;
        }

        public long getLastRefreshTime() {
            return this.nLastRefreshTime;
        }
    }
}

