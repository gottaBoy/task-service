/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Pub.PSSFSysCodePublisherImpl
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSIBiz5TemplHelper;
import SA.SRFDA.PS.Core.Pub.PSSFSysCodePublisherImpl;
import java.util.HashMap;

public abstract class PSIBiz5SysCodePublisherImpl
extends PSSFSysCodePublisherImpl {
    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
        PSIBiz5TemplHelper.fillParams(params);
        super.onFillGenerateCodeParams(strType, obj, params);
    }
}

