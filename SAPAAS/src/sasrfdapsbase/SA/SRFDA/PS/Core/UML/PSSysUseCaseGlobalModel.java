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
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.UML.PSSysUseCaseImpl;
import SA.SRFDA.PS.Data.PSSysUserCase;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysUseCaseGlobalModel
extends PSSystemGlobalModelBase<String, PSSysUserCase, IPSSysUseCase> {
    private static final Log log = LogFactory.getLog(PSSysUseCaseGlobalModel.class);

    @Override
    protected PSSysUserCase GetObject(String strPSSysUserCaseId) {
        PSSysUserCase psSysUserCase = new PSSysUserCase();
        CallResult callResult = this.iPSModelHelper.getPSSysUserCase(strPSSysUserCaseId, psSysUserCase);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u7528\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysUserCaseId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysUserCase;
    }

    @Override
    protected IPSSysUseCase OnCreateModelHelper(PSSysUserCase vt) throws Exception {
        PSSysUseCaseImpl iPSSysUserCase = null;
        iPSSysUserCase = new PSSysUseCaseImpl();
        iPSSysUserCase.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysUserCase;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysUserCase obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysUseCase registerModel(PSSysUserCase vt) throws Exception {
        IPSSysUseCase iIPSSysUserCase = (IPSSysUseCase)this.InternalGetModelHelper(vt.getPSSYSUSERCASEID());
        if (iIPSSysUserCase != null) {
            return iIPSSysUserCase;
        }
        this.setModel(vt.getPSSYSUSERCASEID(), vt, null);
        return (IPSSysUseCase)this.FindModelHelper(vt.getPSSYSUSERCASEID());
    }

    @Override
    protected Vector<PSSysUserCase> getAllModels() throws Exception {
        Vector<PSSysUserCase> list = new Vector<PSSysUserCase>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysUserCases(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u7528\u4f8b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysUserCase vt) {
        return vt.getPSSYSUSERCASEID();
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

    protected String[] getObjectAliases(PSSysUserCase vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

