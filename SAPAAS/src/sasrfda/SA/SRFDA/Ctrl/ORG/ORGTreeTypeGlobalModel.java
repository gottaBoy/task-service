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
import SA.SRFDA.Ctrl.Data.ORGTreeType;
import SA.SRFDA.Ctrl.ORG.IORGTreeTypeHelper;
import SA.SRFDA.Ctrl.ORG.ORGTreeTypeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ORGTreeTypeGlobalModel
extends BaseDAGlobalModel<String, ORGTreeType, IORGTreeTypeHelper> {
    private static final Log log = LogFactory.getLog(ORGTreeTypeGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected ORGTreeType GetObject(String strORGTreeTypeId) {
        ORGTreeType orgTreeType = new ORGTreeType();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetORGTreeType(strORGTreeTypeId, orgTreeType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7ec4\u7ec7\u5355\u5143\u6811\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strORGTreeTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return orgTreeType;
    }

    @Override
    protected IORGTreeTypeHelper OnCreateModelHelper(ORGTreeType vt) throws Exception {
        IORGTreeTypeHelper iORGTreeTypeHelper = null;
        iORGTreeTypeHelper = StringHelper.IsNullOrEmpty((String)vt.getTYPEHELPER()) ? new ORGTreeTypeHelper() : (IORGTreeTypeHelper)ObjectHelper.Create((String)vt.getTYPEHELPER());
        iORGTreeTypeHelper.Init(this.iDAGlobalHelper, vt);
        return iORGTreeTypeHelper;
    }

    @Override
    protected Boolean TestObjectRenew(ORGTreeType obj) {
        return false;
    }
}

