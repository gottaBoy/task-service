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
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.Res.PSSysUniStateImpl;
import SA.SRFDA.PS.Data.PSSysUniState;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUniStateGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUniState, IPSSysUniState> {
    private static final Log log = LogFactory.getLog(PSSysUniStateGlobalModel.class);

    @Override
    protected PSSysUniState GetObject(String strPSSysUniStateId) {
        PSSysUniState psSysUniState = new PSSysUniState();
        CallResult callResult = this.iPSModelHelper.getPSSysUniState(strPSSysUniStateId, psSysUniState);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUniStateId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysUniState;
    }

    @Override
    protected IPSSysUniState OnCreateModelHelper(PSSysUniState vt) throws Exception {
        PSSysUniStateImpl iPSSysUniState = null;
        iPSSysUniState = new PSSysUniStateImpl();
        iPSSysUniState.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUniState;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUniState obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUniState registerModel(PSSysUniState vt) throws Exception {
        IPSSysUniState iIPSSysUniState = (IPSSysUniState)this.InternalGetModelHelper(vt.getPSSYSUNISTATEID());
        if (iIPSSysUniState != null) {
            return iIPSSysUniState;
        }
        this.setModel(vt.getPSSYSUNISTATEID(), vt, null);
        return (IPSSysUniState)this.FindModelHelper(vt.getPSSYSUNISTATEID());
    }

    @Override
    protected Vector<PSSysUniState> getAllModels() throws Exception {
        Vector<PSSysUniState> list = new Vector<PSSysUniState>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUniStates(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u7edf\u4e00\u72b6\u6001\u534f\u540c\u5bf9\u8c61\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUniState vt) {
        return vt.getPSSYSUNISTATEID();
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

    protected String[] getObjectAliases(PSSysUniState vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getUNIQUETAG())) {
            return new String[]{vt.getUNIQUETAG().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

