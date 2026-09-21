/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Msg;

import SA.SRFDA.PS.Core.Msg.IPSSysMsgTempl;
import SA.SRFDA.PS.Core.Msg.PSSysMsgTemplImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysMsgTempl;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysMsgTemplGlobalModel
extends PSSystemGlobalModelBase<String, PSSysMsgTempl, IPSSysMsgTempl> {
    private static final Log log = LogFactory.getLog(PSSysMsgTemplGlobalModel.class);

    @Override
    protected PSSysMsgTempl GetObject(String strPSSysMsgTemplId) {
        PSSysMsgTempl psSysMsgTempl = new PSSysMsgTempl();
        CallResult callResult = this.iPSModelHelper.getPSSysMsgTempl(strPSSysMsgTemplId, psSysMsgTempl);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6d88\u606f\u6a21\u677f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysMsgTemplId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysMsgTempl;
    }

    @Override
    protected IPSSysMsgTempl OnCreateModelHelper(PSSysMsgTempl vt) throws Exception {
        PSSysMsgTemplImpl iPSSysMsgTempl = null;
        iPSSysMsgTempl = new PSSysMsgTemplImpl();
        iPSSysMsgTempl.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysMsgTempl;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysMsgTempl obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysMsgTempl registerModel(PSSysMsgTempl vt) throws Exception {
        IPSSysMsgTempl iIPSSysMsgTempl = (IPSSysMsgTempl)this.InternalGetModelHelper(vt.getPSSYSMSGTEMPLID());
        if (iIPSSysMsgTempl != null) {
            return iIPSSysMsgTempl;
        }
        this.setModel(vt.getPSSYSMSGTEMPLID(), vt, null);
        return (IPSSysMsgTempl)this.FindModelHelper(vt.getPSSYSMSGTEMPLID());
    }

    @Override
    protected Vector<PSSysMsgTempl> getAllModels() throws Exception {
        Vector<PSSysMsgTempl> list = new Vector<PSSysMsgTempl>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysMsgTempls(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6d88\u606f\u6a21\u677f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysMsgTempl vt) {
        return vt.getPSSYSMSGTEMPLID();
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

    protected String[] getObjectAliases(PSSysMsgTempl vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

