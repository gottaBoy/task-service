/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.SRFDAPageEx
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.Web.SRFDAPageEx;

public class SRFDAPSPage
extends SRFDAPageEx {
    protected IPSModelHelper getPSModelHelper(String strPSSysModelInstId) throws Exception {
        return PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), strPSSysModelInstId);
    }

    protected IPSModelStorage getPSModelStorage() throws Exception {
        return PSObjectFactory.getPSModelStorage(this.getDAGlobalHelper());
    }

    protected IPSModelHelper getPSModelHelper() throws Exception {
        return PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null);
    }
}

