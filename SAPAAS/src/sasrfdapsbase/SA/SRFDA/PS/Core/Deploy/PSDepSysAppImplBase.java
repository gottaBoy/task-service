/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSysApp;
import SA.SRFDA.PS.Core.Deploy.IPSDepSysVer;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDepSysApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDepSysAppImplBase
extends PSObjectImpl
implements IPSDepSysApp {
    private static final Log log = LogFactory.getLog(PSDepSysAppImplBase.class);
    protected PSDepSysApp psDepSysApp = null;
    private IPSDepSysVer iPSDepSysVer = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSysVer iPSDepSysVer, PSDepSysApp psDepSysApp) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDepSysVer(iPSDepSysVer);
        this.psDepSysApp = psDepSysApp;
        this.setId(this.psDepSysApp.getPSDEPSYSAPPID());
        this.setName(this.psDepSysApp.getPSDEPSYSAPPNAME());
        this.setPSObjectData(this.psDepSysApp);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDEPSYSAPP";
    }

    @Override
    public IPSDepSysVer getPSDepSysVer() {
        return this.iPSDepSysVer;
    }

    protected void setPSDepSysVer(IPSDepSysVer iPSDepSysVer) {
        this.iPSDepSysVer = iPSDepSysVer;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDepSysVer().getPSSysModelInstId();
    }
}

