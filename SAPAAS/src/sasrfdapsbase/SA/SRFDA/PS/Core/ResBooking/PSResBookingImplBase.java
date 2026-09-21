/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.ResBooking.IPSBookingResType;
import SA.SRFDA.PS.Core.ResBooking.IPSResBookingDispatcherContext;
import SA.SRFDA.PS.Core.ResBooking.IPSResBookingRuntime;
import SA.SRFDA.PS.Core.ResBooking.PSResBookingHandler;
import java.sql.Timestamp;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSResBookingImplBase
extends PSObjectImpl
implements IPSResBookingRuntime {
    private static final Log log = LogFactory.getLog(PSResBookingImplBase.class);
    private int nState = 0;
    private long nBeginTime = 0L;
    private long nEndTime = 0L;
    private Boolean bRunning = false;
    private String strBookingResType = null;
    private Timestamp lastUpdateTime = null;
    private IPSBookingResType iPSBookingResType = null;
    private IEntity resBookingData = null;
    private IPSResBookingDispatcherContext iPSResBookingDispatcherContext = null;
    private Object objRunningLock = new Object();
    private String strStudioConsoleId = null;

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public int getState() {
        return this.nState;
    }

    protected void setState(int nState) {
        if (this.isRunning()) {
            return;
        }
        this.nState = nState;
    }

    protected void gotoState(int nNewState, int nOldState) {
        if (!this.isRunning()) {
            log.warn((Object)StringHelper.format((String)"\u8d44\u6e90\u9884\u7ea6[%1$s]\u5207\u6362\u72b6\u6001\u6ca1\u6709\u5728\u5de5\u4f5c\u7ebf\u7a0b\u4e2d", (Object)this.getName()));
        }
        long nStartTime = System.currentTimeMillis();
        log.debug((Object)StringHelper.format((String)"\u8d44\u6e90\u9884\u7ea6[%1$s][%2$s]\u5207\u6362\u72b6\u6001[%3$s => %4$s]\u5f00\u59cb", (Object)this.getBookingResType(), (Object)this.getName(), (Object)nOldState, (Object)nNewState));
        this.onGotoState(nNewState, nOldState);
        nStartTime = System.currentTimeMillis() - nStartTime;
        log.debug((Object)StringHelper.format((String)"\u8d44\u6e90\u9884\u7ea6[%1$s][%2$s]\u5207\u6362\u72b6\u6001[%3$s => %4$s]\u7ed3\u675f\uff0c\u8017\u65f6[%5$s]ms", (Object)this.getBookingResType(), (Object)this.getName(), (Object)nOldState, (Object)nNewState, (Object)nStartTime));
        this.nState = nNewState;
    }

    protected void onGotoState(int nNewState, int nOldState) {
    }

    @Override
    public long getBeginTime() {
        return this.nBeginTime;
    }

    @Override
    public long getEndTime() {
        return this.nEndTime;
    }

    protected void setBeginTime(long nBeginTime) {
        this.nBeginTime = nBeginTime;
    }

    protected void setEndTime(long nEndTime) {
        this.nEndTime = nEndTime;
    }

    @Override
    public void close() {
        this.onClose();
    }

    protected void onClose() {
    }

    @Override
    public boolean run() {
        if (this.isRunning()) {
            return false;
        }
        long nCurTime = System.currentTimeMillis();
        int nState = this.getState();
        switch (nState) {
            case 10: {
                if (nCurTime < this.getBeginTime() - 300000L || nCurTime >= this.getEndTime()) break;
                this.getPSResBookingDispatcherContext().executeTask(new PSResBookingHandler(this){

                    @Override
                    protected void onRun() {
                        PSResBookingImplBase.this.gotoState(15, 10);
                    }
                });
                break;
            }
            case 15: {
                if (nCurTime < this.getBeginTime() || nCurTime >= this.getEndTime()) break;
                this.getPSResBookingDispatcherContext().executeTask(new PSResBookingHandler(this){

                    @Override
                    protected void onRun() {
                        PSResBookingImplBase.this.gotoState(20, 15);
                    }
                });
                break;
            }
            case 20: {
                long nLeave = this.getEndTime() - nCurTime;
                if (nLeave > 600000L) break;
                this.getPSResBookingDispatcherContext().executeTask(new PSResBookingHandler(this){

                    @Override
                    protected void onRun() {
                        PSResBookingImplBase.this.gotoState(25, 20);
                    }
                });
                break;
            }
            case 25: {
                long nLeave = this.getEndTime() - nCurTime;
                if (nLeave < 30000L || nLeave > 60000L) break;
                this.getPSResBookingDispatcherContext().executeTask(new PSResBookingHandler(this){

                    @Override
                    protected void onRun() {
                        PSResBookingImplBase.this.gotoState(30, 25);
                    }
                });
                break;
            }
        }
        return this.isRunning();
    }

    @Override
    public boolean isRunning() {
        boolean bRunning = this.bRunning;
        return bRunning;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setRunning(boolean bRunning) {
        Object object = this.objRunningLock;
        synchronized (object) {
            this.bRunning = bRunning;
        }
    }

    @Override
    public String getBookingResType() {
        return this.strBookingResType;
    }

    protected void setBookingResType(String strBookingResType) {
        this.strBookingResType = strBookingResType;
    }

    protected Timestamp getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @Override
    public IPSBookingResType getPSBookingResType() {
        return this.iPSBookingResType;
    }

    protected void setPSBookingResType(IPSBookingResType iPSBookingResType) {
        this.iPSBookingResType = iPSBookingResType;
    }

    protected void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public IEntity getResBookingData() {
        return this.resBookingData;
    }

    protected void setResBookingData(IEntity resBookingData) {
        this.resBookingData = resBookingData;
    }

    protected IPSResBookingDispatcherContext getPSResBookingDispatcherContext() {
        return this.iPSResBookingDispatcherContext;
    }

    protected void setPSResBookingDispatcherContext(IPSResBookingDispatcherContext iPSResBookingDispatcherContext) {
        this.iPSResBookingDispatcherContext = iPSResBookingDispatcherContext;
    }

    protected String getStudioConsoleId() {
        return this.strStudioConsoleId;
    }

    protected void setStudioConsoleId(String strStudioConsoleId) {
        this.strStudioConsoleId = strStudioConsoleId;
    }

    protected void sendStudioConsole(String strTopic, String strLogType, String strContent) {
        this.sendStudioConsole(strTopic, strLogType, strContent, null);
    }

    protected void sendStudioConsole(String strTopic, String strLogType, String strContent, String strLogger) {
        if (PSTaskServerEnvImpl.getCurrent() != null && PSTaskServerEnvImpl.getCurrent().isDebugConsoleInfo()) {
            log.debug((Object)StringHelper.format((String)"CONSOLE[%1$s][%2$s][%3$s][%4$s]", (Object)strTopic, (Object)strLogType, (Object)strContent, (Object)strLogger));
        }
        if (PSStudioConsoleHelper.getCurrent() != null) {
            if (StringHelper.isNullOrEmpty((String)strTopic)) {
                strTopic = this.getStudioConsoleId();
            }
            if (StringHelper.isNullOrEmpty((String)strTopic)) {
                return;
            }
            if (!StringHelper.isNullOrEmpty((String)strLogType)) {
                strContent = StringHelper.compare((String)strLogType, (String)"INFO", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent((String)strContent, (int)34, (int)-1, (int)0) : (StringHelper.compare((String)strLogType, (String)"WARN", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent((String)strContent, (int)33, (int)-1, (int)1) : (StringHelper.compare((String)strLogType, (String)"ERROR", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent((String)strContent, (int)31, (int)-1, (int)1) : PSStudioConsoleHelper.getContent((String)strContent, (int)32, (int)-1, (int)0)));
            }
            PSStudioConsoleHelper.getCurrent().sendConsole(strTopic, strContent, strLogger);
        }
    }
}

