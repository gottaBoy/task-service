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
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.Security.PSSysUniResImpl;
import SA.SRFDA.PS.Data.PSSysUniRes;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUniResGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUniRes, IPSSysUniRes> {
    private static final Log log = LogFactory.getLog(PSSysUniResGlobalModel.class);

    @Override
    protected PSSysUniRes GetObject(String strPSSysUniResId) {
        PSSysUniRes psSysUniRes = new PSSysUniRes();
        CallResult callResult = this.iPSModelHelper.getPSSysUniRes(strPSSysUniResId, psSysUniRes);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUniResId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysUniRes;
    }

    @Override
    protected IPSSysUniRes OnCreateModelHelper(PSSysUniRes vt) throws Exception {
        PSSysUniResImpl iPSSysUniRes = null;
        iPSSysUniRes = new PSSysUniResImpl();
        iPSSysUniRes.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUniRes;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUniRes obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUniRes registerModel(PSSysUniRes vt) throws Exception {
        IPSSysUniRes iIPSSysUniRes = (IPSSysUniRes)this.InternalGetModelHelper(vt.getPSSYSUNIRESID());
        if (iIPSSysUniRes != null) {
            return iIPSSysUniRes;
        }
        this.setModel(vt.getPSSYSUNIRESID(), vt, null);
        return (IPSSysUniRes)this.FindModelHelper(vt.getPSSYSUNIRESID());
    }

    @Override
    protected Vector<PSSysUniRes> getAllModels() throws Exception {
        Vector<PSSysUniRes> list = new Vector<PSSysUniRes>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUniReses(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u7edf\u4e00\u8d44\u6e90\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUniRes vt) {
        return vt.getPSSYSUNIRESID();
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

    protected String[] getObjectAliases(PSSysUniRes vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getRESCODE())) {
            return new String[]{vt.getRESCODE().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

