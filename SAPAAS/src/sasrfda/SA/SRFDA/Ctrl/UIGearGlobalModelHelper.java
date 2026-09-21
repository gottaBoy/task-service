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
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAGlobalModel;
import SA.SRFDA.Ctrl.Data.UIGear;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.UIGear.IUIGear;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UIGearGlobalModelHelper
extends BaseDAGlobalModel {
    protected IDEDataCtrl uiGearDataCtrl = null;
    private static final Log log = LogFactory.getLog(UIGearGlobalModelHelper.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nRenewTimer = this.iDAGlobalHelper.getWebExConfig().GetValue("SRFDA", "UIGEARRENEWTIMER", this.nRenewTimer);
        if (this.nRenewTimer < 5000) {
            this.nRenewTimer = 5000;
        }
        if (this.iDAGlobalHelper.getDAModelVersion() >= 11060400) {
            this.uiGearDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE0126", "SYSTEM", null);
            if (this.uiGearDataCtrl == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0126"));
                return callResult;
            }
        } else {
            log.warn((Object)StringHelper.Format((String)"\u6a21\u578b\u7248\u672c[%1$s]\u4e0d\u80fd\u6ee1\u8db3\u754c\u9762\u9a71\u52a8\u5f15\u64ce\u5168\u5c40\u5bf9\u8c61\u52a0\u8f7d\u8981\u6c42", (Object)this.iDAGlobalHelper.getDAModelVersion()));
        }
        return callResult;
    }

    protected Object GetObject(Object objObjectId) {
        if (this.uiGearDataCtrl == null) {
            return null;
        }
        UIGear uiGear = new UIGear();
        uiGear.setUIGEARID((String)objObjectId);
        CallResult callResult = this.uiGearDataCtrl.Get(uiGear);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u754c\u9762\u9a71\u52a8\u5f15\u64ce[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)objObjectId, (Object)callResult.getErrorInfo()));
            return null;
        }
        Object objUIGear = ObjectHelper.Create((String)uiGear.getUIGEAROBJECT());
        if (objUIGear == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u754c\u9762\u9a71\u52a8\u5f15\u64ce[%1$s]", (Object)uiGear.getUIGEAROBJECT()));
            return null;
        }
        if (!(objUIGear instanceof IUIGear)) {
            log.error((Object)StringHelper.Format((String)"\u754c\u9762\u9a71\u52a8\u5f15\u64ce[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)uiGear.getUIGEAROBJECT()));
            return null;
        }
        IUIGear iUIGear = (IUIGear)objUIGear;
        callResult = iUIGear.Init(this.iDAGlobalHelper, uiGear);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u754c\u9762\u9a71\u52a8\u5f15\u64ce[%1$s]\u5931\u8d25\uff0c%2$s", (Object)uiGear.getUIGEAROBJECT(), (Object)callResult.getErrorInfo()));
            return null;
        }
        return iUIGear;
    }

    protected Boolean TestObjectRenew(Object obj) {
        return false;
    }
}

