/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAGlobalModel
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.PSControlTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSControlType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSControlTypeGlobalModel
extends BaseDAGlobalModel<String, PSControlType, IPSControlType> {
    private static final Log log = LogFactory.getLog(PSControlTypeGlobalModel.class);
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
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u63a7\u4ef6\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSControlType GetObject(String strPSControlTypeId) {
        PSControlType PSControlType2 = new PSControlType();
        CallResult callResult = this.iPSModelHelper.getPSControlType(strPSControlTypeId, PSControlType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u63a7\u4ef6\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSControlTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSControlType2;
    }

    protected IPSControlType OnCreateModelHelper(PSControlType vt) throws Exception {
        IPSControlType iPSControlType = null;
        iPSControlType = StringHelper.IsNullOrEmpty((String)vt.getTYPEOBJ()) ? new PSControlTypeImpl() : (IPSControlType)ObjectHelper.Create((String)vt.getTYPEOBJ());
        iPSControlType.init(this.iDAGlobalHelper, vt);
        return iPSControlType;
    }

    protected Boolean TestObjectRenew(PSControlType obj) {
        return false;
    }
}

