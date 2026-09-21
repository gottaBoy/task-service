/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Notify;

import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotify;
import SA.SRFDA.PS.Core.DataEntity.Notify.IPSDENotifyTarget;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTarget;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDENotifyTarget;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDENotifyTargetImpl
extends PSObjectImpl
implements IPSDENotifyTarget {
    private static final Log log = LogFactory.getLog(PSDENotifyTargetImpl.class);
    private IPSDENotify iPSDENotify = null;
    private PSDENotifyTarget psDENotifyTarget = null;
    private IPSDEField targetPSDEField = null;
    private IPSDEField targetTypePSDEField = null;
    private String strTargetType = null;
    private IPSSysMsgTarget iPSSysMsgTarget = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDENotify iPSDENotify, PSDENotifyTarget psDENotifyTarget) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDENotify = iPSDENotify;
            this.psDENotifyTarget = psDENotifyTarget;
            this.setId(this.psDENotifyTarget.getPSDENOTIFYTARGETID());
            this.setName(this.psDENotifyTarget.getPSDENOTIFYTARGETNAME());
            this.setPSObjectData(this.psDENotifyTarget);
            this.strTargetType = this.psDENotifyTarget.getTARGETTYPE();
            if ("DEFIELD".equals(this.getTargetType())) {
                if (!StringHelper.IsNullOrEmpty((String)this.psDENotifyTarget.getTARGETPSDEFID())) {
                    this.targetPSDEField = this.getPSDENotify().getPSDataEntity().getPSDEField(this.psDENotifyTarget.getTARGETPSDEFID());
                }
                if (!StringHelper.IsNullOrEmpty((String)this.psDENotifyTarget.getTARGETTYPEPSDEFID())) {
                    this.targetTypePSDEField = this.getPSDENotify().getPSDataEntity().getPSDEField(this.psDENotifyTarget.getTARGETTYPEPSDEFID());
                }
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
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
    public String getPSSysModelInstId() {
        return this.getPSDENotify().getPSSysModelInstId();
    }

    @Override
    public IPSDENotify getPSDENotify() {
        return this.iPSDENotify;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDENotify().getPSDataEntity().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDENotify().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u7c7b\u578b", codelist="DENotifyTargetType", fields={"TARGETTYPE"})
    public String getTargetType() {
        return this.strTargetType;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6807\u8bc6\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"TARGETPSDEFID"})
    public IPSDEField getTargetPSDEField() {
        return this.targetPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u7c7b\u578b\u503c\u5b58\u50a8\u5c5e\u6027", dumpref=true, from="IPSDataEntity", fields={"TARGETTYPEPSDEFID"})
    public IPSDEField getTargetTypePSDEField() {
        return this.targetTypePSDEField;
    }

    @Override
    public String getModelType() {
        return "PSDENOTIFYTARGET";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDENotify().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6d88\u606f\u76ee\u6807", dumpref=true, fields={"PSSYSMSGTARGETID"})
    public IPSSysMsgTarget getPSSysMsgTarget() throws Exception {
        if (this.iPSSysMsgTarget == null && !StringHelper.IsNullOrEmpty((String)this.psDENotifyTarget.getPSSYSMSGTARGETID())) {
            this.iPSSysMsgTarget = this.getPSDENotify().getPSDataEntity().getPSSystem().getPSSysMsgTarget(this.psDENotifyTarget.getPSSYSMSGTARGETID());
        }
        return this.iPSSysMsgTarget;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6d88\u606f\u76ee\u6807\u8fc7\u6ee4\u9879", hideempty2=true, fields={"FILTER"})
    public String getFilter() {
        return this.psDENotifyTarget.getFILTER();
    }

    @Override
    public String getModelRefId() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u6570\u636e", hideempty2=true, fields={"DATA"})
    public String getData() {
        return this.psDENotifyTarget.getDATA();
    }
}

