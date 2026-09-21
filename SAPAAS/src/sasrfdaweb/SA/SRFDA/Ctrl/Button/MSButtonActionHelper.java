/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Button.SRFExButtonActionHelper
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 */
package SA.SRFDA.Ctrl.Button;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Button.SRFExButtonActionHelper;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;

public class MSButtonActionHelper
extends SRFExButtonActionHelper {
    protected boolean OnClickAction() {
        SRFExAjaxActionResult actionResult = new SRFExAjaxActionResult();
        String strParamValue = this.getPage().getWebContext().getAjaxParam(1);
        if (StringHelper.Length((String)strParamValue) == 0) {
            actionResult.setRetCode(4);
            actionResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u7684\u952e\u503c");
            this.getPage().Output(actionResult.ToJSONString());
            return true;
        }
        String[] Keys = strParamValue.split(",");
        int i = 0;
        while (i < Keys.length) {
            String strKey = Keys[i];
            if (StringHelper.Length((String)strKey) == 0) {
                // empty if block
            }
            ++i;
        }
        actionResult.setRetCode(0);
        this.getPage().Output(actionResult.ToJSONString());
        return true;
    }
}

