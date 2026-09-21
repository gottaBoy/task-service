/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.PS.Core.SubSys.IPSSubAppView;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.PSSubAppViewGlobalModel;
import SA.SRFDA.PS.Core.SubSys.PSSubSysObjectImpl;
import SA.SRFDA.PS.Data.PSSubApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSubAppImpl
extends PSSubSysObjectImpl
implements IPSSubApp {
    private static final Log log = LogFactory.getLog(PSSubAppImpl.class);
    protected PSSubApp psSubApp = null;
    protected PSSubAppViewGlobalModel psSubAppViewGlobalModel = new PSSubAppViewGlobalModel();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSys iPSSubSys, PSSubApp psSubApp) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSubSys(iPSSubSys);
        this.psSubApp = psSubApp;
        this.setId(this.psSubApp.getPSSUBAPPID());
        this.setName(this.psSubApp.getPSSUBAPPNAME());
        this.setPSObjectData(this.psSubApp);
        this.psSubAppViewGlobalModel.Init(iDAGlobalHelper, this);
        this.onInit();
    }

    @Override
    public IPSSubAppView getPSSubAppView(String strPSSubAppViewId) throws Exception {
        return (IPSSubAppView)this.psSubAppViewGlobalModel.FindModelHelper(strPSSubAppViewId);
    }

    @Override
    public void resetPSSubAppView(String strPSSubAppViewId) {
        this.psSubAppViewGlobalModel.ResetModel(strPSSubAppViewId);
    }

    @Override
    public Iterator<IPSSubAppView> getAllPSSubAppViews() throws Exception {
        return this.psSubAppViewGlobalModel.getAllModelHelpers();
    }

    @Override
    public String getAppPKGName() {
        return this.psSubApp.getAPPPKGNAME();
    }

    @Override
    public IPSSubAppView getPSSubAppViewBySubDEView(String strPSSubDEViewId, boolean bTryMode) throws Exception {
        return this.psSubAppViewGlobalModel.getPSSubAppViewBySubDEView(strPSSubDEViewId, bTryMode);
    }
}

