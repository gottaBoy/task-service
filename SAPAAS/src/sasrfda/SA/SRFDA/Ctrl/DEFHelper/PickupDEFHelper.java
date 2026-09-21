/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.LinkDEFHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PickupDEFHelper
extends LinkDEFHelper
implements IPickupDEFHelper {
    protected ILinkDEFHelper pickupTextDEFHelper = null;
    private static final Log log = LogFactory.getLog(PickupDEFHelper.class);

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.getRetCode() != 0) {
            return callResult;
        }
        String strPickupTextField = this.GetPickupTextDEField();
        if (StringHelper.IsNullOrEmpty((String)strPickupTextField)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9a\u4e49\u62fe\u53d6\u6587\u672c\u5c5e\u6027", (Object)this.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDEFHelper iTempDEFHelper = this.getDEHelper().GetDEFHelper(strPickupTextField);
        if (iTempDEFHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u62fe\u53d6\u6587\u672c\u5c5e\u6027\u65e0\u6548", (Object)this.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (!(iTempDEFHelper instanceof ILinkDEFHelper)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ILinkDEFHelper]", (Object)iTempDEFHelper.GetFullName()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        this.pickupTextDEFHelper = (ILinkDEFHelper)iTempDEFHelper;
        return callResult;
    }

    @Override
    public ILinkDEFHelper GetPickupTextDEFHelper() {
        return this.pickupTextDEFHelper;
    }

    protected String GetPickupTextDEField() {
        return this.field.getPICKUPTEXTDEFIELD();
    }

    @Override
    public String GetPickupRange() {
        return this.field.getPICKUPRANGE();
    }

    @Override
    public boolean IsPhisicalDEField() {
        return true;
    }
}

