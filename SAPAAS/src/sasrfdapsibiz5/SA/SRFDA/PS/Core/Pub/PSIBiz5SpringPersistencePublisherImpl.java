/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Deploy.IPSSysRunSession
 *  SA.SRFDA.PS.Data.PSSysSFCode
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.Pub.PSIBiz5SpringConfigPublisherImplBase;
import SA.SRFDA.PS.Data.PSSysSFCode;
import java.util.HashMap;

public class PSIBiz5SpringPersistencePublisherImpl
extends PSIBiz5SpringConfigPublisherImplBase {
    protected void savePSSysSFCode(Object obj, PSSysSFCode psSysSFCodeSrc, HashMap<String, Object> params2) throws Exception {
        if (!(this.iPSSysSFPub instanceof IPSSysRunSession)) {
            return;
        }
        IPSSysRunSession iPSSysRunSession = (IPSSysRunSession)this.iPSSysSFPub;
        if (iPSSysRunSession.getPSSystemDBConfig() == null) {
            return;
        }
        super.savePSSysSFCode(obj, psSysSFCodeSrc, params2);
    }
}

