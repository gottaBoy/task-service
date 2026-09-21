/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.Utility.StringHelper;

public class EmptyFramePage
extends SRFDAPageEx {
    protected String strEmptyInfo = "";

    public EmptyFramePage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
        this.setResourceId("");
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strEmptyInfo = this.getPageParam("PAGE.PAGEINFO", "");
        if (StringHelper.IsNullOrEmpty((String)this.strEmptyInfo)) {
            IDEHelper iDEHelper = this.getDAModelStorage().FindDEHelper(this.getWebContext().getSRFPDEID());
            if (iDEHelper == null) {
                return false;
            }
            String strPDELogicName = iDEHelper.getLogicName(this.getLanguage());
            String strCaption = this.getWebContext().GetParamValue("SRFCAPTION");
            this.strEmptyInfo = StringHelper.Format((String)"\u8bf7\u5148\u5efa\u7acb\u3010%1$s\u3011\u5e76\u4fdd\u5b58\uff0c\u624d\u80fd\u5bf9\u3010%2$s\u3011\u8fdb\u884c\u7ba1\u7406\u3002", (Object)strPDELogicName, (Object)strCaption);
        }
        return true;
    }

    public String GetEmptyInfo() {
        return this.strEmptyInfo;
    }
}

