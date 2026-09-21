/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.View.IPSViewMsg;
import SA.SRFDA.PS.Core.View.PSDEDataSetViewMsgImpl;
import SA.SRFDA.PS.Core.View.PSViewMsgImpl;
import SA.SRFDA.PS.Data.PSViewMsg;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewMsgGlobalModel
extends PSSystemGlobalModelBase<String, PSViewMsg, IPSViewMsg> {
    private static final Log log = LogFactory.getLog(PSViewMsgGlobalModel.class);
    private int nLastViewMsgIndex = 1;
    private HashMap<String, String> autoViewMsgCodeNameMap = new HashMap();

    @Override
    protected PSViewMsg GetObject(String strPSViewMsgId) {
        PSViewMsg psViewMsg = new PSViewMsg();
        CallResult callResult = this.iPSModelHelper.getPSViewMsg(strPSViewMsgId, psViewMsg);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u89c6\u56fe\u6d88\u606f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSViewMsgId, (Object)callResult.getErrorInfo()));
            return null;
        }
        this.fillPSViewMsgCodeName(psViewMsg);
        return psViewMsg;
    }

    @Override
    protected IPSViewMsg OnCreateModelHelper(PSViewMsg vt) throws Exception {
        PSViewMsgImpl iPSViewMsg = null;
        switch (vt.GetParamIntValue("DYNAMICMODE", 0)) {
            case 1: {
                iPSViewMsg = new PSDEDataSetViewMsgImpl();
                break;
            }
            default: {
                iPSViewMsg = new PSViewMsgImpl();
            }
        }
        iPSViewMsg.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSViewMsg;
    }

    @Override
    protected Boolean TestObjectRenew(PSViewMsg obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSViewMsg registerModel(PSViewMsg vt) throws Exception {
        IPSViewMsg iIPSViewMsg = (IPSViewMsg)this.InternalGetModelHelper(vt.getPSVIEWMSGID());
        if (iIPSViewMsg != null) {
            return iIPSViewMsg;
        }
        this.setModel(vt.getPSVIEWMSGID(), vt, null);
        return (IPSViewMsg)this.FindModelHelper(vt.getPSVIEWMSGID());
    }

    @Override
    protected Vector<PSViewMsg> getAllModels() throws Exception {
        Vector<PSViewMsg> list = new Vector<PSViewMsg>();
        CallResult callResult = this.iPSModelHelper.getAllPSViewMsgs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u89c6\u56fe\u6d88\u606f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSViewMsg psViewMsg : list) {
            if (StringHelper.IsNullOrEmpty((String)psViewMsg.getCODENAME())) continue;
            this.autoViewMsgCodeNameMap.put(psViewMsg.getCODENAME().toUpperCase(), "");
        }
        for (PSViewMsg psViewMsg : list) {
            this.fillPSViewMsgCodeName(psViewMsg);
        }
        return list;
    }

    @Override
    protected String getObjectId(PSViewMsg vt) {
        return vt.getPSVIEWMSGID();
    }

    protected void fillPSViewMsgCodeName(PSViewMsg psViewMsg) {
        if (StringHelper.IsNullOrEmpty((String)psViewMsg.getCODENAME())) {
            String strCodeName;
            do {
                ++this.nLastViewMsgIndex;
            } while (this.autoViewMsgCodeNameMap.containsKey(strCodeName = StringHelper.Format((String)"_%1$s", (Object)this.nLastViewMsgIndex)));
            psViewMsg.setCODENAME(strCodeName);
            this.autoViewMsgCodeNameMap.put(strCodeName, "");
        }
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
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

    protected String[] getObjectAliases(PSViewMsg vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

