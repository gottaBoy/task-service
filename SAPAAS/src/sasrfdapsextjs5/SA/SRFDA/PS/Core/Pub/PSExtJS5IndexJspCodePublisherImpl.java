/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Pub.PSExtJS5ViewCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;

public class PSExtJS5IndexJspCodePublisherImpl
extends PSExtJS5ViewCodePublisherImpl {
    protected String getPSAppViewCodeName(IPSAppView iPSAppView) {
        return iPSAppView.getCodeName().toLowerCase();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        String strFullClassName = this.iPSApplication.getPKGCodeName();
        strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".view");
        if (!StringHelper.IsNullOrEmpty((String)strFullClassName)) {
            strFullClassName = String.valueOf(strFullClassName) + StringHelper.Format((String)".");
        }
        strFullClassName = String.valueOf(strFullClassName) + this.iPSAppView.getFullCodeName();
        params.put("viewportname", strFullClassName);
    }
}

