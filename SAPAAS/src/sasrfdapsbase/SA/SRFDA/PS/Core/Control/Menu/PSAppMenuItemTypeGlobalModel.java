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
package SA.SRFDA.PS.Core.Control.Menu;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.PS.Core.Control.Menu.IPSAppMenuItemType;
import SA.SRFDA.PS.Core.Control.Menu.PSAppMenuItemTypeImpl;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Data.PSAppMenuItemType;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppMenuItemTypeGlobalModel
extends BaseDAGlobalModel<String, PSAppMenuItemType, IPSAppMenuItemType> {
    private static final Log log = LogFactory.getLog(PSAppMenuItemTypeGlobalModel.class);
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
            callResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u4e91\u5e73\u53f0\u5e94\u7528\u83dc\u5355\u9879\u7c7b\u578b\u5168\u5c40\u6a21\u578b\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected PSAppMenuItemType GetObject(String strPSAppMenuItemTypeId) {
        PSAppMenuItemType PSAppMenuItemType2 = new PSAppMenuItemType();
        CallResult callResult = this.iPSModelHelper.getPSAppMenuItemType(strPSAppMenuItemTypeId, PSAppMenuItemType2);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u5e94\u7528\u83dc\u5355\u9879\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSAppMenuItemTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return PSAppMenuItemType2;
    }

    protected IPSAppMenuItemType OnCreateModelHelper(PSAppMenuItemType vt) throws Exception {
        PSAppMenuItemTypeImpl iPSAppMenuItemType = new PSAppMenuItemTypeImpl();
        iPSAppMenuItemType.init(this.iDAGlobalHelper, vt);
        return iPSAppMenuItemType;
    }

    protected Boolean TestObjectRenew(PSAppMenuItemType obj) {
        return false;
    }
}

