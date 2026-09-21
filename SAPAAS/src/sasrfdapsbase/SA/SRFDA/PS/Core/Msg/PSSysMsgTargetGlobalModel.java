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

import SA.SRFDA.PS.Core.Msg.IPSSysMsgTarget;
import SA.SRFDA.PS.Core.Msg.PSSysMsgTargetImpl;
import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysMsgTarget;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysMsgTargetGlobalModel
extends PSSystemGlobalModelBase<String, PSSysMsgTarget, IPSSysMsgTarget> {
    private static final Log log = LogFactory.getLog(PSSysMsgTargetGlobalModel.class);

    @Override
    protected PSSysMsgTarget GetObject(String strPSSysMsgTargetId) {
        if (this.isPrepareModels()) {
            return null;
        }
        return null;
    }

    @Override
    protected IPSSysMsgTarget OnCreateModelHelper(PSSysMsgTarget vt) throws Exception {
        PSSysMsgTargetImpl iPSSysMsgTarget = null;
        iPSSysMsgTarget = new PSSysMsgTargetImpl();
        iPSSysMsgTarget.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysMsgTarget;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysMsgTarget obj) {
        return false;
    }

    @Override
    protected IPSSysMsgTarget registerModel(PSSysMsgTarget vt) throws Exception {
        IPSSysMsgTarget iIPSSysMsgTarget = (IPSSysMsgTarget)this.InternalGetModelHelper(vt.getPSSYSMSGTARGETID());
        if (iIPSSysMsgTarget != null) {
            return iIPSSysMsgTarget;
        }
        this.setModel(vt.getPSSYSMSGTARGETID(), vt, null);
        return (IPSSysMsgTarget)this.FindModelHelper(vt.getPSSYSMSGTARGETID());
    }

    @Override
    protected Vector<PSSysMsgTarget> getAllModels() throws Exception {
        Vector<PSSysMsgTarget> list = new Vector<PSSysMsgTarget>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysMsgTargets(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d88\u606f\u76ee\u6807\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysMsgTarget vt) {
        return vt.getPSSYSMSGTARGETID();
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

    protected String[] getObjectAliases(PSSysMsgTarget vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

