/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.View;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.View.IPSViewEngine;
import SA.SRFDA.PS.Data.PSViewEngine;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSViewEngineImpl
extends PSObjectImpl
implements IPSViewEngine {
    protected PSViewEngine psViewEngine = null;
    private static final Log log = LogFactory.getLog(PSViewEngineImpl.class);
    private String strEngineType = null;
    private String strEngineObj = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSViewEngine psViewEngine) throws Exception {
        this.psViewEngine = psViewEngine;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psViewEngine.getPSVIEWENGINEID());
        this.setName(psViewEngine.getPSVIEWENGINENAME());
        this.setPSObjectData(this.psViewEngine);
        this.strEngineType = this.psViewEngine.getENGINETYPE();
        this.strEngineObj = this.psViewEngine.getENGINEOBJ();
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
    public String getEngineType() {
        return this.strEngineType;
    }

    @Override
    public String getEngineObj() {
        return this.strEngineObj;
    }
}

