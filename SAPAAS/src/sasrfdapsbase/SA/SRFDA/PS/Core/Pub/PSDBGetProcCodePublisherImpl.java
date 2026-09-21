/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Pub.PSDBSysProcCodePublisherImpl;
import java.util.HashMap;

public class PSDBGetProcCodePublisherImpl
extends PSDBSysProcCodePublisherImpl {
    @Override
    protected void onGenerateCode() throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();
        this.savePSDESysProcCode((Object)this.psDESysProc, null, params);
    }
}

