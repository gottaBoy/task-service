/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAGlobalModel
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.Control.Form.IPSFDLogicType;
import SA.SRFDA.PS.Core.Control.Form.PSFDLogicTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSFDLogicType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSFDLogicTypeGlobalModel
extends BaseDAGlobalModel<String, PSFDLogicType, IPSFDLogicType> {
    private static final Log log = LogFactory.getLog(PSFDLogicTypeGlobalModel.class);
    protected IPSModelHelper iPSModelHelper = null;

    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            this.iPSModelHelper = PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, null);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u5355\u6210\u5458\u903b\u8f91\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSFDLogicType GetObject(String strPSFDLogicTypeId) {
        PSFDLogicType PSFDLogicType2 = new PSFDLogicType();
        CallResult callResult = this.iPSModelHelper.getPSFDLogicType(strPSFDLogicTypeId, PSFDLogicType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5b9e\u4f53\u8868\u5355\u6210\u5458\u903b\u8f91\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSFDLogicTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSFDLogicType2;
    }

    protected IPSFDLogicType OnCreateModelHelper(PSFDLogicType vt) throws Exception {
        PSFDLogicTypeImpl iPSFDLogicType = new PSFDLogicTypeImpl();
        iPSFDLogicType.init(this.iDAGlobalHelper, vt);
        return iPSFDLogicType;
    }

    protected Boolean TestObjectRenew(PSFDLogicType obj) {
        return false;
    }
}

