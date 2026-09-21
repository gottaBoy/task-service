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
package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.WF.IPSSysWFSetting;
import SA.SRFDA.PS.Core.WF.IPSWFUtilUIAction;
import SA.SRFDA.PS.Core.WF.PSWFUtilUIActionGlobalModel;
import SA.SRFDA.PS.Data.PSSysWFSetting;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysWFSettingImpl
extends PSSystemObjectImpl
implements IPSSysWFSetting {
    private static final Log log = LogFactory.getLog(PSSysWFSettingImpl.class);
    protected PSSysWFSetting psSysWFSetting;
    private String strRemindPSSysMsgTemplId = "";
    private IPSSysMsgTempl remindPSSysMsgTempl = null;
    private PSWFUtilUIActionGlobalModel psWFUtilUIActionGlobalModel = new PSWFUtilUIActionGlobalModel();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysWFSetting psSysWFSetting) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysWFSetting = psSysWFSetting;
            this.setId(this.psSysWFSetting.getPSSYSWFSETTINGID());
            this.setName(this.psSysWFSetting.getPSSYSWFSETTINGNAME());
            this.setPSObjectData(this.psSysWFSetting);
            this.psWFUtilUIActionGlobalModel.Init(iDAGlobalHelper, this);
            this.strRemindPSSysMsgTemplId = this.psSysWFSetting.getPSSYSMSGTEMPLID();
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
    public String getRemindPSSysMsgTemplId() {
        return this.strRemindPSSysMsgTemplId;
    }

    @Override
    public String getModelType() {
        return "PSSYSWFSETTING";
    }

    @Override
    @PSModelRTMeta(description="\u50ac\u529e\u6d88\u606f\u6a21\u677f", dumpref=true, fields={"PSSYSMSGTEMPLID"})
    public IPSSysMsgTempl getRemindPSSysMsgTempl() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getRemindPSSysMsgTemplId())) {
            return null;
        }
        if (this.remindPSSysMsgTempl == null) {
            this.remindPSSysMsgTempl = this.getPSSystem().getPSSysMsgTempl(this.getRemindPSSysMsgTemplId());
        }
        return this.remindPSSysMsgTempl;
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u529f\u80fd\u754c\u9762\u884c\u4e3a", child=true, dumpref=true, rtdump=2)
    public Iterator<IPSWFUtilUIAction> getPSWFUtilUIActions() throws Exception {
        return this.psWFUtilUIActionGlobalModel.getAllModelHelpers();
    }
}

