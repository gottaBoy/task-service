/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.CodeList;

import SA.SRFDA.PS.Core.CodeList.PSCodeListGlobalModel;
import SA.SRFDA.PS.Data.PSCodeList;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCodeListGlobalModel2
extends PSCodeListGlobalModel {
    private static final Log log = LogFactory.getLog(PSCodeListGlobalModel2.class);

    @Override
    protected PSCodeList GetObject(String strPSCodeListId) {
        PSCodeList psCodeList = new PSCodeList();
        CallResult callResult = this.iPSModelHelper.getPSCodeListByTempl(strPSCodeListId, psCodeList);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5e73\u53f0\u4ee3\u7801\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSCodeListId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psCodeList;
    }
}

