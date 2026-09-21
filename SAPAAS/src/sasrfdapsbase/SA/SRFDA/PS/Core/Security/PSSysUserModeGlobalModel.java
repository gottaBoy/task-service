/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Security;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Security.IPSSysUserMode;
import SA.SRFDA.PS.Core.Security.PSSysUserModeImpl;
import SA.SRFDA.PS.Data.PSSysUserMode;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUserModeGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUserMode, IPSSysUserMode> {
    private static final Log log = LogFactory.getLog(PSSysUserModeGlobalModel.class);

    @Override
    protected PSSysUserMode GetObject(String strPSSysUserModeId) {
        PSSysUserMode psSysUserMode = new PSSysUserMode();
        CallResult callResult = this.iPSModelHelper.getPSSysUserMode(strPSSysUserModeId, psSysUserMode);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7528\u6237\u6a21\u5f0f[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUserModeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysUserMode;
    }

    @Override
    protected IPSSysUserMode OnCreateModelHelper(PSSysUserMode vt) throws Exception {
        PSSysUserModeImpl iPSSysUserMode = null;
        iPSSysUserMode = new PSSysUserModeImpl();
        iPSSysUserMode.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUserMode;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUserMode obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUserMode registerModel(PSSysUserMode vt) throws Exception {
        IPSSysUserMode iIPSSysUserMode = (IPSSysUserMode)this.InternalGetModelHelper(vt.getPSSYSUSERMODEID());
        if (iIPSSysUserMode != null) {
            return iIPSSysUserMode;
        }
        this.setModel(vt.getPSSYSUSERMODEID(), vt, null);
        return (IPSSysUserMode)this.FindModelHelper(vt.getPSSYSUSERMODEID());
    }

    @Override
    protected Vector<PSSysUserMode> getAllModels() throws Exception {
        Vector<PSSysUserMode> list = new Vector<PSSysUserMode>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUserModes(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u7528\u6237\u6a21\u5f0f\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUserMode vt) {
        return vt.getPSSYSUSERMODEID();
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

    protected String[] getObjectAliases(PSSysUserMode vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

