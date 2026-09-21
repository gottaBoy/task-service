/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFPubObj;
import SA.SRFDA.PS.Core.SF.PSSFGlobalModelBase;
import SA.SRFDA.PS.Core.SF.PSSFPubObjImpl;
import SA.SRFDA.PS.Data.PSSFPubObj;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFPubObjGlobalModel
extends PSSFGlobalModelBase<String, PSSFPubObj, IPSSFPubObj> {
    private static final Log log = LogFactory.getLog(PSSFPubObjGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSSFPubObj GetObject(String strPSSFPubObjId) {
        PSSFPubObj psSFPubObj = new PSSFPubObj();
        CallResult callResult = this.iPSModelHelper.getPSSFPubObj(strPSSFPubObjId, psSFPubObj);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u670d\u52a1\u6846\u67b6\u53d1\u5e03\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSFPubObjId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSFPubObj;
    }

    @Override
    protected IPSSFPubObj OnCreateModelHelper(PSSFPubObj vt) throws Exception {
        PSSFPubObjImpl iPSSFPubObj = new PSSFPubObjImpl();
        iPSSFPubObj.init(this.iDAGlobalHelper, this.getPSSF(), vt);
        return iPSSFPubObj;
    }

    @Override
    protected Boolean TestObjectRenew(PSSFPubObj obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSSFPubObj vt) {
        return vt.getPSSFPUBOBJID();
    }
}

