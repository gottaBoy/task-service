/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.App.View.IPSAppView
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.Angular;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.Angular.PSAngularTemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAngularCtrlCodePublisherImpl
extends PSPFCtrlCodePublisherImpl {
    private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSAngularTemplHelper.fillParams(params);
    }

    protected String getPSControlCodeName(IPSAppView iPSAppView, IPSControl iPSControl) {
        String strFullName = iPSAppView.getFullCodeName();
        int nPos = strFullName.lastIndexOf(".");
        if (nPos != -1) {
            strFullName = StringHelper.Format((String)"%1$s.%2$s", (Object)strFullName.substring(0, nPos).toLowerCase(), (Object)strFullName.substring(nPos + 1));
        }
        return String.valueOf(strFullName) + "_" + iPSControl.getName().toLowerCase();
    }
}

