/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDevServer;
import SA.SRFDA.PS.Core.Deploy.IPSDevServerType;
import SA.SRFDA.PS.Core.Deploy.PSDevServerImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDevServer;
import SA.SRFDA.PS.Data.PSDevServerType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDevServerTypeImpl
extends PSObjectImpl
implements IPSDevServerType {
    protected PSDevServerType psDevServerType = null;
    private static final Log log = LogFactory.getLog(PSDevServerTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDevServerType psDevServerType) throws Exception {
        this.psDevServerType = psDevServerType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDevServerType.getPSDEVSERVERTYPEID());
        this.setName(psDevServerType.getPSDEVSERVERTYPENAME());
        this.setPSObjectData(this.psDevServerType);
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
    public IPSDevServer createPSDevServer(PSDevServer psDevServer) throws Exception {
        return new PSDevServerImpl();
    }

    @Override
    public String getInstallPath() {
        return this.psDevServerType.getINSTALLPATH();
    }

    @Override
    public void initBookingRes(PSDevServer psDevServer) throws Exception {
    }

    @Override
    public void restoreBookingRes(PSDevServer psDevServer) throws Exception {
    }

    @Override
    public void backupBookingRes(PSDevServer psDevServer) throws Exception {
    }

    @Override
    public void uninitBookingRes(PSDevServer psDevServer) throws Exception {
    }
}

