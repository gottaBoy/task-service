/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFCDN;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPFCDN;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSPFCDNImpl
extends PSObjectImpl
implements IPSPFCDN {
    protected PSPFCDN psPFCDN = null;
    private static final Log log = LogFactory.getLog(PSPFCDNImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPFCDN psPFCDN) throws Exception {
        this.psPFCDN = psPFCDN;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psPFCDN.getPSPFCDNID());
        this.setName(psPFCDN.getPSPFCDNNAME());
        this.setPSObjectData(this.psPFCDN);
        this.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

