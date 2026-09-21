/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsg;
import SA.SRFDA.PS.Core.Res.PSCtrlMsgImpl;
import SA.SRFDA.PS.Data.PSCtrlMsg;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCtrlMsgGlobalModel
extends PSSystemGlobalModelBase<String, PSCtrlMsg, IPSCtrlMsg> {
    private static final Log log = LogFactory.getLog(PSCtrlMsgGlobalModel.class);

    @Override
    protected PSCtrlMsg GetObject(String strPSCtrlMsgId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSCtrlMsg psCtrlMsg = new PSCtrlMsg();
        CallResult callResult = this.iPSModelHelper.getPSCtrlMsg(strPSCtrlMsgId, psCtrlMsg);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u90e8\u4ef6\u6d88\u606f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSCtrlMsgId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psCtrlMsg;
    }

    @Override
    protected IPSCtrlMsg OnCreateModelHelper(PSCtrlMsg vt) throws Exception {
        PSCtrlMsgImpl iPSCtrlMsg = null;
        iPSCtrlMsg = new PSCtrlMsgImpl();
        iPSCtrlMsg.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSCtrlMsg;
    }

    @Override
    protected Boolean TestObjectRenew(PSCtrlMsg obj) {
        return false;
    }

    @Override
    protected IPSCtrlMsg registerModel(PSCtrlMsg vt) throws Exception {
        IPSCtrlMsg iIPSCtrlMsg = (IPSCtrlMsg)this.InternalGetModelHelper(vt.getPSCTRLMSGID());
        if (iIPSCtrlMsg != null) {
            return iIPSCtrlMsg;
        }
        this.setModel(vt.getPSCTRLMSGID(), vt, null);
        return (IPSCtrlMsg)this.FindModelHelper(vt.getPSCTRLMSGID());
    }

    @Override
    protected Vector<PSCtrlMsg> getAllModels() throws Exception {
        Vector<PSCtrlMsg> list = new Vector<PSCtrlMsg>();
        CallResult callResult = this.iPSModelHelper.getAllPSCtrlMsgs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u90e8\u4ef6\u6d88\u606f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSCtrlMsg vt) {
        return vt.getPSCTRLMSGID();
    }

    @Override
    protected void onPreloadModels() {
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSCtrlMsg vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

