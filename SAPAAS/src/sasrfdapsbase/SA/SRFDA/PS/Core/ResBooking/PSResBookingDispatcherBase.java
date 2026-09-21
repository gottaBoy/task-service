/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork2;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskGlobalInfo;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.ResBooking.IPSResBooking;
import SA.SRFDA.PS.Core.ResBooking.IPSResBookingDispatcher;
import SA.SRFDA.PS.Core.ResBooking.IPSResBookingDispatcherContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSResBookingDispatcherBase
extends PSObjectImpl
implements IPSResBookingDispatcher,
IPSResBookingDispatcherContext {
    private static final Log log = LogFactory.getLog(PSResBookingDispatcherBase.class);
    private Boolean bStarted = false;
    private long nLastTaskFinishTime = 0L;
    private ThreadPoolExecutor workThreadPoolExecutor = null;
    private ScheduledExecutorService mainThreadPoolExecutor = null;
    private int nTaskThreadCount = 100;
    private long nLastQueryTime = 0L;
    private Object objThreadPoolLock = new Object();
    private Boolean bLastRunFlag = false;
    private String strQuerySql = null;
    private String strPSSvrDomainId = null;
    private HashMap<String, IPSResBooking> psResBookingMap = new HashMap();
    private ArrayList<IPSResBooking> runningPSResBookingList = new ArrayList();
    private ArrayList<IPSResBooking> tempPSResBookingList = new ArrayList();
    private IDataEntityModel psResBookingDEModel = null;
    private String strPSResBookingKeyName = null;
    private Object objStartedLock = new Object();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.strPSSvrDomainId = this.getPSModelStorage().getPSTaskServerEnv().getPSSvrDomainId();
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        this.strQuerySql = this.onCalcQuerySql();
        this.psResBookingDEModel = this.getService().getDEModel();
        this.strPSResBookingKeyName = this.psResBookingDEModel.getKeyDEField().getName();
        super.onInit();
    }

    protected abstract String onCalcQuerySql();

    protected abstract IService getService();

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    protected int getTaskThreadCount() {
        return this.nTaskThreadCount;
    }

    public boolean isStarted() {
        boolean bStarted = this.bStarted;
        return bStarted;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setStarted(boolean bStarted) {
        Object object = this.objStartedLock;
        synchronized (object) {
            this.bStarted = bStarted;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void start() {
        if (this.isStarted()) {
            return;
        }
        ScheduledExecutorService mainThreadPoolExecutor = this.createMainThreadPoolExecutor();
        ThreadPoolExecutor workThreadPoolExecutor = this.createWorkThreadPoolExecutor();
        Object object = this.objThreadPoolLock;
        synchronized (object) {
            this.mainThreadPoolExecutor = mainThreadPoolExecutor;
            this.workThreadPoolExecutor = workThreadPoolExecutor;
        }
        this.mainThreadPoolExecutor.scheduleAtFixedRate(new Runnable(){

            @Override
            public void run() {
                PSBKTaskWorkHelper.execute(new IPSBKTaskWork2(){

                    @Override
                    public void execute(Object obj) {
                        PSResBookingDispatcherBase.this.queryPSResBooking();
                        PSResBookingDispatcherBase.this.runPSResBooking();
                    }
                });
            }
        }, 5L, 5L, TimeUnit.SECONDS);
        this.onStart();
        this.setStarted(true);
    }

    protected void onStart() {
    }

    protected ScheduledExecutorService createScheduleThreadPoolExecutor() {
        return Executors.newScheduledThreadPool(1);
    }

    protected ScheduledExecutorService createMainThreadPoolExecutor() {
        return Executors.newScheduledThreadPool(1);
    }

    protected ThreadPoolExecutor createWorkThreadPoolExecutor() {
        return new ThreadPoolExecutor(0, this.getTaskThreadCount(), 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(500), new ThreadPoolExecutor.AbortPolicy());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stop() {
        if (!this.isStarted()) {
            return;
        }
        this.setStarted(false);
        this.onStop();
        Object object = this.objThreadPoolLock;
        synchronized (object) {
            List<Runnable> list = null;
            if (this.mainThreadPoolExecutor != null) {
                list = this.mainThreadPoolExecutor.shutdownNow();
            }
            if (this.workThreadPoolExecutor != null) {
                list = this.workThreadPoolExecutor.shutdownNow();
            }
            this.mainThreadPoolExecutor = null;
            this.workThreadPoolExecutor = null;
        }
    }

    protected void onStop() {
    }

    protected void queryPSResBooking() {
        long nCurTime = System.currentTimeMillis();
        if (this.nLastQueryTime + 10000L > nCurTime) {
            return;
        }
        this.nLastQueryTime = nCurTime;
        ArrayList list = null;
        try {
            SqlParamList sqlParamList = new SqlParamList();
            this.fillQuerySqlParamList(sqlParamList);
            list = this.getService().selectRaw(this.getQuerySql(), sqlParamList);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getPSResBookingDEModel().getLogicName(), (Object)ex.getMessage()), (Throwable)ex);
            return;
        }
        try {
            final ArrayList list2 = list;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSResBookingDispatcherBase.this.syncPSResBooking(list2);
                }
            });
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u540c\u6b65[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getPSResBookingDEModel().getLogicName(), (Object)ex.getMessage()), (Throwable)ex);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void syncPSResBooking(ArrayList<IEntity> list) {
        HashMap<String, IPSResBooking> hashMap = this.psResBookingMap;
        synchronized (hashMap) {
            this.tempPSResBookingList.clear();
            for (IEntity iEntity : list) {
                try {
                    String strKeyValue = DataObject.getStringValue((IDataObject)iEntity, (String)this.getPSResBookingKeyName(), null);
                    if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                        throw new Exception(StringHelper.Format((String)"\u6570\u636e\u5bf9\u8c61\u6ca1\u6709\u6307\u5b9a\u952e\u503c[%1$s]", (Object)this.getPSResBookingKeyName()));
                    }
                    IPSResBooking iPSResBooking = this.psResBookingMap.remove(strKeyValue);
                    if (iPSResBooking == null) {
                        iPSResBooking = this.createPSResBooking(iEntity);
                    } else {
                        iPSResBooking.syncEntity(iEntity);
                    }
                    this.tempPSResBookingList.add(iPSResBooking);
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u540c\u6b65[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getPSResBookingDEModel().getLogicName(), (Object)ex.getMessage()), (Throwable)ex);
                }
            }
            for (IPSResBooking iPSResBooking : this.psResBookingMap.values()) {
                this.runningPSResBookingList.remove(iPSResBooking);
                iPSResBooking.close();
            }
            this.psResBookingMap.clear();
            for (IPSResBooking iPSResBooking : this.tempPSResBookingList) {
                this.psResBookingMap.put(iPSResBooking.getId(), iPSResBooking);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void runPSResBooking() {
        HashMap<String, IPSResBooking> hashMap = this.psResBookingMap;
        synchronized (hashMap) {
            this.runningPSResBookingList.clear();
            for (Map.Entry<String, IPSResBooking> et : this.psResBookingMap.entrySet()) {
                if (!et.getValue().isRunning() && !et.getValue().run()) continue;
                this.runningPSResBookingList.add(et.getValue());
            }
        }
    }

    protected void removePSResBooking(IPSResBooking iPSResBooking) {
    }

    protected abstract IPSResBooking createPSResBooking(IEntity var1) throws Exception;

    protected void fillQuerySqlParamList(SqlParamList sqlParamList) throws Exception {
        long nTime = System.currentTimeMillis();
        Timestamp fromTime = new Timestamp(nTime + 300000L);
        Timestamp toTime = new Timestamp(nTime - 60000L);
        sqlParamList.addString(this.getPSSvrDomainId());
        sqlParamList.addDateTime((Object)fromTime);
        sqlParamList.addDateTime((Object)toTime);
    }

    protected final String getPSSvrDomainId() {
        return this.strPSSvrDomainId;
    }

    private final String getPSResBookingKeyName() {
        return this.strPSResBookingKeyName;
    }

    private final IDataEntityModel getPSResBookingDEModel() {
        return this.psResBookingDEModel;
    }

    protected final String getQuerySql() {
        return this.strQuerySql;
    }

    public int getPSResBookingCount() {
        return this.psResBookingMap.size();
    }

    @Override
    public void executeTask(Runnable command) {
        ThreadPoolExecutor workThreadPoolExecutor = this.workThreadPoolExecutor;
        if (workThreadPoolExecutor != null) {
            workThreadPoolExecutor.execute(command);
        }
    }

    public PSBKTaskGlobalInfo getPSBKTaskGlobalInfo() {
        PSBKTaskGlobalInfo psBKTaskGlobalInfo = new PSBKTaskGlobalInfo();
        HashMap<String, IPSResBooking> psResBookingMap = this.psResBookingMap;
        ArrayList<IPSResBooking> runningPSResBookingList = this.runningPSResBookingList;
        if (psResBookingMap != null) {
            psBKTaskGlobalInfo.setSessionCount(psResBookingMap.size());
        }
        if (runningPSResBookingList != null) {
            psBKTaskGlobalInfo.setRunningCount(runningPSResBookingList.size());
        }
        return psBKTaskGlobalInfo;
    }
}

