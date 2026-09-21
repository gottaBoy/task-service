/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.Data.RCAccList;
import SA.SRFDA.Security.IRCAccListHelper;
import SA.SRFDA.Security.RCAccListHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RCAccListGlobalModel
extends BaseDAGlobalModel<String, RCAccList, IRCAccListHelper> {
    private static final Log log = LogFactory.getLog(RCAccListGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected RCAccList GetObject(String strRCAccListId) {
        RCAccList orgUnitType = new RCAccList();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetRCAccList(strRCAccListId, orgUnitType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u8fdc\u7a0b\u8c03\u7528\u8bbf\u95ee\u5217\u8868[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strRCAccListId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return orgUnitType;
    }

    @Override
    protected IRCAccListHelper OnCreateModelHelper(RCAccList vt) throws Exception {
        RCAccListHelper iRCAccListHelper = new RCAccListHelper();
        iRCAccListHelper.Init(this.iDAGlobalHelper, vt);
        return iRCAccListHelper;
    }

    @Override
    protected Boolean TestObjectRenew(RCAccList obj) {
        return false;
    }
}

