/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Issue;

import SA.SRFDA.PS.Core.Issue.IPSSysIssueEngine;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSSysIssueEngine;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import net.ibizsys.paas.util.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysIssueEngineGlobalModel
extends PSGlobalModelBase<String, PSSysIssueEngine, IPSSysIssueEngine> {
    private static final Log log = LogFactory.getLog(PSSysIssueEngineGlobalModel.class);

    @Override
    protected PSSysIssueEngine GetObject(String strPSSysIssueEngineId) {
        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u95ee\u9898\u68c0\u67e5\u5f15\u64ce[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysIssueEngineId, (Object)"\u4e0d\u652f\u6301\u6307\u5b9a\u83b7\u53d6"));
        return null;
    }

    @Override
    protected IPSSysIssueEngine OnCreateModelHelper(PSSysIssueEngine vt) throws Exception {
        IPSSysIssueEngine iPSSysIssueEngine = (IPSSysIssueEngine)ObjectHelper.create((String)vt.getENGINEOBJ());
        iPSSysIssueEngine.init(this.iDAGlobalHelper, vt);
        return iPSSysIssueEngine;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysIssueEngine obj) {
        return false;
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
    protected Vector<PSSysIssueEngine> getAllModels() throws Exception {
        Vector<PSSysIssueEngine> psSysIssueEngine = new Vector<PSSysIssueEngine>();
        CallResult callResult = this.iPSModelHelper.getAllPSSysIssueEngines(psSysIssueEngine);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5168\u90e8\u7cfb\u7edf\u95ee\u9898\u68c0\u67e5\u5f15\u64ce\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return psSysIssueEngine;
    }

    @Override
    protected IPSSysIssueEngine registerModel(PSSysIssueEngine vt) throws Exception {
        IPSSysIssueEngine iPSSysIssueEngine = (IPSSysIssueEngine)this.InternalGetModelHelper(vt.getPSSYSISSUEENGINEID());
        if (iPSSysIssueEngine != null) {
            return iPSSysIssueEngine;
        }
        this.setModel(vt.getPSSYSISSUEENGINEID(), vt, null);
        return (IPSSysIssueEngine)this.FindModelHelper(vt.getPSSYSISSUEENGINEID());
    }

    @Override
    protected String getObjectId(PSSysIssueEngine vt) {
        return vt.getPSSYSISSUEENGINEID();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

