/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Testing;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.PSSysTestCaseImpl;
import SA.SRFDA.PS.Data.PSSysTestCase;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysTestCaseGlobalModel
extends PSSystemGlobalModelBase<String, PSSysTestCase, IPSSysTestCase> {
    private static final Log log = LogFactory.getLog(PSSysTestCaseGlobalModel.class);

    @Override
    protected PSSysTestCase GetObject(String strPSSysTestCaseId) {
        PSSysTestCase psSysTestCase = new PSSysTestCase();
        CallResult callResult = this.iPSModelHelper.getPSSysTestCase(strPSSysTestCaseId, psSysTestCase);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u6d4b\u8bd5\u7528\u4f8b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysTestCaseId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysTestCase;
    }

    @Override
    protected IPSSysTestCase OnCreateModelHelper(PSSysTestCase vt) throws Exception {
        PSSysTestCaseImpl iPSSysTestCase = null;
        iPSSysTestCase = new PSSysTestCaseImpl();
        iPSSysTestCase.init(this.iDAGlobalHelper, this.getPSSystem(), vt);
        return iPSSysTestCase;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysTestCase obj) {
        return false;
    }

    @Override
    public void ResetAll() {
        super.ResetAll();
    }

    @Override
    protected IPSSysTestCase registerModel(PSSysTestCase vt) throws Exception {
        IPSSysTestCase iIPSSysTestCase = (IPSSysTestCase)this.InternalGetModelHelper(vt.getPSSYSTESTCASEID());
        if (iIPSSysTestCase != null) {
            return iIPSSysTestCase;
        }
        this.setModel(vt.getPSSYSTESTCASEID(), vt, null);
        return (IPSSysTestCase)this.FindModelHelper(vt.getPSSYSTESTCASEID());
    }

    @Override
    protected Vector<PSSysTestCase> getAllModels() throws Exception {
        Vector<PSSysTestCase> list = new Vector<PSSysTestCase>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysTestCases(this.iPSSystem.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u6d4b\u8bd5\u7528\u4f8b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysTestCase vt) {
        return vt.getPSSYSTESTCASEID();
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

    protected String[] getObjectAliases(PSSysTestCase vt) {
        if (!StringHelper.IsNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }
}

