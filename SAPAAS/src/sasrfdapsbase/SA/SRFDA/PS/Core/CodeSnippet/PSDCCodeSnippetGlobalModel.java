/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.CodeSnippet.IPSDCCodeSnippet;
import SA.SRFDA.PS.Core.CodeSnippet.PSDCCodeSnippetImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSDCCodeSnippet;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCCodeSnippetGlobalModel
extends PSGlobalModelBase<String, PSDCCodeSnippet, IPSDCCodeSnippet> {
    private static final Log log = LogFactory.getLog(PSDCCodeSnippetGlobalModel.class);

    @Override
    protected PSDCCodeSnippet GetObject(String strPSDCCodeSnippetId) {
        PSDCCodeSnippet PSDCCodeSnippet2 = new PSDCCodeSnippet();
        CallResult callResult = this.iPSModelHelper.getPSDCCodeSnippet(strPSDCCodeSnippetId, PSDCCodeSnippet2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u4ee3\u7801\u7247\u6bb5[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSDCCodeSnippetId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSDCCodeSnippet2;
    }

    @Override
    protected IPSDCCodeSnippet OnCreateModelHelper(PSDCCodeSnippet vt) throws Exception {
        PSDCCodeSnippetImpl iPSDCCodeSnippet = new PSDCCodeSnippetImpl();
        iPSDCCodeSnippet.init(this.iDAGlobalHelper, vt);
        return iPSDCCodeSnippet;
    }

    @Override
    protected Boolean TestObjectRenew(PSDCCodeSnippet obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSDCCodeSnippet vt) {
        return vt.getPSDCCODESNIPPETID();
    }

    @Override
    public IPSDCCodeSnippet FindModelHelper(String objObjectId, boolean bTryMode) throws Exception {
        IPSDCCodeSnippet iPSDCCodeSnippet = (IPSDCCodeSnippet)super.FindModelHelper(objObjectId, bTryMode);
        return iPSDCCodeSnippet;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

