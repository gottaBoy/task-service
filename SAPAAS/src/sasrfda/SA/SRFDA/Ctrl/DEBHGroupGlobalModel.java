/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.DEDataCtrl.IDEBHGroupDataCtrl;
import SA.SRFDA.Ctrl.Data.DEBHGroup;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEBHGroupGlobalModel
extends BaseDAGlobalModel {
    protected IDEBHGroupDataCtrl deBHGroupDataCtrl = null;
    private static final Log log = LogFactory.getLog(DEBHGroupGlobalModel.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nRenewTimer = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "DEBHGROUPRENEWTIMER", this.nRenewTimer);
        if (this.nRenewTimer < 5000) {
            this.nRenewTimer = 5000;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11052400) {
            this.deBHGroupDataCtrl = (IDEBHGroupDataCtrl)this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0215", "SYSTEM", null);
            if (this.deBHGroupDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0215"));
                return callResult;
            }
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6a21\u578b\u7248\u672c[%1$s]\u4e0d\u80fd\u6ee1\u8db3\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4\u5168\u5c40\u5bf9\u8c61\u52a0\u8f7d\u8981\u6c42", (Object)this.iDAGlobalHelper.getDAModelVersion()));
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        CallResult callResult;
        if (this.deBHGroupDataCtrl == null) {
            return null;
        }
        String strDEBHGroupId = (String)objObjectId;
        String[] parts = strDEBHGroupId.split("[|]");
        DEBHGroup deBHGroup = new DEBHGroup();
        if (parts.length == 3) {
            deBHGroup.setDEID(parts[0]);
            deBHGroup.setVIEWTYPE(parts[1]);
            deBHGroup.setGROUPID(parts[2]);
            callResult = this.deBHGroupDataCtrl.Select(deBHGroup);
            if (callResult.IsError()) {
                if (callResult.getRetCode() == 3) {
                    return deBHGroup;
                }
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5206\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
                return null;
            }
        } else {
            deBHGroup.setDEBHGROUPID((String)objObjectId);
            callResult = this.deBHGroupDataCtrl.Get(deBHGroup);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5206\u7ec4[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
                return null;
            }
        }
        Vector<DEBehavior> deBehaviors = new Vector<DEBehavior>();
        CallResult callResult2 = this.deBHGroupDataCtrl.ListDEBehaviors(deBHGroup.getDEBHGROUPID(), deBehaviors);
        if (callResult2.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5206\u7ec4[%1$s]\u660e\u7ec6\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult2.getErrorInfo()));
            return null;
        }
        for (DEBehavior deBehavior : deBehaviors) {
            deBehavior.InitExtParams();
        }
        deBHGroup.setDEBehaviors(deBehaviors);
        return deBHGroup;
    }

    protected Boolean TestObjectRenew(Object obj) {
        DEBHGroup deBHGroup = (DEBHGroup)((Object)obj);
        if (this.iDAGlobalHelper.getDAModelStorage().GetDAModelVersion("DE0215", deBHGroup.getDEBHGROUPID()) != deBHGroup.getVERSION()) {
            return true;
        }
        return false;
    }
}

