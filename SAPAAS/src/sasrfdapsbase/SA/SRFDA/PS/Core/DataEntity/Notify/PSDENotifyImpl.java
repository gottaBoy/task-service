/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Notify;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotifyTarget;
import SA.SRFDA.PS.Core.DataEntity.Notify.PSDENotifyTargetImpl;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgQueue;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDENotify;
import SA.SRFDA.PS.Data.PSDENotifyTarget;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDENotifyImpl
extends PSDataEntityObjectImpl
implements IPSDENotify,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDENotifyImpl.class);
    protected PSDENotify psDENotify;
    protected ArrayList<IPSDENotifyTarget> psDENotifyTargetList = new ArrayList();
    protected String strCodeName = "";
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSDEField beginTimePSDEField = null;
    private IPSDEField endTimePSDEField = null;
    private IPSSysMsgQueue iPSSysMsgQueue = null;
    private IPSSysMsgTempl iPSSysMsgTempl = null;
    private int nNotifyStart = 0;
    private int nNotifyEnd = 0;
    private int nCheckTimer = 0;
    private boolean bTimerMode = false;
    private String strCustomCond = "";
    private int nMsgType = 0;
    private int nTaskMode = 0;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDENotify psDENotify) throws Exception {
        try {
            this.setPSDataEntity(iPSDataEntity);
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.psDENotify = psDENotify;
            this.setId(psDENotify.getPSDENOTIFYID());
            this.setName(psDENotify.getPSDENOTIFYNAME());
            this.setPSObjectData(this.psDENotify);
            this.strCodeName = this.psDENotify.getCODENAME();
            if (!this.psDENotify.isTIMERMODENull()) {
                this.bTimerMode = this.psDENotify.getTIMERMODE();
            }
            if (!this.psDENotify.isMSGTYPENull()) {
                this.nMsgType = this.psDENotify.getMSGTYPE();
            }
            if (!this.psDENotify.isTASKMODENull()) {
                this.nTaskMode = this.psDENotify.getTASKMODE();
            }
            if (this.isTimerMode()) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDENotify.getPSDEDSID())) {
                    this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psDENotify.getPSDEDSID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDENotify.getBEGINPSDEFID())) {
                    this.beginTimePSDEField = this.getPSDataEntity().getPSDEField(this.psDENotify.getBEGINPSDEFID());
                }
                if (this.getPSDEDataSet() == null) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u68c0\u67e5\u7684\u6570\u636e\u96c6");
                }
                if (this.getBeginTimePSDEField() == null) {
                    throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5f00\u59cb\u65f6\u95f4\u5c5e\u6027");
                }
                this.getBeginTimePSDEField().getPSDEFSearchMode(String.format("N_%1$s_LTANDEQ", this.getBeginTimePSDEField().getName()), false);
                this.getBeginTimePSDEField().getPSDEFSearchMode(String.format("N_%1$s_GTANDEQ", this.getBeginTimePSDEField().getName()), false);
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDENotify.getENDPSDEFID())) {
                    this.endTimePSDEField = this.getPSDataEntity().getPSDEField(this.psDENotify.getENDPSDEFID());
                }
                if (this.getEndTimePSDEField() != null) {
                    this.getEndTimePSDEField().getPSDEFSearchMode(String.format("N_%1$s_LTANDEQ", this.getEndTimePSDEField().getName()), false);
                    this.getEndTimePSDEField().getPSDEFSearchMode(String.format("N_%1$s_GTANDEQ", this.getEndTimePSDEField().getName()), false);
                }
                if (!this.psDENotify.isNOTIFYSTARTNull()) {
                    this.nNotifyStart = this.psDENotify.getNOTIFYSTART();
                }
                if (!this.psDENotify.isNOTIFYENDNull()) {
                    this.nNotifyEnd = this.psDENotify.getNOTIFYEND();
                }
                if (!this.psDENotify.isCHECKTIMERNull() && this.psDENotify.getCHECKTIMER() > 0) {
                    this.nCheckTimer = this.psDENotify.getCHECKTIMER();
                }
                this.strCustomCond = this.psDENotify.getCUSTOMCOND();
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
        String strPSSysSFPluginId = this.psDENotify.getPSSYSSFPLUGINID();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysSFPluginId)) {
            this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(strPSSysSFPluginId);
        }
        if (this.getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
        this.onPreparePSDENotifyTargets();
    }

    protected void onPreparePSDENotifyTargets() throws Exception {
        this.psDENotifyTargetList.clear();
        Vector<PSDENotifyTarget> psDENotifyTargetList = new Vector<PSDENotifyTarget>();
        CallResult callResult = this.getPSModelHelper().getPSDENotifyTargets(this.getId(), psDENotifyTargetList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u901a\u77e5\u76ee\u6807\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDENotifyTarget psDENotifyTarget : psDENotifyTargetList) {
            PSDENotifyTargetImpl iPSDENotifyTarget = new PSDENotifyTargetImpl();
            iPSDENotifyTarget.init(this.getDAGlobalHelper(), this, psDENotifyTarget);
            this.psDENotifyTargetList.add(iPSDENotifyTarget);
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getModelType() {
        return "PSDENOTIFY";
    }

    @Override
    public String getModelId() {
        if (this.getPSDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u76ee\u6807\u96c6\u5408", child=true, group="\u903b\u8f91", order=225)
    public Iterator<IPSDENotifyTarget> getPSDENotifyTargets() {
        return this.psDENotifyTargetList.iterator();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6", dumpref=true, from="IPSDataEntity", fields={"PSDEDSID"})
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5f00\u59cb\u65f6\u95f4\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"BEGINPSDEFID"})
    public IPSDEField getBeginTimePSDEField() {
        return this.beginTimePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u675f\u65f6\u95f4\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"ENDPSDEFID"})
    public IPSDEField getEndTimePSDEField() {
        return this.endTimePSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6d88\u606f\u961f\u5217", dumpref=true, fields={"PSSYSMSGQUEUEID"})
    public IPSSysMsgQueue getPSSysMsgQueue() throws Exception {
        if (this.iPSSysMsgQueue == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDENotify.getPSSYSMSGQUEUEID())) {
            this.iPSSysMsgQueue = this.getPSSystem().getPSSysMsgQueue(this.psDENotify.getPSSYSMSGQUEUEID());
        }
        return this.iPSSysMsgQueue;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6d88\u606f\u6a21\u677f", dumpref=true, fields={"PSSYSMSGTEMPLID"})
    public IPSSysMsgTempl getPSSysMsgTempl() throws Exception {
        if (this.iPSSysMsgTempl == null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDENotify.getPSSYSMSGTEMPLID())) {
            this.iPSSysMsgTempl = this.getPSSystem().getPSSysMsgTempl(this.psDENotify.getPSSYSMSGTEMPLID());
        }
        return this.iPSSysMsgTempl;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u524d\u901a\u77e5\u95f4\u9694", ignoredumpvalues="0", fields={"NOTIFYSTART"})
    public int getNotifyStart() {
        return this.nNotifyStart;
    }

    @Override
    @PSModelRTMeta(description="\u5ef6\u540e\u901a\u77e5\u95f4\u9694", ignoredumpvalues="0", fields={"NOTIFYEND"})
    public int getNotifyEnd() {
        return this.nNotifyEnd;
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u68c0\u67e5\u95f4\u9694", ignoredumpvalues="0", fields={"CHECKTIMER"})
    public int getCheckTimer() {
        return this.nCheckTimer;
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u6807\u8bb0", hideempty2=true, fields={"NOTIFYTAG"})
    public String getNotifyTag() {
        return this.psDENotify.getNOTIFYTAG();
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u6807\u8bb02", hideempty2=true, fields={"NOTIFYTAG2"})
    public String getNotifyTag2() {
        return this.psDENotify.getNOTIFYTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5b9a\u65f6\u89e6\u53d1\u6a21\u5f0f", ignoredumpvalues="false", group="\u57fa\u672c", order=125, fields={"TIMERMODE"})
    public boolean isTimerMode() {
        return this.bTimerMode;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6761\u4ef6", fields={"CUSTOMCOND"})
    public String getCustomCond() {
        return this.strCustomCond;
    }

    @Override
    @PSModelRTMeta(description="\u53d1\u9001\u901a\u77e5\u7c7b\u578b", codelist="WFInfomMsgType", fields={"MSGTYPE"})
    public int getMsgType() {
        return this.nMsgType;
    }

    @Override
    @PSModelRTMeta(description="\u9644\u52a0\u4efb\u52a1\u6a21\u5f0f", codelist="DENotifyTaskMode", fields={"TASKMODE"})
    public int getTaskMode() {
        return this.nTaskMode;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u76d1\u63a7\u4e8b\u4ef6\u96c6", fields={"EVENTS"})
    public String getEvents() {
        return this.psDENotify.getEVENTS();
    }

    @Override
    @PSModelRTMeta(description="\u76d1\u63a7\u4e8b\u4ef6\u6a21\u578b", fields={"EVENTMODEL"})
    public String getEventModel() {
        return this.psDENotify.getEVENTMODEL();
    }

    @Override
    @PSModelRTMeta(description="\u76d1\u63a7\u53d8\u5316\u5c5e\u6027\u96c6", fields={"FIELDS"})
    public String getFields() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5668\u6a21\u578b", fields={"FILTERMODEL"})
    public String getFilterModel() {
        return this.psDENotify.getFILTERMODEL();
    }

    @Override
    @PSModelRTMeta(description="\u901a\u77e5\u5b50\u7c7b\u578b", fields={"NOTIFYSUBTYPE"}, codelist="DENotifySubType")
    public String getNotifySubType() {
        return this.psDENotify.getNOTIFYSUBTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5ffd\u7565\u5f02\u5e38", ignoredumpvalues="false", fields={"IGNOREEXCEPTION"})
    public boolean isIgnoreException() {
        return this.psDENotify.getIGNOREEXCEPTION();
    }

    @Override
    @PSModelRTMeta(description="\u7ebf\u7a0b\u6a21\u5f0f", codelist="DELogicThreadRunMode", ignoredumpvalues="0", fields={"THREADRUNMODE"})
    public int getThreadMode() {
        return this.psDENotify.getTHREADRUNMODE();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u903b\u8f91", ignoredumpvalues="false", fields={"TEMPLFLAG"})
    public boolean isTemplate() {
        return this.psDENotify.getTEMPLFLAG();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528", ignoredumpvalues="true", fields={"VALIDFLAG"})
    public boolean isValid() {
        return true;
    }
}

