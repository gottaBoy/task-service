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

import SA.SRFDA.PS.Core.CodeSnippet.IPSCodeSnippetType;
import SA.SRFDA.PS.Core.CodeSnippet.PSCodeSnippetTypeImpl;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Data.PSCodeSnippetType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCodeSnippetTypeGlobalModel
extends PSGlobalModelBase<String, PSCodeSnippetType, IPSCodeSnippetType> {
    private static final Log log = LogFactory.getLog(PSCodeSnippetTypeGlobalModel.class);

    @Override
    protected PSCodeSnippetType GetObject(String strPSCodeSnippetTypeId) {
        PSCodeSnippetType PSCodeSnippetType2 = new PSCodeSnippetType();
        CallResult callResult = this.iPSModelHelper.getPSCodeSnippetType(strPSCodeSnippetTypeId, PSCodeSnippetType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u4ee3\u7801\u7247\u6bb5\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSCodeSnippetTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSCodeSnippetType2;
    }

    @Override
    protected IPSCodeSnippetType OnCreateModelHelper(PSCodeSnippetType vt) throws Exception {
        PSCodeSnippetTypeImpl iPSCodeSnippetType = new PSCodeSnippetTypeImpl();
        iPSCodeSnippetType.init(this.iDAGlobalHelper, vt);
        return iPSCodeSnippetType;
    }

    @Override
    protected Boolean TestObjectRenew(PSCodeSnippetType obj) {
        return false;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    protected String getObjectId(PSCodeSnippetType vt) {
        return vt.getPSCODESNIPPETTYPEID();
    }
}

