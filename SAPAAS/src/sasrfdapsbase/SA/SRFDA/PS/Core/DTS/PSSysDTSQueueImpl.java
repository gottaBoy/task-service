/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DTS;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DTS.IPSSysDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDTSQueue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDTSQueueImpl
extends PSSystemObjectImpl
implements IPSSysDTSQueue {
    private static final Log log = LogFactory.getLog(PSSysDTSQueueImpl.class);
    protected PSSysDTSQueue psSysDTSQueue = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDataEntity historyPSDataEntity = null;
    private IPSDEField timePSDEField = null;
    private IPSDEField errorPSDEField = null;
    private IPSDEField statePSDEField = null;
    private IPSDEAction confirmPSDEAction = null;
    private IPSDEAction cancelPSDEAction = null;
    private int nCancelTimeout = -1;
    private int nRefreshTimer = -1;
    private IPSDEAction pushPSDEAction = null;
    private IPSDEAction refreshPSDEAction = null;
    private IPSSystemModule iPSSystemModule = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysDTSQueue psSysDTSQueue) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysDTSQueue = psSysDTSQueue;
            this.setId(this.psSysDTSQueue.getPSDEDTSQUEUEID());
            this.setName(this.psSysDTSQueue.getPSDEDTSQUEUENAME());
            this.setPSObjectData(this.psSysDTSQueue);
            if (StringHelper.isNullOrEmpty((String)this.psSysDTSQueue.getPSDEID())) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u5206\u5e03\u4e8b\u52a1\u961f\u5217\u7684\u5b9e\u4f53");
            }
            this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysDTSQueue.getPSDEID());
            this.timePSDEField = !StringHelper.isNullOrEmpty((String)this.psSysDTSQueue.getTIMEPSDEFID()) ? this.getPSDataEntity().getPSDEField(this.psSysDTSQueue.getTIMEPSDEFID()) : this.getPSDataEntity().getPSDEFieldByPDT("CREATEDATE", true);
            if (!StringHelper.isNullOrEmpty((String)this.psSysDTSQueue.getERRORPSDEFID())) {
                this.errorPSDEField = this.getPSDataEntity().getPSDEField(this.psSysDTSQueue.getERRORPSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDTSQueue.getSTATEPSDEFID())) {
                this.statePSDEField = this.getPSDataEntity().getPSDEField(this.psSysDTSQueue.getSTATEPSDEFID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDTSQueue.getCANCELPSDEACTIONID())) {
                this.cancelPSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysDTSQueue.getCANCELPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDTSQueue.getFINISHPSDEACTIONID())) {
                this.confirmPSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysDTSQueue.getFINISHPSDEACTIONID());
            }
            if (!this.psSysDTSQueue.isCANCELTIMEOUTNull() && this.psSysDTSQueue.getCANCELTIMEOUT() > 0) {
                this.nCancelTimeout = this.psSysDTSQueue.getCANCELTIMEOUT();
            }
            if (!this.psSysDTSQueue.isREFRESHTIMERNull() && this.psSysDTSQueue.getREFRESHTIMER() > 0) {
                this.nRefreshTimer = this.psSysDTSQueue.getREFRESHTIMER();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDTSQueue.getPUSHPSDEACTIONID())) {
                this.pushPSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysDTSQueue.getPUSHPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDTSQueue.getREFRESHPSDEACTIONID())) {
                this.refreshPSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysDTSQueue.getREFRESHPSDEACTIONID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysDTSQueue.getHISTORYPSDEID())) {
                this.historyPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysDTSQueue.getHISTORYPSDEID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSSYSDTSQUEUE";
    }

    @Override
    public String getDEName() {
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity().getName();
        }
        return null;
    }

    @Override
    public String getErrorField() {
        if (this.getErrorPSDEField() != null) {
            return this.getErrorPSDEField().getName();
        }
        return null;
    }

    @Override
    public String getStateField() {
        if (this.getStatePSDEField() != null) {
            return this.getStatePSDEField().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u65f6\u95f4\u5c5e\u6027\u5bf9\u8c61", dumpref=true, from="IPSDataEntity")
    public IPSDEField getTimePSDEField() {
        return this.timePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9519\u8bef\u5c5e\u6027\u5bf9\u8c61", dumpref=true, from="IPSDataEntity")
    public IPSDEField getErrorPSDEField() {
        return this.errorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u5c5e\u6027\u5bf9\u8c61", dumpref=true, from="IPSDataEntity")
    public IPSDEField getStatePSDEField() {
        return this.statePSDEField;
    }

    @Override
    public String getTimeField() {
        if (this.getTimePSDEField() != null) {
            return this.getTimePSDEField().getName();
        }
        return null;
    }

    @Override
    public String getConfirmDEActionName() {
        if (this.getConfirmPSDEAction() != null) {
            return this.getConfirmPSDEAction().getName();
        }
        return null;
    }

    @Override
    public String getCancelDEActionName() {
        if (this.getCancelPSDEAction() != null) {
            return this.getCancelPSDEAction().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u53d6\u6d88\u64cd\u4f5c\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity")
    public IPSDEAction getCancelPSDEAction() {
        return this.cancelPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u786e\u8ba4\u64cd\u4f5c\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity")
    public IPSDEAction getConfirmPSDEAction() {
        return this.confirmPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u53d6\u6d88\u8d85\u65f6\u65f6\u957f\uff08\u6beb\u79d2\uff09", ignoredumpvalues="-1")
    public int getCancelTimeout() {
        return this.nCancelTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u95f4\u9694\u65f6\u957f\uff08\u6beb\u79d2\uff09", ignoredumpvalues="-1")
    public int getRefreshTimer() {
        return this.nRefreshTimer;
    }

    @Override
    @PSModelRTMeta(description="\u63a8\u9001\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity")
    public IPSDEAction getPushPSDEAction() {
        return this.pushPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u5b9e\u4f53\u884c\u4e3a", dumpref=true, from="IPSDataEntity")
    public IPSDEAction getRefreshPSDEAction() {
        return this.refreshPSDEAction;
    }

    @Override
    public String getPushDEActionName() {
        if (this.getPushPSDEAction() != null) {
            return this.getPushPSDEAction().getName();
        }
        return null;
    }

    @Override
    public String getRefreshDEActionName() {
        if (this.getRefreshPSDEAction() != null) {
            return this.getRefreshPSDEAction().getName();
        }
        return null;
    }

    @Override
    public String getHistoryDEName() {
        if (this.getHistoryPSDataEntity() != null) {
            return this.getHistoryPSDataEntity().getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5386\u53f2\u6570\u636e\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSDataEntity getHistoryPSDataEntity() {
        return this.historyPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, outputdoc="false")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psSysDTSQueue.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5df2\u5efa\u7acb\u72b6\u6001\u503c", ignoredumpvalues="10")
    public String getCreatedState() {
        return String.format("%1$s", 10);
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u4e2d\u72b6\u6001\u503c", ignoredumpvalues="20")
    public String getProcessingState() {
        return String.format("%1$s", 20);
    }

    @Override
    @PSModelRTMeta(description="\u5df2\u5b8c\u6210\u72b6\u6001\u503c", ignoredumpvalues="30")
    public String getFinishedState() {
        return String.format("%1$s", 30);
    }

    @Override
    @PSModelRTMeta(description="\u5904\u7406\u5931\u8d25\u72b6\u6001\u503c", ignoredumpvalues="40")
    public String getFailedState() {
        return String.format("%1$s", 40);
    }

    @Override
    @PSModelRTMeta(description="\u5df2\u53d6\u6d88\u72b6\u6001\u503c", ignoredumpvalues="41")
    public String getCancelledState() {
        return String.format("%1$s", 41);
    }

    @Override
    protected String onGetDynaModelFolder() {
        if (this.getPSDataEntity() != null) {
            return String.format("%1$s/%2$s/%3$s", this.getPSDataEntity().getDynaModelFolder(), Inflector.getInstance().pluralize((Object)this.getDumpModelType()).toUpperCase(), this.getDynaModelTag());
        }
        return super.onGetDynaModelFolder();
    }
}

