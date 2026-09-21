/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSJQTemplHelper;
import SA.SRFDA.PS.Core.Pub.PSPFCtrlCodePublisherImpl;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSJQCtrlCodePublisherImpl
extends PSPFCtrlCodePublisherImpl {
    private static final Log log = LogFactory.getLog(PSPFCtrlCodePublisherImpl.class);

    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        PSJQTemplHelper.fillParams(params);
    }
}

