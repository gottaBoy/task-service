/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub.Vue2;

import SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.Vue2.PSVue2TemplHelper;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSVue2CtrlCodePublisherImpl
extends PSPFCtrlCodePublisherImpl {
    private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSVue2TemplHelper.fillParams(params);
    }
}

