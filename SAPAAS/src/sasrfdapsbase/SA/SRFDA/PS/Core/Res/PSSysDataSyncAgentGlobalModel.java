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
import SA.SRFDA.PS.Core.Res.IPSSysDataSyncAgent;
import SA.SRFDA.PS.Core.Res.PSSysDataSyncAgentImpl;
import SA.SRFDA.PS.Data.PSSysDataSyncAgent;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDataSyncAgentGlobalModel
extends PSSystemGlobalModelBase<String, PSSysDataSyncAgent, IPSSysDataSyncAgent> {
    private static final Log log = LogFactory.getLog(PSSysDataSyncAgentGlobalModel.class);

    @Override
    protected PSSysDataSyncAgent GetObject(String strPSSysDataSyncAgentId) {
        PSSysDataSyncAgent psSysDataSyncAgent = new PSSysDataSyncAgent();
        CallResult callResult = this.iPSModelHelper.getPSSysDataSyncAgent(strPSSysDataSyncAgentId, psSysDataSyncAgent);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6570\u636e\u540c\u6b65\u4ee3\u7406[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysDataSyncAgentId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysDataSyncAgent;
    }

    @Override
    protected IPSSysDataSyncAgent OnCreateModelHelper(PSSysDataSyncAgent vt) throws Exception {
        PSSysDataSyncAgentImpl iPSSysDataSyncAgent = new PSSysDataSyncAgentImpl();
        iPSSysDataSyncAgent.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysDataSyncAgent;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysDataSyncAgent obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysDataSyncAgent registerModel(PSSysDataSyncAgent vt) throws Exception {
        IPSSysDataSyncAgent iIPSSysDataSyncAgent = (IPSSysDataSyncAgent)this.InternalGetModelHelper(vt.getPSSYSDATASYNCAGENTID());
        if (iIPSSysDataSyncAgent != null) {
            return iIPSSysDataSyncAgent;
        }
        this.setModel(vt.getPSSYSDATASYNCAGENTID(), vt, null);
        return (IPSSysDataSyncAgent)this.FindModelHelper(vt.getPSSYSDATASYNCAGENTID());
    }

    @Override
    protected Vector<PSSysDataSyncAgent> getAllModels() throws Exception {
        Vector<PSSysDataSyncAgent> list = new Vector<PSSysDataSyncAgent>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysDataSyncAgents(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6570\u636e\u540c\u6b65\u4ee3\u7406\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysDataSyncAgent vt) {
        return vt.getPSSYSDATASYNCAGENTID();
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

    protected String[] getObjectAliases(PSSysDataSyncAgent vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

