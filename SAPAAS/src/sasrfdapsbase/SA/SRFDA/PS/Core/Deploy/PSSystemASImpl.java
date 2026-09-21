/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSSystemAS;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Data.PSSystemAS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSystemASImpl
extends PSSystemObjectImpl
implements IPSSystemAS {
    private static final Log log = LogFactory.getLog(PSSystemASImpl.class);
    protected PSSystemAS psSystemAS = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSystemAS psSystemAS) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSystem(iPSSystem);
        this.psSystemAS = psSystemAS;
        this.setId(this.psSystemAS.getPSSYSTEMASID());
        this.setName(this.psSystemAS.getPSSYSTEMASNAME());
        this.setPSObjectData(this.psSystemAS);
        this.onInit();
    }

    @Override
    public String getPSAppServerId() {
        return this.psSystemAS.getPSAPPSERVERID();
    }

    @Override
    public String getAppServerType() {
        return this.psSystemAS.getASTYPE();
    }

    @Override
    public String getAppServerSN() {
        return this.psSystemAS.getASID();
    }

    @Override
    public String getModelType() {
        return "PSSYSTEMAS";
    }

    @Override
    public String getPSDCAppServerId() {
        return this.psSystemAS.getPSDEVCENTERASID();
    }
}

