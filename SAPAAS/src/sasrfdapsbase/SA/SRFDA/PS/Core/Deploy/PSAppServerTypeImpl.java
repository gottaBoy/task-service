/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSAppServerType;
import SA.SRFDA.PS.Core.Deploy.PSAppServerImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSAppServer;
import SA.SRFDA.PS.Data.PSAppServerType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppServerTypeImpl
extends PSObjectImpl
implements IPSAppServerType {
    protected PSAppServerType psAppServerType = null;
    private static final Log log = LogFactory.getLog(PSAppServerTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSAppServerType psAppServerType) throws Exception {
        this.psAppServerType = psAppServerType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psAppServerType.getPSASTYPEID());
        this.setName(psAppServerType.getPSASTYPENAME());
        this.setPSObjectData(this.psAppServerType);
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
    public IPSAppServer createPSAppServer(PSAppServer psAppServer) throws Exception {
        return new PSAppServerImpl();
    }

    @Override
    public String getInstallPath(String strOSType) {
        return this.psAppServerType.getINSTALLPATH();
    }

    @Override
    public String getStartupCmd(String strOSType, String strInstallPath) {
        return StringHelper.Format((String)"%1$s%2$s", (Object)strInstallPath, (Object)this.psAppServerType.getSTARTCMD());
    }

    @Override
    public String getShutdownCmd(String strOSType, String strInstallPath) {
        return StringHelper.Format((String)"%1$s%2$s", (Object)strInstallPath, (Object)this.psAppServerType.getSTOPCMD());
    }

    @Override
    public void initBookingRes(PSAppServer psAppServer) throws Exception {
    }

    @Override
    public void restoreBookingRes(PSAppServer psAppServer) throws Exception {
    }

    @Override
    public void backupBookingRes(PSAppServer psAppServer) throws Exception {
    }

    @Override
    public void uninitBookingRes(PSAppServer psAppServer) throws Exception {
    }
}

