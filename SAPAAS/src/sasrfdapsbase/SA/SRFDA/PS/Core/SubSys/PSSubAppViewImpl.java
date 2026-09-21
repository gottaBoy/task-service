/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Core.SubSys.IPSSubAppView;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubAppViewImpl
extends PSObjectImpl
implements IPSSubAppView {
    private static final Log log = LogFactory.getLog(PSSubAppViewImpl.class);
    protected PSSubAppView psSubAppView = null;
    private IPSSubApp iPSSubApp = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubApp iPSSubApp, PSSubAppView psSubAppView) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSubApp = iPSSubApp;
        this.psSubAppView = psSubAppView;
        this.setId(this.psSubAppView.getPSSUBAPPVIEWID());
        this.setName(this.psSubAppView.getPSSUBAPPVIEWNAME());
        this.setPSObjectData(this.psSubAppView);
        this.onInit();
    }

    @Override
    public String getPageUrl() {
        return this.psSubAppView.getPAGEURL();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSubApp.getPSSysModelInstId();
    }

    @Override
    public String getPSSubDEViewId() {
        return this.psSubAppView.getPSSUBDEVIEWID();
    }

    @Override
    public String getAppModuleName() {
        return this.psSubAppView.getMODULENAME();
    }

    @Override
    public String getAppModuleCodeName() {
        return this.psSubAppView.getMODULECODENAME();
    }
}

