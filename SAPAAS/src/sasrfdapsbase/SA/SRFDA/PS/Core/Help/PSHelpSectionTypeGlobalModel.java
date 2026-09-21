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
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.Help.IPSHelpSectionType;
import SA.SRFDA.PS.Core.Help.PSHelpSectionTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSHelpSectionType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSHelpSectionTypeGlobalModel
extends BaseDAGlobalModel<String, PSHelpSectionType, IPSHelpSectionType> {
    private static final Log log = LogFactory.getLog(PSHelpSectionTypeGlobalModel.class);
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
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5e2e\u52a9\u7ae0\u8282\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSHelpSectionType GetObject(String strPSHelpSectionTypeId) {
        PSHelpSectionType PSHelpSectionType2 = new PSHelpSectionType();
        CallResult callResult = this.iPSModelHelper.getPSHelpSectionType(strPSHelpSectionTypeId, PSHelpSectionType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e2e\u52a9\u7ae0\u8282\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSHelpSectionTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSHelpSectionType2;
    }

    protected IPSHelpSectionType OnCreateModelHelper(PSHelpSectionType vt) throws Exception {
        IPSHelpSectionType iPSHelpSectionType = null;
        iPSHelpSectionType = StringHelper.IsNullOrEmpty((String)vt.getTYPEOBJ()) ? new PSHelpSectionTypeImpl() : (IPSHelpSectionType)ObjectHelper.Create((String)vt.getTYPEOBJ());
        iPSHelpSectionType.init(this.iDAGlobalHelper, vt);
        return iPSHelpSectionType;
    }

    protected Boolean TestObjectRenew(PSHelpSectionType obj) {
        return false;
    }
}

