/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSMavenServer;
import SA.SRFDA.PS.Core.Deploy.IPSMavenServerType;
import SA.SRFDA.PS.Core.Deploy.PSMavenServerImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.PS.Data.PSMavenServer;
import SA.SRFDA.PS.Data.PSMavenServerType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMavenServerTypeImpl
extends PSObjectImpl
implements IPSMavenServerType {
    protected PSMavenServerType psMavenServerType = null;
    private static final Log log = LogFactory.getLog(PSMavenServerTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSMavenServerType psMavenServerType) throws Exception {
        this.psMavenServerType = psMavenServerType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psMavenServerType.getPSMAVENSERVERTYPEID());
        this.setName(psMavenServerType.getPSMAVENSERVERTYPENAME());
        this.setPSObjectData(this.psMavenServerType);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSMavenServer createPSMavenServer(PSMavenServer psMavenServer) throws Exception {
        return new PSMavenServerImpl();
    }

    @Override
    public String getInstallPath(String strOSType) {
        return null;
    }

    @Override
    public void createMavenRepo(PSMavenRepo psMavenRepo) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void updateMavenRepo(PSMavenRepo psMavenRepo, int nMode) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

