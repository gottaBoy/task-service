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
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsg;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsgItem;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSCtrlMsgItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCtrlMsgItemImpl
extends PSObjectImpl
implements IPSCtrlMsgItem {
    private static final Log log = LogFactory.getLog(PSCtrlMsgItemImpl.class);
    private IPSCtrlMsg iPSCtrlMsg = null;
    private PSCtrlMsgItem psCtrlMsgItem = null;
    private String strContent = "";
    private IPSLanguageRes contentPSLanguageRes = null;
    private int nTimeout = -1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSCtrlMsg iPSCtrlMsg, PSCtrlMsgItem psCtrlMsgItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSCtrlMsg = iPSCtrlMsg;
            this.psCtrlMsgItem = psCtrlMsgItem;
            this.setId(this.psCtrlMsgItem.getPSCTRLMSGITEMID());
            this.setName(this.psCtrlMsgItem.getPSCTRLMSGITEMNAME());
            this.setPSObjectData(this.psCtrlMsgItem);
            this.strContent = this.psCtrlMsgItem.getCONTENT();
            if (!StringHelper.IsNullOrEmpty((String)this.psCtrlMsgItem.getCONTENTPSLANRESID())) {
                this.contentPSLanguageRes = this.getPSCtrlMsg().getPSSystem().getPSLanguageRes(this.psCtrlMsgItem.getCONTENTPSLANRESID());
            }
            if (!this.psCtrlMsgItem.isTIMEOUTNull() && this.psCtrlMsgItem.getTIMEOUT() > 0) {
                this.nTimeout = this.psCtrlMsgItem.getTIMEOUT();
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
        return this.getPSCtrlMsg().getPSSysModelInstId();
    }

    @Override
    public IPSCtrlMsg getPSCtrlMsg() {
        return this.iPSCtrlMsg;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9")
    public String getContent() {
        return this.strContent;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getContentPSLanguageRes() {
        return this.contentPSLanguageRes;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSCtrlMsg().getPSSystem());
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSCtrlMsg().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    public String getModelType() {
        return "PSCTRLMSGITEM";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSCtrlMsg().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u65f6\u957f\uff08\u6beb\u79d2\uff09", ignoredumpvalues="-1")
    public int getTimeout() {
        return this.nTimeout;
    }
}

