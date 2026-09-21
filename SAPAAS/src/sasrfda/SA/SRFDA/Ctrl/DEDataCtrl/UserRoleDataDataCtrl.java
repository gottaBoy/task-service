/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.UserRoleDataAction;
import SA.SRFDA.Ctrl.Data.UserRoleDataDetail;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserRoleDataDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(UserRoleDataDataCtrl.class);

    @Override
    protected CallResult OnExport(BaseDataEntity baseDataEntity, Vector<XMLNode> list, boolean bFrameOnly) {
        CallResult callResult = super.OnExport(baseDataEntity, list, bFrameOnly);
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        String stUserRoleDataId = baseDataEntity.GetParamStringValue("USERROLEDATAID", "");
        Vector<UserRoleDataDetail> details = new Vector<UserRoleDataDetail>();
        callResult = this.globalHelperEx.getDAModelHelper().GetUserRoleDataDetails(stUserRoleDataId, details);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)"\u83b7\u53d6\u7528\u6237\u89d2\u8272\u6570\u636e\u660e\u7ec6");
            return callResult;
        }
        IDEDataCtrl userroleDataDetailataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0038", this.strCurOpPersonId, this.getWebContext());
        if (userroleDataDetailataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61", (Object)"DE0038"));
            return callResult;
        }
        for (UserRoleDataDetail detail : details) {
            userroleDataDetailataCtrl.Export(detail, list, true, bFrameOnly);
        }
        Vector<UserRoleDataAction> actions = new Vector<UserRoleDataAction>();
        callResult = this.globalHelperEx.getDAModelHelper().GetUserRoleDataActions(stUserRoleDataId, actions);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)"\u83b7\u53d6\u7528\u6237\u89d2\u8272\u6570\u636e\u64cd\u4f5c");
            return callResult;
        }
        IDEDataCtrl userroleDataActionataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrl("DE0039", this.strCurOpPersonId, this.getWebContext());
        if (userroleDataActionataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u6570\u636e\u5bf9\u8c61", (Object)"DE0039"));
            return callResult;
        }
        for (UserRoleDataAction action : actions) {
            userroleDataActionataCtrl.Export(action, list, true, bFrameOnly);
        }
        return callResult;
    }
}

