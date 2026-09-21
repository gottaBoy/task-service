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
import SA.SRFDA.Ctrl.Data.ORGTreeNodeType;
import SA.SRFDA.Ctrl.ORG.IORGTreeNodeTypeHelper;
import SA.SRFDA.Ctrl.ORG.ORGTreeNodeTypeHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ORGTreeNodeTypeGlobalModel
extends BaseDAGlobalModel<String, ORGTreeNodeType, IORGTreeNodeTypeHelper> {
    private static final Log log = LogFactory.getLog(ORGTreeNodeTypeGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected ORGTreeNodeType GetObject(String strORGTreeNodeTypeId) {
        ORGTreeNodeType orgTreeNodeType = new ORGTreeNodeType();
        CallResult callResult = this.iDAGlobalHelper.getDAModelHelper().GetORGTreeNodeType(strORGTreeNodeTypeId, orgTreeNodeType);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7ec4\u7ec7\u5355\u5143\u6811\u8282\u70b9\u7c7b\u578b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strORGTreeNodeTypeId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return orgTreeNodeType;
    }

    @Override
    protected IORGTreeNodeTypeHelper OnCreateModelHelper(ORGTreeNodeType vt) throws Exception {
        IORGTreeNodeTypeHelper iORGTreeNodeTypeHelper = null;
        iORGTreeNodeTypeHelper = StringHelper.IsNullOrEmpty((String)vt.getTYPEHELPER()) ? new ORGTreeNodeTypeHelper() : (IORGTreeNodeTypeHelper)ObjectHelper.Create((String)vt.getTYPEHELPER());
        iORGTreeNodeTypeHelper.Init(this.iDAGlobalHelper, vt);
        return iORGTreeNodeTypeHelper;
    }

    @Override
    protected Boolean TestObjectRenew(ORGTreeNodeType obj) {
        return false;
    }
}

