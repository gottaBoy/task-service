/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFPubObj;
import SA.SRFDA.PS.Core.PF.PSPFGlobalModelBase;
import SA.SRFDA.PS.Core.PF.PSPFPubObjImpl;
import SA.SRFDA.PS.Data.PSPFPubObj;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFPubObjGlobalModel
extends PSPFGlobalModelBase<String, PSPFPubObj, IPSPFPubObj> {
    private static final Log log = LogFactory.getLog(PSPFPubObjGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        this.bEnableEmptyMap = true;
        return super.OnInit();
    }

    @Override
    protected PSPFPubObj GetObject(String strPSPFPubObjId) {
        PSPFPubObj psPFPubObj = new PSPFPubObj();
        CallResult callResult = this.iPSModelHelper.getPSPFPubObj(strPSPFPubObjId, psPFPubObj);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u524d\u53f0\u5e94\u7528\u6846\u67b6\u53d1\u5e03\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSPFPubObjId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psPFPubObj;
    }

    @Override
    protected IPSPFPubObj OnCreateModelHelper(PSPFPubObj vt) throws Exception {
        PSPFPubObjImpl iPSPFPubObj = new PSPFPubObjImpl();
        iPSPFPubObj.init(this.iDAGlobalHelper, this.getPSPF(), vt);
        return iPSPFPubObj;
    }

    @Override
    protected Boolean TestObjectRenew(PSPFPubObj obj) {
        return false;
    }

    @Override
    protected String getObjectId(PSPFPubObj vt) {
        return vt.getPSPFPUBOBJID();
    }
}

