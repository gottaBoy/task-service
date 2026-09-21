/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDBCallerHelperEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.DateParser
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.WebEx.Utility.ContextHelper
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SRFTS.Ctrl;

import SA.SRFramework.DataEx.BaseDBCallerHelperEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.DateParser;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import SRFTS.Ctrl.Data.TSTaskItem;
import SRFTS.Ctrl.ISRFTSEngine;
import SRFTS.Ctrl.ISRFTSTask;
import SRFTS.Ctrl.ISRFTSTaskContext;
import SRFTS.Ctrl.ITSDataCtrl;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFTSTaskProxy
extends TimerTask
implements ISRFTSTaskContext {
    protected TSTaskItem tsTaskItem = null;
    protected BaseDBCallerHelperEx dbCallerHelper = null;
    private Timer tsTimer = null;
    protected ISRFTSTask isrfTSTask = null;
    protected ITSDataCtrl tsDataCtrl = null;
    protected boolean bFinish = false;
    private static Log log = LogFactory.getLog(SRFTSTaskProxy.class);
    protected ContextHelper contextHelper = null;
    protected ISRFExGlobalHelper iGlobalHelper = null;
    protected ISRFTSEngine iTSEngine = null;
    protected Date startRunTime = null;

    public CallResult Start(ISRFTSEngine iTSEngine, TSTaskItem tsTaskItem, BaseDBCallerHelperEx dbCallerHelper, ITSDataCtrl tsDataCtrl, ISRFExGlobalHelper iGlobalHelper) {
        CallResult callResult = new CallResult();
        this.iTSEngine = iTSEngine;
        this.iGlobalHelper = iGlobalHelper;
        if (iGlobalHelper instanceof ContextHelper) {
            this.contextHelper = (ContextHelper)iGlobalHelper;
        }
        this.tsTaskItem = tsTaskItem;
        this.dbCallerHelper = dbCallerHelper;
        this.tsDataCtrl = tsDataCtrl;
        this.bFinish = false;
        Object obj = ObjectHelper.Create((String)this.tsTaskItem.getTASKOBJECT());
        if (obj == null || !(obj instanceof ISRFTSTask)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u65e0\u6548\u6216\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3ISRFTSTask", (Object)this.tsTaskItem.getTASKOBJECT()));
            return callResult;
        }
        this.isrfTSTask = (ISRFTSTask)obj;
        this.tsTimer = new Timer(this.tsTaskItem.getTSTASKITEMID());
        this.tsTimer.schedule((TimerTask)this, this.tsTaskItem.getREALTIME());
        return callResult;
    }

    @Override
    public void run() {
        if (this.iTSEngine.AddRunningTask(this.tsTaskItem.getTSTASKID())) {
            this.InternalRun();
            this.iTSEngine.RemoveRunningTask(this.tsTaskItem.getTSTASKID());
        } else {
            log.error((Object)StringHelper.Format((String)"\u4efb\u52a1\u9879[%1$s]\u6682\u4e0d\u6267\u884c\uff0c\u76ee\u524d\u5df2\u6709\u76f8\u540c\u4efb\u52a1\u6b63\u5728\u6267\u884c\u8fc7\u7a0b\u4e2d", (Object)this.tsTaskItem.getTSTASKITEMID()));
        }
        this.bFinish = true;
    }

    protected void InternalRun() {
        CallResult taskRunResult;
        CallResult callResult;
        this.startRunTime = new Date();
        long nCurTime = this.startRunTime.getTime();
        log.info((Object)StringHelper.Format((String)"\u5f00\u59cb\u6267\u884c\u8ba1\u5212\u4efb\u52a1\u9879[%3$s][%1$s]\uff0c\u8ba1\u5212\u8fd0\u884c\u65f6\u95f4[%2$s]", (Object)this.tsTaskItem.getTSTASKITEMID(), (Object)DateParser.toDateTimeString((Date)this.tsTaskItem.getREALTIME()), (Object)this.tsTaskItem.getTASKITEMINFO()));
        try {
            callResult = this.tsDataCtrl.PrepareRunTaskItem(this.tsTaskItem);
            if (callResult == null || callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u4efb\u52a1\u9879[%1$s]\u72b6\u6001\u5931\u8d25", (Object)this.tsTaskItem.getTSTASKITEMID()));
                return;
            }
            if (callResult.getUserObject() == null) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u4efb\u52a1\u9879[%1$s]\u72b6\u6001\u5931\u8d25", (Object)this.tsTaskItem.getTSTASKITEMID()));
                return;
            }
            if (!((Boolean)callResult.getUserObject()).booleanValue()) {
                log.error((Object)StringHelper.Format((String)"\u4efb\u52a1\u9879[%1$s]\u72b6\u6001\u65e0\u6548", (Object)this.tsTaskItem.getTSTASKITEMID()));
                return;
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u4efb\u52a1\u9879[%1$s]\u5931\u8d25", (Object)this.tsTaskItem.getTSTASKITEMID()), (Throwable)ex);
            return;
        }
        try {
            callResult = this.tsDataCtrl.StartRunTaskItem(this.tsTaskItem);
            if (callResult == null || callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u542f\u52a8\u4efb\u52a1\u9879[%1$s]\u5931\u8d25,%2$s", (Object)this.tsTaskItem.getTSTASKITEMID(), (Object)(callResult == null ? "\u4e0d\u660e\u9519\u8bef" : callResult.getErrorInfo())));
                return;
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u542f\u52a8\u4efb\u52a1\u9879[%1$s]\u5931\u8d25", (Object)this.tsTaskItem.getTSTASKITEMID()), (Throwable)ex);
            return;
        }
        try {
            taskRunResult = this.isrfTSTask.Run(this);
            if (taskRunResult == null) {
                taskRunResult = new CallResult();
                taskRunResult.setRetCode(1);
                taskRunResult.setErrorInfo("\u6ca1\u6709\u8fd4\u56de\u7ed3\u679c\u5bf9\u8c61");
            }
        }
        catch (Exception ex) {
            taskRunResult = new CallResult();
            taskRunResult.setRetCode(1);
            taskRunResult.setErrorInfo(ex.getMessage());
        }
        if (this.tsDataCtrl != null && this.tsTaskItem != null) {
            try {
                CallResult callResult2 = this.tsDataCtrl.FinishRunTaskItem(this.tsTaskItem, taskRunResult);
                if (callResult2 == null || callResult2.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u5b8c\u6210\u4efb\u52a1\u9879[%1$s]\u5931\u8d25", (Object)this.tsTaskItem.getTSTASKITEMID()));
                    return;
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5b8c\u6210\u4efb\u52a1\u9879[%1$s]\u5931\u8d25", (Object)this.tsTaskItem.getTSTASKITEMID()), (Throwable)ex);
                return;
            }
        }
        nCurTime = new Date().getTime() - nCurTime;
        log.debug((Object)StringHelper.Format((String)"\u7ed3\u675f\u6267\u884c\u8ba1\u5212\u4efb\u52a1\u9879[%3$s][%1$s]\uff0c\u8fd0\u884c\u8017\u65f6[%2$s]ms", (Object)this.tsTaskItem.getTSTASKITEMID(), (Object)nCurTime, (Object)this.tsTaskItem.getTASKITEMINFO()));
    }

    @Override
    public BaseDBCallerHelperEx getDBCallerHelper() {
        return this.dbCallerHelper;
    }

    @Override
    public TSTaskItem getTaskItem() {
        return this.tsTaskItem;
    }

    @Override
    public ContextHelper getContextHelper() {
        return this.contextHelper;
    }

    @Override
    public Object getAttribute(String strParam) {
        return this.contextHelper;
    }

    @Override
    public ISRFExGlobalHelper getGlobalHelper() {
        return this.iGlobalHelper;
    }

    @Override
    public ISRFTSEngine getTSEngine() {
        return this.iTSEngine;
    }

    public void Close() {
        try {
            this.tsTaskItem = null;
            this.dbCallerHelper = null;
            this.tsDataCtrl = null;
            this.contextHelper = null;
            this.iGlobalHelper = null;
            this.tsTimer.cancel();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public boolean isFinish() {
        return this.bFinish;
    }

    public void UserStop() {
        try {
            this.bFinish = true;
            if (this.tsDataCtrl != null && this.tsTaskItem != null) {
                CallResult taskRunResult = new CallResult();
                taskRunResult.setRetCode(1);
                taskRunResult.setErrorInfo("\u7528\u6237\u5173\u95ed\u4efb\u52a1");
                this.iTSEngine.RemoveRunningTask(this.tsTaskItem.getTSTASKID());
                CallResult callResult = this.tsDataCtrl.FinishRunTaskItem(this.tsTaskItem, taskRunResult);
                if (callResult == null || callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u5b8c\u6210\u4efb\u52a1\u9879[%1$s]\u5931\u8d25", (Object)this.tsTaskItem.getTSTASKITEMID()));
                    return;
                }
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5b8c\u6210\u4efb\u52a1\u9879[%1$s]\u5931\u8d25", (Object)this.tsTaskItem.getTSTASKITEMID()), (Throwable)ex);
            return;
        }
    }

    public boolean IsTimeout(long nTIMER) {
        if (this.startRunTime == null || this.bFinish) {
            return false;
        }
        Date dtNow = new Date();
        long nInterval = dtNow.getTime() - this.startRunTime.getTime();
        return nInterval > nTIMER;
    }
}

