/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.UML;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.UML.IPSSysUseCaseRS;
import SA.SRFDA.PS.Core.UML.PSSysUseCaseRSImpl;
import SA.SRFDA.PS.Data.PSSysUserCaseRS;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUseCaseRSGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUserCaseRS, IPSSysUseCaseRS> {
    private static final Log log = LogFactory.getLog(PSSysUseCaseRSGlobalModel.class);

    @Override
    protected PSSysUserCaseRS GetObject(String strPSSysUserCaseRSId) {
        PSSysUserCaseRS psSysUserCaseRS = new PSSysUserCaseRS();
        CallResult callResult = this.iPSModelHelper.getPSSysUserCaseRS(strPSSysUserCaseRSId, psSysUserCaseRS);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7528\u4f8b\u5173\u7cfb[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUserCaseRSId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysUserCaseRS;
    }

    @Override
    protected IPSSysUseCaseRS OnCreateModelHelper(PSSysUserCaseRS vt) throws Exception {
        PSSysUseCaseRSImpl iPSSysUserCaseRS = null;
        iPSSysUserCaseRS = new PSSysUseCaseRSImpl();
        iPSSysUserCaseRS.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUserCaseRS;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUserCaseRS obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUseCaseRS registerModel(PSSysUserCaseRS vt) throws Exception {
        IPSSysUseCaseRS iIPSSysUserCaseRS = (IPSSysUseCaseRS)this.InternalGetModelHelper(vt.getPSSYSUSERCASERSID());
        if (iIPSSysUserCaseRS != null) {
            return iIPSSysUserCaseRS;
        }
        this.setModel(vt.getPSSYSUSERCASERSID(), vt, null);
        return (IPSSysUseCaseRS)this.FindModelHelper(vt.getPSSYSUSERCASERSID());
    }

    @Override
    protected Vector<PSSysUserCaseRS> getAllModels() throws Exception {
        Vector<PSSysUserCaseRS> list = new Vector<PSSysUserCaseRS>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUserCaseRSs(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u7528\u4f8b\u5173\u7cfb\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUserCaseRS vt) {
        return vt.getPSSYSUSERCASERSID();
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

    protected String[] getObjectAliases(PSSysUserCaseRS vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

