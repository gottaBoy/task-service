/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSAppType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSAppType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSAppTypeImpl
extends PSObjectImpl
implements IPSAppType {
    protected PSAppType psAppType = null;
    private static final Log log = LogFactory.getLog(PSAppTypeImpl.class);
    private boolean bMobileApp = false;
    private boolean bUseServiceApi = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSAppType psAppType) throws Exception {
        this.psAppType = psAppType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psAppType.getPSAPPTYPEID());
        this.setName(psAppType.getPSAPPTYPENAME());
        this.setPSObjectData(this.psAppType);
        if (!this.psAppType.isMOBILEMODENull()) {
            this.bMobileApp = this.psAppType.getMOBILEMODE();
        }
        this.onInit();
    }

    @Override
    public boolean isMobileApp() {
        return this.bMobileApp;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public boolean isUseServiceApi() {
        return this.bUseServiceApi;
    }
}

