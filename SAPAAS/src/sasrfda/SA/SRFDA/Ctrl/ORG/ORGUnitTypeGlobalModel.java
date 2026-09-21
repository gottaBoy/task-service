/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.ORG;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.Data.ORGUnitType;
import SA.SRFDA.Ctrl.ORG.IORGUnitTypeHelper;
import SA.SRFDA.Ctrl.ORG.ORGUnitTypeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ORGUnitTypeGlobalModel
extends BaseDAGlobalModel<String, ORGUnitType, IORGUnitTypeHelper> {
    private static final Log log = LogFactory.getLog(ORGUnitTypeGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected ORGUnitType GetObject(String strORGUnitTypeId) {
        ORGUnitType orgUnitType = new ORGUnitType();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetORGUnitType(strORGUnitTypeId, orgUnitType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7ec4\u7ec7\u5355\u5143\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strORGUnitTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return orgUnitType;
    }

    @Override
    protected IORGUnitTypeHelper OnCreateModelHelper(ORGUnitType vt) throws Exception {
        IORGUnitTypeHelper iORGUnitTypeHelper = null;
        iORGUnitTypeHelper = StringHelper.IsNullOrEmpty((String)vt.getTYPEHELPER()) ? new ORGUnitTypeHelper() : (IORGUnitTypeHelper)ObjectHelper.Create((String)vt.getTYPEHELPER());
        iORGUnitTypeHelper.Init(this.iDAGlobalHelper, vt);
        return iORGUnitTypeHelper;
    }

    @Override
    protected Boolean TestObjectRenew(ORGUnitType obj) {
        return false;
    }
}

